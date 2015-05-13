package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.EnergySourceEnev2014;


/**
 * @author Martin Fluegge
 * 
 */
public class EnergySourceEnev2014Helper extends TypeMapHelper<EnergySourceEnev2014, String> {

	@Override
	protected void fillMap() {
		reverseMap.put(EnergySourceEnev2014.NO_INFORMATION, "");
		reverseMap.put(EnergySourceEnev2014.GEOTHERMAL, "Erdwärme");
		reverseMap.put(EnergySourceEnev2014.SOLAR_HEATING, "Solar");
		reverseMap.put(EnergySourceEnev2014.PELLET_HEATING, "Holzpellets");
		reverseMap.put(EnergySourceEnev2014.GAS, "Gas");
		reverseMap.put(EnergySourceEnev2014.OIL, "Öl");
		reverseMap.put(EnergySourceEnev2014.DISTRICT_HEATING, "Fernwärme");
		reverseMap.put(EnergySourceEnev2014.ELECTRICITY, "Strom");
		reverseMap.put(EnergySourceEnev2014.COAL, "Kohle");
		reverseMap.put(EnergySourceEnev2014.ACID_GAS, "Erdgas leicht");
		reverseMap.put(EnergySourceEnev2014.SOUR_GAS, "Erdgas schwer");
		reverseMap.put(EnergySourceEnev2014.LIQUID_GAS, "Flüssiggas");
		reverseMap.put(EnergySourceEnev2014.STEAM_DISTRICT_HEATING, "Fernwärme-Dampf");
		reverseMap.put(EnergySourceEnev2014.WOOD, "Holz");
		reverseMap.put(EnergySourceEnev2014.WOOD_CHIPS, "Holz-Hackschnitzel");
		reverseMap.put(EnergySourceEnev2014.COAL_COKE, "Kohle/Koks");
		reverseMap.put(EnergySourceEnev2014.LOCAL_HEATING, "Nahwärme");
		reverseMap.put(EnergySourceEnev2014.HEAT_SUPPLY, "Wärmelieferung");
		reverseMap.put(EnergySourceEnev2014.BIO_ENERGY, "Bioenergie");
		reverseMap.put(EnergySourceEnev2014.WIND_ENERGY, "Windenergie");
		reverseMap.put(EnergySourceEnev2014.HYDRO_ENERGY, "Wasserenergie");
		reverseMap.put(EnergySourceEnev2014.ENVIRONMENTAL_THERMAL_ENERGY, "Umweltwärme");
		reverseMap.put(EnergySourceEnev2014.COMBINED_HEAT_AND_POWER_FOSSIL_FUELS, "KWK fossil");
		reverseMap.put(EnergySourceEnev2014.COMBINED_HEAT_AND_POWER_RENEWABLE_ENERGY, "KWK erneuerbar");
		reverseMap.put(EnergySourceEnev2014.COMBINED_HEAT_AND_POWER_REGENERATIVE_ENERGY, "KWK regenerativ");
		reverseMap.put(EnergySourceEnev2014.COMBINED_HEAT_AND_POWER_BIO_ENERGY, "KWK bio");
	}

	public synchronized EnergySourceEnev2014 getIs24Value(String salesforceValue) {

		// for backwards compatibility
		if ("Pelletheizung".equals(salesforceValue)) {
			salesforceValue = "Holzpellets";
		} else if ("Solarheizung".equals(salesforceValue)) {
			salesforceValue = "Solar";
		}

		return reverseMap.getKey(salesforceValue);
	}
}
