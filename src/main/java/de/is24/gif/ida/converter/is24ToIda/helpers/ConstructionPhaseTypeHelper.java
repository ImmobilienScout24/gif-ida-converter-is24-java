package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.ConstructionPhaseType;


/**
 * @author Martin Fluegge
 * 
 */
public class ConstructionPhaseTypeHelper extends TypeMapHelper<ConstructionPhaseType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(ConstructionPhaseType.NO_INFORMATION, "");
		reverseMap.put(ConstructionPhaseType.PROJECTED, "Haus in Planung (projektiert)");
		reverseMap.put(ConstructionPhaseType.UNDER_CONSTRUCTION, "Haus im Bau");
		reverseMap.put(ConstructionPhaseType.COMPLETED, "Haus fertig gestellt");
	}
}
