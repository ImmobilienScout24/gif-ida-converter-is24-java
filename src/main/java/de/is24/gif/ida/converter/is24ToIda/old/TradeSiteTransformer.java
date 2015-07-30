package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.TradeSite;

/**
 * @author Martin Fluegge
 */

public class TradeSiteTransformer extends SiteTransformer<TradeSite> {

	@Override
	protected Property doTransform(TradeSite a, ITransformContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	// protected UtilizationTradeSiteHelper utilizationTradeSiteHelper = new
	// UtilizationTradeSiteHelper();
	// protected SiteRecommendedUseForTradeTypeHelper
	// siteRecommendedUseForTradeTypeHelper = new
	// SiteRecommendedUseForTradeTypeHelper();
	//
	// @Override
	// protected Ch__Angebot__c doTransform(TradeSite tradeSite,
	// ITransformContext context) {
	//
	// Ch__Angebot__c angebot = new Ch__Angebot__c();
	// updateRealestateGenericFields(tradeSite, (SalesforceTransformContext)
	// context, angebot);
	//
	// SiteFacade facade = DuckType.coerce(tradeSite).to(SiteFacade.class);
	// updateSiteFields(facade, angebot);
	//
	// angebot.setCh__Nutzungsart__c(utilizationTradeSiteHelper.getSalesforceValue(tradeSite.getUtilizationTradeSite()));
	//
	// SiteRecommendedUseForTradeTypes value =
	// tradeSite.getRecommendedUseTypes();
	// if (value != null) {
	// Collection<String> getSalesforceValues =
	// siteRecommendedUseForTradeTypeHelper.getSalesforceValues(value.getSiteRecommendedUseForTradeType());
	// angebot.setCh__Empfohlene_Nutzung__c(StringUtils.join(getSalesforceValues,
	// ";"));
	// }
	//
	// Price price = tradeSite.getPrice();
	// if (price == null) {
	// angebot.setCh__Preis_auf_Anfrage__c(true);
	// } else {
	// angebot.setCh__Preis_Pacht_Miete_pro_Jahr__c(OptionalTypeHelper.priceValue(price));
	// }
	//
	// return angebot;
	// }
	//
	// @Override
	// protected String getImmotypeName(TradeSite realestate) {
	// if (isAbroad(realestate)) {
	// return "Gewerbe - Grundstück Ausland";
	// } else {
	// return "Gewerbe - Grundstück";
	// }
	// }
}
