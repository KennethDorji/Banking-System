package com.state.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.state.bank.client.CerotIdAccountClient;
import com.state.bank.exception.AccountException;
import com.state.bank.response.AccountResponse;
import com.state.bank.response.ErrorResponse;

@RestController
public class AccountHandler {

	@Autowired
	private CerotIdAccountClient accountClient;

	// use this annotation @PathVariable or @RequestParam to get user input from url
	// AccountResponse
	@GetMapping("/account/{id}")
	public ResponseEntity<?> abc(@PathVariable("id") String id) {
		try {
			return new ResponseEntity<AccountResponse>(accountClient.callFindAccount(id), HttpStatus.OK);
		} catch (JsonMappingException e) {
			ErrorResponse err = ErrorResponse.builder()
					.errorMsg(e.getMessage())
					.httpStatus(HttpStatus.BAD_REQUEST)
					.errorCode(HttpStatus.BAD_REQUEST.value())
					.build();
			return new ResponseEntity<ErrorResponse>(err, HttpStatus.BAD_REQUEST);
		} catch (JsonProcessingException e) {
			ErrorResponse err = ErrorResponse.builder()
					.errorMsg(e.getMessage())
					.httpStatus(HttpStatus.BAD_REQUEST)
					.errorCode(HttpStatus.BAD_REQUEST.value())
					.build();
			return new ResponseEntity<ErrorResponse>(err, HttpStatus.BAD_REQUEST);
		} catch (AccountException e) {
			ErrorResponse err = ErrorResponse.builder()
					.errorMsg(e.getMessage())
					.httpStatus(HttpStatus.NOT_FOUND)
					.errorCode(HttpStatus.NOT_FOUND.value())
					.build();
			return new ResponseEntity<ErrorResponse>(err, HttpStatus.NOT_FOUND);
		}
	}
}
