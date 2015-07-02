package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import org.zgif.converter.sdk.ValidationError;

import de.immobilienscout24.rest.schema.offer.realestates._1.HouseRent;

/**
 * @author René Böttge
 * @author Christopher Heeren
 * 
 */
public class HouseRentValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		HouseRent houseRent = (HouseRent) o;

		List<ValidationError> results = super.validate(o);

		validateBaseRent(houseRent, results);
		validateLivingSpace(houseRent, results);
		validatePlotArea(houseRent, results);
		validateNumberOfRooms(houseRent, results);
		validateEnergyConsumptionContainsWarmWater(houseRent, results);
		// validateThermalCharacteristic(houseRent, results);
		validateConstructionYear(houseRent, results);
		validateLastRefurbishment(houseRent, results);

		return results;
	}

	protected void validateBaseRent(HouseRent houseRent, List<ValidationError> results) {
		if (houseRent.getBaseRent() < 0 || houseRent.getBaseRent() > 9999999999999.99) {
			createAndAddValidationError(houseRent.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldBaseRent") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateLivingSpace(HouseRent houseRent, List<ValidationError> results) {
		if (houseRent.getLivingSpace() < 0 || houseRent.getLivingSpace() > 99999999.99) {
			createAndAddValidationError(houseRent.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldLivingSpace") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validatePlotArea(HouseRent houseRent, List<ValidationError> results) {
		if (houseRent.getPlotArea() < 0 || houseRent.getPlotArea() > 99999999.99) {
			createAndAddValidationError(houseRent.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldPlotArea") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateNumberOfRooms(HouseRent houseRent, List<ValidationError> results) {
		if (houseRent.getNumberOfRooms() < 1 || houseRent.getNumberOfRooms() > 999.99) {
			createAndAddValidationError(houseRent.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldNumberOfRooms") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	// protected void validateThermalCharacteristic(HouseRent houseRent,
	// List<ValidationError> results) {
	// Double tc = houseRent.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(houseRent.getExternalId(), getOfferName() +
	// " / " + Messages.getString(thermCharName(houseRent)) + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }

	protected void validateEnergyConsumptionContainsWarmWater(HouseRent houseRent, List<ValidationError> results) {
		String eccww;
		Double tc = houseRent.getThermalCharacteristic();
		if (houseRent.getEnergyConsumptionContainsWarmWater() != null) {
			eccww = houseRent.getEnergyConsumptionContainsWarmWater().toString();
		} else {
			eccww = null;
		}

		if (eccww != null && eccww.equals("YES")) {
			if (tc == null) {
				createAndAddValidationError(houseRent.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldEnergy") + " - " + Messages.getString("MessageThermalCharMissing"), results);
			}
		}
	}

	// private String thermCharName(HouseRent houseRent) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (houseRent.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if (houseRent.getOffer().getEnergieverbrauchskennwert_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if (houseRent.getOffer().getEndenergiebedarf_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }

	protected void validateConstructionYear(HouseRent houseRent, List<ValidationError> results) {
		if (houseRent.getConstructionYear() != null) {
			if (houseRent.getConstructionYear() < 1000 || houseRent.getConstructionYear() > 9999) {
				createAndAddValidationError(houseRent.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldConstructionYear") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLastRefurbishment(HouseRent houseRent, List<ValidationError> results) {
		if (houseRent.getLastRefurbishment() != null) {
			if (houseRent.getLastRefurbishment() < 1000 || houseRent.getLastRefurbishment() > 9999) {
				createAndAddValidationError(houseRent.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldLastRefurbishment") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeHouseRent");
	}
}
