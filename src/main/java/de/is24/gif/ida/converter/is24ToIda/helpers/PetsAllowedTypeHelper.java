package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.PetsAllowedType;


/**
 * @author Martin Fluegge
 * 
 */
public class PetsAllowedTypeHelper extends TypeMapHelper<PetsAllowedType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(PetsAllowedType.NO_INFORMATION, "");
		reverseMap.put(PetsAllowedType.NEGOTIABLE, "Nach Vereinbarung");
		reverseMap.put(PetsAllowedType.YES, "Ja");
		reverseMap.put(PetsAllowedType.NO, "Nein");
	}
}
