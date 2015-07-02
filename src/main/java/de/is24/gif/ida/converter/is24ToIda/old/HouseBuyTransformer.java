package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;

import de.immobilienscout24.rest.facades.offer.realestates._1.HouseFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.HouseBuy;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

/**
 * @author Martin Fluegge
 * 
 */
public class HouseBuyTransformer extends HouseTransformer<HouseBuy> {
	@Override
	protected Ch__Angebot__c doTransform(HouseBuy houseBuy, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(houseBuy, (SalesforceTransformContext) context, angebot);

		HouseFacade facade = DuckType.coerce(houseBuy).to(HouseFacade.class);
		updateHouseFields(facade, angebot);

		angebot.setCh__Kaufpreis__c(OptionalTypeHelper.priceValue(houseBuy.getPrice()));
		angebot.setCh__Einliegerwohnung__c(OptionalTypeHelper.boolValue(houseBuy.getLodgerFlat()));
		angebot.setCh__Bauphase__c(constructionPhaseTypeHelper.getSalesforceValue(houseBuy.getConstructionPhase()));
		angebot.setCh__Vermietet__c(OptionalTypeHelper.boolValue(houseBuy.getRented()));
		angebot.setCh__Mieteinnahmen_pro_Monat__c(houseBuy.getRentalIncome());
		angebot.setCh__Denkmalschutzobjekt__c(OptionalTypeHelper.boolValue(houseBuy.getListed()));
		angebot.setCh__Als_Ferienhaus_geeignet__c(OptionalTypeHelper.boolValue(houseBuy.getSummerResidencePractical()));
		angebot.setCh__Bezugsfrei_ab_Text__c(houseBuy.getFreeFrom());
		angebot.setCh__Garage_Stellplatz_Kaufpreis__c(houseBuy.getParkingSpacePrice());

		return angebot;
	}

	@Override
	protected String getImmotypeName(HouseBuy realestate) {
		if (isAbroad(realestate)) {
			return "Kauf - Haus Ausland";
		} else {
			return "Kauf - Haus";
		}
	}
}
