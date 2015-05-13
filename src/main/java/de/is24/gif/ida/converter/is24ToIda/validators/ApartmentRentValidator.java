package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import de.gifev.ida.converter.sdk.ValidationError;
import de.immobilienscout24.rest.schema.offer.realestates._1.ApartmentRent;

/**
 * 
 * @author Christopher Heeren
 * 
 */
public class ApartmentRentValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		ApartmentRent apartmentRent = (ApartmentRent) o;

		List<ValidationError> results = super.validate(o);

		validateBaseRent(apartmentRent, results);
		validateLivingSpace(apartmentRent, results);
		validateNumberOfRooms(apartmentRent, results);
		validateEnergyConsumptionContainsWarmWater(apartmentRent, results);
		// validateThermalCharacteristic(apartmentRent, results);
		validateConstructionYear(apartmentRent, results);
		validateLastRefurbishment(apartmentRent, results);

		return results;
	}

	protected void validateBaseRent(ApartmentRent apartmentRent, List<ValidationError> results) {
		if (apartmentRent.getBaseRent() < 0 || apartmentRent.getBaseRent() > 9999999999999.99) {
			createAndAddValidationError(apartmentRent.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldBaseRent") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateLivingSpace(ApartmentRent apartmentRent, List<ValidationError> results) {
		if (apartmentRent.getLivingSpace() < 0 || apartmentRent.getLivingSpace() > 99999999.99) {
			createAndAddValidationError(apartmentRent.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldLivingSpace") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateNumberOfRooms(ApartmentRent apartmentRent, List<ValidationError> results) {
		if (apartmentRent.getNumberOfRooms() < 1 || apartmentRent.getNumberOfRooms() > 999.99) {
			createAndAddValidationError(apartmentRent.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldNumberOfRooms") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	//
	// protected void validateThermalCharacteristic(ApartmentRent apartmentRent,
	// List<ValidationError> results) {
	// Double tc = apartmentRent.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(apartmentRent.getExternalId(), getOfferName()
	// + " / " + Messages.getString(thermCharName(apartmentRent)) + " - "
	// + Messages.getString("MessageOutOfRange"), results);
	// }
	// }

	protected void validateEnergyConsumptionContainsWarmWater(ApartmentRent apartmentRent, List<ValidationError> results) {
		String eccww;
		Double tc = apartmentRent.getThermalCharacteristic();
		if (apartmentRent.getEnergyConsumptionContainsWarmWater() != null) {
			eccww = apartmentRent.getEnergyConsumptionContainsWarmWater().toString();
		} else {
			eccww = null;
		}

		if (eccww != null && eccww.equals("YES")) {
			if (tc == null) {
				createAndAddValidationError(apartmentRent.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldEnergy") + " - " + Messages.getString("MessageThermalCharMissing"), results);
			}
		}
	}

	protected void validateConstructionYear(ApartmentRent apartmentRent, List<ValidationError> results) {
		if (apartmentRent.getConstructionYear() != null) {
			if (apartmentRent.getConstructionYear() < 1000 || apartmentRent.getConstructionYear() > 9999) {
				createAndAddValidationError(apartmentRent.getExternalId(), getOfferName() + " / " + Messages.getString("FieldConstructionYear") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLastRefurbishment(ApartmentRent apartmentRent, List<ValidationError> results) {
		if (apartmentRent.getLastRefurbishment() != null) {
			if (apartmentRent.getLastRefurbishment() < 1000 || apartmentRent.getLastRefurbishment() > 9999) {
				createAndAddValidationError(apartmentRent.getExternalId(), getOfferName() + " / " + Messages.getString("FieldLastRefurbishment") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	// // identify relevant thermal characteristic for message
	// private String thermCharName(ApartmentRent apartmentRent) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (apartmentRent.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if
	// (apartmentRent.getOffer().getEnergieverbrauchskennwert_kWh_m_a() != null)
	// {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if (apartmentRent.getOffer().getEndenergiebedarf_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeApartmentRent");
	}
}
