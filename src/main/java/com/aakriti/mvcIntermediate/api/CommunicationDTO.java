package com.aakriti.mvcIntermediate.api;

import com.aakriti.mvcIntermediate.validator.Phones;

public class CommunicationDTO {

	private String email;
	@Phones
	private Phone phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CommunicationDTO [email=" + email + ", phone=" + phone + "]";
	}
	
//	we can use formatter, own custom property editor or converter
//	for formatter and converter we have to register it in config file
//	focus in deeply

}
