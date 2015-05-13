package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.SupplyType;


/**
 * @author Martin Fluegge
 * 
 */
public class SupplyTypeHelper extends TypeMapHelper<SupplyType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(SupplyType.NO_INFORMATION, "");
		reverseMap.put(SupplyType.DIRECT_APPROACH, "Direkter Zugang");
		reverseMap.put(SupplyType.NO_DIRECT_APPROACH, "Keine direkte Anfahrt");
		reverseMap.put(SupplyType.CAR_APPROACH, "PKW-Zufahrt");
		reverseMap.put(SupplyType.APPROACH_TO_THE_FRONT, "Anfahrt von vorne");
		reverseMap.put(SupplyType.APPROACH_TO_THE_BACK, "Anfahrt von hinten");
		reverseMap.put(SupplyType.FULL_TIME, "Ganztägig");
		reverseMap.put(SupplyType.FORENOON, "Vormittags");
	}
}
