package com.state.bank.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.state.bank.response.CreateUserRequest;

@Component
public class CerotIdUserClient {

	@Value("${user.create}")
	private String userCreateEp;

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;

	public ResponseEntity<CreateUserRequest> callCreateUser(CreateUserRequest createUserRequest)
			{
		CreateUserRequest userRequest = null;
		try {
		URI uri = new URI(userCreateEp);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		HttpEntity<CreateUserRequest> entity = new HttpEntity<CreateUserRequest>(createUserRequest, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);
			userRequest = mapper.readValue(response.getBody(), CreateUserRequest.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<CreateUserRequest>(userRequest, HttpStatus.CREATED);
	}

}
