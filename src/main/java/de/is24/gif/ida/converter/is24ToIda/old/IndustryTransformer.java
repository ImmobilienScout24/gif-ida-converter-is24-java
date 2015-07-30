package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.Industry;

/**
 * 
 * @author Martin Fluegge
 * 
 */

public class IndustryTransformer extends CommercialTransformer<Industry> {

	@Override
	protected Property doTransform(Industry a, ITransformContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	// protected IndustryTypeHelper industryTypeHelper = new
	// IndustryTypeHelper();
	//
	// @Override
	// protected Ch__Angebot__c doTransform(Industry industry, ITransformContext
	// context) {
	//
	// Ch__Angebot__c angebot = new Ch__Angebot__c();
	// updateRealestateGenericFields(industry, (SalesforceTransformContext)
	// context, angebot);
	//
	// CommercialFacade facade =
	// DuckType.coerce(industry).to(CommercialFacade.class);
	// updateCommercialFields(facade, angebot);
	//
	// angebot.setCh__Objektart__c(industryTypeHelper.getSalesforceValue(industry.getIndustryType()));
	// angebot.setCh__Grundstuecksflaeche_ca_in_m2__c(industry.getPlotArea());
	// angebot.setCh__Hallen_Geschosshoehe_in_m__c(industry.getHallHeight());
	// angebot.setCh__Bodenbelag__c(flooringTypeHelper.getSalesforceValue(industry.getFlooringType()));
	// angebot.setCh__Rampe__c(OptionalTypeHelper.boolValue(industry.getRamp()));
	// angebot.setCh__Hebebuehne__c(OptionalTypeHelper.boolValue(industry.getAutoLift()));
	// angebot.setCh__Lastenaufzug__c(OptionalTypeHelper.boolValue(industry.getGoodsLift()));
	// angebot.setCh__Tragkraft_Lastenaufzug_in_kg__c(industry.getGoodsLiftLoad());
	// angebot.setCh__Kranbahn__c(OptionalTypeHelper.boolValue(industry.getCraneRunway()));
	// angebot.setCh__Kranbahn_Traglast_in_Tonnen__c(industry.getCraneRunwayLoad());
	// angebot.setCh__Bodenbelastung_in_kg_m2__c(industry.getFloorLoad());
	// angebot.setCh__Stromanschlusswert_kVA__c(OptionalTypeHelper.doubleValue(industry.getConnectedLoad()));
	// angebot.setCh__Prod_Lagerflaeche_teilbar_ab_m2__c(industry.getMinDivisible());
	// angebot.setCh__Produktions_Lagerflaeche_in_m2__c(industry.getNetFloorSpace());
	//
	// return angebot;
	// }
	//
	// @Override
	// protected String getImmotypeName(Industry industry) {
	// return "Gewerbe - Halle / Produktion";
	// }
}
