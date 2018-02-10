package com.ubicompsystem.integration.google.hotelads.hotelfeed.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubicompsystem.integration.google.hotelads.Address;
import com.ubicompsystem.integration.google.hotelads.AddressTypes;
import com.ubicompsystem.integration.google.hotelads.Attr;
import com.ubicompsystem.integration.google.hotelads.AttrType;
import com.ubicompsystem.integration.google.hotelads.Attributes;
import com.ubicompsystem.integration.google.hotelads.Author;
import com.ubicompsystem.integration.google.hotelads.Component;
import com.ubicompsystem.integration.google.hotelads.Content;
import com.ubicompsystem.integration.google.hotelads.Image;
import com.ubicompsystem.integration.google.hotelads.Listing;
import com.ubicompsystem.integration.google.hotelads.Listings;
import com.ubicompsystem.integration.google.hotelads.Review;
import com.ubicompsystem.integration.google.hotelads.Text;
import com.ubicompsystem.integration.google.hotelads.YesNoValues;
import com.ubicompsystem.integration.google.hotelads.hotelfeed.services.DefaultCorePropertyService;

@RestController
public class HotelFeedResource {
	
	//TODO : Convert to interface and Autowire
	DefaultCorePropertyService propertyService = new DefaultCorePropertyService();
	
	@RequestMapping(value="/", produces=MediaType.APPLICATION_XML_VALUE)
	public Listings getListings() {
		Listings result = new Listings();
		result.getListing().addAll(generateListings());
		return result;
	}
	
	protected List<Listing> generateListings(){
		List<Listing> result = new ArrayList<Listing>();
		Listing listing = new Listing();
		
		listing.setLongitude( 101.1029f );
		listing.setLatitude( -0.920129f );
		
		listing.getAddress().add(generateAddress());
		listing.setCountry("ATM");
		listing.setContent(generateContent());
		result.add(listing);
		
		return result;
	}
	
	protected Address generateAddress() {
		Address result = new Address();
		result.getContent().addAll( Arrays.asList( new Component[] {
			component( AddressTypes.ADDR1.value(), "1 Circuitry Circuit" ),
			component( AddressTypes.ADDR2.value(), "Electron Grove" ),
			component( AddressTypes.ADDR3.value(), "Processor Precinct" ),
			component( AddressTypes.CITY.value(), "Elec 3 City" ),
			component( AddressTypes.PROVINCE.value(), "Ionic" ),
			component( AddressTypes.POSTAL_CODE.value(), "102012" )
		}));
		return result;
	}
	
	protected Content generateContent() {
		Content result = new Content();
		result.getTextOrReviewOrImage().addAll( Arrays.asList( new Object[] {
			description()
		}));
		return result;
	}

	protected Text description() {
		Text result = new Text();
		result.setTitle("description" );
		result.setTitle("Title");
		result.setLink("http://www.google.com");
		result.setBody("Description");
		return result;
	}
	
	protected Image image() {
		Image result = new Image();
		result.setType("image");
		result.setUrl("http://placehold.it/300x300");
		result.setTitle( "Hotel Image" );
		return result;
	}
	
	protected Attributes attributes() {
		Attributes result = new Attributes();
		result.getAttr().addAll( Arrays.asList( new Attr[] {
			attr(AttrType.AIRCOND.value(), YesNoValues.YES.value() ),
			attr(AttrType.RESTAURANT.value(), YesNoValues.YES.value() )
		}));
		return result;
	}
	
	protected Attr attr( String name, String value ) {
		Attr result = new Attr();
		result.setName(name);
		result.setContent(value);
		return result;
	}
	
	protected Review review() {
		Review result = new Review();
		Author author = new Author();
		result.setAuthor(author);
		return result;
	}
	
	protected Component component( String name, String value ) {
		Component result = new Component();
		result.setName(name);
		result.setContent(value);
		return result;
	}
}
