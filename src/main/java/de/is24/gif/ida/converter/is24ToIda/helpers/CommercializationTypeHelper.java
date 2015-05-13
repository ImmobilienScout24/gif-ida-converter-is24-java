package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.CommercializationType;


/**
 * @author Martin Fluegge
 * 
 */
public class CommercializationTypeHelper extends TypeMapHelper<CommercializationType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(CommercializationType.BUY, "Kauf");
		reverseMap.put(CommercializationType.RENT, "Miete");
		reverseMap.put(CommercializationType.LEASE, "Pacht");
		reverseMap.put(CommercializationType.LEASEHOLD, "Erbpacht");
		reverseMap.put(CommercializationType.COMPULSORY_AUCTION, "Zwangsversteigerung");
		reverseMap.put(CommercializationType.RENT_AND_BUY, "Miete und Kauf");
	}
}
