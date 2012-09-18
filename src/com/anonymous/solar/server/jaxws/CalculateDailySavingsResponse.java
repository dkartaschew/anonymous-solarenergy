
package com.anonymous.solar.server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "calculateDailySavingsResponse", namespace = "http://server.solar.anonymous.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateDailySavingsResponse", namespace = "http://server.solar.anonymous.com/")
public class CalculateDailySavingsResponse {

    @XmlElement(name = "return", namespace = "")
    private com.anonymous.solar.shared.SolarResult _return;

    /**
     * 
     * @return
     *     returns SolarResult
     */
    public com.anonymous.solar.shared.SolarResult getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.anonymous.solar.shared.SolarResult _return) {
        this._return = _return;
    }

}
