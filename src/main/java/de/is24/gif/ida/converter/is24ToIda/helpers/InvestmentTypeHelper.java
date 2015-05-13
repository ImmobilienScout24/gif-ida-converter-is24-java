package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.InvestmentType;


/**
 * @author Martin Fluegge
 * 
 */
public class InvestmentTypeHelper extends TypeMapHelper<InvestmentType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(InvestmentType.SINGLE_FAMILY_HOUSE, "Einfamilienhaus");
		reverseMap.put(InvestmentType.MULTI_FAMILY_HOUSE, "Mehrfamilienhaus");
		reverseMap.put(InvestmentType.FREEHOLD_FLAT, "Eigentumswohnung");
		reverseMap.put(InvestmentType.SHOPPING_CENTRE, "Einkaufszentrum");
		reverseMap.put(InvestmentType.RESTAURANT, "Gaststätte");
		reverseMap.put(InvestmentType.HOTEL, "Hotel");
		reverseMap.put(InvestmentType.LEISURE_FACILITY, "Freizeitanlage");
		reverseMap.put(InvestmentType.COMMERCIAL_UNIT, "Gewerbeeinheit");
		reverseMap.put(InvestmentType.OFFICE_BUILDING, "Bürogebäude");
		reverseMap.put(InvestmentType.COMMERCIAL_BUILDING, "Geschäftshaus");
		reverseMap.put(InvestmentType.COMMERCIAL_PROPERTY, "Gewerbeanwesen");
		reverseMap.put(InvestmentType.HALL_STORAGE, "Halle/Lager");
		reverseMap.put(InvestmentType.INDUSTRIAL_PROPERTY, "Industrieanwesen");
		reverseMap.put(InvestmentType.SHOP_SALES_FLOOR, "Laden/Verkaufsfläche");
		reverseMap.put(InvestmentType.SERVICE_CENTRE, "Servicecenter");
		reverseMap.put(InvestmentType.OTHER, "Sonstige");
		reverseMap.put(InvestmentType.SUPERMARKET, "Supermarkt");
		reverseMap.put(InvestmentType.LIVING_BUSINESS_HOUSE, "Wohn-/ Geschäftshaus");
		reverseMap.put(InvestmentType.HOUSING_ESTATE, "Wohnanlage");
	}
}
