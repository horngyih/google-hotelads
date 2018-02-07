//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.07 at 07:13:36 PM SGT 
//


package com.ubicompsystems.integration.google.hotelads;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &lt;choice maxOccurs="2" minOccurs="0"&gt;
 *         &lt;element ref="{}UPC_A"/&gt;
 *         &lt;element ref="{}EAN_13"/&gt;
 *         &lt;element ref="{}UCC_EAN_128"/&gt;
 *         &lt;element ref="{}CODE_128"/&gt;
 *         &lt;element ref="{}CODE_39"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "upcaOrEAN13OrUCCEAN128"
})
@XmlRootElement(name = "barcode")
public class Barcode {

    @XmlElementRefs({
        @XmlElementRef(name = "CODE_128", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CODE_39", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EAN_13", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UCC_EAN_128", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UPC_A", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> upcaOrEAN13OrUCCEAN128;

    /**
     * Gets the value of the upcaOrEAN13OrUCCEAN128 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the upcaOrEAN13OrUCCEAN128 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUPCAOrEAN13OrUCCEAN128().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getUPCAOrEAN13OrUCCEAN128() {
        if (upcaOrEAN13OrUCCEAN128 == null) {
            upcaOrEAN13OrUCCEAN128 = new ArrayList<JAXBElement<String>>();
        }
        return this.upcaOrEAN13OrUCCEAN128;
    }

}
