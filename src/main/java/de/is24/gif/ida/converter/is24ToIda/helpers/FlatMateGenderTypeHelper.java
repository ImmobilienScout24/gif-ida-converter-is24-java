package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.FlatMateGenderType;


/**
 * @author Martin Fluegge
 * 
 */
public class FlatMateGenderTypeHelper extends TypeMapHelper<FlatMateGenderType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(FlatMateGenderType.MALE_OR_FEMALE, "");
		reverseMap.put(FlatMateGenderType.MALE, "Männlich");
		reverseMap.put(FlatMateGenderType.FEMALE, "Weiblich");
	}
}
