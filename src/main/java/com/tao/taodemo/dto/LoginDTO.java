package com.tao.taodemo.dto;

import java.util.Optional;

public class LoginDTO {
	private Optional<UserInfoDTO> userInfoDTO;
	private Optional<InventoryDTO> inventoryDTO;
	
	public Optional<UserInfoDTO> getUserInfoDTO() {
		return userInfoDTO;
	}
	public void setUserInfoDTO(Optional<UserInfoDTO> userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}
	public Optional<InventoryDTO> getInventoryDTO() {
		return inventoryDTO;
	}
	public void setInventoryDTO(Optional<InventoryDTO> inventoryDTO) {
		this.inventoryDTO = inventoryDTO;
	}
}
