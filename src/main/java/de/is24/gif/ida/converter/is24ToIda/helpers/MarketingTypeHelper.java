package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.MarketingType;


/**
 * @author Martin Fluegge
 * 
 */
public class MarketingTypeHelper extends TypeMapHelper<MarketingType, String> {

	@Override
	protected void fillMap() {
		reverseMap.put(MarketingType.PURCHASE, "Kaufpreis");
		reverseMap.put(MarketingType.PURCHASE_PER_SQM, "Kaufpreis pro m²");
		reverseMap.put(MarketingType.RENT, "Miete pro Monat");
		reverseMap.put(MarketingType.RENT_PER_SQM, "Miete pro m²");
		reverseMap.put(MarketingType.LEASE, "Pacht");
		reverseMap.put(MarketingType.LEASEHOLD, "Erbpacht");
		reverseMap.put(MarketingType.BUDGET_RENT, "Budget Miete");
		reverseMap.put(MarketingType.RENT_AND_BUY, "Miete und Kauf");
	}
}
