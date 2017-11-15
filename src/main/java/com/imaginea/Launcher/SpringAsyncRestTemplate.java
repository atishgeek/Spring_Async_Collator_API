package com.imaginea.Launcher;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

@SpringBootApplication
public class SpringAsyncRestTemplate {

	public static void main(String[] args) {
		AsyncRestTemplate asycTemp = new  AsyncRestTemplate();
		
		String url ="http://localhost:8080/OrderDetails";
		HttpMethod method = HttpMethod.GET;
		Class<String> responseType = String.class;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		HttpEntity<String> requestEntity = new HttpEntity<String>("params", headers);
		ListenableFuture<ResponseEntity<String>> future = asycTemp.exchange(url, method, requestEntity, responseType);
		try {
			//waits for the result
			ResponseEntity<String> entity = future.get();
			//prints body source code for the given URL
			System.out.println(entity.getBody());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
