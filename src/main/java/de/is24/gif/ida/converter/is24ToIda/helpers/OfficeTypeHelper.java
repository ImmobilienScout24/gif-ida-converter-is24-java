package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.OfficeType;


/**
 * @author Martin Fluegge
 * 
 */
public class OfficeTypeHelper extends TypeMapHelper<OfficeType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(OfficeType.LOFT, "Loft");
		reverseMap.put(OfficeType.STUDIO, "Atelier");
		reverseMap.put(OfficeType.OFFICE, "Büro");
		reverseMap.put(OfficeType.OFFICE_FLOOR, "Büroetage");
		reverseMap.put(OfficeType.OFFICE_BUILDING, "Bürohaus");
		reverseMap.put(OfficeType.OFFICE_CENTRE, "Bürozentrum");
		reverseMap.put(OfficeType.OFFICE_STORAGE_BUILDING, "Büro-/Lagergebäude");
		reverseMap.put(OfficeType.SURGERY, "Praxis");
		reverseMap.put(OfficeType.SURGERY_FLOOR, "Praxisetage");
		reverseMap.put(OfficeType.SURGERY_BUILDING, "Praxishaus");
		reverseMap.put(OfficeType.COMMERCIAL_CENTRE, "Gewerbezentrum");
		reverseMap.put(OfficeType.LIVING_AND_COMMERCIAL_BUILDING, "Wohn- und Geschäftsgebäude");
		reverseMap.put(OfficeType.OFFICE_AND_COMMERCIAL_BUILDING, "Büro- und Geschäftsgebäude");
	}
}
