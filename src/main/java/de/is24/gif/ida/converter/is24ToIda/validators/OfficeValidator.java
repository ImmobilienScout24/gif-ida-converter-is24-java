package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

/**
 * @author Christopher Heeren
 * 
 */
public class OfficeValidator extends IS24ApiOfferValidator {

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
	// Office office = (Office) o;
	//
	// List<ValidationError> results = super.validate(o);
	//
	// validateCommercializationType(office, results);
	// validatePriceMarketingType(office, results);
	// validateOfficeType(office, results);
	// validateNetFloorSpace(office, results);
	// validateEnergyConsumptionContainsWarmWater(office, results);
	// validateThermalCharacteristic(office, results);
	// validateConstructionYear(office, results);
	// validateLastRefurbishment(office, results);
	// validateMinDivisible(office, results);
	//
	// validateEnergyConsumptionElectricity(office, results);
	// validateEnergyConsumptionHeating(office, results);
	// validateThermalCharacteristicElectricity(office, results);
	// validateThermalCharacteristicHeating(office, results);
	// validateElectricityConsumption(office, results);
	// validateHeatingConsumption(office, results);
	//
	// return results;
	// }
	//
	// protected void validateOfficeType(Office office, List<ValidationError>
	// results) {
	// if (office.getOfficeType() == null) {
	// createAndAddValidationError(office.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldObjectType") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validateCommercializationType(Office office,
	// List<ValidationError> results) {
	// if (office.getCommercializationType() == null) {
	// createAndAddValidationError(office.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldCommercializationType") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validatePriceMarketingType(Office office,
	// List<ValidationError> results) {
	// MarketingType mt = office.getPrice().getMarketingType();
	// CommercializationType ct = office.getCommercializationType();
	// if (mt == null) {
	// createAndAddValidationError(office.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldPriceMarketingType") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (ct != null) {
	// if ((mt.name().contains("RENT") && ct != CommercializationType.RENT) ||
	// (mt.name().contains("PURCHASE") && ct != CommercializationType.BUY)) {
	// createAndAddValidationError(office.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldPriceMarketingType") +
	// " - " + Messages.getString("MessageMismatchMarketingType"), results);
	// }
	// }
	// }
	//
	// protected void validateNetFloorSpace(Office office, List<ValidationError>
	// results) {
	// String externalId = office.getExternalId();
	// Double valValue = office.getNetFloorSpace();
	// if (valValue == null) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldNetFloorSpaceOffice") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (valValue < 0 || valValue > 99999999.99) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldNetFloorSpaceOffice") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateMinDivisible(Office office, List<ValidationError>
	// results) {
	// String externalId = office.getExternalId();
	// Double valValue = office.getMinDivisible();
	// if (valValue != null && (valValue < 1 || valValue > 99999999.99)) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldMinDivisibleOffice") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateThermalCharacteristic(Office office,
	// List<ValidationError> results) {
	// Double tc = office.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(office.getExternalId(), getOfferName() +
	// " / " + Messages.getString(thermCharName(office)) + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateEnergyConsumptionContainsWarmWater(Office office,
	// List<ValidationError> results) {
	// String eccww;
	// Double tc = office.getThermalCharacteristic();
	// if (office.getEnergyConsumptionContainsWarmWater() != null) {
	// eccww = office.getEnergyConsumptionContainsWarmWater().toString();
	// } else {
	// eccww = null;
	// }
	//
	// if (eccww != null && eccww.equals("YES")) {
	// if (tc == null) {
	// createAndAddValidationError(office.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldEnergy") + " - " +
	// Messages.getString("MessageThermalCharMissing"), results);
	// }
	// }
	// }
	//
	// private String thermCharName(Office office) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (office.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if (office.getOffer().getEnergieverbrauchskennwert_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if (office.getOffer().getEndenergiebedarf_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }
	//
	// protected void validateEnergyConsumptionElectricity(Office office,
	// List<ValidationError> results) {
	// if (office.getEnergyCertificate() != null) {
	// Double tc =
	// office.getEnergyCertificate().getEnergyConsumptionElectricity();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(office.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharEnergyConsumptionElectricity") +
	// " - " + Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateEnergyConsumptionHeating(Office office,
	// List<ValidationError> results) {
	// if (office.getEnergyCertificate() != null) {
	// Double tc = office.getEnergyCertificate().getEnergyConsumptionHeating();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(office.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharEnergyConsumptionHeating") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateThermalCharacteristicElectricity(Office office,
	// List<ValidationError> results) {
	// if (office.getEnergyCertificate() != null) {
	// Double tc =
	// office.getEnergyCertificate().getThermalCharacteristicElectricity();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(office.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldThermalCharElectricity") + " - " +
	// Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	// }
	//
	// protected void validateThermalCharacteristicHeating(Office office,
	// List<ValidationError> results) {
	// if (office.getEnergyCertificate() != null) {
	// Double tc =
	// office.getEnergyCertificate().getThermalCharacteristicHeating();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(office.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldThermalCharHeating") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateElectricityConsumption(Office office,
	// List<ValidationError> results) {
	// if (office.getEnergyCertificate() != null) {
	// Double tc = office.getEnergyCertificate().getElectricityConsumption();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(office.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharConsumptionElectricity") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateHeatingConsumption(Office office,
	// List<ValidationError> results) {
	// if (office.getEnergyCertificate() != null) {
	// Double tc = office.getEnergyCertificate().getHeatingConsumption();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(office.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharConsumptionHeating") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateConstructionYear(Office office,
	// List<ValidationError> results) {
	// if (office.getConstructionYear() != null) {
	// if (office.getConstructionYear() < 1000 || office.getConstructionYear() >
	// 9999) {
	// createAndAddValidationError(office.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldConstructionYear") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateLastRefurbishment(Office office,
	// List<ValidationError> results) {
	// if (office.getLastRefurbishment() != null) {
	// if (office.getLastRefurbishment() < 1000 || office.getLastRefurbishment()
	// > 9999) {
	// createAndAddValidationError(office.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldLastRefurbishment") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// @Override
	// protected String getOfferName() {
	// return Messages.getString("TypeOffice");
	// }
}
