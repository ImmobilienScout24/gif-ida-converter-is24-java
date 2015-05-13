package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

/**
 * 
 * @author Christopher Heeren
 * 
 */
public class InvestmentValidator extends IS24ApiOfferValidator {

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
	// Investment investment = (Investment) o;
	//
	// List<ValidationError> results = super.validate(o);
	//
	// validatePriceValue(investment, results);
	// validateInvestmentType(investment, results);
	// validateNetFloorSpace(investment, results);
	// validateConstructionYear(investment, results);
	// validateEnergyConsumptionContainsWarmWater(investment, results);
	// validateThermalCharacteristic(investment, results);
	//
	// validateEnergyConsumptionElectricity(investment, results);
	// validateEnergyConsumptionHeating(investment, results);
	// validateThermalCharacteristicElectricity(investment, results);
	// validateThermalCharacteristicHeating(investment, results);
	// validateElectricityConsumption(investment, results);
	// validateHeatingConsumption(investment, results);
	//
	// return results;
	// }
	//
	// protected void validatePriceValue(Investment investment,
	// List<ValidationError> results) {
	// if (investment.getPrice().getValue() < 0 ||
	// investment.getPrice().getValue() > 9999999999999.99) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldPriceValue") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateNetFloorSpace(Investment investment,
	// List<ValidationError> results) {
	// if (investment.getNetFloorSpace() == null) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldNetFloorSpaceInvestment") + " - " +
	// Messages.getString("MessageValueNotSet"),
	// results);
	// } else if (investment.getNetFloorSpace() < 0 ||
	// investment.getNetFloorSpace() > 99999999.99) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldNetFloorSpaceInvestment") + " - " +
	// Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	//
	// protected void validateConstructionYear(Investment investment,
	// List<ValidationError> results) {
	// if (investment.getConstructionYear() == null) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldConstructionYear") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (investment.getConstructionYear() < 1000 ||
	// investment.getConstructionYear() > 9999) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldConstructionYear") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateInvestmentType(Investment investment,
	// List<ValidationError> results) {
	// if (investment.getInvestmentType() == null) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldObjectType") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validateThermalCharacteristic(Investment investment,
	// List<ValidationError> results) {
	// Double tc = investment.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString(thermCharName(investment)) + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateEnergyConsumptionContainsWarmWater(Investment
	// investment, List<ValidationError> results) {
	// String eccww;
	// Double tc = investment.getThermalCharacteristic();
	// if (investment.getEnergyConsumptionContainsWarmWater() != null) {
	// eccww = investment.getEnergyConsumptionContainsWarmWater().toString();
	// } else {
	// eccww = null;
	// }
	//
	// if (eccww != null && eccww.equals("YES")) {
	// if (tc == null) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldEnergy") + " - " +
	// Messages.getString("MessageThermalCharMissing"), results);
	// }
	// }
	// }
	//
	// private String thermCharName(Investment investment) {
	// String valMsgField = "FieldThermalChar";
	//
	// // if (investment.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// // valMsgField = "FieldThermalCharConsumption";
	// // } else if
	// (investment.getOffer().getEnergieverbrauchskennwert_kWh_m_a() != null) {
	// // valMsgField = "FieldThermalCharConsumptionValue";
	// // } else if (investment.getOffer().getEndenergiebedarf_kWh_m_a() !=
	// null) {
	// // valMsgField = "FieldThermalCharRequired";
	// // }
	// return valMsgField;
	// }
	//
	// protected void validateEnergyConsumptionElectricity(Investment
	// investment, List<ValidationError> results) {
	// if (investment.getEnergyCertificate() != null) {
	// Double tc =
	// investment.getEnergyCertificate().getEnergyConsumptionElectricity();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(investment.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharEnergyConsumptionElectricity") +
	// " - " + Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateEnergyConsumptionHeating(Investment investment,
	// List<ValidationError> results) {
	// if (investment.getEnergyCertificate() != null) {
	// Double tc =
	// investment.getEnergyCertificate().getEnergyConsumptionHeating();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(investment.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharEnergyConsumptionHeating") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateThermalCharacteristicElectricity(Investment
	// investment, List<ValidationError> results) {
	// if (investment.getEnergyCertificate() != null) {
	// Double tc =
	// investment.getEnergyCertificate().getThermalCharacteristicElectricity();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldThermalCharElectricity") + " - " +
	// Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	// }
	//
	// protected void validateThermalCharacteristicHeating(Investment
	// investment, List<ValidationError> results) {
	// if (investment.getEnergyCertificate() != null) {
	// Double tc =
	// investment.getEnergyCertificate().getThermalCharacteristicHeating();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(investment.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldThermalCharHeating") + " - " +
	// Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	// }
	//
	// protected void validateElectricityConsumption(Investment investment,
	// List<ValidationError> results) {
	// if (investment.getEnergyCertificate() != null) {
	// Double tc =
	// investment.getEnergyCertificate().getElectricityConsumption();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(investment.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharConsumptionElectricity") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateHeatingConsumption(Investment investment,
	// List<ValidationError> results) {
	// if (investment.getEnergyCertificate() != null) {
	// Double tc = investment.getEnergyCertificate().getHeatingConsumption();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(investment.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharConsumptionHeating") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// @Override
	// protected String getOfferName() {
	// return Messages.getString("TypeInvestment");
	// }
}
