package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.LocationClassificationType;


/**
 * @author Martin Fluegge
 * 
 */
public class LocationClassificationTypeHelper extends TypeMapHelper<LocationClassificationType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(LocationClassificationType.NO_INFORMATION, "");
		reverseMap.put(LocationClassificationType.CLASSIFICATION_A, "A-Lage");
		reverseMap.put(LocationClassificationType.CLASSIFICATION_B, "B-Lage");
		reverseMap.put(LocationClassificationType.SHOPPING_CENTRE, "Einkaufszentrum");
	}
}
