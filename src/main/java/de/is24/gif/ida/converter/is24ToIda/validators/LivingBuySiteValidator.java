package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

/**
 * @author René Böttge
 * @author Christopher Heeren
 * 
 */
public class LivingBuySiteValidator extends IS24ApiOfferValidator {

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
	// LivingBuySite livingBuySite = (LivingBuySite) o;
	//
	// List<ValidationError> results = super.validate(o);
	//
	// // validateAddress is called super
	// validatePriceValue(livingBuySite, results);
	// validatePlotArea(livingBuySite, results);
	// validateGrz(livingBuySite, results);
	// validateGfz(livingBuySite, results);
	// validateCommercializationType(livingBuySite, results);
	// validateMinDivisible(livingBuySite, results);
	//
	// return results;
	// }
	//
	// // Override address validator because house number is not mandatory on
	// sites
	// // AND in order to process international offers
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
	// protected void validatePriceValue(LivingBuySite livingBuySite,
	// List<ValidationError> results) {
	// // If there's no price value OR "on application" is true,
	// // no price node is exported,
	// // hence, only the value range is validated
	// if (livingBuySite.getPrice() != null &&
	// (livingBuySite.getPrice().getValue() < 0 ||
	// livingBuySite.getPrice().getValue() > 9999999999999.99)) {
	// createAndAddValidationError(livingBuySite.getExternalId(), getOfferName()
	// + " / " + Messages.getString("FieldPriceValueSite") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validatePlotArea(LivingBuySite livingBuySite,
	// List<ValidationError> results) {
	// if (livingBuySite.getPlotArea() == null) {
	// createAndAddValidationError(livingBuySite.getExternalId(), getOfferName()
	// + " / " + Messages.getString("FieldPlotArea") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (livingBuySite.getPlotArea() < 0 || livingBuySite.getPlotArea()
	// > 99999999.99) {
	// createAndAddValidationError(livingBuySite.getExternalId(), getOfferName()
	// + " / " + Messages.getString("FieldPlotArea") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// // Salesforce validating differs from the IS24 one here
	// protected void validateGrz(LivingBuySite livingBuySite,
	// List<ValidationError> results) {
	// if (livingBuySite.getGrz() != null && (livingBuySite.getGrz() < 0 ||
	// livingBuySite.getGrz() > 9.99)) {
	// createAndAddValidationError(livingBuySite.getExternalId(), getOfferName()
	// + " / " + Messages.getString("FieldGRZ") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateGfz(LivingBuySite livingBuySite,
	// List<ValidationError> results) {
	// if (livingBuySite.getGfz() != null && (livingBuySite.getGfz() < 0 ||
	// livingBuySite.getGfz() > 9.99)) {
	// createAndAddValidationError(livingBuySite.getExternalId(), getOfferName()
	// + " / " + Messages.getString("FieldGFZ") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateCommercializationType(LivingBuySite livingBuySite,
	// List<ValidationError> results) {
	// if (livingBuySite.getCommercializationType() == null) {
	// createAndAddValidationError(livingBuySite.getExternalId(),
	// getOfferName() + " / " +
	// Messages.getString("FieldCommercializationTypeSites") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (livingBuySite.getCommercializationType() ==
	// CommercializationType.LEASEHOLD && livingBuySite.getTenancy() == null) {
	// // API expects a value for Tenancy if
	// // CommercializationType is LEASEHOLD
	// createAndAddValidationError(livingBuySite.getExternalId(), getOfferName()
	// + " / " + Messages.getString("FieldTenancy") + " - " +
	// Messages.getString("MessageMissingTenancy"), results);
	// }
	// }
	//
	// protected void validateMinDivisible(LivingBuySite livingBuySite,
	// List<ValidationError> results) {
	// String externalId = livingBuySite.getExternalId();
	// Double valValue = livingBuySite.getMinDivisible();
	// if (valValue != null && (valValue < 1 || valValue > 99999999.99)) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldMinDivisible") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// @Override
	// protected String getOfferName() {
	// return Messages.getString("TypeLivingBuySite");
	// }
}
