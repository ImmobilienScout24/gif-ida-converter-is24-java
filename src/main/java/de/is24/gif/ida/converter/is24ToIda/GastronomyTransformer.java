package de.is24.gif.ida.converter.is24ToIda;

import de.gifev.ida.converter.sdk.ITransformContext;
import de.immobilienscout24.rest.facades.offer.realestates._1.CommercialFacade;
import de.immobilienscout24.rest.schema.common._1.Price;
import de.immobilienscout24.rest.schema.offer.realestates._1.Gastronomy;
import de.is24.gif.ida.converter.is24ToIda.helpers.GastronomyTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

/**
 * 
 * @author Martin Fluegge
 * 
 */

public class GastronomyTransformer extends CommercialTransformer<Gastronomy> {
	protected GastronomyTypeHelper gastronomyTypeHelper = new GastronomyTypeHelper();

	@Override
	protected Ch__Angebot__c doTransform(Gastronomy gastronomy, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(gastronomy, (SalesforceTransformContext) context, angebot);

		CommercialFacade facade = DuckType.coerce(gastronomy).to(CommercialFacade.class);
		updateCommercialFields(facade, angebot);

		angebot.setCh__Denkmalschutzobjekt__c(OptionalTypeHelper.boolValue(gastronomy.getListed()));
		angebot.setCh__Gastterrasse__c(OptionalTypeHelper.boolValue(gastronomy.getTerrace()));
		angebot.setCh__Anzahl_Plaetze_Gastraum__c(OptionalTypeHelper.doubleValue(gastronomy.getNumberSeats()));
		angebot.setCh__Anzahl_Betten__c(OptionalTypeHelper.doubleValue(gastronomy.getNumberBeds()));
		angebot.setCh__Keller__c(OptionalTypeHelper.boolValue(gastronomy.getCellar()));
		angebot.setCh__Flaeche_teilbar_ab_in_m2__c(gastronomy.getMinDivisible());
		angebot.setCh__Gastraumflaeche_in_m2__c(gastronomy.getNetFloorSpace());
		angebot.setCh__Objektart__c(gastronomyTypeHelper.getSalesforceValue(gastronomy.getGastronomyType()));
		angebot.setCh__Pacht_Kaufobjekt__c(commercializationTypeHelper.getSalesforceValue(gastronomy.getCommercializationType()));

		Price price = gastronomy.getPrice();
		if (price == null) {
			angebot.setCh__Preis_auf_Anfrage__c(true);
		} else {
			angebot.setCh__Pacht_bzw_Kaufpreis__c(OptionalTypeHelper.priceValue(price));
			// not for gastronomy:
			angebot.setCh__Miet_Kaufpreis__c(null);
			angebot.setCh__Miet_Kaufpreis_Picklist__c(null);
		}

		return angebot;
	}

	@Override
	protected String getImmotypeName(Gastronomy realestate) {
		return "Gewerbe - Gastronomie / Hotels";
	}

}
