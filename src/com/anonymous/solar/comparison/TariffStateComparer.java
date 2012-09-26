package com.anonymous.solar.comparison;

import java.util.Comparator;
import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.TariffRate;

public class TariffStateComparer implements Comparator<TariffRate> {

	@Override
	public int compare(TariffRate inv1, TariffRate inv2) {
		String state1 = inv1.getTariffState();
		String state2 = inv2.getTariffState();
 
        if (state1.compareTo(state2) == 0){
            return 0;
        }else if (state1.compareTo(state2) > 1){
            return 1;
        }else{
            return -1;
        }
	}

}
