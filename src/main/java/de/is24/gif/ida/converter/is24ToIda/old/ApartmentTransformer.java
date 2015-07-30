package de.is24.gif.ida.converter.is24ToIda.old;

import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.is24ToIda.Realestate2PropertyTransformer;

public abstract class ApartmentTransformer<T extends RealEstate> extends Realestate2PropertyTransformer<T> {

	// protected void updateApartmentFields(ApartmentFacade facade,
	// Ch__Angebot__c angebot) {
	//
	// angebot.setCh__Wohnungstyp__c(apartmentTypeHelper.getSalesforceValue(facade.getApartmentType()));
	// angebot.setCh__Keller__c(OptionalTypeHelper.boolValue(facade.getCellar()));
	// angebot.setCh__Barrierefrei__c(OptionalTypeHelper.boolValue(facade.getHandicappedAccessible()));
	// angebot.setCh__Anzahl_Garage_Stellplatz__c(OptionalTypeHelper.doubleValue(facade.getNumberOfParkingSpaces()));
	// angebot.setCh__Objektzustand__c(conditionHelper.getSalesforceValue(facade.getCondition()));
	// angebot.setCh__Letzte_Modernisierung_Sanierung__c(OptionalTypeHelper.stringValue(facade.getLastRefurbishment()));
	// angebot.setCh__Etage__c(OptionalTypeHelper.doubleValue(facade.getFloor()));
	// angebot.setCh__Personenaufzug__c(facade.isLift());
	// angebot.setCh__Seniorengerechtes_Wohnen__c(facade.isAssistedLiving());
	// angebot.setCh__Bezugsfrei_ab_Text__c(facade.getFreeFrom());
	// angebot.setCh__Nutzflaeche_ca_in_m2__c(facade.getUsableFloorSpace());
	// angebot.setCh__Wohnflaeche_ca_in_m2__c(facade.getLivingSpace());
	// angebot.setCh__Zimmer__c(facade.getNumberOfRooms());
	// angebot.setCh__Einbaukueche__c(facade.isBuiltInKitchen());
	// angebot.setCh__Balkon_Terrasse__c(facade.isBalcony());
	// angebot.setCh__Wohnberechtigungsschein_erforderlich__c(facade.isCertificateOfEligibilityNeeded());
	// angebot.setCh__Garten_mitbenutzung__c(facade.isGarden());
	// angebot.setCh__Qualitaet_der_Ausstattung__c(interiorQualityHelper.getSalesforceValue(facade.getInteriorQuality()));
	// angebot.setCh__Etagenzahl__c(OptionalTypeHelper.doubleValue(facade.getNumberOfFloors()));
	// angebot.setCh__Anzahl_Schlafzimmer__c(OptionalTypeHelper.doubleValue(facade.getNumberOfBedRooms()));
	// angebot.setCh__Anzahl_Badezimmer__c(OptionalTypeHelper.doubleValue(facade.getNumberOfBathRooms()));
	// angebot.setCh__Gaeste_WC__c(OptionalTypeHelper.boolValue(facade.getGuestToilet()));
	// angebot.setCh__Garage_Stellplatz__c(parkingSpaceTypeHelper.getSalesforceValue(facade.getParkingSpaceType()));
	// }
}
