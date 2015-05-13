package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.InternetConnectionType;


/**
 * @author Martin Fluegge
 * 
 */
public class InternetConnectionTypeHelper extends TypeMapHelper<InternetConnectionType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(InternetConnectionType.NO_INFORMATION, "");
		reverseMap.put(InternetConnectionType.DSL, "DSL-Anschluss vorhanden");
		reverseMap.put(InternetConnectionType.DSL_FLATRATE, "DSL-Flatrate");

	}
}
