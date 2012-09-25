
package com.anonymous.solar.server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "insertTariffRate", namespace = "http://server.solar.anonymous.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertTariffRate", namespace = "http://server.solar.anonymous.com/")
public class InsertTariffRate {

    @XmlElement(name = "arg0", namespace = "")
    private com.anonymous.solar.shared.TariffRate arg0;

    /**
     * 
     * @return
     *     returns TariffRate
     */
    public com.anonymous.solar.shared.TariffRate getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.anonymous.solar.shared.TariffRate arg0) {
        this.arg0 = arg0;
    }

}
