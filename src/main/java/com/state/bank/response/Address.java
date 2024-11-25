package com.state.bank.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long addressId;
    private Integer streetNumber;
    private String streetName;
    private String cityName;
    private String stateName;
    private Integer zipCode;
}
