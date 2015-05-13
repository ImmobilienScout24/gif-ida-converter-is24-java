package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.ShortTermAccommodationType;


/**
 * @author Martin Fluegge
 * 
 */
public class ShortTermAccomodationTypeHelper extends TypeMapHelper<ShortTermAccommodationType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(ShortTermAccommodationType.APARTMENT, "Appartment");
		reverseMap.put(ShortTermAccommodationType.FLAT, "Wohnung");
		reverseMap.put(ShortTermAccommodationType.HOUSE, "Haus");
		reverseMap.put(ShortTermAccommodationType.ROOM, "Zimmer");
	}
}
