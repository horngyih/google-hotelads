package com.ubicompsystem.integration.google.hotelads;

public enum StarRating implements StringValueEnum {

	ONE_STAR("1"),
	TWO_STAR("2"),
	THREE_STAR("3"),
	FOUR_STAR("4"),
	FIVE_STAR("5");
	
	String value;
	StarRating(String value){
		this.value = value;
	}
	
	@Override
	public String value() {
		return this.value;
	}
}
