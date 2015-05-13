package de.is24.gif.ida.converter.is24ToIda;

import de.gifev.ida.converter.sdk.ITransformContext;
import de.immobilienscout24.rest.facades.offer.realestates._1.SiteFacade;
import de.immobilienscout24.rest.schema.common._1.Price;
import de.immobilienscout24.rest.schema.common._1.SiteRecommendedUseTypes;
import de.immobilienscout24.rest.schema.offer.realestates._1.LivingBuySite;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.SiteRecommendedUseTypeHelper;

/**
 * @author Martin Fluegge
 */

public class LivingBuySiteTransformer extends SiteTransformer<LivingBuySite> {

	private SiteRecommendedUseTypeHelper siteRecommendedUseTypeHelper = new SiteRecommendedUseTypeHelper();

	@Override
	protected Ch__Angebot__c doTransform(LivingBuySite livingBuySite, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(livingBuySite, (SalesforceTransformContext) context, angebot);

		SiteFacade facade = DuckType.coerce(livingBuySite).to(SiteFacade.class);
		updateSiteFields(facade, angebot);

		Price price = livingBuySite.getPrice();
		if (price == null) {
			angebot.setCh__Preis_auf_Anfrage__c(true);
		} else {
			angebot.setCh__Kaufpreis_Erbpacht_pro_Jahr__c(OptionalTypeHelper.priceValue(price));
		}

		SiteRecommendedUseTypes value = livingBuySite.getRecommendedUseTypes();
		if (value != null) {
			angebot.setCh__Empfohlene_Nutzung__c(StringUtils.join(siteRecommendedUseTypeHelper.getSalesforceValues(value.getSiteRecommendedUseType()), ";"));
		}

		return angebot;
	}

	@Override
	protected String getImmotypeName(LivingBuySite realestate) {
		if (isAbroad(realestate)) {
			return "Kauf - Grundstück Ausland";
		} else {
			return "Kauf - Grundstück";
		}
	}
}