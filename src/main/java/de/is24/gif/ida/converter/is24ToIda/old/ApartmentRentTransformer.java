package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;

import de.immobilienscout24.rest.facades.offer.realestates._1.ApartmentFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.ApartmentRent;

/**
 * 
 * @author Martin Fluegge
 * 
 */

public class ApartmentRentTransformer extends ApartmentTransformer<ApartmentRent> {

	@Override
	public Ch__Angebot__c doTransform(ApartmentRent apartmentRent, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(apartmentRent, (SalesforceTransformContext) context, angebot);

		ApartmentFacade facade = DuckType.coerce(apartmentRent).to(ApartmentFacade.class);
		updateApartmentFields(facade, angebot);

		angebot.setCh__WG_geeignet__c(yesNotApplicableBooleanTypeHelper.getSalesforceValue(apartmentRent.getUseAsFlatshareRoom()));
		angebot.setCh__Kaltmiete__c(apartmentRent.getBaseRent());
		angebot.setCh__Warmmiete__c(apartmentRent.getTotalRent());
		angebot.setCh__Nebenkosten__c(apartmentRent.getServiceCharge());
		angebot.setCh__Kaution_Genossenschaftsanteile__c(apartmentRent.getDeposit());
		angebot.setCh__Heizkosten_Heizung_Warmwasser__c(apartmentRent.getHeatingCosts());
		angebot.setCh__Heizkosten_in_Nebenkosten_enthalten__c(yesNoNotApplicableTypeHelper.getSalesforceValue(apartmentRent.getHeatingCostsInServiceCharge()));
		angebot.setCh__Haustiere__c(petsAllowedTypeHelper.getSalesforceValue(apartmentRent.getPetsAllowed()));
		angebot.setCh__Garage_Stellplatz_Miete__c(apartmentRent.getParkingSpacePrice());

		return angebot;
	}

	@Override
	protected String getImmotypeName(ApartmentRent realestate) {
		return "Miete - Wohnung";
	}
}
