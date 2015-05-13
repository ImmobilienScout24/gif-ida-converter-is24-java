package de.is24.gif.ida.converter.is24ToIda;

import java.util.logging.Logger;

import de.gifev.ida.converter.sdk.ITransformContext;
import de.immobilienscout24.rest.schema.common._1.FlatMateGenderType;
import de.immobilienscout24.rest.schema.common._1.Price;
import de.immobilienscout24.rest.schema.offer.realestates._1.ShortTermAccommodation;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.PriceIntervalTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.ShortTermAccomodationTypeHelper;

/**
 * @author Martin Fluegge
 */

public class ShortTermAccommodationTransformer extends RealestateTransformer<ShortTermAccommodation> {

	private static Logger LOG = Logger.getLogger(ShortTermAccommodationTransformer.class);
	protected PriceIntervalTypeHelper priceIntervalTypeHelper = new PriceIntervalTypeHelper();
	protected ShortTermAccomodationTypeHelper shortTermAccomodationTypeHelper = new ShortTermAccomodationTypeHelper();

	@Override
	protected Ch__Angebot__c doTransform(ShortTermAccommodation shortTermAccommodation, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(shortTermAccommodation, (SalesforceTransformContext) context, angebot);

		angebot.setCh__Kaltmiete__c(shortTermAccommodation.getBaseRent());
		angebot.setCh__Keller__c(shortTermAccommodation.isCellar());
		angebot.setCh__Kaution__c(shortTermAccommodation.getDeposit());
		angebot.setCh__Etage__c(OptionalTypeHelper.stringToDouble(shortTermAccommodation.getFloor()));
		angebot.setCh__Etagenzahl__c(OptionalTypeHelper.doubleValue(shortTermAccommodation.getNumberOfFloors()));
		angebot.setCh__Gaeste_WC__c(shortTermAccommodation.isGuestToilet());
		angebot.setCh__Barrierefrei__c(shortTermAccommodation.isHandicappedAccessible());
		angebot.setCh__Personenaufzug__c(shortTermAccommodation.isLift());
		angebot.setCh__Maximale_Personenanzahl__c(OptionalTypeHelper.doubleValue(shortTermAccommodation.getMaxNumberOfPersons()));
		angebot.setCh__Maximale_Mietdauer_in_Monate__c(shortTermAccommodation.getMaxRentalTime());
		angebot.setCh__Mindestmietdauer__c(OptionalTypeHelper.doubleString(shortTermAccommodation.getMinRentalTime()));
		angebot.setCh__Anzahl_Garage_Stellplatz__c(OptionalTypeHelper.doubleValue(shortTermAccommodation.getNumberOfParkingSpaces()));
		angebot.setCh__Garage_Stellplatz_Miete__c(shortTermAccommodation.getParkingSpacePrice());
		angebot.setCh__Nebenkosten__c(shortTermAccommodation.getServiceCharge());
		angebot.setCh__Wohnflaeche_ca_in_m2__c(shortTermAccommodation.getLivingSpace());
		angebot.setCh__Zimmer__c(shortTermAccommodation.getNumberOfRooms());
		angebot.setCh__Das_Angebot_ist_frei_bis__c(OptionalTypeHelper.toGregorian(shortTermAccommodation.getEndRentalDate()));
		angebot.setCh__Bezugsfrei_ab_Date__c(OptionalTypeHelper.toGregorian(shortTermAccommodation.getStartRentalDate()));
		angebot.setCh__Balkon_Terrasse__c(shortTermAccommodation.isBalcony());
		angebot.setCh__Garten_mitbenutzung__c(shortTermAccommodation.isGarden());
		angebot.setCh__Mindestmietdauer__c(shortTermAccommodation.getMinRentalTime() + "");
		angebot.setCh__Objektzustand__c(conditionHelper.getSalesforceValue(shortTermAccommodation.getCondition()));
		angebot.setCh__Moeblierung__c(yesNoNotApplicableTypeHelper.getSalesforceValue(shortTermAccommodation.getHasFurniture()));
		angebot.setCh__Garage_Stellplatz__c(parkingSpaceTypeHelper.getSalesforceValue(shortTermAccommodation.getParkingSpaceType()));
		angebot.setCh__Haustiere__c(petsAllowedTypeHelper.getSalesforceValue(shortTermAccommodation.getPetsAllowed()));
		angebot.setCh__Wohnart__c(shortTermAccomodationTypeHelper.getSalesforceValue(shortTermAccommodation.getShortTermAccomodationType()));

		FlatMateGenderType gender = shortTermAccommodation.getGender();
		if ((gender == null) || (gender == FlatMateGenderType.MALE_OR_FEMALE)) {
			angebot.setCh__Geschlecht__c("");
		} else if (gender == FlatMateGenderType.MALE) {
			angebot.setCh__Geschlecht__c("Nur an Männer");
		} else {
			angebot.setCh__Geschlecht__c("Nur an Frauen");
		}

		Boolean nonSmoker = shortTermAccommodation.isNonSmoker();
		if (nonSmoker == null) {
			angebot.setCh__Nichtraucher__c("");
		} else if (nonSmoker == true) {
			angebot.setCh__Nichtraucher__c("Nur an Nichtraucher");
		} else {
			angebot.setCh__Nichtraucher__c("Keine Einschränkung");
		}

		Price price = shortTermAccommodation.getPrice();
		if (price != null) {
			angebot.setCh__Pauschalmiete__c(priceValue(price));
			angebot.setCh__Pauschalmiete_pro__c(priceIntervalTypeHelper.getSalesforceValue(price.getPriceIntervalType()));
		}

		return angebot;
	}

	@Override
	protected String getImmotypeName(ShortTermAccommodation shortTermAccommodation) {
		return "Miete - Möbliertes Wohnen / Wohnen auf Zeit";
	}
}
