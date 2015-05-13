package de.is24.gif.ida.converter.is24ToIda;

import de.gifev.ida.converter.sdk.ITransformContext;
import de.immobilienscout24.rest.facades.offer.realestates._1.ApartmentFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.ApartmentBuy;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

/**
 * 
 * @author Martin Fluegge
 * 
 */

public class ApartmentBuyTransformer extends ApartmentTransformer<ApartmentBuy> {

	@Override
	protected Ch__Angebot__c doTransform(ApartmentBuy apartmentBuy, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(apartmentBuy, (SalesforceTransformContext) context, angebot);

		ApartmentFacade facade = DuckType.coerce(apartmentBuy).to(ApartmentFacade.class);
		updateApartmentFields(facade, angebot);

		angebot.setCh__Kaufpreis__c(OptionalTypeHelper.priceValue(apartmentBuy.getPrice()));
		angebot.setCh__Vermietet__c(OptionalTypeHelper.boolValue(apartmentBuy.getRented()));
		angebot.setCh__Mieteinnahmen_pro_Monat__c(apartmentBuy.getRentalIncome());
		angebot.setCh__Denkmalschutzobjekt__c(OptionalTypeHelper.boolValue(apartmentBuy.getListed()));
		angebot.setCh__Garage_Stellplatz_Kaufpreis__c(apartmentBuy.getParkingSpacePrice());
		angebot.setCh__Hausgeld__c(apartmentBuy.getServiceCharge());
		angebot.setCh__Als_Ferienwohnung_geeignet__c(OptionalTypeHelper.boolValue(apartmentBuy.getSummerResidencePractical()));

		return angebot;
	}

	@Override
	protected String getImmotypeName(ApartmentBuy realestate) {
		if (isAbroad(realestate)) {
			return "Kauf - Wohnung Ausland";
		} else {
			return "Kauf - Wohnung";
		}
	}
}
