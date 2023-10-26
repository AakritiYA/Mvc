package com.aakriti.mvcIntermediate.api;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;

public class UserInfoDTO {

	@NotBlank( message = "Your name should not be null")
	private String username; //this name should be same as the form input name
	private String lovername; //this name should be same as the form input name
	@AssertTrue(message = "you have to tick the check box")
	private boolean termandcondition;
	
	private String res;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLovername() {
		return lovername;
	}

	public void setLovername(String lovername) {
		this.lovername = lovername;
	}

	public boolean isTermandcondition() {
		return termandcondition;
	}

	public void setTermandcondition(boolean termandcondition) {
		this.termandcondition = termandcondition;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

}
