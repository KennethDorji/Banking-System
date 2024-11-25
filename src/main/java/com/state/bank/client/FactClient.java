package com.state.bank.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.state.bank.response.Fact;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FactClient {

	@Value("${fact.api.url}")
	private String factAPIURL;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper mapper;

	public ResponseEntity<?> callFactApi() throws JsonMappingException, JsonProcessingException {
		// URI factUri = new URI(factAPIURL);
		log.info("Inside callFactApi");
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(factAPIURL, String.class);
		if (responseEntity.hasBody()) {
			log.info("Received valid response from API");
			String finalRespose = responseEntity.getBody();
			log.info("Result recived from API is {}",finalRespose);
			List<Fact> facts = mapper.readValue(finalRespose, new TypeReference<List<Fact>>() {
			});
			log.info("Fact record size is {}",facts.size());
			return new ResponseEntity<List<Fact>>(facts, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("No result found", HttpStatus.BAD_REQUEST);
	}

	public List<Fact> callFactApiWithoutResponseEntity() throws JsonMappingException, JsonProcessingException {
		// URI factUri = new URI(factAPIURL);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(factAPIURL, String.class);
		if (responseEntity.hasBody()) {
			String finalRespose = responseEntity.getBody();
			List<Fact> facts = mapper.readValue(finalRespose, new TypeReference<List<Fact>>() {
			});
			return facts;
		}
		return null;
	}

}
