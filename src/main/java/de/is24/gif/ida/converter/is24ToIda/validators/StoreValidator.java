package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

/**
 * @author Christopher Heeren
 * 
 */
public class StoreValidator extends IS24ApiOfferValidator {

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
	// Store store = (Store) o;
	//
	// List<ValidationError> results = super.validate(o);
	//
	// validateCommercializationType(store, results);
	// validatePriceMarketingType(store, results);
	// validateNetFloorSpace(store, results);
	// validateEnergyConsumptionContainsWarmWater(store, results);
	// validateThermalCharacteristic(store, results);
	// validateConstructionYear(store, results);
	// validateLastRefurbishment(store, results);
	// validateMinDivisible(store, results);
	// // validateTotalFloorSpace(store, results);
	//
	// validateEnergyConsumptionElectricity(store, results);
	// validateEnergyConsumptionHeating(store, results);
	// validateThermalCharacteristicElectricity(store, results);
	// validateThermalCharacteristicHeating(store, results);
	// validateElectricityConsumption(store, results);
	// validateHeatingConsumption(store, results);
	//
	// return results;
	// }
	//
	// protected void validateCommercializationType(Store store,
	// List<ValidationError> results) {
	// if (store.getCommercializationType() == null) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString("FieldCommercializationType") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validatePriceMarketingType(Store store,
	// List<ValidationError> results) {
	// MarketingType mt = store.getPrice().getMarketingType();
	// CommercializationType ct = store.getCommercializationType();
	// if (mt == null) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString("FieldPriceMarketingType") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (ct != null) {
	// if ((mt.name().contains("RENT") && ct != CommercializationType.RENT) ||
	// (mt.name().contains("PURCHASE") && ct != CommercializationType.BUY)) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString("FieldPriceMarketingType") + " - " +
	// Messages.getString("MessageMismatchMarketingType"),
	// results);
	// }
	// }
	// }
	//
	// protected void validateNetFloorSpace(Store store, List<ValidationError>
	// results) {
	// String externalId = store.getExternalId();
	// Double valValue = store.getNetFloorSpace();
	// if (valValue == null) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldNetFloorSpaceStore") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (valValue < 0 || valValue > 99999999.99) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldNetFloorSpaceStore") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateTotalFloorSpace(Store store, List<ValidationError>
	// results) {
	// String externalId = store.getExternalId();
	// Double valValue = store.getTotalFloorSpace();
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
	// protected void validateMinDivisible(Store store, List<ValidationError>
	// results) {
	// String externalId = store.getExternalId();
	// Double valValue = store.getMinDivisible();
	// if (valValue != null && (valValue < 1 || valValue > 99999999.99)) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldMinDivisibleStore") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateThermalCharacteristic(Store store,
	// List<ValidationError> results) {
	// Double tc = store.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString(thermCharName(store)) + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateEnergyConsumptionContainsWarmWater(Store store,
	// List<ValidationError> results) {
	// String eccww;
	// Double tc = store.getThermalCharacteristic();
	// if (store.getEnergyConsumptionContainsWarmWater() != null) {
	// eccww = store.getEnergyConsumptionContainsWarmWater().toString();
	// } else {
	// eccww = null;
	// }
	//
	// if (eccww != null && eccww.equals("YES")) {
	// if (tc == null) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString("FieldEnergy") + " - " +
	// Messages.getString("MessageThermalCharMissing"), results);
	// }
	// }
	// }
	//
	// private String thermCharName(Store store) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (store.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if (store.getOffer().getEnergieverbrauchskennwert_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if (store.getOffer().getEndenergiebedarf_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }
	//
	// protected void validateEnergyConsumptionElectricity(Store store,
	// List<ValidationError> results) {
	// if (store.getEnergyCertificate() != null) {
	// Double tc =
	// store.getEnergyCertificate().getEnergyConsumptionElectricity();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(store.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharEnergyConsumptionElectricity") +
	// " - " + Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateEnergyConsumptionHeating(Store store,
	// List<ValidationError> results) {
	// if (store.getEnergyCertificate() != null) {
	// Double tc = store.getEnergyCertificate().getEnergyConsumptionHeating();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(store.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharEnergyConsumptionHeating") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateThermalCharacteristicElectricity(Store store,
	// List<ValidationError> results) {
	// if (store.getEnergyCertificate() != null) {
	// Double tc =
	// store.getEnergyCertificate().getThermalCharacteristicElectricity();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString("FieldThermalCharElectricity") + " - " +
	// Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	// }
	//
	// protected void validateThermalCharacteristicHeating(Store store,
	// List<ValidationError> results) {
	// if (store.getEnergyCertificate() != null) {
	// Double tc =
	// store.getEnergyCertificate().getThermalCharacteristicHeating();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString("FieldThermalCharHeating") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateElectricityConsumption(Store store,
	// List<ValidationError> results) {
	// if (store.getEnergyCertificate() != null) {
	// Double tc = store.getEnergyCertificate().getElectricityConsumption();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(store.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldThermalCharConsumptionElectricity") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateHeatingConsumption(Store store,
	// List<ValidationError> results) {
	// if (store.getEnergyCertificate() != null) {
	// Double tc = store.getEnergyCertificate().getHeatingConsumption();
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString("FieldThermalCharConsumptionHeating") + " - " +
	// Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	// }
	//
	// protected void validateConstructionYear(Store store,
	// List<ValidationError> results) {
	// if (store.getConstructionYear() != null) {
	// if (store.getConstructionYear() < 1000 || store.getConstructionYear() >
	// 9999) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString("FieldConstructionYear") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// protected void validateLastRefurbishment(Store store,
	// List<ValidationError> results) {
	// if (store.getLastRefurbishment() != null) {
	// if (store.getLastRefurbishment() < 1000 || store.getLastRefurbishment() >
	// 9999) {
	// createAndAddValidationError(store.getExternalId(), getOfferName() + " / "
	// + Messages.getString("FieldLastRefurbishment") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	// }
	//
	// @Override
	// protected String getOfferName() {
	// return Messages.getString("TypeStore");
	// }
}
