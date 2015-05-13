package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.RealEstateCondition;


/**
 * @author Martin Fluegge
 * 
 */
public class RealEstateConditionTypeHelper extends TypeMapHelper<RealEstateCondition, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(RealEstateCondition.NO_INFORMATION, "");
		reverseMap.put(RealEstateCondition.FIRST_TIME_USE, "Erstbezug");
		reverseMap.put(RealEstateCondition.FIRST_TIME_USE_AFTER_REFURBISHMENT, "Erstbezug nach Sanierung");
		reverseMap.put(RealEstateCondition.MINT_CONDITION, "Neuwertig");
		reverseMap.put(RealEstateCondition.REFURBISHED, "Saniert");
		reverseMap.put(RealEstateCondition.MODERNIZED, "Modernisiert");
		reverseMap.put(RealEstateCondition.FULLY_RENOVATED, "Vollständig renoviert");
		reverseMap.put(RealEstateCondition.WELL_KEPT, "Gepflegt");
		reverseMap.put(RealEstateCondition.NEED_OF_RENOVATION, "Renovierungsbedürftig");
		reverseMap.put(RealEstateCondition.NEGOTIABLE, "Nach Vereinbarung");
		reverseMap.put(RealEstateCondition.RIPE_FOR_DEMOLITION, "Abbruchreif");
	}
}
