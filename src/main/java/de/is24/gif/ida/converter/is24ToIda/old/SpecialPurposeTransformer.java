package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.SpecialPurpose;

/**
 * 
 * @author Martin Fluegge
 * 
 */

public class SpecialPurposeTransformer extends CommercialTransformer<SpecialPurpose> {

	@Override
	protected Property doTransform(SpecialPurpose a, ITransformContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	// protected SpecialPurposeTypeHelper specialPurposeTypeHelper = new
	// SpecialPurposeTypeHelper();
	//
	// @Override
	// protected Ch__Angebot__c doTransform(SpecialPurpose specialPurpose,
	// ITransformContext context) {
	//
	// Ch__Angebot__c angebot = new Ch__Angebot__c();
	// updateRealestateGenericFields(specialPurpose,
	// (SalesforceTransformContext) context, angebot);
	//
	// CommercialFacade facade =
	// DuckType.coerce(specialPurpose).to(CommercialFacade.class);
	// updateCommercialFields(facade, angebot);
	//
	// angebot.setCh__Objektart__c(specialPurposeTypeHelper.getSalesforceValue(specialPurpose.getSpecialPurposePropertyType()));
	// angebot.setCh__Grundstuecksflaeche_in_m2__c(specialPurpose.getPlotArea());
	// angebot.setCh__Denkmalschutzobjekt__c(OptionalTypeHelper.boolValue(specialPurpose.getListed()));
	// angebot.setCh__Keller__c(OptionalTypeHelper.boolValue(specialPurpose.getBasement()));
	// angebot.setCh__Bodenbelag__c(flooringTypeHelper.getSalesforceValue(specialPurpose.getFlooringType()));
	// angebot.setCh__Hauptflaeche_teilbar_ab_in_m2__c(specialPurpose.getMinDivisible());
	// angebot.setCh__Hauptflaeche_in_m2__c(specialPurpose.getNetFloorSpace());
	//
	// return angebot;
	// }
	//
	// @Override
	// protected String getImmotypeName(SpecialPurpose realestate) {
	// return "Gewerbe - Spezialgewerbe";
	// }
}
