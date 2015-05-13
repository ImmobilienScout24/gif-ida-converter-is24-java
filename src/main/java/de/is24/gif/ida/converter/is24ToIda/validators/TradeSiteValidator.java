package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

/**
 * @author Christopher Heeren
 * 
 */
public class TradeSiteValidator extends IS24ApiOfferValidator {

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
	// TradeSite tradeSite = (TradeSite) o;
	//
	// List<ValidationError> results = super.validate(o);
	//
	// // validateAddress is called super
	//
	// validatePriceValue(tradeSite, results);
	// validatePlotArea(tradeSite, results);
	// validateGrz(tradeSite, results);
	// validateGfz(tradeSite, results);
	// validateCommercializationType(tradeSite, results);
	// validateUtilizationTradeSite(tradeSite, results);
	// validateMinDivisible(tradeSite, results);
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
	// protected void validatePriceValue(TradeSite tradeSite,
	// List<ValidationError> results) {
	// // If there's no price value OR "on application" is true,
	// // price is set to 0 -> on application,
	// // hence, only the value range is validated
	// if (tradeSite.getPrice() != null && (tradeSite.getPrice().getValue() < 0
	// || tradeSite.getPrice().getValue() > 9999999999999.99)) {
	// createAndAddValidationError(tradeSite.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldPriceValueTradeSite") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validatePlotArea(TradeSite tradeSite,
	// List<ValidationError> results) {
	// String externalId = tradeSite.getExternalId();
	// if (tradeSite.getPlotArea() == null) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldPlotArea") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// } else if (tradeSite.getPlotArea() < 0 || tradeSite.getPlotArea() >
	// 99999999.99) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldPlotArea") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// // Salesforce validating differs from the IS24 one here
	// protected void validateGrz(TradeSite tradeSite, List<ValidationError>
	// results) {
	// if (tradeSite.getGrz() != null && (tradeSite.getGrz() < 0 ||
	// tradeSite.getGrz() > 9.99)) {
	// createAndAddValidationError(tradeSite.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldGRZ") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateGfz(TradeSite tradeSite, List<ValidationError>
	// results) {
	// if (tradeSite.getGfz() != null && (tradeSite.getGfz() < 0 ||
	// tradeSite.getGfz() > 9.99)) {
	// createAndAddValidationError(tradeSite.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldGFZ") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// protected void validateCommercializationType(TradeSite tradeSite,
	// List<ValidationError> results) {
	// if (tradeSite.getCommercializationType() == null) {
	// createAndAddValidationError(tradeSite.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldCommercializationTypeSites") + " - " +
	// Messages.getString("MessageValueNotSet"),
	// results);
	// } else if (tradeSite.getCommercializationType() ==
	// CommercializationType.LEASEHOLD && tradeSite.getTenancy() == null) {
	// // API expects a value for Tenancy if
	// // CommercializationType is LEASEHOLD
	// createAndAddValidationError(tradeSite.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldTenancy") + " - " +
	// Messages.getString("MessageMissingTenancy"), results);
	// }
	// }
	//
	// protected void validateUtilizationTradeSite(TradeSite tradeSite,
	// List<ValidationError> results) {
	// if (tradeSite.getUtilizationTradeSite() == null) {
	// createAndAddValidationError(tradeSite.getExternalId(), getOfferName() +
	// " / " + Messages.getString("FieldUtilizationTradeSite") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validateMinDivisible(TradeSite tradeSite,
	// List<ValidationError> results) {
	// String externalId = tradeSite.getExternalId();
	// Double valValue = tradeSite.getMinDivisible();
	// if (valValue != null && (valValue < 1 || valValue > 99999999.99)) {
	// createAndAddValidationError(externalId, getOfferName() + " / " +
	// Messages.getString("FieldMinDivisible") + " - " +
	// Messages.getString("MessageOutOfRange"), results);
	// }
	// }
	//
	// @Override
	// protected String getOfferName() {
	// return Messages.getString("TypeTradeSite");
	// }
}
