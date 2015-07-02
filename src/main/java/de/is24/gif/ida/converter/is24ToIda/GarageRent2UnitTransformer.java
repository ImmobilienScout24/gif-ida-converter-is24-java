package de.is24.gif.ida.converter.is24ToIda;

import generated.Unit;

import org.zgif.converter.sdk.ITransformContext;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageRent;

/**
 * @author Martin Fluegge
 * 
 */
public class GarageRent2UnitTransformer extends Garage2UnitTransformer<GarageRent> {

	@Override
	protected Unit doTransform(GarageRent garageRent, ITransformContext context) {

		Unit unit = new Unit();
		super.doTransform(garageRent, unit, context);

		unit.setTitleOfExposee(garageRent.getTitle());

		return unit;
	}
}
