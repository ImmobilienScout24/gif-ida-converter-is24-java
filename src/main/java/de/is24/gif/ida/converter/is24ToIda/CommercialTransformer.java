package de.is24.gif.ida.converter.is24ToIda;

import de.immobilienscout24.rest.facades.offer.realestates._1.CommercialFacade;
import de.immobilienscout24.rest.schema.common._1.Price;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.is24ToIda.helpers.MarketingTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

public abstract class CommercialTransformer<T extends RealEstate> extends RealestateTransformer<T> {
	protected MarketingTypeHelper marketingTypeHelper = new MarketingTypeHelper();

	protected void updateCommercialFields(CommercialFacade facade, Ch__Angebot__c angebot) {

		angebot.setCh__Gesamtflaeche_in_m2__c(facade.getTotalFloorSpace());
		angebot.setCh__Fahrzeit_naechster_Hbf_in_min__c(OptionalTypeHelper.doubleValue(facade.getDistanceToMRS()));
		angebot.setCh__Fahrzeit_naechste_BAB_in_min__c(OptionalTypeHelper.doubleValue(facade.getDistanceToFM()));
		angebot.setCh__Fussweg_zu_OPNV_in_min__c(OptionalTypeHelper.doubleValue(facade.getDistanceToPT()));
		angebot.setCh__Fahrzeit_naechster_Flughafen_in_min__c(OptionalTypeHelper.doubleValue(facade.getDistanceToAirport()));
		angebot.setCh__Anzahl_der_Parkflaechen__c(OptionalTypeHelper.doubleValue(facade.getNumberOfParkingSpaces()));
		angebot.setCh__Preis_pro_Parkflaeche__c(facade.getParkingSpacePrice());
		angebot.setCh__Verfuegbar_ab__c(facade.getFreeFrom());
		angebot.setCh__Nebenflaeche_in_m2__c(facade.getAdditionalArea());
		angebot.setCh__Etagen__c(facade.getNumberOfFloors());
		angebot.setCh__Nebenkosten__c(OptionalTypeHelper.priceValue(facade.getAdditionalCosts()));
		angebot.setCh__Personenaufzug__c(OptionalTypeHelper.boolValue(facade.getLift()));
		angebot.setCh__Kaution__c(facade.getDeposit());
		angebot.setCh__Objektzustand__c(conditionHelper.getSalesforceValue(facade.getCondition()));
		angebot.setCh__Letzte_Modernisierung_Sanierung__c(OptionalTypeHelper.stringValue(facade.getLastRefurbishment()));
		angebot.setCh__Qualitaet_der_Ausstattung__c(interiorQualityHelper.getSalesforceValue(facade.getInteriorQuality()));
		angebot.setCh__Miet_Kaufobjekt__c(commercializationTypeHelper.getSalesforceValue(facade.getCommercializationType()));

		Price price = facade.getPrice();
		if (price != null) {
			angebot.setCh__Miet_Kaufpreis__c(OptionalTypeHelper.priceValue(price));
			angebot.setCh__Miet_Kaufpreis_Picklist__c(marketingTypeHelper.getSalesforceValue(price.getMarketingType()));
		}
	}
}
