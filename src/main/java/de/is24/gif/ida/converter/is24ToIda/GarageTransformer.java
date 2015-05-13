package de.is24.gif.ida.converter.is24ToIda;

import de.immobilienscout24.rest.facades.offer.realestates._1.GarageFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.is24ToIda.helpers.GarageTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

/**
 * @author Martin Fluegge
 */
public abstract class GarageTransformer<T extends RealEstate> extends RealestateTransformer<T> {
	protected GarageTypeHelper garageTypeHelper = new GarageTypeHelper();

	protected void updateGarageFields(GarageFacade facade, Ch__Angebot__c angebot) {
		angebot.setCh__Flaeche_ca_in_m2__c(facade.getUsableFloorSpace());
		angebot.setCh__Laenge_in_m__c(facade.getLengthGarage());
		angebot.setCh__Breite_in_m__c(facade.getWidthGarage());
		angebot.setCh__Hoehe_in_m__c(facade.getHeightGarage());
		angebot.setCh__Letzte_Modernisierung_Sanierung__c(OptionalTypeHelper.stringValue(facade.getLastRefurbishment()));
		angebot.setCh__Objektart__c(garageTypeHelper.getSalesforceValue(facade.getGarageType()));
		angebot.setCh__Objektzustand__c(conditionHelper.getSalesforceValue(facade.getCondition()));
	}
}
