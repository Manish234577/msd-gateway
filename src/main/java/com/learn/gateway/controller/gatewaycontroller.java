package com.learn.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class gatewaycontroller {
	private RestTemplate resttemplate;
	@GetMapping("/getbooks")
	public String getBooks() {
		System.out.println("called");
		resttemplate=new RestTemplate();
		String message=resttemplate.getForObject("http://localhost:8080/getbooks", String.class);
		return message;
				
	}
	@GetMapping("/getcustomers")
	public String getcustomers() {
		System.out.println("customers called");
		resttemplate=new RestTemplate();
		String message =resttemplate.getForObject("http://localhost:8081/getcustomers", String.class);
				return message;
	}
	@GetMapping("/addbook")
	public String addBook(int id,String name,String author) {
		System.out.println("add called");
		resttemplate=new RestTemplate();
		String message=resttemplate.getForObject("http://localhost:8080/addbooks?id=" +id +"&name=" +name +"&author="+author, String.class);
		return  message;
				
	}
	@GetMapping("/deletebook")
	public String deletebook(int id) {
		System.out.println("delete called");
		resttemplate=new RestTemplate();
		String message=resttemplate.getForObject("http://localhost:8080/deletebook?id="+id,String.class);
		return message;
	}
   @GetMapping("/deletecustomer")
   public String deletecustomer(int id) {
	   System.out.println("delete customer");
	   resttemplate=new RestTemplate();
	   String message=resttemplate.getForObject("http://localhost:8081/deletebook?id"+id, String.class);
	   return message;
   }

}
