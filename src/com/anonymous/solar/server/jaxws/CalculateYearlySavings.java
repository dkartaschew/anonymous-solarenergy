
package com.anonymous.solar.server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "calculateYearlySavings", namespace = "http://server.solar.anonymous.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateYearlySavings", namespace = "http://server.solar.anonymous.com/", propOrder = {
    "arg0",
    "arg1"
})
public class CalculateYearlySavings {

    @XmlElement(name = "arg0", namespace = "")
    private com.anonymous.solar.shared.SolarResult arg0;
    @XmlElement(name = "arg1", namespace = "")
    private int arg1;

    /**
     * 
     * @return
     *     returns SolarResult
     */
    public com.anonymous.solar.shared.SolarResult getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.anonymous.solar.shared.SolarResult arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

}
