
package com.anonymous.solar.server.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getTariffRatesResponse", namespace = "http://server.solar.anonymous.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTariffRatesResponse", namespace = "http://server.solar.anonymous.com/")
public class GetTariffRatesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.anonymous.solar.shared.TariffRate> _return;

    /**
     * 
     * @return
     *     returns List<TariffRate>
     */
    public List<com.anonymous.solar.shared.TariffRate> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.anonymous.solar.shared.TariffRate> _return) {
        this._return = _return;
    }

}
