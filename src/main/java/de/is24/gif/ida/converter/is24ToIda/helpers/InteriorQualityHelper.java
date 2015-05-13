package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.InteriorQuality;


/**
 * @author Martin Fluegge
 * 
 */
public class InteriorQualityHelper extends TypeMapHelper<InteriorQuality, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(InteriorQuality.NO_INFORMATION, "");
		reverseMap.put(InteriorQuality.LUXURY, "Luxus");
		reverseMap.put(InteriorQuality.SOPHISTICATED, "Gehoben");
		reverseMap.put(InteriorQuality.NORMAL, "Normal");
		reverseMap.put(InteriorQuality.SIMPLE, "Einfach");
	}
}
