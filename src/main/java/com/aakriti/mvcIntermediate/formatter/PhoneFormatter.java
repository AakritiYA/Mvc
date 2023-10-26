package com.aakriti.mvcIntermediate.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.aakriti.mvcIntermediate.api.Phone;


public class PhoneFormatter implements Formatter<Phone> {

//	method is used to convert object to string type
//	so that user can update the value, for that user have to see the value
	public String print(Phone object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

//	method is used to convert string to object type
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {

		Phone phone = new Phone();
		// split the string from the user
		String[] phoneNumberArray = completePhoneNumber.split("-");

		// whether the number consists of -
		int index = completePhoneNumber.indexOf('-');
		if (index == -1) {
//		if the '-' is not found add 91 as the default country code
			phone.setCountrycode("91");
			phone.setUserNumber(phoneNumberArray[0]);

		} else {
			// extract the countrycode and set it to the phone class countrycodeproperty

			phone.setCountrycode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}
		return phone;

	}


}
