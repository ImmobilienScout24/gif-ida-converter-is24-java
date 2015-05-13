package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import de.gifev.ida.converter.sdk.ValidationError;
import de.immobilienscout24.rest.schema.offer.realestates._1.FlatShareRoom;

/**
 * @author Christopher Heeren
 * 
 */
public class FlatShareRoomValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		FlatShareRoom flatShareRoom = (FlatShareRoom) o;

		List<ValidationError> results = super.validate(o);

		validateBaseRent(flatShareRoom, results);
		validateRoomSize(flatShareRoom, results);
		validateFreeFrom(flatShareRoom, results);
		// validateThermalCharacteristic(flatShareRoom, results);
		validateEnergyConsumptionContainsWarmWater(flatShareRoom, results);

		return results;
	}

	protected void validateBaseRent(FlatShareRoom flatShareRoom, List<ValidationError> results) {
		if (flatShareRoom.getBaseRent() < 0 || flatShareRoom.getBaseRent() > 9999999999999.99) {
			createAndAddValidationError(flatShareRoom.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldBaseRent") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateRoomSize(FlatShareRoom flatShareRoom, List<ValidationError> results) {
		if (flatShareRoom.getRoomSize() < 0 || flatShareRoom.getRoomSize() > 99999999.99) {
			createAndAddValidationError(flatShareRoom.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldRoomSize") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateFreeFrom(FlatShareRoom flatShareRoom, List<ValidationError> results) {
		if (flatShareRoom.getFreeFrom() == null) {
			createAndAddValidationError(flatShareRoom.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldRoomFreeFrom") + " - " + Messages.getString("MessageValueNotSet"), results);
		}
	}

	// protected void validateThermalCharacteristic(FlatShareRoom flatShareRoom,
	// List<ValidationError> results) {
	// Double tc = flatShareRoom.getThermalCharacteristic();
	//
	// if (tc != null && tc <= 0) {
	// createAndAddValidationError(flatShareRoom.getExternalId(), getOfferName()
	// + " / " + Messages.getString(thermCharName(flatShareRoom)) + " - " +
	// Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }

	protected void validateEnergyConsumptionContainsWarmWater(FlatShareRoom flatShareRoom, List<ValidationError> results) {
		String eccww;
		Double tc = flatShareRoom.getThermalCharacteristic();
		if (flatShareRoom.getEnergyConsumptionContainsWarmWater() != null) {
			eccww = flatShareRoom.getEnergyConsumptionContainsWarmWater().toString();
		} else {
			eccww = null;
		}

		if (eccww != null && eccww.equals("YES")) {
			if (tc == null) {
				createAndAddValidationError(flatShareRoom.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldEnergy") + " - " + Messages.getString("MessageThermalCharMissing"), results);
			}
		}
	}

	// private String thermCharName(FlatShareRoom flatShareRoom) {
	// String valMsgField = "FieldThermalChar";
	//
	// if (flatShareRoom.getOffer().getEndenergieverbrauch_kWh_m_a() != null) {
	// valMsgField = "FieldThermalCharConsumption";
	// } else if
	// (flatShareRoom.getOffer().getEnergieverbrauchskennwert_kWh_m_a() != null)
	// {
	// valMsgField = "FieldThermalCharConsumptionValue";
	// } else if (flatShareRoom.getOffer().getEndenergiebedarf_kWh_m_a() !=
	// null) {
	// valMsgField = "FieldThermalCharRequired";
	// }
	// return valMsgField;
	// }

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeFlatShareRoom");
	}
}
