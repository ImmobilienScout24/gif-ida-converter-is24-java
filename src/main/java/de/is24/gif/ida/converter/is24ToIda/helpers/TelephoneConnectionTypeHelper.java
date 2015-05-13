package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.TelephoneConnectionType;


/**
 * @author Martin Fluegge
 * 
 */
public class TelephoneConnectionTypeHelper extends TypeMapHelper<TelephoneConnectionType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(TelephoneConnectionType.NO_INFORMATION, "");
		reverseMap.put(TelephoneConnectionType.ANALOG, "Analog");
		reverseMap.put(TelephoneConnectionType.ISDN, "ISDN");
		reverseMap.put(TelephoneConnectionType.NOT_AVAILABLE, "Nicht vorhanden");
	}
}
