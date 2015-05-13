package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.OfficeRentDuration;


/**
 * @author cheeren
 * 
 */
public class OfficeRentDurationHelper extends TypeMapHelper<OfficeRentDuration, String> {

	@Override
	protected void fillMap() {
		reverseMap.put(OfficeRentDuration.WEEKLY, "Wochenweise");
		reverseMap.put(OfficeRentDuration.MONTHLY, "Monatsweise");
		reverseMap.put(OfficeRentDuration.YEARLY, "1-2 Jahre");
		reverseMap.put(OfficeRentDuration.LONG_TERM, "Langfristig");
	}
}
