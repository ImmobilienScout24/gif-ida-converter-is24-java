package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import de.gifev.ida.converter.sdk.ValidationError;
import de.immobilienscout24.rest.schema.common._1.CountyCourt;
import de.immobilienscout24.rest.schema.offer.realestates._1.CompulsoryAuction;

/**
 * @author Christopher Heeren
 * 
 */
public class CompulsoryAuctionValidator extends IS24ApiOfferValidator {

	@Override
	public List<ValidationError> validate(Object o) {
		CompulsoryAuction compulsoryAuction = (CompulsoryAuction) o;

		List<ValidationError> results = super.validate(o);

		validateMarketValue(compulsoryAuction, results);
		validateArea(compulsoryAuction, results);
		validateDateOfAuction(compulsoryAuction, results);
		validateRecordationDate(compulsoryAuction, results);
		validateAuctionObjectType(compulsoryAuction, results);
		validateCountyCourt(compulsoryAuction, results);
		validateFileReferenceAtCountyCourt(compulsoryAuction, results);
		validateNumberOfFolio(compulsoryAuction, results);
		validateOwner(compulsoryAuction, results);

		return results;
	}

	protected void validateMarketValue(CompulsoryAuction compulsoryAuction, List<ValidationError> results) {
		if (compulsoryAuction.getMarketValue().getValue() < 0 || compulsoryAuction.getMarketValue().getValue() > 9999999999999.99) {
			createAndAddValidationError(compulsoryAuction.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldMarketValue") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateArea(CompulsoryAuction compulsoryAuction, List<ValidationError> results) {
		if (compulsoryAuction.getArea() < 0 || compulsoryAuction.getArea() > 99999999.99) {
			createAndAddValidationError(compulsoryAuction.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldArea") + " - " + Messages.getString("MessageOutOfRange"), results);
		}
	}

	protected void validateDateOfAuction(CompulsoryAuction compulsoryAuction, List<ValidationError> results) {
		if (compulsoryAuction.getDateOfAuction() == null) {
			createAndAddValidationError(compulsoryAuction.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldDateOfAuction") + " - " + Messages.getString("MessageValueNotSet"), results);
		}
	}

	protected void validateRecordationDate(CompulsoryAuction compulsoryAuction, List<ValidationError> results) {
		if (compulsoryAuction.getRecordationDate() == null) {
			createAndAddValidationError(compulsoryAuction.getExternalId(), getOfferName() + " / " + Messages.getString("FieldRecordationDate") + " - "
					+ Messages.getString("MessageValueNotSet"), results);
		}
	}

	protected void validateAuctionObjectType(CompulsoryAuction compulsoryAuction, List<ValidationError> results) {
		if (compulsoryAuction.getAuctionObjectType() == null) {
			createAndAddValidationError(compulsoryAuction.getExternalId(), getOfferName() + " / " + Messages.getString("FieldAuctionObjectType") + " - "
					+ Messages.getString("MessageValueNotSet"), results);
		}
	}

	protected void validateCountyCourt(CompulsoryAuction compulsoryAuction, List<ValidationError> results) {
		if (compulsoryAuction.getCountyCourt() == null) {
			createAndAddValidationError(compulsoryAuction.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldCountyCourt") + " - " + Messages.getString("MessageValueNotSet"), results);
		} else {
			CountyCourt countyCourt = compulsoryAuction.getCountyCourt();
			if (countyCourt.getName() == null || countyCourt.getName().length() == 0) {
				createAndAddValidationError(compulsoryAuction.getExternalId(), getOfferName() + " / " + Messages.getString("FieldCountyCourtName") + " - "
						+ Messages.getString("MessageValueNotSet"), results);
			}
			if (countyCourt.getCourtNumber() == null || countyCourt.getCourtNumber().length() == 0) {
				createAndAddValidationError(compulsoryAuction.getExternalId(), getOfferName() + " / " + Messages.getString("FieldCountyCourtNumber") + " - "
						+ Messages.getString("MessageValueNotSet"), results);
			} else if (countyCourt.getCourtNumber().length() > 16) {
				createAndAddValidationError(compulsoryAuction.getExternalId(), getOfferName() + " / " + Messages.getString("FieldCountyCourtNumber") + " - "
						+ Messages.getString("MessageOutOfRange"), results);
			}
		}
	}

	protected void validateFileReferenceAtCountyCourt(CompulsoryAuction compulsoryAuction, List<ValidationError> results) {
		if (compulsoryAuction.getFileReferenceAtCountyCourt() == null || compulsoryAuction.getFileReferenceAtCountyCourt().length() == 0) {
			createAndAddValidationError(compulsoryAuction.getExternalId(), getOfferName() + " / " + Messages.getString("FieldFileReferenceAtCountyCourt")
					+ " - " + Messages.getString("MessageValueNotSet"), results);
		}
	}

	protected void validateNumberOfFolio(CompulsoryAuction compulsoryAuction, List<ValidationError> results) {
		if (compulsoryAuction.getNumberOfFolio() == null || compulsoryAuction.getNumberOfFolio().length() == 0) {
			createAndAddValidationError(compulsoryAuction.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldNumberOfFolio") + " - " + Messages.getString("MessageValueNotSet"), results);
		}
	}

	protected void validateOwner(CompulsoryAuction compulsoryAuction, List<ValidationError> results) {
		if (compulsoryAuction.getOwner() == null || compulsoryAuction.getOwner().length() == 0) {
			createAndAddValidationError(compulsoryAuction.getExternalId(),
					getOfferName() + " / " + Messages.getString("FieldOwner") + " - " + Messages.getString("MessageValueNotSet"), results);
		}
	}

	// @Override
	// protected void validateCourtage(IS24ApiOffer is24ApiOffer,
	// List<ValidationError> results) {
	// // No courtage info at all in SF for compulsory auctions
	// // the API shouldn't expect the courtage node, here
	// }

	@Override
	protected String getOfferName() {
		return Messages.getString("TypeCompulsoryAuction");
	}
}
