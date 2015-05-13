package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import de.gifev.ida.converter.sdk.ValidationError;
import de.immobilienscout24.rest.schema.offer.realestates._1.ApartmentBuy;

/**
 * @author Christopher Heeren
 * 
 */
public class ApartmentBuyValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		ApartmentBuy apartmentBuy = (ApartmentBuy) o;

		List<ValidationError> results = super.validate(o);

		validatePriceValue(apartmentBuy, results);
		validateLivingSpace(apartmentBuy, results);
		validateNumberOfRooms(apartmentBuy, results);
		validateThermalCharacteristic(apartmentBuy, results);
		validateEnergyConsumptionContainsWarmWater(apartmentBuy, results);
		validateConstructionYear(apartmentBuy, results);
		validateLastRefurbishment(apartmentBuy, results);

		return results;
	}

	// // Override address validation in order to process international offers
	// @Override
	// protected void validateAddress(IS24ApiOffer is24ApiOffer,
	// List<ValidationError> results) {
	//
	// // String externalId = is24ApiOffer.getExternalId();
	// //
	// // if (is24ApiOffer.getAddress() == null) {
	// // createAndAddValidationError(externalId,
	////					getOfferName() + " / " + Messages.getString("FieldAddress") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// // } else {
	// // Address address = is24ApiOffer.getAddress();
	// // if (address.getCity() == null || address.getCity().length() == 0) {
	// // createAndAddValidationError(externalId,
	////						getOfferName() + " / " + Messages.getString("FieldCity") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// // }
	// //
	// // if (is24ApiOffer.getOffer().getImmobilientyp() != null &&
	// is24ApiOffer.getOffer().getImmobilientyp().contains("Ausland")) {
	// // InternationalCountryRegion internationalCountryRegion =
	// address.getInternationalCountryRegion();
	// //
	// // if (internationalCountryRegion.getCountry() == null ||
	// internationalCountryRegion.getCountry().length() == 0) {
	// // createAndAddValidationError(externalId,
	// // getOfferName() + " / " + Messages.getString("FieldCountry") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// // }
	// // if (internationalCountryRegion.getRegion() == null ||
	// internationalCountryRegion.getRegion().length() == 0) {
	// // createAndAddValidationError(externalId,
	// // getOfferName() + " / " + Messages.getString("FieldRegion") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// // } else if (internationalCountryRegion.getCountry() != null &&
	// internationalCountryRegion.getCountry().length() > 0) {
	// // // Check: Is region existing in IS24?
	// // Countries countries = new Countries();
	// // if (countries.checkRegion(internationalCountryRegion.getCountry(),
	// internationalCountryRegion.getRegion()) == false) {
	// // createAndAddValidationError(externalId,
	// // getOfferName() + " / " + Messages.getString("FieldRegion") + " - " +
	// Messages.getString("MessageInvalidInput"), results);
	// // }
	// // }
	// // } else {
	// // if (address.getHouseNumber() == null ||
	// address.getHouseNumber().length() == 0) {
	// // createAndAddValidationError(externalId,
	////							getOfferName() + " / " + Messages.getString("FieldHouseNumber") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// // }
	// // if (address.getStreet() == null || address.getStreet().length() == 0)
	// {
	// // createAndAddValidationError(externalId,
	////							getOfferName() + " / " + Messages.getString("FieldStreet") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// // }
	// // if (address.getPostcode() == null || address.getPostcode().length() ==
	// 0) {
	// // createAndAddValidationError(externalId,
	////							getOfferName() + " / " + Messages.getString("FieldPostcode") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// // }
	// // }
	// // }
	// }

	protected void validatePriceValue(ApartmentBuy apartmentBuy, List<ValidationError> results) {
		if (apartmentBuy.getPrice().getValue() < 0 || apartmentBuy.getPrice().getValue() > 9999999999999.99) {
			createAndAddValidationError(apartmentBuy.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldPriceValue") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateLivingSpace(ApartmentBuy apartmentBuy, List<ValidationError> results) {
		if (apartmentBuy.getLivingSpace() < 0 || apartmentBuy.getLivingSpace() > 99999999.99) {
			createAndAddValidationError(apartmentBuy.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldLivingSpace") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateNumberOfRooms(ApartmentBuy apartmentBuy, List<ValidationError> results) {
		if (apartmentBuy.getNumberOfRooms() < 1 || apartmentBuy.getNumberOfRooms() > 999.99) {
			createAndAddValidationError(apartmentBuy.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldNumberOfRooms") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateThermalCharacteristic(ApartmentBuy apartmentBuy, List<ValidationError> results) {
		Double tc = apartmentBuy.getThermalCharacteristic();

		if (tc != null && tc <= 0) {
			createAndAddValidationError(apartmentBuy.getExternalId(), getOfferName() + " / " + Messages.getString(thermCharName(apartmentBuy)) + " - "
					+ Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateEnergyConsumptionContainsWarmWater(ApartmentBuy apartmentBuy, List<ValidationError> results) {
		String eccww;
		Double tc = apartmentBuy.getThermalCharacteristic();
		if (apartmentBuy.getEnergyConsumptionContainsWarmWater() != null) {
			eccww = apartmentBuy.getEnergyConsumptionContainsWarmWater().toString();
		} else {
			eccww = null;
		}

		if (eccww != null && eccww.equals("YES")) {
			if (tc == null) {
				createAndAddValidationError(apartmentBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldEnergy") + " - " + Messages.getString("MessageThermalCharMissing"), results);
			}
		}
	}

	private String thermCharName(ApartmentBuy apartmentBuy) {
		String valMsgField = "FieldThermalChar";

		// if (apartmentBuy.getOffer().getEndenergieverbrauch_kWh_m_a() != null)
		// {
		// valMsgField = "FieldThermalCharConsumption";
		// } else if
		// (apartmentBuy.getOffer().getEnergieverbrauchskennwert_kWh_m_a() !=
		// null) {
		// valMsgField = "FieldThermalCharConsumptionValue";
		// } else if (apartmentBuy.getOffer().getEndenergiebedarf_kWh_m_a() !=
		// null) {
		// valMsgField = "FieldThermalCharRequired";
		// }
		return valMsgField;
	}

	protected void validateConstructionYear(ApartmentBuy apartmentBuy, List<ValidationError> results) {
		if (apartmentBuy.getConstructionYear() != null) {
			if (apartmentBuy.getConstructionYear() < 1000 || apartmentBuy.getConstructionYear() > 9999) {
				createAndAddValidationError(apartmentBuy.getExternalId(), getOfferName() + " / " + Messages.getString("FieldConstructionYear") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLastRefurbishment(ApartmentBuy apartmentBuy, List<ValidationError> results) {
		if (apartmentBuy.getLastRefurbishment() != null) {
			if (apartmentBuy.getLastRefurbishment() < 1000 || apartmentBuy.getLastRefurbishment() > 9999) {
				createAndAddValidationError(apartmentBuy.getExternalId(), getOfferName() + " / " + Messages.getString("FieldLastRefurbishment") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeApartmentBuy");
	}
}
