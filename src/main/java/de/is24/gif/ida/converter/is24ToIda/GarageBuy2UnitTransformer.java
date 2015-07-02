package de.is24.gif.ida.converter.is24ToIda;

import generated.Unit;

import org.zgif.converter.sdk.ITransformContext;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageBuy;

/**
 * @author Martin Fluegge
 * 
 */
public class GarageBuy2UnitTransformer extends Garage2UnitTransformer<GarageBuy> {

	@Override
	protected Unit doTransform(GarageBuy garageBuy, ITransformContext context) {

		Unit unit = new Unit();

		super.doTransform(garageBuy, unit, context);

		unit.setTitleOfExposee(garageBuy.getTitle());

		return unit;
	}
}
