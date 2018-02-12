package com.ubicompsystem.integration.google.hotelads.hotelfeed.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ubicompsystem.common.util.Logger;
import com.ubicompsystem.core.property.service.PropertyService;
import com.ubicompsystem.data.contact.address.AddressData;
import com.ubicompsystem.data.contact.address.AddressTypeCode;
import com.ubicompsystem.data.property.PropertyAttributeData;
import com.ubicompsystem.data.property.PropertyBizObj;
import com.ubicompsystem.data.property.PropertyData;
import com.ubicompsystem.enumerate.PropertyAttribute;
import com.ubicompsystem.integration.google.hotelads.*;

public class DefaultCorePropertyService {

	@Autowired
	PropertyService propertyService;
	
	Logger log = new Logger( this.getClass() );
	
	public Listings getListings(){
		Listings result = new Listings();
		System.out.println( getPropertyService() );
		result.getListing().add(generateListing());
		System.out.println( printListing(generateListing()) );
		return result;
	}

	public Listing generateListing() {
		PropertyBizObj property = new PropertyBizObj();
		PropertyData propertyData = new PropertyData();
		property.setPropertyData(propertyData);
		propertyData.setPropertyID(1);
		propertyData.setCustomerID("TESTCUST");
		propertyData.setPropertyCode("TESTPROP");

		AddressData address = new AddressData();
		address.setAddress("1, General Street,\n Gramacy Park" );
		address.setCity( "Test City" );
		address.setState( "Test State" );
		property.setAddressList(Arrays.asList(address));

		propertyData.setPropertyName( "Test Property", "en" );

		PropertyAttributeData description = new PropertyAttributeData();
		description.setAttributeCode(PropertyAttribute.DESC.name());
		description.setAttributeValue("Property Description");
		description.setLanguageCode("en");
		propertyData.getAttributeList().add( description );

		return transform( property );
	}
	
	public Listing transform( PropertyBizObj property ) {
		Listing result = null;
		if( property != null ) {
			result = new Listing();
            result.setContent(new Content());
			populateID(result, property);
			populateAddress(result, property);
			populateAttributes( result, property );
			populateImages(result, property);
			populateReviews(result, property);
		}
		return result;
	}

	public void populateID(Listing listing, PropertyBizObj property) {
		if( listing != null && property != null ) {
			StringBuilder propertyID = new StringBuilder();
			PropertyData propertyData = property.getPropertyData();
			if( propertyData != null ) {
				if( propertyData.getPropertyID() != null ) {
					propertyID.append( propertyData.getPropertyID() );
				} else {
					if(propertyData.getCustomerID() != null && !"".equals(propertyData.getCustomerID().trim())) {
						propertyID.append( propertyData.getCustomerID() );
					}
					if(propertyData.getPropertyCode() != null && !"".equals(propertyData.getPropertyCode().trim())) {
						propertyID.append( "::" );
						propertyID.append( propertyData.getPropertyCode() );
					}
				}
			}
			listing.setId(propertyID.toString());
		}
	}
	
	public void populateAttributes( Listing listing, PropertyBizObj property ) {
		if( listing != null && property != null ) {
			Map<String, Map<String, List<PropertyAttributeData>>> propertyAttributes = mapPropertyAttributesByLanguage(property);
			System.out.println( propertyAttributes );
			populateName( listing, propertyAttributes );
			populateDescription( listing, propertyAttributes );
		}
	}
	
	public void populateName( Listing listing, Map<String, Map<String, List<PropertyAttributeData>>> propertyAttributes ) {
		if( listing != null && propertyAttributes != null ) {
			for( String languageCode : propertyAttributes.keySet() ) {
				Map<String, List<PropertyAttributeData>> mapOfAttributes = propertyAttributes.get(languageCode);
				if( mapOfAttributes != null ) {
					List<PropertyAttributeData>  attributes = mapOfAttributes.get( PropertyAttribute.PROPNAME.name() );
					if( attributes != null && attributes.size() > 0 ) {
						PropertyAttributeData nameAttribute =  attributes.get(0);
						String propertyName = nameAttribute.getAttributeValue();
						System.out.println( "Name : " + propertyName );
						if( propertyName != null && !"".equals(propertyName.trim())) {
							if( languageCode != null && languageCode.contains("_") ) {
								languageCode = languageCode.substring(0, languageCode.indexOf("_") ).toUpperCase();
							} else {
							    languageCode = LanguageContent.EN.name();
                            }
							try {
								LanguageContent contentLanguage = LanguageContent.valueOf(languageCode);
								Name name = new Name();
								name.setLanguage(contentLanguage);
								name.setValue(propertyName);
								System.out.println( "Setting Name : " + name.getValue() + "(" + name.getLanguage() + ")" );
								listing.getName().add(name);
							} catch( IllegalArgumentException illegalArgEx ) {
							}
						}
					}
				}
			}
		}
	}
	
	public void populateDescription( Listing listing, Map<String, Map<String, List<PropertyAttributeData>>> propertyAttributes ) {
		if( listing != null && propertyAttributes != null ) {
			for( String languageCode : propertyAttributes.keySet() ) {
				Map<String, List<PropertyAttributeData>> mapOfAttributes = propertyAttributes.get(languageCode);
				if( mapOfAttributes != null ) {
					List<PropertyAttributeData> attributes = mapOfAttributes.get( PropertyAttribute.DESC.name());
					if( attributes != null && attributes.size() > 0 ) {
						PropertyAttributeData descAttribute = attributes.get(0);
						String propertyDesc = descAttribute.getAttributeValue();
						if( propertyDesc != null && !"".equals(propertyDesc.trim())) {
							if( languageCode != null && languageCode.contains("_") ) {
								languageCode = languageCode.substring(0, languageCode.indexOf("_"));
							}
							Text text = new Text();
							text.setType("description");
							text.setTitle("description_" + languageCode);
							text.setBody(propertyDesc);
							listing.getContent().getTextOrReviewOrImage().add(text);
						}
					}
				}
			}
		}
	}
	
	public void populateImages( Listing listing, PropertyBizObj property ) {
		//TODO: No Images Yet
	}
	
	public void populateReviews( Listing listing, PropertyBizObj property ) {
		//TODO: No Reviews Yet
	}
	
	public void populateAddress( Listing listing, PropertyBizObj property ) {
		if( property != null && listing != null ) {
			if( property.getAddressList() != null ) {
				String country = null;
				Float longitude = null;
				Float latitude = null;
				for( AddressData address : property.getAddressList() ) {
					Address listingAddress = transform( address );
					if( listingAddress != null ) {
						listing.getAddress().add(listingAddress);
					}

					if( address.getCountryCode() != null && !"".equals(address.getCountryCode())) {
						if( country == null || AddressTypeCode.INTER.name().equals( address.getAddressTypeCode() ) ) {
							country = address.getCountryCode();
						}
					}
					
					if( address.getLongitude() != null && address.getLatitude() != null ) {
						if( longitude == null || AddressTypeCode.INTER.name().equals( address.getAddressTypeCode() ) ) {
							longitude = address.getLongitude().floatValue();
							latitude = address.getLatitude().floatValue();
						}
					}
					
				}
				listing.setCountry(country);
				if( longitude != null && latitude != null ) {
					listing.setLongitude(longitude);
					listing.setLatitude(latitude);
				 } else {
				    listing.setLongitude( 100f );
				    listing.setLatitude( 100f );
                }
			}
		}
	}
	
	public Address transform( AddressData address ) {
		Address result = null;
		if( address != null ) {
			result = new Address();
			String addressLines = address.getAddress();
			String city = address.getCity();
			String state = address.getState();
			String postalCode = address.getZipCode();
			
			if( addressLines != null && !"".equals( addressLines.trim() ) ) {
				String[] lines = addressLines.split("\n");
				if( lines.length > 0 ) {
					result.getContent().add(createComponent(AddressTypes.ADDR1.value(), lines[0]));
				}
				
				if( lines.length > 1 ) {
					result.getContent().add(createComponent(AddressTypes.ADDR2.value(), lines[1]));
				}
				
				if( lines.length > 2 ) {
					StringBuilder remainder = new StringBuilder();
					for( int i = 2; i < lines.length; i++ ) {
						remainder.append(lines[i]);
					}
					result.getContent().add(createComponent( AddressTypes.ADDR3.value(), remainder.toString()));
				}
			}
			
			if( city != null && !"".equals(city.trim())) {
				result.getContent().add(createComponent(AddressTypes.CITY.value(), city ));
			}
			
			if( state != null && !"".equals(state.trim())) {
				result.getContent().add(createComponent(AddressTypes.PROVINCE.value(), state ));
			}
			
			if( postalCode != null && !"".equals(postalCode.trim())) {
				result.getContent().add(createComponent( AddressTypes.POSTAL_CODE.value(), postalCode));
			}
			
		}
		return result;
	}
	
	protected Component createComponent( String name, String value ) {
		Component result = new Component();
		result.setName(name);
		result.setContent(value);
		return result;
	}
	
	protected Map<String, Map<String, List<PropertyAttributeData>>> mapPropertyAttributesByLanguage( PropertyBizObj property ){
		Map<String, Map<String, List<PropertyAttributeData>>> result = new HashMap<String, Map<String,List<PropertyAttributeData>>>();
		if( property != null ) {
			if( property.getPropertyData() != null ) {
				List<PropertyAttributeData> attributes = property.getPropertyData().getAttributeList();
				if( attributes != null ) {
					for( PropertyAttributeData attribute : attributes ) {
						String languageCode = attribute.getLanguageCode();
						Map<String,List<PropertyAttributeData>> attributeMap = result.get(languageCode);
						if( attributeMap == null ) {
							attributeMap = new HashMap<String, List<PropertyAttributeData>>();
							result.put( languageCode, attributeMap);
						}
						
						List<PropertyAttributeData> attributeList = attributeMap.get(attribute.getAttributeCode());
						if( attributeList == null ) {
							attributeList = new ArrayList<PropertyAttributeData>();
							attributeMap.put( attribute.getAttributeCode(), attributeList );
						}
						attributeList.add( attribute );
					}
				}
			}
		}
		return result;
	}
	
	private PropertyService getPropertyService() {
		return this.propertyService;
	}

	public static String printListing( Listing listing ){
	    StringBuilder result = new StringBuilder();
	    result.append( "Listing\n" );
	    result.append( "ID : " );
	    result.append( listing.getId() );
	    result.append( "\n" );
	    result.append( "Names : " ).append( "(" ).append( listing.getName().size() ).append(")\n");
	    for( Name name : listing.getName() ){
	        result.append( "Name : " )
                    .append( name.getValue() )
                    .append("(")
                    .append(name.getLanguage())
                    .append(")\n");
        }
        result.append( "Location : " ).append( listing.getLongitude() ).append( ", " ).append( listing.getLatitude() );
	    result.append("\n");
        return result.toString();
    }

}
