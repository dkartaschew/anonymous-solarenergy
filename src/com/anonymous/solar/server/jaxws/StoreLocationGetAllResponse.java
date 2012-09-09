
package com.anonymous.solar.server.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "StoreLocationGetAllResponse", namespace = "http://server.solar.anonymous.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoreLocationGetAllResponse", namespace = "http://server.solar.anonymous.com/")
public class StoreLocationGetAllResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.anonymous.solar.shared.LocationData> _return;

    /**
     * 
     * @return
     *     returns List<LocationData>
     */
    public List<com.anonymous.solar.shared.LocationData> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.anonymous.solar.shared.LocationData> _return) {
        this._return = _return;
    }

}
