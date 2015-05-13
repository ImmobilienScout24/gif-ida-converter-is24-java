package de.is24.gif.ida.converter.is24ToIda;

import de.gifev.ida.converter.sdk.ITransformContext;
import de.immobilienscout24.rest.facades.offer.realestates._1.HouseFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.HouseRent;

/**
 * @author Martin Fluegge
 * 
 */
public class HouseRentTransformer extends HouseTransformer<HouseRent> {
	@Override
	protected Ch__Angebot__c doTransform(HouseRent houseRent, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(houseRent, (SalesforceTransformContext) context, angebot);

		HouseFacade facade = DuckType.coerce(houseRent).to(HouseFacade.class);
		updateHouseFields(facade, angebot);

		angebot.setCh__WG_geeignet__c(yesNotApplicableBooleanTypeHelper.getSalesforceValue(houseRent.getUseAsFlatshareRoom()));
		angebot.setCh__Kaltmiete__c(houseRent.getBaseRent());
		angebot.setCh__Warmmiete__c(houseRent.getTotalRent());
		angebot.setCh__Nebenkosten__c(houseRent.getServiceCharge());
		angebot.setCh__Kaution_Genossenschaftsanteile__c(houseRent.getDeposit());
		angebot.setCh__Heizkosten_Heizung_Warmwasser__c(houseRent.getHeatingCosts());
		angebot.setCh__Heizkosten_in_Nebenkosten_enthalten__c(yesNoNotApplicableTypeHelper.getSalesforceValue(houseRent.getHeatingCostsInServiceCharge()));
		angebot.setCh__Haustiere__c(petsAllowedTypeHelper.getSalesforceValue(houseRent.getPetsAllowed()));
		angebot.setCh__Einbaukueche__c(houseRent.isBuiltInKitchen());
		angebot.setCh__Verfuegbar_ab__c(houseRent.getFreeFrom());
		angebot.setCh__Garage_Stellplatz_Miete__c(houseRent.getParkingSpacePrice());

		return angebot;
	}

	@Override
	protected String getImmotypeName(HouseRent realestate) {
		return "Miete - Haus";
	}
}
