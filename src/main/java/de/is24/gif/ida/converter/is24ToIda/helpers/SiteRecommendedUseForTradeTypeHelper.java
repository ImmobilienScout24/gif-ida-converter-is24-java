package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.SiteRecommendedUseForTradeType;


/**
 * @author cheeren
 * 
 */
public class SiteRecommendedUseForTradeTypeHelper extends TypeMapHelper<SiteRecommendedUseForTradeType, String> {

	@Override
	protected void fillMap() {
		reverseMap.put(SiteRecommendedUseForTradeType.NO_INFORMATION, "");
		reverseMap.put(SiteRecommendedUseForTradeType.FARMLAND, "Ackerland");
		reverseMap.put(SiteRecommendedUseForTradeType.FUTURE_DEVELOPMENT_LAND, "Bauerwartungsland");
		reverseMap.put(SiteRecommendedUseForTradeType.MOORAGE, "Bootsstände");
		reverseMap.put(SiteRecommendedUseForTradeType.OFFICE, "Büro");
		reverseMap.put(SiteRecommendedUseForTradeType.CAMPING, "Camping");
		reverseMap.put(SiteRecommendedUseForTradeType.BIG_STORE, "Einzelhandel - groß");
		reverseMap.put(SiteRecommendedUseForTradeType.LITTLE_STORE, "Einzelhandel - klein");
		reverseMap.put(SiteRecommendedUseForTradeType.GARAGE, "Garagen");
		reverseMap.put(SiteRecommendedUseForTradeType.GARDEN, "Garten");
		reverseMap.put(SiteRecommendedUseForTradeType.GASTRONOMY, "Gastronomie");
		reverseMap.put(SiteRecommendedUseForTradeType.BUSINESS, "Gewerbe");
		reverseMap.put(SiteRecommendedUseForTradeType.HOTEL, "Hotel");
		reverseMap.put(SiteRecommendedUseForTradeType.INDUSTRY, "Industrie");
		reverseMap.put(SiteRecommendedUseForTradeType.NO_DEVELOPMENT, "Keine Bebauung");
		reverseMap.put(SiteRecommendedUseForTradeType.SMALL_BUSINESS, "Kleingewerbe");
		reverseMap.put(SiteRecommendedUseForTradeType.STOCK, "Lager");
		reverseMap.put(SiteRecommendedUseForTradeType.ORCHARD, "Obstpflanzung");
		reverseMap.put(SiteRecommendedUseForTradeType.CAR_PARK, "Parkhaus");
		reverseMap.put(SiteRecommendedUseForTradeType.PRODUCTION, "Produktion");
		reverseMap.put(SiteRecommendedUseForTradeType.PARKING_SPACE, "Stellplätze");
		reverseMap.put(SiteRecommendedUseForTradeType.FORREST, "Wald");
	}
}
