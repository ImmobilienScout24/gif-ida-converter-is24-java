package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.BuildingType;


/**
 * @author Martin Fluegge
 * 
 */
public class BuildingTypeHelper extends TypeMapHelper<BuildingType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(BuildingType.NO_INFORMATION, "");
		reverseMap.put(BuildingType.SINGLE_FAMILY_HOUSE, "Einfamilienhaus (freistehend)");
		reverseMap.put(BuildingType.MID_TERRACE_HOUSE, "Reihenmittelhaus");
		reverseMap.put(BuildingType.END_TERRACE_HOUSE, "Reiheneckhaus");
		reverseMap.put(BuildingType.MULTI_FAMILY_HOUSE, "Mehrfamilienhaus");
		reverseMap.put(BuildingType.BUNGALOW, "Bungalow");
		reverseMap.put(BuildingType.FARMHOUSE, "Bauernhaus");
		reverseMap.put(BuildingType.SEMIDETACHED_HOUSE, "Doppelhaushälfte");
		reverseMap.put(BuildingType.VILLA, "Villa");
		reverseMap.put(BuildingType.CASTLE_MANOR_HOUSE, "Burg/ Schloss");
		reverseMap.put(BuildingType.SPECIAL_REAL_ESTATE, "Besondere Immobilie");
		reverseMap.put(BuildingType.OTHER, "Wohnimmobilie (sonstige)");
	}
}
