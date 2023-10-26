package com.aakriti.mvcIntermediate.api;
import com.aakriti.mvcIntermediate.validator.*;
public class Phone {

	private String countrycode;
	
	@Phones(message = "invalid")
	private String userNumber;

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	@Override
	public String toString() {
		return countrycode + "-" + userNumber;
	}

}
