package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.GarageType;


/**
 * @author Martin Fluegge
 * 
 */
public class GarageTypeHelper extends TypeMapHelper<GarageType, String> {

	@Override
	protected void fillMap() {
		reverseMap.put(GarageType.NO_INFORMATION, "Keine Angabe");
		reverseMap.put(GarageType.GARAGE, "Garage");
		reverseMap.put(GarageType.STREET_PARKING, "Außenstellplatz");
		reverseMap.put(GarageType.CARPORT, "Carport");
		reverseMap.put(GarageType.DUPLEX, "Duplex");
		reverseMap.put(GarageType.CAR_PARK, "Parkhaus");
		reverseMap.put(GarageType.UNDERGROUND_GARAGE, "Tiefgarage");
	}
}
