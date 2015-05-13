package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.SiteRecommendedUseType;


/**
 * @author Martin Fluegge
 * 
 */
public class SiteRecommendedUseTypeHelper extends TypeMapHelper<SiteRecommendedUseType, String> {

	@Override
	protected void fillMap() {
		reverseMap.put(SiteRecommendedUseType.NO_INFORMATION, "");
		reverseMap.put(SiteRecommendedUseType.FUTURE_DEVELOPMENT_LAND, "Bauerwartungsland");
		reverseMap.put(SiteRecommendedUseType.TWINHOUSE, "Doppelhaushälfte");
		reverseMap.put(SiteRecommendedUseType.SINGLE_FAMILY_HOUSE, "Einfamilienhaus");
		reverseMap.put(SiteRecommendedUseType.GARAGE, "Garagen");
		reverseMap.put(SiteRecommendedUseType.GARDEN, "Garten");
		reverseMap.put(SiteRecommendedUseType.NO_DEVELOPMENT, "Keine Bebauung");
		reverseMap.put(SiteRecommendedUseType.APARTMENT_BUILDING, "Mehrfamilienhaus");
		reverseMap.put(SiteRecommendedUseType.ORCHARD, "Obstpflanzung");
		reverseMap.put(SiteRecommendedUseType.TERRACE_HOUSE, "Reihenhaus");
		reverseMap.put(SiteRecommendedUseType.PARKING_SPACE, "Stellplätze");
		reverseMap.put(SiteRecommendedUseType.VILLA, "Villa");
		reverseMap.put(SiteRecommendedUseType.FORREST, "Wald");
	}
}
