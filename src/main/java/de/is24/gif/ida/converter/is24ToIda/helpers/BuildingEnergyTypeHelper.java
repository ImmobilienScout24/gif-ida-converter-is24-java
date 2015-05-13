package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.BuildingEnergyRatingType;


/**
 * @author Martin Fluegge
 * 
 */
public class BuildingEnergyTypeHelper extends TypeMapHelper<BuildingEnergyRatingType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(BuildingEnergyRatingType.NO_INFORMATION, "");
		reverseMap.put(BuildingEnergyRatingType.ENERGY_REQUIRED, "Bedarfsausweis"); // "Endenergiebedarf"
		reverseMap.put(BuildingEnergyRatingType.ENERGY_CONSUMPTION, "Verbrauchsausweis"); //
	}
}
