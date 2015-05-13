package de.is24.gif.ida.converter.is24ToIda;

import de.gifev.ida.converter.sdk.ITransformContext;
import de.immobilienscout24.rest.facades.offer.realestates._1.SiteFacade;
import de.immobilienscout24.rest.schema.common._1.SiteRecommendedUseTypes;
import de.immobilienscout24.rest.schema.offer.realestates._1.LivingRentSite;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

/**
 * @author Martin Fluegge
 */

public class LivingRentSiteTransformer extends SiteTransformer<LivingRentSite> {

	@Override
	protected Ch__Angebot__c doTransform(LivingRentSite livingRentSite, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(livingRentSite, (SalesforceTransformContext) context, angebot);

		SiteFacade facade = DuckType.coerce(livingRentSite).to(SiteFacade.class);
		updateSiteFields(facade, angebot);

		angebot.setCh__Miete_Pacht_pro_Jahr__c(OptionalTypeHelper.priceValue(livingRentSite.getPrice()));

		SiteRecommendedUseTypes value = livingRentSite.getRecommendedUseTypes();
		if (value != null) {
			angebot.setCh__Empfohlene_Nutzung__c(StringUtils.join(siteRecommendedUseTypeHelper.getSalesforceValues(value.getSiteRecommendedUseType()), ";"));
		}

		return angebot;
	}

	@Override
	protected String getImmotypeName(LivingRentSite realestate) {
		return "Miete - Grundstück";
	}
}
