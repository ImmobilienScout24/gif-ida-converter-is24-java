package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import de.gifev.ida.converter.sdk.ValidationError;

/**
 * @author Martin Fluegge
 * @author Christopher Heeren
 * 
 */
public abstract class IS24ApiOfferValidator extends AbstractAddressValidator {

	protected abstract String getOfferName();

	@Override
	public List<ValidationError> validate(Object o) {

		return null;
	}

	// @Override
	// public List<ValidationError> validate(Object o) {
	// IS24ApiOffer is24ApiOffer = (IS24ApiOffer) o;
	//
	// List<ValidationError> results = new ArrayList<ValidationError>();
	//
	// validateTitle(is24ApiOffer, results);
	// validateAddress(is24ApiOffer, results);
	// validateCourtage(is24ApiOffer, results);
	//
	// return results;
	// }
	//
	// protected void validateAddress(IS24ApiOffer is24ApiOffer,
	// List<ValidationError> results) {
	//
	// validateAddress(is24ApiOffer.getAddress(), is24ApiOffer.getExternalId(),
	// getOfferName(), results);
	// }
	//
	// protected void validateTitle(IS24ApiOffer is24ApiOffer,
	// List<ValidationError> results) {
	// if (is24ApiOffer.getTitle() == null) {
	// createAndAddValidationError(is24ApiOffer.getExternalId(), getOfferName()
	// + " / " + Messages.getString("FieldTitle") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validateCourtage(IS24ApiOffer is24ApiOffer,
	// List<ValidationError> results) {
	// // API returns: MESSAGE: hasCourtage is mandatory: YES or NO.
	// // The value NOT_APPLICABLE is no more allowed
	// if (is24ApiOffer.getOffer().getProvision() == null ||
	// is24ApiOffer.getOffer().getProvision().isEmpty()) {
	// createAndAddValidationError(is24ApiOffer.getExternalId(), getOfferName()
	// + " / " + Messages.getString("FieldCourtage") + " - " +
	// Messages.getString("MessageCourtageYesNo"), results);
	// }
	//
	// if (is24ApiOffer.getOffer().getProvision() != null &&
	// is24ApiOffer.getOffer().getProvision().equals("Ja")) {
	// if (is24ApiOffer.getOffer().getProvisionshoehe() == null ||
	// is24ApiOffer.getOffer().getProvisionshoehe().length() == 0) {
	// createAndAddValidationError(is24ApiOffer.getExternalId(), getOfferName()
	// + " / " + Messages.getString("FieldCourtageHeight") + " - " +
	// Messages.getString("MessageMissingCourtage"),
	// results);
	// }
	// }
	// if (is24ApiOffer.getOffer().getProvision() != null &&
	// is24ApiOffer.getOffer().getProvision().equals("Nein")) {
	// if (is24ApiOffer.getOffer().getProvisionshinweisExt() != null &&
	// is24ApiOffer.getOffer().getProvisionshinweisExt().length() > 0) {
	// createAndAddValidationError(is24ApiOffer.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldCourtageNote") + " - "
	// + Messages.getString("MessageCourtageNoteRedundant"), results);
	// }
	// }
	// }
	//

}
