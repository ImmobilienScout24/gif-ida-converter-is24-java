package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

/**
 * @author Christopher Heeren
 * 
 */
public class ShortTermAccommodationValidator extends IS24ApiOfferValidator {

	@Override
	public List validate(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getOfferName() {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public List<ValidationError> validate(Object o) {
	// ShortTermAccommodation shortTermAccommodation = (ShortTermAccommodation)
	// o;
	//
	// List<ValidationError> results = super.validate(o);
	//
	// validateTotalRent(shortTermAccommodation, results);
	// validateShortTermAccomodationType(shortTermAccommodation, results);
	// validateStartRentalDate(shortTermAccommodation, results);
	// validatePriceIntervalType(shortTermAccommodation, results);
	// validateEnergyConsumptionContainsWarmWater(shortTermAccommodation,
	// results);
	// validateThermalCharacteristic(shortTermAccommodation, results);
	//
	// return results;
	// }
	//
	// protected void validateTotalRent(ShortTermAccommodation
	// shortTermAccommodation, List<ValidationError> results) {
	// if (shortTermAccommodation.getTotalRent() == null &&
	// shortTermAccommodation.getPrice().getValue() == null) {
	// createAndAddValidationError(shortTermAccommodation.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldTotalRent") + " - " +
	// Messages.getString("MessageValueNotSet"),
	// results);
	// } else if (shortTermAccommodation.getTotalRent() < 0 ||
	// shortTermAccommodation.getTotalRent() > 9999999999999.99) {
	// createAndAddValidationError(shortTermAccommodation.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldTotalRent") + " - " +
	// Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	//
	// protected void validateShortTermAccomodationType(ShortTermAccommodation
	// shortTermAccommodation, List<ValidationError> results) {
	// if (shortTermAccommodation.getShortTermAccomodationType() == null ||
	// shortTermAccommodation.getShortTermAccomodationType().name().length() ==
	// 0) {
	// createAndAddValidationError(shortTermAccommodation.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldShortTermAccomodationType") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validateStartRentalDate(ShortTermAccommodation
	// shortTermAccommodation, List<ValidationError> results) {
	// if (shortTermAccommodation.getStartRentalDate() == null) {
	// createAndAddValidationError(shortTermAccommodation.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldRoomFreeFrom") + " - "
	// + Messages.getString("MessageValueNotSet"),
	// results);
	// } else if (shortTermAccommodation.getEndRentalDate() != null) {
	// if
	// (shortTermAccommodation.getStartRentalDate().compare(shortTermAccommodation.getEndRentalDate())
	// == DatatypeConstants.GREATER) {
	// createAndAddValidationError(shortTermAccommodation.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldEndRentalDate") + " - "
	// + Messages.getString("MessageMismatchDate"), results);
	// }
	// }
	// }
	//
	// protected void validatePriceIntervalType(ShortTermAccommodation
	// shortTermAccommodation, List<ValidationError> results) {
	// if (shortTermAccommodation.getPrice().getPriceIntervalType() == null) {
	// createAndAddValidationError(shortTermAccommodation.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldPriceIntervalType") +
	// " - " + Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validateThermalCharacteristic(ShortTermAccommodation
	// shortTermAccommodation, List<ValidationError> results) {
	// Double tc = shortTermAccommodation.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(shortTermAccommodation.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString(thermCharName(shortTermAccommodation)) + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void
	// validateEnergyConsumptionContainsWarmWater(ShortTermAccommodation
	// shortTermAccommodation, List<ValidationError> results) {
	// String eccww;
	// Double tc = shortTermAccommodation.getThermalCharacteristic();
	// if (shortTermAccommodation.getEnergyConsumptionContainsWarmWater() !=
	// null) {
	// eccww =
	// shortTermAccommodation.getEnergyConsumptionContainsWarmWater().toString();
	// } else {
	// eccww = null;
	// }
	//
	// if (eccww != null && eccww.equals("YES")) {
	// if (tc == null) {
	// createAndAddValidationError(shortTermAccommodation.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldEnergy") + " - " +
	// Messages.getString("MessageThermalCharMissing"), results);
	// }
	// }
	// }
	//
	// private String thermCharName(ShortTermAccommodation
	// shortTermAccommodation) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (shortTermAccommodation.getOffer().getEndenergieverbrauch_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if
	// (shortTermAccommodation.getOffer().getEnergieverbrauchskennwert_kWh_m_a()
	// != null) {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if
	// (shortTermAccommodation.getOffer().getEndenergiebedarf_kWh_m_a() != null)
	// {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }
	//
	// @Override
	// protected String getOfferName() {
	// return Messages.getString("TypeShortTermAccommodation");
	// }
}
