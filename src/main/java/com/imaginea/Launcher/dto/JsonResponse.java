package com.imaginea.Launcher.dto;

import java.util.List;

public class JsonResponse {
	
	
	List<List<User>> userDetails;
	
	List<List<Orders>> orderDetails;

	
	public List<List<User>> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<List<User>> userDetails) {
		this.userDetails = userDetails;
	}

	public List<List<Orders>> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<List<Orders>> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	

}
