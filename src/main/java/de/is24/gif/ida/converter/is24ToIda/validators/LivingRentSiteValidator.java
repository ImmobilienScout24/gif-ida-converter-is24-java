package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

public class LivingRentSiteValidator extends IS24ApiOfferValidator {

	@Override
	public List validate(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getOfferName() {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public List<ValidationError> validate(Object o) {
	// LivingRentSite livingRentSite = (LivingRentSite) o;
	//
	// List<ValidationError> results = super.validate(o);
	//
	// // validateAddress is called super
	// validatePriceValue(livingRentSite, results);
	// validatePlotArea(livingRentSite, results);
	// validateGrz(livingRentSite, results);
	// validateGfz(livingRentSite, results);
	// validateMinDivisible(livingRentSite, results);
	//
	// return results;
	// }
	//
	// // Override address validator because house number is not mandatory on
	// sites
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
	//
	// if (address.getStreet() == null || address.getStreet().length() == 0) {
	//				createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldStreet") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	// if (address.getCity() == null || address.getCity().length() == 0) {
	//				createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldCity") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	// if (address.getPostcode() == null || address.getPostcode().length() == 0)
	// {
	//				createAndAddValidationError(externalId, getOfferName() + " / " + Messages.getString("FieldPostcode") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	// }
	// }
	//
	// protected void validatePriceValue(LivingRentSite livingRentSite,
	// List<ValidationError> results) {
	// // If there's no price value OR "on application" is true,
	// // no price node is exported,
	// // hence, only the value range is validated
	// if (livingRentSite.getPrice() != null &&
	// (livingRentSite.getPrice().getValue() < 0 ||
	// livingRentSite.getPrice().getValue() > 9999999999999.99)) {
	// createAndAddValidationError(livingRentSite.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldPriceValueRentSite") +
	// " - " + Messages.getString("MessageOutOfRange"),
	// results);
	// }
	// }
	//
	// protected void validatePlotArea(LivingRentSite livingRentSite,
	// List<ValidationError> results) {
	// if (livingRentSite.getPlotArea() == null) {
	// createAndAddValidationError(livingRentSite.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldPlotArea") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (livingRentSite.getPlotArea() < 0 ||
	// livingRentSite.getPlotArea() > 99999999.99) {
	// createAndAddValidationError(livingRentSite.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldPlotArea") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// // Salesforce validating differs from the IS24 one here
	// protected void validateGrz(LivingRentSite livingRentSite,
	// List<ValidationError> results) {
	// if (livingRentSite.getGrz() != null && (livingRentSite.getGrz() < 0 ||
	// livingRentSite.getGrz() > 9.99)) {
	// createAndAddValidationError(livingRentSite.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldGRZ") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateGfz(LivingRentSite livingRentSite,
	// List<ValidationError> results) {
	// if (livingRentSite.getGfz() != null && (livingRentSite.getGfz() < 0 ||
	// livingRentSite.getGfz() > 9.99)) {
	// createAndAddValidationError(livingRentSite.getExternalId(),
	// getOfferName() + " / " + Messages.getString("FieldGFZ") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateMinDivisible(LivingRentSite livingRentSite,
	// List<ValidationError> results) {
	// String externalId = livingRentSite.getExternalId();
	// Double valValue = livingRentSite.getMinDivisible();
	// if (valValue != null && (valValue < 1 || valValue > 99999999.99)) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldMinDivisible") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// @Override
	// protected String getOfferName() {
	// return Messages.getString("TypeLivingRentSite");
	// }
}
