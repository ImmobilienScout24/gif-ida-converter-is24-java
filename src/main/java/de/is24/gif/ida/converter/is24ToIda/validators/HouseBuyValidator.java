package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import de.gifev.ida.converter.sdk.ValidationError;
import de.immobilienscout24.rest.schema.offer.realestates._1.HouseBuy;

/**
 * @author René Böttge
 * @author Christopher Heeren
 * 
 */
public class HouseBuyValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		HouseBuy houseBuy = (HouseBuy) o;

		List<ValidationError> results = super.validate(o);

		// validatePriceValue(houseBuy, results);
		validateLivingSpace(houseBuy, results);
		validatePlotArea(houseBuy, results);
		validateNumberOfRooms(houseBuy, results);
		validateEnergyConsumptionContainsWarmWater(houseBuy, results);
		// validateThermalCharacteristic(houseBuy, results);
		validateConstructionYear(houseBuy, results);
		validateLastRefurbishment(houseBuy, results);

		return results;
	}

	// Override address validation in order to process international offers
	// @Override
	// protected void validateAddress(IS24ApiOffer is24ApiOffer,
	// List<ValidationError> results) {
	//
	// String externalId = is24ApiOffer.getExternalId();
	//
	// if (is24ApiOffer.getAddress() == null) {
	//			createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldAddress") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// } else {
	// Address address = is24ApiOffer.getAddress();
	// if (address.getCity() == null || address.getCity().length() == 0) {
	//				createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldCity") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	//
	// if (is24ApiOffer.getOffer().getImmobilientyp() != null &&
	// is24ApiOffer.getOffer().getImmobilientyp().contains("Ausland")) {
	// InternationalCountryRegion internationalCountryRegion =
	// address.getInternationalCountryRegion();
	//
	// if (internationalCountryRegion.getCountry() == null ||
	// internationalCountryRegion.getCountry().length() == 0) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldCountry") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// if (internationalCountryRegion.getRegion() == null ||
	// internationalCountryRegion.getRegion().length() == 0) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldRegion") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (internationalCountryRegion.getCountry() != null &&
	// internationalCountryRegion.getCountry().length() > 0) {
	// // Check: Is region existing in IS24?
	// Countries countries = new Countries();
	// if (countries.checkRegion(internationalCountryRegion.getCountry(),
	// internationalCountryRegion.getRegion()) == false) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldRegion") + " - " +
	// Messages.getString("MessageInvalidInput"), results);
	// }
	// }
	// } else {
	// if (address.getHouseNumber() == null || address.getHouseNumber().length()
	// == 0) {
	//					createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldHouseNumber") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	// if (address.getStreet() == null || address.getStreet().length() == 0) {
	//					createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldStreet") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	// if (address.getPostcode() == null || address.getPostcode().length() == 0)
	// {
	//					createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldPostcode") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	// }
	// }
	// }
	//
	// protected void validatePriceValue(HouseBuy houseBuy,
	// List<ValidationError> results) {
	// if (houseBuy.getPrice().getValue() == null) {
	// createAndAddValidationError(houseBuy.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldPriceValue") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (houseBuy.getPrice().getValue() < 0 ||
	// houseBuy.getPrice().getValue() > 9999999999999.99) {
	// createAndAddValidationError(houseBuy.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldPriceValue") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }

	protected void validateLivingSpace(HouseBuy houseBuy, List<ValidationError> results) {
		if (houseBuy.getLivingSpace() < 0 || houseBuy.getLivingSpace() > 99999999.99) {
			createAndAddValidationError(houseBuy.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldLivingSpace") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validatePlotArea(HouseBuy houseBuy, List<ValidationError> results) {
		if (houseBuy.getPlotArea() < 0 || houseBuy.getPlotArea() > 99999999.99) {
			createAndAddValidationError(houseBuy.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldPlotArea") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateNumberOfRooms(HouseBuy houseBuy, List<ValidationError> results) {
		if (houseBuy.getNumberOfRooms() < 1 || houseBuy.getNumberOfRooms() > 999.99) {
			createAndAddValidationError(houseBuy.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldNumberOfRooms") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	// protected void validateThermalCharacteristic(HouseBuy houseBuy,
	// List<ValidationError> results) {
	// Double tc = houseBuy.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(houseBuy.getExternalId(), getOfferName() +
	// " / " + Messages.getString(thermCharName(houseBuy)) + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }

	protected void validateEnergyConsumptionContainsWarmWater(HouseBuy houseBuy, List<ValidationError> results) {
		String eccww;
		Double tc = houseBuy.getThermalCharacteristic();
		if (houseBuy.getEnergyConsumptionContainsWarmWater() != null) {
			eccww = houseBuy.getEnergyConsumptionContainsWarmWater().toString();
		} else {
			eccww = null;
		}

		if (eccww != null && eccww.equals("YES")) {
			if (tc == null) {
				createAndAddValidationError(houseBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldEnergy") + " - " + Messages.getString("MessageThermalCharMissing"), results);
			}
		}
	}

	// private String thermCharName(HouseBuy houseBuy) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (houseBuy.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if (houseBuy.getOffer().getEnergieverbrauchskennwert_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if (houseBuy.getOffer().getEndenergiebedarf_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }

	protected void validateConstructionYear(HouseBuy houseBuy, List<ValidationError> results) {
		if (houseBuy.getConstructionYear() != null) {
			if (houseBuy.getConstructionYear() < 1000 || houseBuy.getConstructionYear() > 9999) {
				createAndAddValidationError(houseBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldConstructionYear") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLastRefurbishment(HouseBuy houseBuy, List<ValidationError> results) {
		if (houseBuy.getLastRefurbishment() != null) {
			if (houseBuy.getLastRefurbishment() < 1000 || houseBuy.getLastRefurbishment() > 9999) {
				createAndAddValidationError(houseBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldLastRefurbishment") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeHouseBuy");
	}
}
