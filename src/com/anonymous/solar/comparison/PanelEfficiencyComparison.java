package com.anonymous.solar.comparison;

import java.util.Comparator;
import com.anonymous.solar.shared.SolarPanel;

public class PanelEfficiencyComparison implements Comparator<SolarPanel> {

	@Override
	public int compare(SolarPanel o1, SolarPanel o2) {
		Double loss1 = o1.getPanelLossYear();
		Double loss2 = o2.getPanelLossYear();
 
        if (loss1 > loss2){
            return +1;
        }else if (loss1 < loss2){
            return -1;
        }else{
            return 0;
        }
	}

}
