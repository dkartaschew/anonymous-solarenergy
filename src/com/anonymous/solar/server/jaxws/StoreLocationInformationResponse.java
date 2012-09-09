
package com.anonymous.solar.server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "StoreLocationInformationResponse", namespace = "http://server.solar.anonymous.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoreLocationInformationResponse", namespace = "http://server.solar.anonymous.com/")
public class StoreLocationInformationResponse {

    @XmlElement(name = "return", namespace = "")
    private Long _return;

    /**
     * 
     * @return
     *     returns Long
     */
    public Long getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Long _return) {
        this._return = _return;
    }

}
