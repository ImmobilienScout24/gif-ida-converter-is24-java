package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;

import de.immobilienscout24.rest.schema.offer.realestates._1.FlatShareRoom;
import de.is24.gif.ida.converter.is24ToIda.helpers.FlatMateGenderTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.InternetConnectionTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.ParkingSituationTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.SmokingAllowedTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.TVConnectionTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.TelephoneConnectionTypeHelper;

/**
 * @author Martin Fluegge
 */

public class FlatShareRoomTransformer extends RealestateTransformer<FlatShareRoom> {
	protected InternetConnectionTypeHelper internetConnectionTypeHelper = new InternetConnectionTypeHelper();
	protected SmokingAllowedTypeHelper smokingAllowedTypeHelper = new SmokingAllowedTypeHelper();
	protected FlatMateGenderTypeHelper flatMateGenderTypeHelper = new FlatMateGenderTypeHelper();
	protected TVConnectionTypeHelper tvConnectionTypeHelper = new TVConnectionTypeHelper();
	protected TelephoneConnectionTypeHelper telephoneConnectionTypeHelper = new TelephoneConnectionTypeHelper();
	protected ParkingSituationTypeHelper parkingSituationTypeHelper = new ParkingSituationTypeHelper();

	@Override
	protected Ch__Angebot__c doTransform(FlatShareRoom flatShareRoom, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(flatShareRoom, (SalesforceTransformContext) context, angebot);

		angebot.setCh__Zimmerflaeche_ca_in_m2__c(flatShareRoom.getRoomSize());
		angebot.setCh__Zimmer__c(flatShareRoom.getNumberOfRooms());
		angebot.setCh__Kaltmiete__c(flatShareRoom.getBaseRent());
		angebot.setCh__Warmmiete__c(flatShareRoom.getTotalRent());
		angebot.setCh__Nebenkosten__c(flatShareRoom.getServiceCharge());
		angebot.setCh__Kaution_Genossenschaftsanteile__c(flatShareRoom.getDeposit());
		angebot.setCh__Heizkosten_Heizung_Warmwasser__c(flatShareRoom.getHeatingCosts());

		angebot.setCh__Keller__c(OptionalTypeHelper.boolValue(flatShareRoom.getCellar()));
		angebot.setCh__Barrierefrei__c(OptionalTypeHelper.boolValue(flatShareRoom.getBarrierFree()));
		angebot.setCh__Bezugsfrei_ab_Date__c(OptionalTypeHelper.toGregorian(flatShareRoom.getFreeFrom()));
		angebot.setCh__Verfuegbar_bis__c(OptionalTypeHelper.toGregorian(flatShareRoom.getFreeUntil()));
		angebot.setCh__WG_Gesamtflaeche_in_m2__c(flatShareRoom.getTotalSpace());
		angebot.setCh__Mitbewohner_Maenner__c(OptionalTypeHelper.doubleValue(flatShareRoom.getNumberOfMaleFlatMates()));
		angebot.setCh__Mitbewohner_Frauen__c(OptionalTypeHelper.doubleValue(flatShareRoom.getNumberOfFemaleFlatMates()));
		angebot.setCh__Alter_der_derzeitigen_Bewohner_von__c(OptionalTypeHelper.doubleValue(flatShareRoom.getAgeOfFlatMatesFrom()));
		angebot.setCh__Alter_der_derzeitigen_Bewohner_bis__c(OptionalTypeHelper.doubleValue(flatShareRoom.getAgeOfFlatMatesTo()));
		angebot.setCh__Alter_des_gesuchten_Mitbewohners_von__c(OptionalTypeHelper.doubleValue(flatShareRoom.getAgeOfRequestedFrom()));
		angebot.setCh__Alter_des_gesuchten_Mitbewohners_bis__c(OptionalTypeHelper.doubleValue(flatShareRoom.getAgeOfRequestedTo()));
		angebot.setCh__Anzahl_der_gesuchten_Mitbewohner__c(OptionalTypeHelper.doubleValue(flatShareRoom.getNumberOfRequestedFlatMates()));
		angebot.setCh__Etage__c(OptionalTypeHelper.doubleValue(flatShareRoom.getFloor()));
		angebot.setCh__Etagenzahl__c(OptionalTypeHelper.doubleValue(flatShareRoom.getNumberOfFloors()));
		angebot.setCh__Anzahl_Badezimmer__c(OptionalTypeHelper.doubleValue(flatShareRoom.getNumberOfBathRooms()));
		angebot.setCh__Balkon_Terrasse__c(OptionalTypeHelper.boolValue(flatShareRoom.getBalcony()));
		angebot.setCh__Garten_mitbenutzung__c(OptionalTypeHelper.boolValue(flatShareRoom.getGarden()));
		angebot.setCh__Personenaufzug__c(OptionalTypeHelper.boolValue(flatShareRoom.getLift()));
		angebot.setCh__Backofen__c(OptionalTypeHelper.boolValue(flatShareRoom.getOven()));
		angebot.setCh__Kuehlschrank__c(OptionalTypeHelper.boolValue(flatShareRoom.getRefrigerator()));
		angebot.setCh__Herd__c(OptionalTypeHelper.boolValue(flatShareRoom.getStove()));
		angebot.setCh__Spuelmaschine__c(OptionalTypeHelper.boolValue(flatShareRoom.getDishwasher()));
		angebot.setCh__Waschmaschine__c(OptionalTypeHelper.boolValue(flatShareRoom.getWashingMachine()));
		angebot.setCh__Badezimmer_enthaelt_WC__c(OptionalTypeHelper.boolValue(flatShareRoom.getBathHasWc()));
		angebot.setCh__Badezimmer_enthaelt_Dusche__c(OptionalTypeHelper.boolValue(flatShareRoom.getBathHasShower()));
		angebot.setCh__Badezimmer_enthaelt_Badewanne__c(OptionalTypeHelper.boolValue(flatShareRoom.getBathHasTub()));
		angebot.setCh__Gaeste_WC__c(OptionalTypeHelper.boolValue(flatShareRoom.getGuestToilet()));
		angebot.setCh__Haustiere__c(petsAllowedTypeHelper.getSalesforceValue(flatShareRoom.getPetsAllowed()));
		angebot.setCh__Bodenbelag__c(flooringTypeHelper.getSalesforceValue(flatShareRoom.getFlooringType()));
		angebot.setCh__Wohnungstyp__c(apartmentTypeHelper.getSalesforceValue(flatShareRoom.getApartmentType()));
		angebot.setCh__Heizkosten_in_Nebenkosten_enthalten__c(yesNoNotApplicableTypeHelper.getSalesforceValue(flatShareRoom.getHeatingCostsInServiceCharge()));
		angebot.setCh__Internetanschluss__c(internetConnectionTypeHelper.getSalesforceValue(flatShareRoom.getInternetConnection()));
		angebot.setCh__Rauchen__c(smokingAllowedTypeHelper.getSalesforceValue(flatShareRoom.getSmokingAllowed()));
		angebot.setCh__Gesuchter_Mitbewohner_ist_Geschlecht__c(flatMateGenderTypeHelper.getSalesforceValue(flatShareRoom.getRequestedGender()));
		angebot.setCh__Moeblierung__c(yesNoNotApplicableTypeHelper.getSalesforceValue(flatShareRoom.getFurnishing()));
		angebot.setCh__TV_Anschluss__c(tvConnectionTypeHelper.getSalesforceValue(flatShareRoom.getTvConnection()));
		angebot.setCh__Telefonanschluss__c(telephoneConnectionTypeHelper.getSalesforceValue(flatShareRoom.getTelephoneConnection()));
		angebot.setCh__Parkplatzsituation__c(parkingSituationTypeHelper.getSalesforceValue(flatShareRoom.getParkingSituation()));
		angebot.setCh__Mindestmietdauer__c(getMinimumTermOfLease(flatShareRoom.getMinimumTermOfLease()));
		angebot.setCh__WG_Groesse__c(getFlatShareSize(flatShareRoom.getFlatShareSize()));

		return angebot;
	}

	@Override
	protected String getImmotypeName(FlatShareRoom flatShareRoom) {
		return "Miete - WG-Zimmer";
	}

	private String getMinimumTermOfLease(Integer value) {
		// TODO NEED TO BE TESTED WITH LIMITS!
		String mindestmietdauer = "";
		if (value != null) {
			if (value == 0) {
				mindestmietdauer = "Unbefristet";
			} else if (value == 1) {
				mindestmietdauer = "1 Monat";
			} else if (value == 12) {
				mindestmietdauer = "12 Monate und mehr";
			} else if ((value > 1) && (value < 12)) {
				mindestmietdauer = value.toString() + " Monate";
			}
		}
		return mindestmietdauer;
	}

	private String getFlatShareSize(Integer value) {
		// TODO NEED TO BE TESTED WITH LIMITS!
		String wgGroesse = "";
		if (value != null) {
			if (value < 11) {
				wgGroesse = value.toString() + "er WG";
			} else {
				wgGroesse = ">10er WG";
			}
		}
		return wgGroesse;
	}
}
