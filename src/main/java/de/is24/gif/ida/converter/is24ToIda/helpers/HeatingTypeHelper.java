package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.HeatingType;


/**
 * @author Martin Fluegge
 * 
 */
public class HeatingTypeHelper extends TypeMapHelper<HeatingType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(HeatingType.NO_INFORMATION, "");
		reverseMap.put(HeatingType.SELF_CONTAINED_CENTRAL_HEATING, "Etagenheizung");
		reverseMap.put(HeatingType.STOVE_HEATING, "Ofenheizung");
		reverseMap.put(HeatingType.CENTRAL_HEATING, "Zentralheizung");
	}
}
