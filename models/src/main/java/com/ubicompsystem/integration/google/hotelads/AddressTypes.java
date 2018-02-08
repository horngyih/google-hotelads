package com.ubicompsystem.integration.google.hotelads;

public enum AddressTypes implements StringValueEnum {
	ADDR1("addr1"), ADDR2("addr2"), ADDR3("addr3"), CITY("city"), PROVINCE("province"), POSTAL_CODE("postal_code");
	
	String value;
	AddressTypes(String value){
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
}
