package de.is24.gif.ida.converter.is24ToIda;

import generated.Unit;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.converter.sdk.impl.Validator;

import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.tbd.BasicTransformer;

/**
 * @author Martin Fluegge
 */
public abstract class Realestate2UnitTransformer<T extends RealEstate> extends BasicTransformer<T, Unit> {

	public Realestate2UnitTransformer() {
		// this(new RealestateValidator());
	}

	public Realestate2UnitTransformer(Validator validator) {
		super();
		setValidator(validator);
	}

	protected void doTransform(RealEstate realeste, Unit unit, ITransformContext context) {
		// salesforce automatically puts this value into anbieterObjektId , too
		// if we set field name here salesforce will break during upsert!
		// unit.setName(realestate.getExternalId());
		//
		// unit.setCh__Ueberschrift_Ihrer_Anzeige__c(realestate.getTitle());
		// unit.setCh__Adresse_vollstaendig_anzeigen__c(realestate.isShowAddress());
		// unit.setCh__Objektbeschreibung__c(realestate.getDescriptionNote());
		// unit.setCh__Ausstattung__c(realestate.getFurnishingNote());
		// unit.setCh__Lage__c(realestate.getLocationNote());
		// unit.setCh__Sonstiges__c(realestate.getOtherNote());
		// unit.setCh__Gruppennummer__c(OptionalTypeHelper.doubleValue(realestate.getGroupNumber()));
		// unit.setCh__Status__c(realestateStateHelper.getSalesforceValue(realestate.getRealEstateState()));

		// updateSetImmoType(realestate, unit, context);
		// updateCountry(realestate, unit, context);
		//
		// // Currently disabled API searchfield as it is too small at
		// salesforce
		// // updateApiSearchData(realestate, angebot);
		// updateAddress(realestate, unit);
		// updateContact(realestate, unit);
		//
		// if (realestate instanceof CompulsoryAuction == false) {
		// updateCourtage(realestate, unit);
		// }
		//
		// if (new
		// DuckType(realestate).quacksLikeA(EnergyCertificateFacade.class)) {
		// energyCertificateTransformer.updateEnergyCertificate(DuckType.coerce(realestate).to(EnergyCertificateFacade.class),
		// unit);
		// }
	}

	// private void updateCountry(T realestate, Ch__Angebot__c angebot,
	// SalesforceTransformContext context) {
	//
	// Wgs84Address address = realestate.getAddress();
	//
	// if (address != null) {
	// CountryRegion internationalCountryRegion =
	// address.getInternationalCountryRegion();
	//
	// if (internationalCountryRegion != null) {
	//
	// CountryCode country = internationalCountryRegion.getCountry();
	// if (country != null) {
	//
	// angebot.setCh__Land__c(new
	// Countries().getCountryNameByCode(country.name()));
	// }
	// angebot.setCh__Auslandsregion__c(internationalCountryRegion.getRegion());
	// }
	// }
	// }
	//
	// private void updateContact(T realestate, Ch__Angebot__c angebot) {
	// de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate.Contact
	// realestateContact = realestate.getContact();
	// if (realestateContact != null) {
	// String id = realestateContact.getId().toString();
	//
	// LOG.info("Setting contact with id " + id + " to offer " +
	// angebot.getName());
	//
	// Contact contact = new Contact();
	//
	// contact.setCh__KontaktHash__c(id);
	// angebot.setCh__Kontakt__r(contact);
	// }
	// }
	//
	// public void updateCourtage(T realestate, Ch__Angebot__c angebot) {
	// RealestateFacade facade =
	// DuckType.coerce(realestate).to(RealestateFacade.class);
	//
	// CourtageInfo courtage = facade.getCourtage();
	// if (courtage != null) {
	// angebot.setCh__Provisionshoehe__c(courtage.getCourtage());
	// angebot.setCh__ProvisionshinweisExt__c(courtage.getCourtageNote());
	//
	// angebot.setCh__Provision__c(yesNoNotApplicableTypeHelper.getSalesforceValue(courtage.getHasCourtage()));
	// }
	// }
	//
	// private void updateSetImmoType(T realestate, Ch__Angebot__c angebot,
	// SalesforceTransformContext context) {
	// String immotypeName = getImmotypeName(realestate);
	// String recordTypeId =
	// context.getRecordTypeMappingAngebot().get(immotypeName);
	//
	// if (recordTypeId == null) {
	// throw new RuntimeException("RecordTypeId not found " + immotypeName);
	// }
	//
	// angebot.setRecordTypeId(recordTypeId);
	// }
	//
	// public void updateAddress(RealEstate realestate, Ch__Angebot__c angebot)
	// {
	// Wgs84Address address = realestate.getAddress();
	//
	// if (address != null) {
	// angebot.setCh__Hausnummer__c(address.getHouseNumber());
	// angebot.setCh__Strasse__c(address.getStreet());
	// angebot.setCh__Postleitzahl__c(address.getPostcode());
	// angebot.setCh__Ort__c(address.getCity());
	// }
	// }
	//
	// public final boolean isAbroad(T realestate) {
	// Wgs84Address address = realestate.getAddress();
	//
	// if (address != null && address.getGeoHierarchy() != null) {
	// String fullGeoCodeId =
	// address.getGeoHierarchy().getCountry().getFullGeoCodeId();
	// return !("1276".equals(fullGeoCodeId) || fullGeoCodeId == null ||
	// fullGeoCodeId.isEmpty());
	//
	// } else {
	// return false;
	// }
	// }
	//
	// public void updateApiSearchData(RealEstate realestate, Ch__Angebot__c
	// angebot) {
	// ApiSearchData apiSearchData = realestate.getApiSearchData();
	//
	// if (apiSearchData != null) {
	// angebot.setCh__API_Suchfeld_1__c(apiSearchData.getSearchField1());
	// angebot.setCh__API_Suchfeld_2__c(apiSearchData.getSearchField2());
	// angebot.setCh__API_Suchfeld_3__c(apiSearchData.getSearchField3());
	// }
	// }
}
