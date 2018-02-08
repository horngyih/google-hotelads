package com.ubicompsystem.integration.google.hotelads;

public enum AttrType implements StringValueEnum{
	AIRCOND("air_conditioned" ), 
	ALL_INCL("all_inclusive_available"), 
	CHILD_FRIENDLY("child_friendly"),
	HAS_GOLF_AFFL("has_affliated_golf_course"),
	AIRPORT_SHUTTL("has_airport_shuttle"),
	BAR_LOUNGE("has_bar_lounge"),
	BEACH_ACCESS("has_beach_access"),
	BUSS_CTR("has_business_center"),
	FIT_CTR("has_fitness_center"),
	FREE_BR("has_free_breakfast"),
	HOT_TUB("has_hot_tub"),
	LAUNDRY("has_laundry_service"),
	RESTAURANT("has_restaurant"),
	ROOM_SVC("has_room_service"),
	SPA("has_spa"),
	KITCHEN_AVAIL("kitchen_availability"),
	ROOMS_PER_UNIT("number_or_rooms"),
	REVIEWS_COUNT("num_reviews"),
	PARKING_TYPE("parking_type"),
	PETS_ALLOW("pets_allowed"),
	RATING("rating"),
	STARS_RATING("rating_stars"),
	SMOKE_FREE("smoke_free_property"),
	SWIMMING_POOL_TYPE("swimming_pool_type"),
	WHEELCHAIR_ACC("wheelchair_accessible"),
	WIFI_TYPE("wifi_type");
	
	String name;
	AttrType(String name ) {
		this.name = name;
	}
	
	public String value() {
		return this.name;
	}
}
