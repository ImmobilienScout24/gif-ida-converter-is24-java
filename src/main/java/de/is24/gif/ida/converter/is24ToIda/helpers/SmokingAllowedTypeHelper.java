package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.SmokingAllowedType;


/**
 * @author Martin Fluegge
 * 
 */
public class SmokingAllowedTypeHelper extends TypeMapHelper<SmokingAllowedType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(SmokingAllowedType.NO_INFORMATION, "");
		reverseMap.put(SmokingAllowedType.ALLOWED, "Erlaubt");
		reverseMap.put(SmokingAllowedType.UNWANTED, "Unerwünscht");
		reverseMap.put(SmokingAllowedType.OWN_ROOM_ONLY, "Nur im eigenen Zimmer");
	}
}
