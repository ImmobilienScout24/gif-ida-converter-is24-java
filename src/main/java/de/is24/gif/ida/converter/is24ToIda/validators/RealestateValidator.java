package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.ArrayList;
import java.util.List;

import org.zgif.converter.sdk.ValidationError;
import org.zgif.converter.sdk.impl.Validator;

import de.immobilienscout24.rest.facades.offer.realestates._1.EnergyCertificateFacade;
import de.immobilienscout24.rest.schema.common._1.BuildingEnergyRatingType;
import de.immobilienscout24.rest.schema.common._1.CourtageInfo;
import de.immobilienscout24.rest.schema.common._1.EnergyCertificateCreationDate;
import de.immobilienscout24.rest.schema.common._1.EnergyPerformanceCertificate;
import de.immobilienscout24.rest.schema.common._1.YesNoNotApplicableType;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;

/**
 * @author Martin Fluegge
 * 
 */
public class RealestateValidator extends Validator {

	@Override
	public List<ValidationError> validate(Object o) {

		final RealEstate realEstate = (RealEstate) o;
		List<ValidationError> results = new ArrayList<ValidationError>();

		validateExternalId(realEstate, results);
		validateCourtageIfNeeded(realEstate, results);
		validateEnEVDataIfNeeded(realEstate, results);
		validateAddress(realEstate, results);

		return results;
	}

	private void validateExternalId(RealEstate realEstate, List<ValidationError> results) {
		String externalId = realEstate.getExternalId();
		if (externalId != null) {
			String scoutId = realEstate.getId() + "";
			if (externalId.startsWith(" ")) {
				createAndAddValidationError(scoutId, "Die ObjektNr.(>>" + externalId + "<<) darf nicht mit einem Leerzeichen beginnen. "
						+ getExposeUrl(scoutId), results);
			} else if (externalId.endsWith(" ")) {
				createAndAddValidationError(scoutId, "Die ObjektNr.(>>" + externalId + "<<) darf nicht mit einem Leerzeichen enden. " + getExposeUrl(scoutId),
						results);
			}
		}
	}

	private void validateAddress(RealEstate realEstate, List<ValidationError> results) {
		// Wgs84Address address = realEstate.getAddress();
		//
		// if (address != null) {
		// String houseNumber = address.getHouseNumber();
		//
		// if (houseNumber != null && !houseNumber.isEmpty()) {
		//
		// if (houseNumber.length() > 10) {
		// String scoutId = stringValue(realEstate.getId());
		// createAndAddValidationError(scoutId,
		// "Die Hausnummer der Addresse darf nicht mehr als 10 Zeichen enthalten. "
		// + getExposeUrl(scoutId),
		// results);
		// }
		// }
		// }
	}

	private void validateEnEVDataIfNeeded(RealEstate realEstate, List<ValidationError> results) {
		// if
		// (!RealEstateState.ARCHIVED.equals(realEstate.getRealEstateState())) {
		// if (new
		// DuckType(realEstate).quacksLikeA(EnergyCertificateFacade.class)) {
		// EnergyCertificateFacade energyFacade =
		// DuckType.coerce(realEstate).to(EnergyCertificateFacade.class);
		// validateEnEVData(energyFacade, stringValue(realEstate.getId()),
		// results);
		// }
		// }

	}

	private void validateEnEVData(EnergyCertificateFacade energyFacade, String scoutId, List<ValidationError> results) {
		EnergyPerformanceCertificate energyCertificate = energyFacade.getEnergyCertificate();

		BuildingEnergyRatingType bert = energyFacade.getBuildingEnergyRatingType();
		boolean bertWasSet = bert != null && !bert.equals(BuildingEnergyRatingType.NO_INFORMATION);

		if (energyCertificate != null && bertWasSet) {
			EnergyCertificateCreationDate creationDate = energyCertificate.getEnergyCertificateCreationDate();
			if (creationDate == null || EnergyCertificateCreationDate.NOT_APPLICABLE.equals(creationDate)) {
				createAndAddValidationError(scoutId, "Das Feld 'Erstellungsdatum Energieausweis' muss gesetzt werden. " + getExposeUrl(scoutId), results);
			}
		}
	}

	private String getExposeUrl(String scoutId) {

		return "http://www.immobilienscout24.de/expose/" + scoutId;
	}

	private void validateCourtageIfNeeded(RealEstate realEstate, List<ValidationError> results) {
		// if (new DuckType(realEstate).quacksLikeA(RealestateFacade.class)) {
		// RealestateFacade facade =
		// DuckType.coerce(realEstate).to(RealestateFacade.class);
		// CourtageInfo courtage = facade.getCourtage();
		// String scoutId = stringValue(realEstate.getId());
		//
		// if (courtage != null) {
		// validateCourtage(courtage, scoutId, results);
		// }
		// }
	}

	private void validateCourtage(CourtageInfo courtage, String scoutId, List<ValidationError> results) {
		YesNoNotApplicableType hasCourtage = courtage.getHasCourtage();

		if (!YesNoNotApplicableType.YES.equals(hasCourtage)) {
			String courtageString = courtage.getCourtage();
			if (courtageString != null && courtageString.length() > 0) {
				// TODO move this to message file
				createAndAddValidationError(scoutId, "Provisionshöhe darf nicht angegeben werden, wenn für Provision nicht 'Ja' gewählt wurde. "
						+ getExposeUrl(scoutId), results);
			}
		}

		String courtageValue = courtage.getCourtage();

		int maxCourtageLength = 50;
		if (courtageValue != null && courtageValue.length() > maxCourtageLength) {
			createAndAddValidationError(scoutId, "Provisionshöhe darf nicht mehr als " + maxCourtageLength + " Zeichen enthalten. " + getExposeUrl(scoutId),
					results);
		}
	}
}
