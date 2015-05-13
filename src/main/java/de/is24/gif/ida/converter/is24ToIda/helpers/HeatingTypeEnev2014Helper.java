package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.HeatingTypeEnev2014;


/**
 * @author Martin Fluegge
 * 
 */
public class HeatingTypeEnev2014Helper extends TypeMapHelper<HeatingTypeEnev2014, String> {

	@Override
	protected void fillMap() {
		reverseMap.put(HeatingTypeEnev2014.NO_INFORMATION, "");
		reverseMap.put(HeatingTypeEnev2014.SELF_CONTAINED_CENTRAL_HEATING, "Etagenheizung");
		reverseMap.put(HeatingTypeEnev2014.STOVE_HEATING, "Ofenheizung");
		reverseMap.put(HeatingTypeEnev2014.CENTRAL_HEATING, "Zentralheizung");
		reverseMap.put(HeatingTypeEnev2014.COMBINED_HEAT_AND_POWER_PLANT, "Blockheizkraftwerke");
		reverseMap.put(HeatingTypeEnev2014.ELECTRIC_HEATING, "Elektro-Heizung");
		reverseMap.put(HeatingTypeEnev2014.DISTRICT_HEATING, "Fernwärme");
		reverseMap.put(HeatingTypeEnev2014.FLOOR_HEATING, "Fußbodenheizung");
		reverseMap.put(HeatingTypeEnev2014.GAS_HEATING, "Gas-Heizung");
		reverseMap.put(HeatingTypeEnev2014.WOOD_PELLET_HEATING, "Holz-Pelletheizung");
		reverseMap.put(HeatingTypeEnev2014.NIGHT_STORAGE_HEATER, "Nachtspeicheröfen");
		reverseMap.put(HeatingTypeEnev2014.OIL_HEATING, "Öl-Heizung");
		reverseMap.put(HeatingTypeEnev2014.SOLAR_HEATING, "Solar-Heizung");
		reverseMap.put(HeatingTypeEnev2014.HEAT_PUMP, "Wärmepumpe");
	}
}
