package com.tao.taodemo.repository;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tao.taodemo.model.AppUser;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, UUID>{
	
    @Modifying
    @Transactional
    @Query("INSERT INTO AppUser "
		+  "( "
		+  " id       "
		+  ",username "
		+  ",role     "
		+  ",password "
		+  ")         "
		+  "VALUES    "
		+  "(:id, :username, :role, :password)")
    int addUser(@Param("id") UUID id, @Param("username") String username, @Param("role") String role, @Param("password") String password);
    
    @Query("SELECT id as id, password as password, role as role, username as username FROM AppUser  WHERE username = :username ")
	List<AppUser> findByUserName(@Param("username") String username);
    
    @Query("SELECT a FROM AppUser a WHERE username = :username AND password = :password ")
    Optional<AppUser> userLogin(@Param("username") String username, @Param("password") String password);
    
	@Modifying
	@Query("UPDATE AppUser SET role = :role, password = :password WHERE username = :username")
	int updateUser(@Param("username") String userName, @Param("role") String role, @Param("password") String password);

	List<AppUser> findAll();
	
}
