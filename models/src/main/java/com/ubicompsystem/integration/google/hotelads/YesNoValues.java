package com.ubicompsystem.integration.google.hotelads;

public enum YesNoValues implements StringValueEnum {
	YES("Yes"),
	NO("No");
	
	String value;
	YesNoValues( String value ){
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}

}
