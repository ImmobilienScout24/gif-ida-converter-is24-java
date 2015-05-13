package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.ParkingSituationType;


/**
 * @author Martin Fluegge
 * 
 */
public class ParkingSituationTypeHelper extends TypeMapHelper<ParkingSituationType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(ParkingSituationType.NO_INFORMATION, "");
		reverseMap.put(ParkingSituationType.GOOD, "Gute Parkmöglichkeit");
		reverseMap.put(ParkingSituationType.BAD, "Schlechte Parkmöglichkeit");
		reverseMap.put(ParkingSituationType.RESIDENT_PARKING, "Bewohnerparken");
		reverseMap.put(ParkingSituationType.OWN_PARKING_SPACE, "Eigener Stellplatz/Garage");
	}
}
