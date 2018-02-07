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
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="name" type="{}language_and_text" maxOccurs="unbounded"/&gt;
 *         &lt;element name="description" type="{}language_and_text" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{}menu_option" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "nameOrDescriptionOrMenuOption"
})
@XmlRootElement(name = "menu_item")
public class MenuItem {

    @XmlElementRefs({
        @XmlElementRef(name = "name", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "menu_option", type = MenuOption.class, required = false),
        @XmlElementRef(name = "description", type = JAXBElement.class, required = false)
    })
    protected List<Object> nameOrDescriptionOrMenuOption;

    /**
     * Gets the value of the nameOrDescriptionOrMenuOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameOrDescriptionOrMenuOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameOrDescriptionOrMenuOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MenuOption }
     * {@link JAXBElement }{@code <}{@link LanguageAndText }{@code >}
     * {@link JAXBElement }{@code <}{@link LanguageAndText }{@code >}
     * 
     * 
     */
    public List<Object> getNameOrDescriptionOrMenuOption() {
        if (nameOrDescriptionOrMenuOption == null) {
            nameOrDescriptionOrMenuOption = new ArrayList<Object>();
        }
        return this.nameOrDescriptionOrMenuOption;
    }

}
