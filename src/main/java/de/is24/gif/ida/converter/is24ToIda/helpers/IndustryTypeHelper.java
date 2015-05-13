package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.IndustryType;


/**
 * @author Martin Fluegge
 * 
 */
public class IndustryTypeHelper extends TypeMapHelper<IndustryType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(IndustryType.SHOWROOM_SPACE, "Ausstellungsfläche");
		reverseMap.put(IndustryType.HALL, "Halle");
		reverseMap.put(IndustryType.HIGH_LACK_STORAGE, "Hochregallager");
		reverseMap.put(IndustryType.INDUSTRY_HALL, "Industriehalle");
		reverseMap.put(IndustryType.INDUSTRY_HALL_WITH_OPEN_AREA, "Industriehalle mit Freifläche");
		reverseMap.put(IndustryType.COLD_STORAGE, "Kühlhaus");
		reverseMap.put(IndustryType.MULTIDECK_CABINET_STORAGE, "Kühlregallager");
		reverseMap.put(IndustryType.STORAGE_WITH_OPEN_AREA, "Lager mit Freifläche");
		reverseMap.put(IndustryType.STORAGE_AREA, "Lagerfläche");
		reverseMap.put(IndustryType.STORAGE_HALL, "Lagerhalle");
		reverseMap.put(IndustryType.SERVICE_AREA, "Servicefläche");
		reverseMap.put(IndustryType.SHIPPING_STORAGE, "Speditionslager");
		reverseMap.put(IndustryType.REPAIR_SHOP, "Werkstatt");
	}
}
