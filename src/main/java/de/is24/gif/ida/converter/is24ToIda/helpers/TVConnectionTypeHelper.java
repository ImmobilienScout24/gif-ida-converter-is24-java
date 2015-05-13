package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.TvConnectionType;


/**
 * @author Martin Fluegge
 * 
 */
public class TVConnectionTypeHelper extends TypeMapHelper<TvConnectionType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(TvConnectionType.NO_INFORMATION, "");
		reverseMap.put(TvConnectionType.CABLE, "Kabel");
		reverseMap.put(TvConnectionType.SATELLITE, "Satellit");
		reverseMap.put(TvConnectionType.CABLE_AND_SATELLITE, "Kabel und Satellit");
	}
}
