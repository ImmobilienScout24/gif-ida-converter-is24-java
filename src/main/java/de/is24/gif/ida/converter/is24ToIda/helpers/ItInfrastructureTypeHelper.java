package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.ItInfrastructureType;


/**
 * @author Martin Fluegge
 * 
 */
public class ItInfrastructureTypeHelper extends TypeMapHelper<ItInfrastructureType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(ItInfrastructureType.NO_INFORMATION, "");
		reverseMap.put(ItInfrastructureType.YES, "Ja");
		reverseMap.put(ItInfrastructureType.NO, "Nein");
		reverseMap.put(ItInfrastructureType.BY_APPOINTMENT, "Nach Vereinbarung");
	}
}
