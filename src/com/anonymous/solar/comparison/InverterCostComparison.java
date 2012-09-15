package com.anonymous.solar.comparison;

import java.util.Comparator;
import com.anonymous.solar.shared.SolarInverter;

public class InverterCostComparison implements Comparator<SolarInverter> {

	@Override
	public int compare(SolarInverter inv1, SolarInverter inv2) {
		Double cost1 = inv1.getInverterCost();
		Double cost2 = inv2.getInverterCost();
 
        if (cost1 > cost2){
            return +1;
        }else if (cost1 < cost2){
            return -1;
        }else{
            return 0;
        }
	}

}
