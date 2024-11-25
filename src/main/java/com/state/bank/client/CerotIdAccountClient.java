package com.state.bank.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.state.bank.exception.AccountException;
import com.state.bank.response.AccountResponse;

@Component
public class CerotIdAccountClient {

	private static final String ACCOUNT_FIND_ACCOUNT_URL = "http://localhost:8080/v1/account/findAccount?id=";

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper objectMapper;

	public AccountResponse callFindAccount(String id) throws AccountException, JsonMappingException, JsonProcessingException {
		String finalUrl = ACCOUNT_FIND_ACCOUNT_URL + id;
		String response = null;
		try {
			response = restTemplate.getForObject(finalUrl, String.class);
		} catch (RestClientException e) {
			throw new AccountException("Error while finind account details ", e);
		}
		
			AccountResponse account = objectMapper.readValue(response, AccountResponse.class);
		
		return account;
	}

	public static void main(String[] args) {
		String s1 = ACCOUNT_FIND_ACCOUNT_URL;
		System.out.println();
	}
}
