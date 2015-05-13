package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.PriceIntervalType;


/**
 * @author Martin Fluegge
 * 
 */
public class PriceIntervalTypeHelper extends TypeMapHelper<PriceIntervalType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(PriceIntervalType.DAY, "Tag");
		reverseMap.put(PriceIntervalType.WEEK, "Woche");
		reverseMap.put(PriceIntervalType.MONTH, "Monat");
		reverseMap.put(PriceIntervalType.YEAR, "Jahr");
		reverseMap.put(PriceIntervalType.ONE_TIME_CHARGE, "Einmalzahlung");
	}
}
