/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.sun.xml.ws.tx.coord.common.types;

import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.EndpointReference;

import org.w3c.dom.Element;


/**
 * <p>Java class for CreateCoordinationContextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateCoordinationContextType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://docs.oasis-open.org/ws-tx/wscoor/2006/06}Expires" minOccurs="0"/>
 *         &lt;element name="CurrentContext" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://docs.oasis-open.org/ws-tx/wscoor/2006/06}CoordinationContextType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CoordinationType" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;any/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface CreateCoordinationContextType {


    /**
     * Gets the value of the expires property.
     * 
     * @return
     *     possible object is
     *     {@link BaseExpires }
     *     
     */
    BaseExpires getExpires();

    /**
     * Sets the value of the expires property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseExpires }
     *     
     */
    void setExpires(BaseExpires value);

    /**
     * Gets the value of the currentContext property.
     * 
     * @return
     *     possible object is
     *     {@link CreateCoordinationContextType.CurrentContextIF }
     *     
     */
    CurrentContextIF getCurrentContext();

    /**
     * Sets the value of the currentContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateCoordinationContextType.CurrentContextIF }
     *     
     */
    void setCurrentContext(CurrentContextIF value);

    /**
     * Gets the value of the coordinationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getCoordinationType();

    /**
     * Sets the value of the coordinationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setCoordinationType(String value);

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    List<Object> getAny();

    Map<QName, String> getOtherAttributes();


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://docs.oasis-open.org/ws-tx/wscoor/2006/06}CoordinationContextType">
     *       &lt;sequence>
     *         &lt;any/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    public interface CurrentContextIF<T extends EndpointReference,E,I,C>
        extends CoordinationContextTypeIF<T, E,I,C>
    {


        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Element }
         * {@link Object }
         * 
         * 
         */
        List<Object> getAny();

    }

}
