package com.imaginea.Launcher;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.imaginea.Launcher.dto.Orders;
import com.imaginea.Launcher.dto.User;

@Component
public class ApiCaller {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
		@Async
	  public CompletableFuture<List<User>> getAllUsers() throws InterruptedException{
		  String url = String.format("http://localhost:8080/UserDetails");
	        ResponseEntity<List<User>> results = restTemplate().exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>(){});
	        
	        List<User> userResult = results.getBody();  
	        
	        return CompletableFuture.completedFuture(userResult);
	  }


		@Async
	  public CompletableFuture<List<Orders>> getAllOrders() throws InterruptedException{
		  String url = String.format("http://localhost:8080/OrderDetails");
	        ResponseEntity<List<Orders>> results = restTemplate().exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Orders>>(){});
	        
	        List<Orders> orderResult = results.getBody();  
	        
	        return CompletableFuture.completedFuture(orderResult);
	  }

	  
}
