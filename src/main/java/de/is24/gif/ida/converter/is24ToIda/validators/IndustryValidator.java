package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import org.zgif.converter.sdk.ValidationError;

import de.immobilienscout24.rest.schema.common._1.CommercializationType;
import de.immobilienscout24.rest.schema.common._1.MarketingType;
import de.immobilienscout24.rest.schema.offer.realestates._1.Industry;

/**
 * @author Christopher Heeren
 * 
 */
public class IndustryValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		Industry industry = (Industry) o;

		List<ValidationError> results = super.validate(o);

		validateCommercializationType(industry, results);
		validatePriceMarketingType(industry, results);
		validateIndustryType(industry, results);
		validateTotalFloorSpace(industry, results);
		validateNetFloorSpace(industry, results);
		validateMinDivisible(industry, results);
		validateEnergyConsumptionContainsWarmWater(industry, results);
		// validateThermalCharacteristic(industry, results);
		validateConstructionYear(industry, results);
		validateLastRefurbishment(industry, results);

		validateEnergyConsumptionElectricity(industry, results);
		validateEnergyConsumptionHeating(industry, results);
		validateThermalCharacteristicElectricity(industry, results);
		validateThermalCharacteristicHeating(industry, results);
		validateElectricityConsumption(industry, results);
		validateHeatingConsumption(industry, results);

		return results;
	}

	protected void validateIndustryType(Industry industry, List<ValidationError> results) {
		if (industry.getIndustryType() == null) {
			createAndAddValidationError(industry.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldObjectType") + " - " + Messages.getString("MessageValueNotSet"), results);
		}
	}

	protected void validateCommercializationType(Industry industry, List<ValidationError> results) {
		if (industry.getCommercializationType() == null) {
			createAndAddValidationError(industry.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldCommercializationType") + " - " + Messages.getString("MessageValueNotSet"), results);
		}
	}

	protected void validatePriceMarketingType(Industry industry, List<ValidationError> results) {
		MarketingType mt = industry.getPrice().getMarketingType();
		CommercializationType ct = industry.getCommercializationType();
		if (mt == null) {
			createAndAddValidationError(industry.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldPriceMarketingType") + " - " + Messages.getString("MessageValueNotSet"), results);
		} else if (ct != null) {
			if ((mt.name().contains("RENT") && ct != CommercializationType.RENT) || (mt.name().contains("PURCHASE") && ct != CommercializationType.BUY)) {
				createAndAddValidationError(industry.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldPriceMarketingType") + " - " + Messages.getString("MessageMismatchMarketingType"),
						results);
			}
		}
	}

	protected void validateTotalFloorSpace(Industry industry, List<ValidationError> results) {
		String externalId = industry.getExternalId();
		Double valValue = industry.getTotalFloorSpace();
		if (valValue == null) {
			createAndAddValidationError(externalId,
					getOfferName() + " / " + Messages.getString("FieldArea") + " - " + Messages.getString("MessageValueNotSet"), results);
		} else if (valValue < 0 || valValue > 99999999.99) {
			createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldArea") + " - " + Messages.getString("MessageOutOfRange"),
					results);
		}
	}

	protected void validateNetFloorSpace(Industry industry, List<ValidationError> results) {
		String externalId = industry.getExternalId();
		Double valValue = industry.getNetFloorSpace();
		if (valValue == null) {
			createAndAddValidationError(externalId,
					getOfferName() + " / " + Messages.getString("FieldNetFloorSpaceIndustry") + " - " + Messages.getString("MessageValueNotSet"), results);
		} else if (valValue < 0 || valValue > 99999999.99) {
			createAndAddValidationError(externalId,
					getOfferName() + " / " + Messages.getString("FieldNetFloorSpaceIndustry") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateMinDivisible(Industry industry, List<ValidationError> results) {
		String externalId = industry.getExternalId();
		Double valValue = industry.getMinDivisible();
		if (valValue != null && (valValue < 1 || valValue > 99999999.99)) {
			createAndAddValidationError(externalId,
					getOfferName() + " / " + Messages.getString("FieldMinDivisibleIndustry") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	// protected void validateThermalCharacteristic(Industry industry,
	// List<ValidationError> results) {
	// Double tc = industry.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(industry.getExternalId(), getOfferName() +
	// " / " + Messages.getString(thermCharName(industry)) + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }

	protected void validateEnergyConsumptionContainsWarmWater(Industry industry, List<ValidationError> results) {
		String eccww;
		Double tc = industry.getThermalCharacteristic();
		if (industry.getEnergyConsumptionContainsWarmWater() != null) {
			eccww = industry.getEnergyConsumptionContainsWarmWater().toString();
		} else {
			eccww = null;
		}

		if (eccww != null && eccww.equals("YES")) {
			if (tc == null) {
				createAndAddValidationError(industry.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldEnergy") + " - " + Messages.getString("MessageThermalCharMissing"), results);
			}
		}
	}

	//
	// private String thermCharName(Industry industry) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (industry.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if (industry.getOffer().getEnergieverbrauchskennwert_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if (industry.getOffer().getEndenergiebedarf_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }

	protected void validateConstructionYear(Industry industry, List<ValidationError> results) {
		if (industry.getConstructionYear() != null) {
			if (industry.getConstructionYear() < 1000 || industry.getConstructionYear() > 9999) {
				createAndAddValidationError(industry.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldConstructionYear") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLastRefurbishment(Industry industry, List<ValidationError> results) {
		if (industry.getLastRefurbishment() != null) {
			if (industry.getLastRefurbishment() < 1000 || industry.getLastRefurbishment() > 9999) {
				createAndAddValidationError(industry.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldLastRefurbishment") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateEnergyConsumptionElectricity(Industry industry, List<ValidationError> results) {
		if (industry.getEnergyCertificate() != null) {
			Double tc = industry.getEnergyCertificate().getEnergyConsumptionElectricity();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(
						industry.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldThermalCharEnergyConsumptionElectricity") + " - "
								+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateEnergyConsumptionHeating(Industry industry, List<ValidationError> results) {
		if (industry.getEnergyCertificate() != null) {
			Double tc = industry.getEnergyCertificate().getEnergyConsumptionHeating();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(industry.getExternalId(), getOfferName() + " / " + Messages.getString("FieldThermalCharEnergyConsumptionHeating")
						+ " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateThermalCharacteristicElectricity(Industry industry, List<ValidationError> results) {
		if (industry.getEnergyCertificate() != null) {
			Double tc = industry.getEnergyCertificate().getThermalCharacteristicElectricity();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(industry.getExternalId(), getOfferName() + " / " + Messages.getString("FieldThermalCharElectricity") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateThermalCharacteristicHeating(Industry industry, List<ValidationError> results) {
		if (industry.getEnergyCertificate() != null) {
			Double tc = industry.getEnergyCertificate().getThermalCharacteristicHeating();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(industry.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldThermalCharHeating") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateElectricityConsumption(Industry industry, List<ValidationError> results) {
		if (industry.getEnergyCertificate() != null) {
			Double tc = industry.getEnergyCertificate().getElectricityConsumption();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(industry.getExternalId(), getOfferName() + " / " + Messages.getString("FieldThermalCharConsumptionElectricity")
						+ " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateHeatingConsumption(Industry industry, List<ValidationError> results) {
		if (industry.getEnergyCertificate() != null) {
			Double tc = industry.getEnergyCertificate().getHeatingConsumption();
			if (tc != null && tc <= 0) {
				createAndAddValidationError(industry.getExternalId(), getOfferName() + " / " + Messages.getString("FieldThermalCharConsumptionHeating") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeIndustry");
	}
}
