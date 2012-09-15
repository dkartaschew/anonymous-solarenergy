package com.anonymous.solar.comparison;

import java.util.Comparator;
import com.anonymous.solar.shared.SolarInverter;

public class InverterWattageComparison implements Comparator<SolarInverter> {

	@Override
	public int compare(SolarInverter inv1, SolarInverter inv2) {
		Double item1 = inv1.getInverterWattage();
		Double item2 = inv2.getInverterWattage();
 
        if (item1 > item2){
            return +1;
        }else if (item1 < item2){
            return -1;
        }else{
            return 0;
        }
	}

}
