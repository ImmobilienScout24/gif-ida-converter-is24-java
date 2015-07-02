package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import org.zgif.converter.sdk.ValidationError;

import de.immobilienscout24.rest.schema.offer.realestates._1.Gastronomy;

/**
 * @author Christopher Heeren
 * 
 */
public class GastronomyValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		Gastronomy gastronomy = (Gastronomy) o;

		List<ValidationError> results = super.validate(o);

		validateGastronomyType(gastronomy, results);
		validateCommercializationType(gastronomy, results);
		validateTotalFloorSpace(gastronomy, results);
		// validateMinDivisible(gastronomy, results); //Not in dialogues
		validateEnergyConsumptionContainsWarmWater(gastronomy, results);
		// validateThermalCharacteristic(gastronomy, results);
		validateConstructionYear(gastronomy, results);
		validateLastRefurbishment(gastronomy, results);

		validateEnergyConsumptionElectricity(gastronomy, results);
		validateEnergyConsumptionHeating(gastronomy, results);
		validateThermalCharacteristicElectricity(gastronomy, results);
		validateThermalCharacteristicHeating(gastronomy, results);
		validateElectricityConsumption(gastronomy, results);
		validateHeatingConsumption(gastronomy, results);

		return results;
	}

	protected void validateGastronomyType(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getGastronomyType() == null) {
			createAndAddValidationError(gastronomy.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldObjectType") + " - " + Messages.getString("MessageValueNotSet"), results);
		}
	}

	protected void validateCommercializationType(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getCommercializationType() == null) {
			createAndAddValidationError(gastronomy.getExternalId(), getOfferName() + " / " + Messages.getString("FieldCommercializationType") + " - "
					+ Messages.getString("MessageValueNotSet"), results);
		}
	}

	protected void validateTotalFloorSpace(Gastronomy gastronomy, List<ValidationError> results) {
		String externalId = gastronomy.getExternalId();
		Double valValue = gastronomy.getTotalFloorSpace();
		if (valValue == null) {
			createAndAddValidationError(externalId,
					getOfferName() + " / " + Messages.getString("FieldArea") + " - " + Messages.getString("MessageValueNotSet"), results);
		} else if (valValue < 0 || valValue > 99999999.99) {
			createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldArea") + " - " + Messages.getString("MessageOutOfRange"),
					results);
		}
	}

	protected void validateMinDivisible(Gastronomy gastronomy, List<ValidationError> results) {
		String externalId = gastronomy.getExternalId();

		if (gastronomy.getMinDivisible() != null && gastronomy.getMinDivisible() <= 1) {
			createAndAddValidationError(externalId,
					getOfferName() + " / " + Messages.getString("FieldMinDivisibleGastronomy") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	// protected void validateThermalCharacteristic(Gastronomy gastronomy,
	// List<ValidationError> results) {
	// Double tc = gastronomy.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(gastronomy.getExternalId(), getOfferName() +
	// " / " + Messages.getString(thermCharName(gastronomy)) + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }

	protected void validateEnergyConsumptionContainsWarmWater(Gastronomy gastronomy, List<ValidationError> results) {
		String eccww;
		Double tc = gastronomy.getThermalCharacteristic();
		if (gastronomy.getEnergyConsumptionContainsWarmWater() != null) {
			eccww = gastronomy.getEnergyConsumptionContainsWarmWater().toString();
		} else {
			eccww = null;
		}

		if (eccww != null && eccww.equals("YES")) {
			if (tc == null) {
				createAndAddValidationError(gastronomy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldEnergy") + " - " + Messages.getString("MessageThermalCharMissing"), results);
			}
		}
	}

	//
	// private String thermCharName(Gastronomy gastronomy) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (gastronomy.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if (gastronomy.getOffer().getEnergieverbrauchskennwert_kWh_m_a()
	// != null) {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if (gastronomy.getOffer().getEndenergiebedarf_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }

	protected void validateConstructionYear(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getConstructionYear() != null) {
			if (gastronomy.getConstructionYear() < 1000 || gastronomy.getConstructionYear() > 9999) {
				createAndAddValidationError(gastronomy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldConstructionYear") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLastRefurbishment(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getLastRefurbishment() != null) {
			if (gastronomy.getLastRefurbishment() < 1000 || gastronomy.getLastRefurbishment() > 9999) {
				createAndAddValidationError(gastronomy.getExternalId(), getOfferName() + " / " + Messages.getString("FieldLastRefurbishment") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateEnergyConsumptionElectricity(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getEnergyCertificate() != null) {
			Double tc = gastronomy.getEnergyCertificate().getEnergyConsumptionElectricity();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(
						gastronomy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldThermalCharEnergyConsumptionElectricity") + " - "
								+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateEnergyConsumptionHeating(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getEnergyCertificate() != null) {
			Double tc = gastronomy.getEnergyCertificate().getEnergyConsumptionHeating();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(gastronomy.getExternalId(), getOfferName() + " / " + Messages.getString("FieldThermalCharEnergyConsumptionHeating")
						+ " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateThermalCharacteristicElectricity(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getEnergyCertificate() != null) {
			Double tc = gastronomy.getEnergyCertificate().getThermalCharacteristicElectricity();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(gastronomy.getExternalId(), getOfferName() + " / " + Messages.getString("FieldThermalCharElectricity") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateThermalCharacteristicHeating(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getEnergyCertificate() != null) {
			Double tc = gastronomy.getEnergyCertificate().getThermalCharacteristicHeating();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(gastronomy.getExternalId(), getOfferName() + " / " + Messages.getString("FieldThermalCharHeating") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateElectricityConsumption(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getEnergyCertificate() != null) {
			Double tc = gastronomy.getEnergyCertificate().getElectricityConsumption();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(gastronomy.getExternalId(), getOfferName() + " / " + Messages.getString("FieldThermalCharConsumptionElectricity")
						+ " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateHeatingConsumption(Gastronomy gastronomy, List<ValidationError> results) {
		if (gastronomy.getEnergyCertificate() != null) {
			Double tc = gastronomy.getEnergyCertificate().getHeatingConsumption();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(gastronomy.getExternalId(), getOfferName() + " / " + Messages.getString("FieldThermalCharConsumptionHeating")
						+ " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeGastronomy");
	}
}
