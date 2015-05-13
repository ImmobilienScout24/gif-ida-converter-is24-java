package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.ParkingSpaceType;


/**
 * @author Martin Fluegge
 * 
 */
public class ParkingSpaceTypeHelper extends TypeMapHelper<ParkingSpaceType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(ParkingSpaceType.NO_INFORMATION, "");
		reverseMap.put(ParkingSpaceType.GARAGE, "Garage");
		reverseMap.put(ParkingSpaceType.OUTSIDE, "Außenstellplatz");
		reverseMap.put(ParkingSpaceType.CARPORT, "Carport");
		reverseMap.put(ParkingSpaceType.DUPLEX, "Duplex");
		reverseMap.put(ParkingSpaceType.CAR_PARK, "Parkhaus");
		reverseMap.put(ParkingSpaceType.UNDERGROUND_GARAGE, "Tiefgarage");
	}
}
