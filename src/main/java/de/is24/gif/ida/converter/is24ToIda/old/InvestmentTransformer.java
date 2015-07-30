package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.Investment;
import de.is24.gif.ida.converter.is24ToIda.Realestate2PropertyTransformer;

/**
 * @author Martin Fluegge
 */

public class InvestmentTransformer extends Realestate2PropertyTransformer<Investment> {

	@Override
	protected Property doTransform(Investment a, ITransformContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	// protected InvestmentTypeHelper investmentTypeHelper = new
	// InvestmentTypeHelper();
	//
	// @Override
	// protected String getImmotypeName(Investment investment) {
	// return "Anlage - Anlageimmobilie";
	// }
	//
	// @Override
	// protected Ch__Angebot__c doTransform(Investment investment,
	// ITransformContext context) {
	//
	// Ch__Angebot__c angebot = new Ch__Angebot__c();
	// updateRealestateGenericFields(investment, (SalesforceTransformContext)
	// context, angebot);
	//
	// angebot.setCh__Kaufpreis__c(OptionalTypeHelper.priceValue(investment.getPrice()));
	// angebot.setCh__Kaufpreis_pro_m2__c(OptionalTypeHelper.priceValue(investment.getPricePerSQM()));
	// angebot.setCh__Gewerbeflaeche_ca_in_m2__c(investment.getIndustrialArea());
	// angebot.setCh__Grundstuecksflaeche_in_m2__c(investment.getPlotArea());
	// angebot.setCh__Vermietbare_Flaeche_ca_in_m2__c(investment.getNetFloorSpace());
	// angebot.setCh__Gesamtflaeche_ca_in_m2__c(investment.getTotalFloorSpace());
	// angebot.setCh__Wohnflaeche_ca_in_m2__c(investment.getLivingSpace());
	// angebot.setCh__Kaufpreis__c(OptionalTypeHelper.priceValue(investment.getPrice()));
	// angebot.setCh__x_fache_Miete__c(investment.getPriceMultiplier());
	// angebot.setCh__Mieteinnahmen_pa_Ist__c(OptionalTypeHelper.priceValue(investment.getRentalIncomeActual()));
	// angebot.setCh__Mieteinnahmen_pa_Soll__c(OptionalTypeHelper.priceValue(investment.getRentalIncomeTarget()));
	// angebot.setCh__Nicht_umgelegte_Kosten__c(OptionalTypeHelper.priceValue(investment.getOtherCosts()));
	// angebot.setCh__Denkmalschutzobjekt__c(OptionalTypeHelper.boolValue(investment.getListed()));
	// angebot.setCh__Personenaufzug__c(OptionalTypeHelper.boolValue(investment.getLift()));
	// angebot.setCh__Anzahl_der_Parkflaechen__c(OptionalTypeHelper.doubleValue(investment.getNumberOfParkingSpaces()));
	// angebot.setCh__Preis_pro_Parkflaeche__c(investment.getParkingSpacePrice());
	// angebot.setCh__Sonstige_Flaeche_ca_in_m2__c(investment.getAdditionalArea());
	// angebot.setCh__Etagen__c(investment.getNumberOfFloors());
	// angebot.setCh__Betriebskosten_umgelegt__c(OptionalTypeHelper.priceValue(investment.getAdditionalCosts()));
	// angebot.setCh__Fahrzeit_naechster_Hbf_in_min__c(OptionalTypeHelper.doubleValue(investment.getDistanceToMRS()));
	// angebot.setCh__Fahrzeit_naechster_Flughafen_in_min__c(OptionalTypeHelper.doubleValue(investment.getDistanceToAirport()));
	// angebot.setCh__Fahrzeit_naechste_BAB_in_min__c(OptionalTypeHelper.doubleValue(investment.getDistanceToFM()));
	// angebot.setCh__Fussweg_zu_OPNV_in_min__c(OptionalTypeHelper.doubleValue(investment.getDistanceToPT()));
	// angebot.setCh__Objektart__c(investmentTypeHelper.getSalesforceValue(investment.getInvestmentType()));
	// angebot.setCh__Objektzustand__c(conditionHelper.getSalesforceValue(investment.getCondition()));
	// angebot.setCh__Letzte_Modernisierung_Sanierung__c(OptionalTypeHelper.stringValue(investment.getLastRefurbishment()));
	// angebot.setCh__Qualitaet_der_Ausstattung__c(interiorQualityHelper.getSalesforceValue(investment.getInteriorQuality()));
	//
	// return angebot;
	// }
}
