package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.GastronomyType;


/**
 * @author Martin Fluegge
 * 
 */
public class GastronomyTypeHelper extends TypeMapHelper<GastronomyType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(GastronomyType.BAR_LOUNGE, "Barbetrieb/Lounge");
		reverseMap.put(GastronomyType.CAFE, "Café");
		reverseMap.put(GastronomyType.CLUB_DISCO, "Club / Diskothek");
		reverseMap.put(GastronomyType.GUESTS_HOUSE, "Gästehaus");
		reverseMap.put(GastronomyType.TAVERN, "Gaststätte");
		reverseMap.put(GastronomyType.HOTEL, "Hotel");
		reverseMap.put(GastronomyType.HOTEL_RESIDENCE, "Hotelanwesen");
		reverseMap.put(GastronomyType.HOTEL_GARNI, "Hotel garni");
		reverseMap.put(GastronomyType.PENSION, "Pension");
		reverseMap.put(GastronomyType.RESTAURANT, "Restaurant");
		reverseMap.put(GastronomyType.BUNGALOW, "Ferienbungalows");
	}
}
