package de.is24.gif.ida.converter.is24ToIda.old;

import de.immobilienscout24.rest.facades.offer.realestates._1.HouseFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

/**
 * @author Martin Fluegge
 */
public abstract class HouseTransformer<T extends RealEstate> extends RealestateTransformer<T> {

	protected void updateHouseFields(HouseFacade facade, Ch__Angebot__c angebot) {

		angebot.setCh__Wohnflaeche_ca_in_m2__c(facade.getLivingSpace());
		angebot.setCh__Zimmer__c(facade.getNumberOfRooms());
		angebot.setCh__Grundstuecksflaeche_ca_in_m2__c(facade.getPlotArea());
		angebot.setCh__Nutzflaeche_ca_in_m2__c(facade.getUsableFloorSpace());
		angebot.setCh__Letzte_Modernisierung_Sanierung__c(OptionalTypeHelper.stringValue(facade.getLastRefurbishment()));
		angebot.setCh__Etagenzahl__c(OptionalTypeHelper.doubleValue(facade.getNumberOfFloors()));
		angebot.setCh__Anzahl_Schlafzimmer__c(OptionalTypeHelper.doubleValue(facade.getNumberOfBedRooms()));
		angebot.setCh__Anzahl_Badezimmer__c(OptionalTypeHelper.doubleValue(facade.getNumberOfBathRooms()));
		angebot.setCh__Anzahl_Garage_Stellplatz__c(OptionalTypeHelper.doubleValue(facade.getNumberOfParkingSpaces()));
		angebot.setCh__Keller__c(OptionalTypeHelper.boolValue(facade.getCellar()));
		angebot.setCh__Barrierefrei__c(OptionalTypeHelper.boolValue(facade.getHandicappedAccessible()));
		angebot.setCh__Gaeste_WC__c(OptionalTypeHelper.boolValue(facade.getGuestToilet()));
		angebot.setCh__Haustyp__c(buildingTypeHelper.getSalesforceValue(facade.getBuildingType()));
		angebot.setCh__Qualitaet_der_Ausstattung__c(interiorQualityHelper.getSalesforceValue(facade.getInteriorQuality()));
		angebot.setCh__Garage_Stellplatz__c(parkingSpaceTypeHelper.getSalesforceValue(facade.getParkingSpaceType()));
		angebot.setCh__Objektzustand__c(conditionHelper.getSalesforceValue(facade.getCondition()));
	}
}
