package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.LivingBuySite;

/**
 * @author Martin Fluegge
 */

public class LivingBuySiteTransformer extends SiteTransformer<LivingBuySite> {

	@Override
	protected Property doTransform(LivingBuySite a, ITransformContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	// private SiteRecommendedUseTypeHelper siteRecommendedUseTypeHelper = new
	// SiteRecommendedUseTypeHelper();
	//
	// @Override
	// protected Ch__Angebot__c doTransform(LivingBuySite livingBuySite,
	// ITransformContext context) {
	//
	// Ch__Angebot__c angebot = new Ch__Angebot__c();
	// updateRealestateGenericFields(livingBuySite, (SalesforceTransformContext)
	// context, angebot);
	//
	// SiteFacade facade = DuckType.coerce(livingBuySite).to(SiteFacade.class);
	// updateSiteFields(facade, angebot);
	//
	// Price price = livingBuySite.getPrice();
	// if (price == null) {
	// angebot.setCh__Preis_auf_Anfrage__c(true);
	// } else {
	// angebot.setCh__Kaufpreis_Erbpacht_pro_Jahr__c(OptionalTypeHelper.priceValue(price));
	// }
	//
	// SiteRecommendedUseTypes value = livingBuySite.getRecommendedUseTypes();
	// if (value != null) {
	// angebot.setCh__Empfohlene_Nutzung__c(StringUtils.join(siteRecommendedUseTypeHelper.getSalesforceValues(value.getSiteRecommendedUseType()),
	// ";"));
	// }
	//
	// return angebot;
	// }
	//
	// @Override
	// protected String getImmotypeName(LivingBuySite realestate) {
	// if (isAbroad(realestate)) {
	// return "Kauf - Grundstück Ausland";
	// } else {
	// return "Kauf - Grundstück";
	// }
	// }
}