package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

/**
 * @author Rene Boettge
 * 
 */
public class Is24ApiContactValidator extends AbstractAddressValidator {

	@Override
	public List validate(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public List<ValidationError> validate(Object o) {
	// List<ValidationError> results = new ArrayList<ValidationError>();
	// Is24ApiContact contact = (Is24ApiContact) o;
	//
	//
	// validateEmail(contact, results);
	// validateLastname(contact, results);
	// validatePhoneNumber(contact, results);
	// validateCellPhoneNumber(contact, results);
	// validateFaxPhoneNumber(contact, results);
	// validateAddress(contact.getAddress(), contact.getExternalId(),
	// getTypeName(), results, false);
	//
	// return results;
	// }
	//
	// protected void validateEmail(Is24ApiContact contact,
	// List<ValidationError> results) {
	//
	// if (Tools.isNullOrEmpty(contact.getEmail())) {
	// createAndAddValidationError(contact.getExternalId(), getTypeName() +
	// " / " + Messages.getString("FieldEmail") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validateLastname(Is24ApiContact contact,
	// List<ValidationError> results) {
	//
	// if (Tools.isNullOrEmpty(contact.getLastname())) {
	// createAndAddValidationError(contact.getExternalId(), getTypeName() +
	// " / " + Messages.getString("FieldLastname") + " - " +
	// Messages.getString("MessageValueNotSet"), results);
	// }
	// }
	//
	// protected void validatePhoneNumber(Is24ApiContact contact,
	// List<ValidationError> results) {
	// try {
	// String phoneNumber = contact.getPhoneNumber();
	//
	// if (isInvalidNumber(contact, results, phoneNumber)) {
	// createAndAddValidationError(contact.getExternalId(), getTypeName() +
	// " / " + Messages.getString("FieldPhoneNumber") + " - " +
	// Messages.getString("MessageInvalidFormat"), results);
	// }
	//
	// } catch (NumberParseException e) {
	// createAndAddValidationError(contact.getExternalId(), getTypeName() +
	// " / " + Messages.getString("FieldPhoneNumber") + " - " +
	// Messages.getString("MessageInvalidFormat"), results);
	// }
	// }
	//
	// protected void validateCellPhoneNumber(Is24ApiContact contact,
	// List<ValidationError> results) {
	// try {
	// String cellPhoneNumber = contact.getCellPhoneNumber();
	//
	// if (isInvalidNumber(contact, results, cellPhoneNumber)) {
	// createAndAddValidationError(contact.getExternalId(), getTypeName() +
	// " / " + Messages.getString("FieldCellPhoneNumber") + " - " +
	// Messages.getString("MessageInvalidFormat"), results);
	// }
	// } catch (NumberParseException e) {
	// createAndAddValidationError(contact.getExternalId(), getTypeName() +
	// " / " + Messages.getString("FieldCellPhoneNumber") + " - " +
	// Messages.getString("MessageInvalidFormat"), results);
	// }
	// }
	//
	// protected void validateFaxPhoneNumber(Is24ApiContact contact,
	// List<ValidationError> results) {
	// try {
	// String faxNumber = contact.getFaxNumber();
	//
	// if (isInvalidNumber(contact, results, faxNumber)) {
	// createAndAddValidationError(contact.getExternalId(), getTypeName() +
	// " / " + Messages.getString("FieldFaxPhoneNumber") + " - " +
	// Messages.getString("MessageInvalidFormat"), results);
	// }
	// } catch (NumberParseException e) {
	// createAndAddValidationError(contact.getExternalId(), getTypeName() +
	// " / " + Messages.getString("FieldFaxPhoneNumber") + " - " +
	// Messages.getString("MessageInvalidFormat"), results);
	// }
	// }
	//
	// protected String getTypeName() {
	// return Messages.getString("TypeIs24Contact");
	// }
	//
	// private boolean isInvalidNumber(Is24ApiContact contact,
	// List<ValidationError> results, String phoneNumber) {
	//
	// if (phoneNumber != null) {
	// // String regexp =
	// // "(\\+[1-9]\\d{0,3})+\\s{0,1}\\d{1,10} +([\\d][\\d \\-]{0,24}[\\d])";
	// String regexp =
	// "(\\+[1-9]\\d{0,3}) +(\\d{1,10}) +([\\d][\\d]{0,20}[\\d])";
	//
	// Pattern p = Pattern.compile(regexp);
	// Matcher m = p.matcher(phoneNumber);
	//
	// return !m.find();
	// }
	// return false;
	// }
}
