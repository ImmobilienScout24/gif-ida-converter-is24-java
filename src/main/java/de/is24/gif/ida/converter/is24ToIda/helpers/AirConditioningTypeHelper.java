package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.AirConditioningType;


/**
 * @author Martin Fluegge
 * 
 */
public class AirConditioningTypeHelper extends TypeMapHelper<AirConditioningType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(AirConditioningType.NO_INFORMATION, "");
		reverseMap.put(AirConditioningType.YES, "Ja");
		reverseMap.put(AirConditioningType.NO, "Nein");
		reverseMap.put(AirConditioningType.BY_APPOINTMENT, "Nach Vereinbarung");
	}
}
