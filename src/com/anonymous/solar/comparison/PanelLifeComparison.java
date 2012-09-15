package com.anonymous.solar.comparison;

import java.util.Comparator;

import com.anonymous.solar.shared.SolarPanel;

public class PanelLifeComparison implements Comparator<SolarPanel> {
	@Override
	public int compare(SolarPanel o1, SolarPanel o2) {
		Integer cost1 = o1.getPanelLifeYears();
		Integer cost2 = o2.getPanelLifeYears();
 
        if (cost1 > cost2){
            return +1;
        }else if (cost1 < cost2){
            return -1;
        }else{
            return 0;
        }
	}
}