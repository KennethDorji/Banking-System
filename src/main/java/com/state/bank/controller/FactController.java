package com.state.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.state.bank.client.FactClient;
import com.state.bank.response.Fact;

@RestController
@RequestMapping("/api")
public class FactController {

	@Autowired
	private FactClient factClient;
	
	@GetMapping("/facts")
	public ResponseEntity<?> getFacts() throws Exception{
		return factClient.callFactApi();
	}
	@GetMapping("/facts2")
	public List<Fact> getFacts2() throws JsonMappingException, JsonProcessingException {
		return factClient.callFactApiWithoutResponseEntity();
	}
}
