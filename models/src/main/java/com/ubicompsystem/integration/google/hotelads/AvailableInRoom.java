package com.ubicompsystem.integration.google.hotelads;

public enum AvailableInRoom implements StringValueEnum{
	
	ALL_ROOMS("Available in all rooms"),
	SOME_ROOMS("Availabile in some rooms"),
	NOT_AVAILABLE("Not available");
	
	String value;
	AvailableInRoom(String value){
		this.value = value;
	}
	
	@Override
	public String value() {
		return this.value;
	}
}
