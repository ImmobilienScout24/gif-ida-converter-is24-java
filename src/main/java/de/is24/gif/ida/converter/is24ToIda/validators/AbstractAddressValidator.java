package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.List;

import org.zgif.converter.sdk.ValidationError;

import de.immobilienscout24.rest.schema.common._1.Address;

/**
 * @author Martin Fluegge
 * 
 */
public abstract class AbstractAddressValidator extends Validator {

	protected void validateAddress(Address address, String objectId, String objectName, List<ValidationError> results, boolean isMandatory) {

		if (address == null) {
			createAndAddValidationError(objectId,
					objectName + " / " + Messages.getString("FieldAddress") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			// Not mandatory on international offers AND SITES
			if (isMandatory && (address.getHouseNumber() == null || address.getHouseNumber().length() == 0)) {
				createAndAddValidationError(objectId,
						objectName + " / " + Messages.getString("FieldHouseNumber") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
			}
			// Not mandatory on international offers
			if (isMandatory && (address.getStreet() == null || address.getStreet().length() == 0)) {
				createAndAddValidationError(objectId,
						objectName + " / " + Messages.getString("FieldStreet") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (isMandatory && (address.getCity() == null || address.getCity().length() == 0)) {
				createAndAddValidationError(objectId,
						objectName + " / " + Messages.getString("FieldCity") + " - " + Messages.getString("MessageValueNotSet"), results); //$NON-NLS-1$ //$NON-NLS-2$
			}
			// Not mandatory on international offers
			if (isMandatory && (address.getPostcode() == null || address.getPostcode().length() == 0)) {
				createAndAddValidationError(objectId,
						objectName + " / " + Messages.getString("FieldPostcode") + " - " + Messages.getString("MessageValueNotSet"), results);
			}
		}
	}

	protected void validateAddress(Address address, String objectId, String objectName, List<ValidationError> results) {

		validateAddress(address, objectId, objectName, results, true);
	}
}
