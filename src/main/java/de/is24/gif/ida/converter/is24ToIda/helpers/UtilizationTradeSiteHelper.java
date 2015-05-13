package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.UtilizationTradeSite;


/**
 * @author Martin Fluegge
 * 
 */
public class UtilizationTradeSiteHelper extends TypeMapHelper<UtilizationTradeSite, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(UtilizationTradeSite.LEISURE, "Freizeit");
		reverseMap.put(UtilizationTradeSite.AGRICULTURE_FORESTRY, "Land-/Forstwirtschaft");
		reverseMap.put(UtilizationTradeSite.TRADE, "Gewerbe");
	}
}
