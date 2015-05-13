package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.SpecialPurposeType;


/**
 * @author Martin Fluegge
 * 
 */
public class SpecialPurposeTypeHelper extends TypeMapHelper<SpecialPurposeType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(SpecialPurposeType.RESIDENCE, "Anwesen");
		reverseMap.put(SpecialPurposeType.FARM, "Bauernhof");
		reverseMap.put(SpecialPurposeType.HORSE_FARM, "Reiterhof");
		reverseMap.put(SpecialPurposeType.VINEYARD, "Weingut");
		reverseMap.put(SpecialPurposeType.REPAIR_SHOP, "Werkstatt");
		reverseMap.put(SpecialPurposeType.LEISURE_FACILITY, "Freizeitanlage");
		reverseMap.put(SpecialPurposeType.INDUSTRIAL_AREA, "Gewerbefläche");
		reverseMap.put(SpecialPurposeType.SPECIAL_ESTATE, "Spezialobjekt");
		reverseMap.put(SpecialPurposeType.COMMERCIAL_CENTRE, "Gewerbepark");
	}
}
