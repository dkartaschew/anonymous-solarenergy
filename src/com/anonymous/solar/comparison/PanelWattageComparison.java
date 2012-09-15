package com.anonymous.solar.comparison;

import java.util.Comparator;

import com.anonymous.solar.shared.SolarPanel;

public class PanelWattageComparison implements Comparator<SolarPanel> {
	@Override
	public int compare(SolarPanel o1, SolarPanel o2) {
		Double cost1 = o1.getPanelWattage();
		Double cost2 = o2.getPanelWattage();
 
        if (cost1 > cost2){
            return +1;
        }else if (cost1 < cost2){
            return -1;
        }else{
            return 0;
        }
	}
}
