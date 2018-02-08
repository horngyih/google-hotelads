package com.ubicompsystem.integration.google.hotelads;

public enum PaymentType implements StringValueEnum {

	FREE("No payment required"),
	PAID("Paid"),
	NOT_AVAILABLE("Not available");
	
	String value;
	PaymentType(String value){
		this.value = value;
	}
	
	@Override
	public String value() {
		return this.value;
	}
}
