/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

/*
 * SignedElements.java
 *
 * Created on February 17, 2006, 9:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.sun.xml.ws.security.impl.policy;

import com.sun.xml.ws.policy.AssertionSet;
import com.sun.xml.ws.policy.PolicyAssertion;
import com.sun.xml.ws.policy.sourcemodel.AssertionData;
import com.sun.xml.ws.security.policy.SecurityAssertionValidator;
import com.sun.xml.ws.security.policy.SecurityPolicyVersion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import static com.sun.xml.ws.security.impl.policy.Constants.*;
/**
 *
 * @author K.Venugopal@sun.com
 */
public class SignedElements extends PolicyAssertion implements com.sun.xml.ws.security.policy.SignedElements, SecurityAssertionValidator{
    
    private String xpathVersion;
    private List<String> targetList;
    private boolean populated = false;
    private static QName XPathVersion = new QName("XPathVersion");
    private static List<String> emptyList = Collections.emptyList();
    private AssertionFitness fitness = AssertionFitness.IS_VALID;
    private SecurityPolicyVersion spVersion;
    
    /** Creates a new instance of SignedElements */
    public SignedElements() {
        spVersion = SecurityPolicyVersion.SECURITYPOLICY200507;
    }
    
    public SignedElements(AssertionData name,Collection<PolicyAssertion> nestedAssertions, AssertionSet nestedAlternative) {
        super(name,nestedAssertions,nestedAlternative);
        String nsUri = getName().getNamespaceURI();
        spVersion = PolicyUtil.getSecurityPolicyVersion(nsUri);
    }
    
    public String getXPathVersion() {
        populate();
        return xpathVersion;
    }
    
    public void setXPathVersion(String version) {
        this.xpathVersion = version;
    }
    
    public void addTarget(String target) {
        if ( targetList == null ) {
            targetList = new ArrayList<String>();
        }
        targetList.add(target);
    }
    
    public void removeTarget(String target) {
        if ( targetList != null ) {
            targetList.remove(target);
        }
    }
    
    public Iterator<String> getTargets() {
        populate();
        if ( targetList != null ) {
            return targetList.iterator();
        }
        return emptyList.iterator();
    }
    
    public AssertionFitness validate(boolean isServer) {
        return populate(isServer);
    }
    private void populate(){
        populate(false);
    }
    
    private synchronized AssertionFitness populate(boolean isServer) {
        if ( !populated ) {
            this.xpathVersion = this.getAttributeValue(XPathVersion);
            
            if ( this.hasNestedAssertions() ) {
                
                Iterator <PolicyAssertion> it = this.getNestedAssertionsIterator();
                while( it.hasNext() ) {
                    PolicyAssertion assertion = (PolicyAssertion) it.next();
                    if ( PolicyUtil.isXPath(assertion, spVersion)) {
                        addTarget(assertion.getValue());
                    }else{
                        if(!assertion.isOptional()){
                            log_invalid_assertion(assertion, isServer,SignedElements);
                            fitness = AssertionFitness.HAS_UNKNOWN_ASSERTION;
                        }
                    }
                }
            }
            populated = true;
        }
        return fitness;
    }
}
