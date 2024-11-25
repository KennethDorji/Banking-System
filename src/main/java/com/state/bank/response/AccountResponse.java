package com.state.bank.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AccountResponse {
	private Long id;
	private String accountType;
	private String accountNumber;
	private String accountHolderName;
	private double accountBalance;
	private String deposits;
	private String accountVarient;
	
	
}