package de.is24.gif.ida.converter.idaToIs24;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.subset_4_1.entity.Unit;

import de.immobilienscout24.rest.facades.offer.realestates._1.GarageFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.facade.DuckType;
import de.is24.gif.ida.converter.is24ToIda.helpers.GarageTypeHelper;

/**
 * @author Martin Fluegge
 */
public abstract class Unit2GarageTransformer<T extends Unit, A extends RealEstate> extends Unit2RealestateTransformer<Unit, A> {

	protected GarageTypeHelper garageTypeHelper = new GarageTypeHelper();

	protected void doTransform(Unit unit, RealEstate garage, ITransformContext context) {

		super.doTransform(unit, garage, context);

		GarageFacade facade = DuckType.coerce(garage).to(GarageFacade.class);

		// unit.setCh__Flaeche_ca_in_m2__c(facade.getUsableFloorSpace());
		// unit.setCh__Laenge_in_m__c(facade.getLengthGarage());
		// unit.setCh__Breite_in_m__c(facade.getWidthGarage());
		// unit.setCh__Hoehe_in_m__c(facade.getHeightGarage());
		// unit.setCh__Letzte_Modernisierung_Sanierung__c(OptionalTypeHelper.stringValue(facade.getLastRefurbishment()));
		// unit.setCh__Objektart__c(garageTypeHelper.getSalesforceValue(facade.getGarageType()));
		// unit.setCh__Objektzustand__c(conditionHelper.getSalesforceValue(facade.getCondition()));
	}
}
