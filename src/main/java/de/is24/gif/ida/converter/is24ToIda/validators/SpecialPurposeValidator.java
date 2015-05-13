package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

/**
 * @author Christopher Heeren
 * 
 */
public class SpecialPurposeValidator extends IS24ApiOfferValidator {

	@Override
	public List validate(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	//
	// @Override
	// public List<ValidationError> validate(Object o) {
	// SpecialPurpose specialPurpose = (SpecialPurpose) o;
	//
	// List<ValidationError> results = super.validate(o);
	//
	// validateCommercializationType(specialPurpose, results);
	// validatePriceMarketingType(specialPurpose, results);
	// validateSpecialPurposePropertyType(specialPurpose, results);
	// validateTotalFloorSpace(specialPurpose, results);
	// validateEnergyConsumptionContainsWarmWater(specialPurpose, results);
	// validateThermalCharacteristic(specialPurpose, results);
	// validateConstructionYear(specialPurpose, results);
	// validateLastRefurbishment(specialPurpose, results);
	// validateMinDivisible(specialPurpose, results);
	//
	// validateEnergyConsumptionElectricity(specialPurpose, results);
	// validateEnergyConsumptionHeating(specialPurpose, results);
	// validateThermalCharacteristicElectricity(specialPurpose, results);
	// validateThermalCharacteristicHeating(specialPurpose, results);
	// validateElectricityConsumption(specialPurpose, results);
	// validateHeatingConsumption(specialPurpose, results);
	//
	// return results;
	// }
	//
	// protected void validateSpecialPurposePropertyType(SpecialPurpose
	// specialPurpose, List<ValidationError> results) {
	// if (specialPurpose.getSpecialPurposePropertyType() == null) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldObjectType") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validateCommercializationType(SpecialPurpose
	// specialPurpose, List<ValidationError> results) {
	// if (specialPurpose.getCommercializationType() == null) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldCommercializationType")
	// + " - " + Messages.getString("MessageValueNotSet"),
	// results);
	// }
	// }
	//
	// protected void validatePriceMarketingType(SpecialPurpose specialPurpose,
	// List<ValidationError> results) {
	// MarketingType mt = specialPurpose.getPrice().getMarketingType();
	// CommercializationType ct = specialPurpose.getCommercializationType();
	// if (mt == null) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldPriceMarketingType") +
	// " - " + Messages.getString("MessageValueNotSet"),
	// results);
	// } else if (ct != null) {
	// if ((mt.name().contains("RENT") && ct != CommercializationType.RENT) ||
	// (mt.name().contains("PURCHASE") && ct != CommercializationType.BUY)) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldPriceMarketingType") +
	// " - " + Messages.getString("MessageMismatchMarketingType"), results);
	// }
	// }
	// }
	//
	// protected void validateTotalFloorSpace(SpecialPurpose specialPurpose,
	// List<ValidationError> results) {
	// String externalId = specialPurpose.getExternalId();
	// Double valValue = specialPurpose.getTotalFloorSpace();
	// if (valValue == null) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldArea") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (valValue < 0 || valValue > 99999999.99) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldArea") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateMinDivisible(SpecialPurpose specialPurpose,
	// List<ValidationError> results) {
	// String externalId = specialPurpose.getExternalId();
	// Double valValue = specialPurpose.getMinDivisible();
	// if (valValue != null && (valValue < 1 || valValue > 99999999.99)) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldMinDivisibleSpecialPurpose") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateThermalCharacteristic(SpecialPurpose
	// specialPurpose, List<ValidationError> results) {
	// Double tc = specialPurpose.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString(thermCharName(specialPurpose)) + " - " +
	// Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	//
	// protected void validateEnergyConsumptionContainsWarmWater(SpecialPurpose
	// specialPurpose, List<ValidationError> results) {
	// String eccww;
	// Double tc = specialPurpose.getThermalCharacteristic();
	// if (specialPurpose.getEnergyConsumptionContainsWarmWater() != null) {
	// eccww =
	// specialPurpose.getEnergyConsumptionContainsWarmWater().toString();
	// } else {
	// eccww = null;
	// }
	//
	// if (eccww != null && eccww.equals("YES")) {
	// if (tc == null) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldEnergy") + " - " +
	// Messages.getString("MessageThermalCharMissing"),
	// results);
	// }
	// }
	// }
	//
	// private String thermCharName(SpecialPurpose specialPurpose) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (specialPurpose.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if
	// (specialPurpose.getOffer().getEnergieverbrauchskennwert_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if (specialPurpose.getOffer().getEndenergiebedarf_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }
	//
	// protected void validateEnergyConsumptionElectricity(SpecialPurpose
	// specialPurpose, List<ValidationError> results) {
	// if (specialPurpose.getEnergyCertificate() != null) {
	// Double tc =
	// specialPurpose.getEnergyCertificate().getEnergyConsumptionElectricity();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharEnergyConsumptionElectricity") +
	// " - " + Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateEnergyConsumptionHeating(SpecialPurpose
	// specialPurpose, List<ValidationError> results) {
	// if (specialPurpose.getEnergyCertificate() != null) {
	// Double tc =
	// specialPurpose.getEnergyCertificate().getEnergyConsumptionHeating();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharEnergyConsumptionHeating") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateThermalCharacteristicElectricity(SpecialPurpose
	// specialPurpose, List<ValidationError> results) {
	// if (specialPurpose.getEnergyCertificate() != null) {
	// Double tc =
	// specialPurpose.getEnergyCertificate().getThermalCharacteristicElectricity();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharElectricity") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateThermalCharacteristicHeating(SpecialPurpose
	// specialPurpose, List<ValidationError> results) {
	// if (specialPurpose.getEnergyCertificate() != null) {
	// Double tc =
	// specialPurpose.getEnergyCertificate().getThermalCharacteristicHeating();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldThermalCharHeating") +
	// " - " + Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	// }
	//
	// protected void validateElectricityConsumption(SpecialPurpose
	// specialPurpose, List<ValidationError> results) {
	// if (specialPurpose.getEnergyCertificate() != null) {
	// Double tc =
	// specialPurpose.getEnergyCertificate().getElectricityConsumption();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharConsumptionElectricity") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateHeatingConsumption(SpecialPurpose specialPurpose,
	// List<ValidationError> results) {
	// if (specialPurpose.getEnergyCertificate() != null) {
	// Double tc =
	// specialPurpose.getEnergyCertificate().getHeatingConsumption();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharConsumptionHeating") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateConstructionYear(SpecialPurpose specialPurpose,
	// List<ValidationError> results) {
	// if (specialPurpose.getConstructionYear() != null) {
	// if (specialPurpose.getConstructionYear() < 1000 ||
	// specialPurpose.getConstructionYear() > 9999) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldConstructionYear") +
	// " - " + Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	// }
	//
	// protected void validateLastRefurbishment(SpecialPurpose specialPurpose,
	// List<ValidationError> results) {
	// if (specialPurpose.getLastRefurbishment() != null) {
	// if (specialPurpose.getLastRefurbishment() < 1000 ||
	// specialPurpose.getLastRefurbishment() > 9999) {
	// createAndAddValidationError(specialPurpose.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldLastRefurbishment") +
	// " - " + Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	// }
	//
	// @Override
	// protected String getOfferName() {
	// return Messages.getString("TypeSpecialPurpose");
	// }

	@Override
	protected String getOfferName() {
		// TODO Auto-generated method stub
		return null;
	}
}
