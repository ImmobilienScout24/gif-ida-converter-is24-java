package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.CompulsoryAuctionType;


/**
 * @author Martin Fluegge
 * 
 */
public class CompulsoryAuctionTypeHelper extends TypeMapHelper<CompulsoryAuctionType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(CompulsoryAuctionType.FREEHOLD_FLAT, "Eigentumswohnung");
		reverseMap.put(CompulsoryAuctionType.FAMILY_HOUSE, "Ein/Mehrfamilienhaus");
		reverseMap.put(CompulsoryAuctionType.BUSINESS_AND_YIELD, "Gewerbe");
		reverseMap.put(CompulsoryAuctionType.LOT, "Grundstück");
		reverseMap.put(CompulsoryAuctionType.GARAGE_AND_OTHER, "Garage/Sonstige");
	}
}
