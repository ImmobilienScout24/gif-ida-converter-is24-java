package de.is24.gif.ida.converter.is24ToIda;

import de.gifev.ida.converter.sdk.ITransformContext;
import de.immobilienscout24.rest.facades.offer.realestates._1.GarageFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.GarageRent;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

/**
 * @author Martin Fluegge
 * 
 */
public class GarageRentTransformer extends GarageTransformer<GarageRent> {
	@Override
	protected Ch__Angebot__c doTransform(GarageRent garageRent, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(garageRent, (SalesforceTransformContext) context, angebot);

		GarageFacade facade = DuckType.coerce(garageRent).to(GarageFacade.class);
		updateGarageFields(facade, angebot);

		angebot.setCh__Verfuegbar_ab_Datum__c(OptionalTypeHelper.toGregorian(garageRent.getFreeFrom()));
		angebot.setCh__Verfuegbar_bis__c(OptionalTypeHelper.toGregorian(garageRent.getFreeUntil()));
		angebot.setCh__Miete__c(OptionalTypeHelper.priceValue(garageRent.getPrice()));

		return angebot;
	}

	@Override
	protected String getImmotypeName(GarageRent realestate) {
		return "Miete - Garage / Stellplatz";
	}
}
