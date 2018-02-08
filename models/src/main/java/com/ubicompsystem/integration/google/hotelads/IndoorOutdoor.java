package com.ubicompsystem.integration.google.hotelads;

public enum IndoorOutdoor implements StringValueEnum {

	INDOOR("Indoors"),
	OUTDOOR("Outdoors"),
	BOTH("Indoors and outdoors"),
	NOT_AVAILABLE("Not Available");
	
	String value;
	IndoorOutdoor( String value ){
		this.value = value;
	}
	
	@Override
	public String value() {
		return this.value;
	}
}
