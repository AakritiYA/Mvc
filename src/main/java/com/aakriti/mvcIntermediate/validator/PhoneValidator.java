package com.aakriti.mvcIntermediate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phones, String>{
	
//	@Override
	public boolean isValid(String PhoneFromJsp, ConstraintValidatorContext context) {
		//i need to write my logic here
//		int digitCount = 0;
//		for (char c : PhoneFromJsp.toCharArray()) {
//            if (Character.isDigit(c)) {
//                digitCount++;
//            }
//        }
//		
		if(PhoneFromJsp==null) {
			return false;
		}
		
//		if(digitCount!=10) {
//			return false;
//		}
		return true;
	}

//	public void initialize(Phone constraintAnnotation) {
////		i cam write the post construct work right here
////		we will do our initialization stuffs inside this method
//	}
}
