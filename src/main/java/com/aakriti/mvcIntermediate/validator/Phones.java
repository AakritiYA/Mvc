package com.aakriti.mvcIntermediate.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Documented
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phones {

	public String message() default "{invalidPhoneMessage}"; //"Phone Number must of 10 digits and contains only numberical values";
//	public int digitCount() default 0;
//	public boolean notNull() default false;
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
