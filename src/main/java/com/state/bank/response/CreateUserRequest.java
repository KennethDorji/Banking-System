package com.state.bank.response;

import java.util.Set;

import com.state.bank.response.Account.AccountBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class CreateUserRequest {

	    private String firstName;
	    private String lastName;
	    private String dob;
	    private String mobileNum;
	    private String email;
	    private Address address;
	    private Set<Account> account;
}
