package com.tao.taodemo.repository;



import java.util.List;
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
    @Query(value = "INSERT INTO app_user (id, username, role, password) VALUES (:id, :username, :role, :password)", nativeQuery = true)
    int addUser(@Param("id") UUID id, @Param("username") String username, @Param("role") String role, @Param("password") String password);
    
    @Query("SELECT id as id, password as password, role as role, username as username FROM AppUser  WHERE username = :username ")
	List<AppUser> findByUserName(@Param("username") String username);
    
    List<AppUser> findAll();
/*	
	@Query("SELECT * FROM app_user a WHERE a.username > :username ")
	List<AppUser> findByUserName(@Param("username") String userName);
	
	@Query("SELECT * FROM app_user a WHERE a.username = :username AND a.password = :password")
	List<AppUser> findByUserNameAndPassword(@Param("username") String userName, @Param("password") String password);
	
	@Modifying
	@Query("UPDATE app_user SET role = :role, password = :password WHERE username = :username")
	int updateUser(@Param("username") String userName, @Param("role") String role, @Param("password") String password);
*/
	
}
