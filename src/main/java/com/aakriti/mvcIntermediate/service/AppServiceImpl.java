package com.aakriti.mvcIntermediate.service;

import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {

	public final String appFormula = "EMAFL";
	
	public String calculateLove(String username, String crushname) {
		int countTheCharOfBoth = (username+crushname).toCharArray().length;
		int formulaCount = appFormula.toCharArray().length;
		
		int rem = countTheCharOfBoth % formulaCount;
		char resultChar = appFormula.charAt(rem);
		
		String result = whatBetweenUs(resultChar);
		
		return result;
	}

	public String whatBetweenUs(char calculationResult) {
		
		String result = null;
		
		if(calculationResult == 'E') {
			result = LoveCalculatorConstants.E_CHAR_MEANING;
		}
		else if(calculationResult == 'M') {
			result = LoveCalculatorConstants.M_CHAR_MEANING;
		}
		else if(calculationResult == 'A') {
			result = LoveCalculatorConstants.A_CHAR_MEANING;
		}
		else if(calculationResult == 'F') {
			result = LoveCalculatorConstants.F_CHAR_MEANING;
		}
		else if(calculationResult == 'L') {
			result = LoveCalculatorConstants.L_CHAR_MEANING;
		}
		return result;
	}

}
