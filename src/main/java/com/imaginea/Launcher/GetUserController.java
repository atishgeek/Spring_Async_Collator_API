package com.imaginea.Launcher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imaginea.Launcher.dto.JsonResponse;
import com.imaginea.Launcher.dto.Orders;
import com.imaginea.Launcher.dto.User;

@Controller
public class GetUserController {

	@Autowired
	ApiCaller apicaller;
	
	@RequestMapping("/")
	public @ResponseBody JsonResponse getAllDetails() throws InterruptedException {
		
		JsonResponse response = new  JsonResponse();
		
		List<List<User>> multipleUserList = new ArrayList<>();
		List<List<Orders>> multipleOrderList = new ArrayList<>();
		
		 long start = System.currentTimeMillis();
		
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Request sent at :"+currentTime);
		
	  CompletableFuture<List<User>> userList = apicaller.getAllUsers();
	  CompletableFuture<List<Orders>> orderList = apicaller.getAllOrders();
	  
	  CompletableFuture.allOf(userList,orderList).join();
	  try {
		//result.setOrderDetails(orderList.get());
		  
		  multipleUserList.add(userList.get());
		  multipleOrderList.add(orderList.get());
		  
		  response.setUserDetails(multipleUserList);
		  response.setOrderDetails(multipleOrderList);
		  
		
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	  
	  LocalDateTime currentTime2 = LocalDateTime.now();
	  System.out.println("Response recieved at :"+currentTime2);
	  System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
	  
		
		
		return response;
	}
	
	
/*	@RequestMapping("/findUsers/id/{id}")
	public @ResponseBody User findUser(@PathVariable int id) throws InterruptedException, ExecutionException{
		
		CompletableFuture<User> user = null;
		try {
			user = apicaller.findUser(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user.get();
	}
	*/
	
	
	
}
