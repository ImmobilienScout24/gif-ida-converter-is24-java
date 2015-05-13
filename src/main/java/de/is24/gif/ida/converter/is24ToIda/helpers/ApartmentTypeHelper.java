package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.ApartmentType;


/**
 * @author Martin Fluegge
 * 
 */
public class ApartmentTypeHelper extends TypeMapHelper<ApartmentType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(ApartmentType.ROOF_STOREY, "Dachgeschoss");
		reverseMap.put(ApartmentType.LOFT, "Loft");
		reverseMap.put(ApartmentType.MAISONETTE, "Maisonette");
		reverseMap.put(ApartmentType.PENTHOUSE, "Penthouse");
		reverseMap.put(ApartmentType.TERRACED_FLAT, "Terrassenwohnung");
		reverseMap.put(ApartmentType.GROUND_FLOOR, "Erdgeschosswohnung");
		reverseMap.put(ApartmentType.APARTMENT, "Etagenwohnung");
		reverseMap.put(ApartmentType.RAISED_GROUND_FLOOR, "Hochparterre");
		reverseMap.put(ApartmentType.HALF_BASEMENT, "Souterrain");
		reverseMap.put(ApartmentType.OTHER, "Sonstige");
		reverseMap.put(ApartmentType.NO_INFORMATION, "");
	}
}
