//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.07 at 07:13:36 PM SGT 
//


package com.ubicompsystems.integration.google.hotelads;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="card_name"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="30"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="card_logo_url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="add_to_card_message" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="add_to_card_url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="business_logo_url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{}attlist.club_card"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cardName",
    "cardLogoUrl",
    "addToCardMessage",
    "addToCardUrl",
    "businessLogoUrl"
})
@XmlRootElement(name = "club_card")
public class ClubCard {

    @XmlElement(name = "card_name", required = true)
    protected String cardName;
    @XmlElement(name = "card_logo_url", required = true)
    protected String cardLogoUrl;
    @XmlElement(name = "add_to_card_message")
    protected String addToCardMessage;
    @XmlElement(name = "add_to_card_url", required = true)
    protected String addToCardUrl;
    @XmlElement(name = "business_logo_url")
    protected String businessLogoUrl;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "idref")
    @XmlSchemaType(name = "anySimpleType")
    protected String idref;

    /**
     * Gets the value of the cardName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Sets the value of the cardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardName(String value) {
        this.cardName = value;
    }

    /**
     * Gets the value of the cardLogoUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardLogoUrl() {
        return cardLogoUrl;
    }

    /**
     * Sets the value of the cardLogoUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardLogoUrl(String value) {
        this.cardLogoUrl = value;
    }

    /**
     * Gets the value of the addToCardMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddToCardMessage() {
        return addToCardMessage;
    }

    /**
     * Sets the value of the addToCardMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddToCardMessage(String value) {
        this.addToCardMessage = value;
    }

    /**
     * Gets the value of the addToCardUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddToCardUrl() {
        return addToCardUrl;
    }

    /**
     * Sets the value of the addToCardUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddToCardUrl(String value) {
        this.addToCardUrl = value;
    }

    /**
     * Gets the value of the businessLogoUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessLogoUrl() {
        return businessLogoUrl;
    }

    /**
     * Sets the value of the businessLogoUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessLogoUrl(String value) {
        this.businessLogoUrl = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the idref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdref() {
        return idref;
    }

    /**
     * Sets the value of the idref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdref(String value) {
        this.idref = value;
    }

}