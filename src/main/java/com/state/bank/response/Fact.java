package com.state.bank.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fact {

	private Status status;
	@JsonProperty("_id")
	private String id;
	private String user;
	private String text;
	@JsonProperty("__v")
	private int value;
	private String source;
	private String updatedAt;
	private String type;
	private String createdAt;
	private boolean deleted;
	private boolean used;

}
