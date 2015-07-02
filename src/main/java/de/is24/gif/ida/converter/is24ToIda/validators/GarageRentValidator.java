package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import org.zgif.converter.sdk.ValidationError;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageRent;

/**
 * @author Martin Fluegge
 * @author Christopher Heeren
 * 
 */
public class GarageRentValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		GarageRent garageRent = (GarageRent) o;

		List<ValidationError> results = super.validate(o);

		validatePriceValue(garageRent, results);
		validateWidthGarage(garageRent, results);
		validateLengthGarage(garageRent, results);
		validateHeightGarage(garageRent, results);
		validateUsableFloorSpace(garageRent, results);
		validateConstructionYear(garageRent, results);
		validateLastRefurbishment(garageRent, results);

		return results;
	}

	protected void validatePriceValue(GarageRent garageRent, List<ValidationError> results) {
		if (garageRent.getPrice().getValue() < 0 || garageRent.getPrice().getValue() > 9999999999999.99) {
			createAndAddValidationError(garageRent.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldRent") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateWidthGarage(GarageRent garageRent, List<ValidationError> results) {
		if (garageRent.getWidthGarage() != null) {
			if (garageRent.getWidthGarage() < 0 || garageRent.getWidthGarage() > 99.99) {
				createAndAddValidationError(garageRent.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldWidth") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLengthGarage(GarageRent garageRent, List<ValidationError> results) {
		if (garageRent.getLengthGarage() != null) {
			if (garageRent.getLengthGarage() < 0 || garageRent.getLengthGarage() > 99.99) {
				createAndAddValidationError(garageRent.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldLength") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateHeightGarage(GarageRent garageRent, List<ValidationError> results) {
		if (garageRent.getHeightGarage() != null) {
			if (garageRent.getHeightGarage() < 0 || garageRent.getHeightGarage() > 99.99) {
				createAndAddValidationError(garageRent.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldHeight") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateUsableFloorSpace(GarageRent garageRent, List<ValidationError> results) {
		if (garageRent.getUsableFloorSpace() != null) {
			if (garageRent.getUsableFloorSpace() < 0 || garageRent.getUsableFloorSpace() > 99.99) {
				createAndAddValidationError(garageRent.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldUsableFloorspace") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateConstructionYear(GarageRent garageRent, List<ValidationError> results) {
		if (garageRent.getConstructionYear() != null) {
			if (garageRent.getConstructionYear() < 1000 || garageRent.getConstructionYear() > 9999) {
				createAndAddValidationError(garageRent.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldConstructionYear") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLastRefurbishment(GarageRent garageRent, List<ValidationError> results) {
		if (garageRent.getLastRefurbishment() != null) {
			if (garageRent.getLastRefurbishment() < 1000 || garageRent.getLastRefurbishment() > 9999) {
				createAndAddValidationError(garageRent.getExternalId(), getOfferName() + " / " + Messages.getString("FieldLastRefurbishment") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeGarageRent");
	}
}
