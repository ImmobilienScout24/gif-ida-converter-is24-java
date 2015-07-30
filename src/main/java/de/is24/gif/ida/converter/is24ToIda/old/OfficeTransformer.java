package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.Office;

/**
 * @author Martin Fluegge
 */

public class OfficeTransformer extends CommercialTransformer<Office> {

	@Override
	protected Property doTransform(Office a, ITransformContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	// protected OfficeTypeHelper officeTypeHelper = new OfficeTypeHelper();
	// protected ItInfrastructureTypeHelper itInfrastructureTypeHelper = new
	// ItInfrastructureTypeHelper();
	// protected AirConditioningTypeHelper airConditioningTypeHelper = new
	// AirConditioningTypeHelper();
	// protected OfficeRentDurationHelper officeRentDurationHelper = new
	// OfficeRentDurationHelper();
	//
	// @Override
	// protected Ch__Angebot__c doTransform(Office office, ITransformContext
	// context) {
	//
	// Ch__Angebot__c angebot = new Ch__Angebot__c();
	// updateRealestateGenericFields(office, (SalesforceTransformContext)
	// context, angebot);
	//
	// CommercialFacade facade =
	// DuckType.coerce(office).to(CommercialFacade.class);
	// updateCommercialFields(facade, angebot);
	//
	// angebot.setCh__Objektart__c(officeTypeHelper.getSalesforceValue(office.getOfficeType()));
	// angebot.setCh__Keller__c(OptionalTypeHelper.boolValue(office.getCellar()));
	// angebot.setCh__Barrierefrei__c(OptionalTypeHelper.boolValue(office.getHandicappedAccessible()));
	// angebot.setCh__Bodenbelag__c(flooringTypeHelper.getSalesforceValue(office.getFlooringType()));
	// angebot.setCh__Kantine_Cafeteria__c(OptionalTypeHelper.boolValue(office.getHasCanteen()));
	// angebot.setCh__Starkstrom__c(OptionalTypeHelper.boolValue(office.getHighVoltage()));
	// angebot.setCh__Kueche_vorhanden__c(OptionalTypeHelper.boolValue(office.getKitchenComplete()));
	// angebot.setCh__Denkmalschutzobjekt__c(OptionalTypeHelper.boolValue(office.getListed()));
	// angebot.setCh__Buero_Praxisflaeche_teilbar_ab_in_m__c(office.getMinDivisible());
	// angebot.setCh__Buero_Praxisflaeche_in_m2__c(office.getNetFloorSpace());
	// angebot.setCh__DV_Verkabelung_vorhanden__c(itInfrastructureTypeHelper.getSalesforceValue(office.getLanCables()));
	// angebot.setCh__Klimaanlage__c(airConditioningTypeHelper.getSalesforceValue(office.getAirConditioning()));
	//
	// OfficeRentDurations durations = office.getOfficeRentDurations();
	// if (durations != null) {
	// Collection<String> getSalesforceValues =
	// officeRentDurationHelper.getSalesforceValues(durations.getOfficeRentDuration());
	// angebot.setCh__Mietdauer_MSP__c(StringUtils.join(getSalesforceValues,
	// ";"));
	// }
	//
	// return angebot;
	// }
	//
	// @Override
	// protected String getImmotypeName(Office office) {
	// return "Gewerbe - Büro / Praxis";
	// }
}
