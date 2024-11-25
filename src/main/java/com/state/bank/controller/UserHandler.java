package com.state.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.state.bank.client.CerotIdUserClient;
import com.state.bank.response.CreateUserRequest;

@RestController
public class UserHandler {

	@Autowired
	private CerotIdUserClient cerotIdUserClient;

	@PostMapping("/user/create")
	public ResponseEntity<?> create(@RequestBody CreateUserRequest createUserRequest) {
		return cerotIdUserClient.callCreateUser(createUserRequest);
	}
}
