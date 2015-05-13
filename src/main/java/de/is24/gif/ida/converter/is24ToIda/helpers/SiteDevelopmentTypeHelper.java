package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.SiteDevelopmentType;


/**
 * @author Martin Fluegge
 * 
 */
public class SiteDevelopmentTypeHelper extends TypeMapHelper<SiteDevelopmentType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(SiteDevelopmentType.DEVELOPED, "Erschlossen");
		reverseMap.put(SiteDevelopmentType.DEVELOPED_PARTIALLY, "Teilerschlossen");
		reverseMap.put(SiteDevelopmentType.NOT_DEVELOPED, "Unerschlossen");
		reverseMap.put(SiteDevelopmentType.NO_INFORMATION, "");
	}
}
