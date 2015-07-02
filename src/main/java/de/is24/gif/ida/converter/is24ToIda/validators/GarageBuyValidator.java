package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import org.zgif.converter.sdk.ValidationError;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageBuy;

/**
 * @author Christopher Heeren
 * 
 */
public class GarageBuyValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		GarageBuy garageBuy = (GarageBuy) o;

		List<ValidationError> results = super.validate(o);

		validatePriceValue(garageBuy, results);
		validateWidthGarage(garageBuy, results);
		validateLengthGarage(garageBuy, results);
		validateHeightGarage(garageBuy, results);
		validateUsableFloorSpace(garageBuy, results);
		validateConstructionYear(garageBuy, results);
		validateLastRefurbishment(garageBuy, results);

		return results;
	}

	protected void validatePriceValue(GarageBuy garageBuy, List<ValidationError> results) {
		if (garageBuy.getPrice().getValue() < 0 || garageBuy.getPrice().getValue() > 9999999999999.99) {
			createAndAddValidationError(garageBuy.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldPriceValue") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateWidthGarage(GarageBuy garageBuy, List<ValidationError> results) {
		if (garageBuy.getWidthGarage() != null) {
			if (garageBuy.getWidthGarage() < 0 || garageBuy.getWidthGarage() > 99.99) {
				createAndAddValidationError(garageBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldWidth") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLengthGarage(GarageBuy garageBuy, List<ValidationError> results) {
		if (garageBuy.getLengthGarage() != null) {
			if (garageBuy.getLengthGarage() < 0 || garageBuy.getLengthGarage() > 99.99) {
				createAndAddValidationError(garageBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldLength") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateHeightGarage(GarageBuy garageBuy, List<ValidationError> results) {
		if (garageBuy.getHeightGarage() != null) {
			if (garageBuy.getHeightGarage() < 0 || garageBuy.getHeightGarage() > 99.99) {
				createAndAddValidationError(garageBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldHeight") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateUsableFloorSpace(GarageBuy garageBuy, List<ValidationError> results) {
		if (garageBuy.getUsableFloorSpace() != null) {
			if (garageBuy.getUsableFloorSpace() < 0 || garageBuy.getUsableFloorSpace() > 99.99) {
				createAndAddValidationError(garageBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldUsableFloorspace") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateConstructionYear(GarageBuy garageBuy, List<ValidationError> results) {
		if (garageBuy.getConstructionYear() != null) {
			if (garageBuy.getConstructionYear() < 1000 || garageBuy.getConstructionYear() > 9999) {
				createAndAddValidationError(garageBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldConstructionYear") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateLastRefurbishment(GarageBuy garageBuy, List<ValidationError> results) {
		if (garageBuy.getLastRefurbishment() != null) {
			if (garageBuy.getLastRefurbishment() < 1000 || garageBuy.getLastRefurbishment() > 9999) {
				createAndAddValidationError(garageBuy.getExternalId(),
						getOfferName() + " / " + Messages.getString("FieldLastRefurbishment") + " - " + Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeGarageBuy");
	}
}
