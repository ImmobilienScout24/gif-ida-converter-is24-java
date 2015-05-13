package de.is24.gif.ida.converter.is24ToIda;

import de.immobilienscout24.rest.facades.offer.realestates._1.SiteFacade;
import de.immobilienscout24.rest.schema.common._1.CommercializationType;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.SiteConstructibleTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.SiteDevelopmentTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.SiteRecommendedUseTypeHelper;

/**
 * @author Martin Fluegge
 */
public abstract class SiteTransformer<T extends RealEstate> extends RealestateTransformer<T> {

	protected SiteDevelopmentTypeHelper siteDevelopmentTypeHelper = new SiteDevelopmentTypeHelper();
	protected SiteConstructibleTypeHelper siteConstructibleTypeHelper = new SiteConstructibleTypeHelper();
	protected SiteRecommendedUseTypeHelper siteRecommendedUseTypeHelper = new SiteRecommendedUseTypeHelper();

	public void updateSiteFields(SiteFacade facade, Ch__Angebot__c angebot) {

		angebot.setCh__Verfuegbar_ab__c(facade.getFreeFrom());
		angebot.setCh__Grundstuecksflaeche_ca_in_m2__c(facade.getPlotArea());
		angebot.setCh__Flaeche_teilbar_ab_in_m2__c(facade.getMinDivisible());
		angebot.setCh__Kurzfristig_bebaubar__c(facade.isShortTermConstructible());
		angebot.setCh__Baugenehmigung__c(facade.isBuildingPermission());
		angebot.setCh__Abriss__c(facade.isDemolition());
		angebot.setCh__Vermarktungsart__c(commercializationTypeHelper.getSalesforceValue(facade.getCommercializationType()));
		angebot.setCh__Erschliessung__c(siteDevelopmentTypeHelper.getSalesforceValue(facade.getSiteDevelopmentType()));
		angebot.setCh__Bebaubar_nach__c(siteConstructibleTypeHelper.getSalesforceValue(facade.getSiteConstructibleType()));
		angebot.setCh__GRZ__c(facade.getGrz());
		angebot.setCh__GFZ__c(facade.getGfz());
		// Heimfall should only be set for Erbpacht.
		if (CommercializationType.LEASEHOLD.equals(facade.getCommercializationType())) {
			angebot.setCh__Heimfall_nach__c(OptionalTypeHelper.doubleValue(facade.getTenancy()));
		}
		// LeaseInterval not in SF yet
	}
}
