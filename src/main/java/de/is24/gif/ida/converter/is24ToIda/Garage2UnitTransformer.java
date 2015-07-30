package de.is24.gif.ida.converter.is24ToIda;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.facades.offer.realestates._1.GarageFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.facade.DuckType;
import de.is24.gif.ida.converter.is24ToIda.helpers.GarageTypeHelper;

/**
 * @author Martin Fluegge
 */
public abstract class Garage2UnitTransformer<T extends RealEstate> extends Realestate2PropertyTransformer<T> {

	protected GarageTypeHelper garageTypeHelper = new GarageTypeHelper();

	protected void doTransform(RealEstate garage, Property unit, ITransformContext context) {

		super.doTransform(garage, unit, context);

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
