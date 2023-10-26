package com.aakriti.mvcIntermediate.propertyeditor;

import java.beans.PropertyEditorSupport;

// for creating own PropertyEditor we have to only extend the PropertyEditorSupport class

public class NameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String textFromJsp) throws IllegalArgumentException {
		String updatedstring = textFromJsp.toUpperCase();
		setValue(updatedstring);
	}
}
