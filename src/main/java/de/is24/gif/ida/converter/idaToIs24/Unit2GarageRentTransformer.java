package de.is24.gif.ida.converter.idaToIs24;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageBuy;

/**
 * @author Martin Fluegge
 * 
 */
public class Unit2GarageRentTransformer extends Unit2GarageTransformer<Property, GarageBuy> {

	@Override
	protected GarageBuy doTransform(Property unit, ITransformContext context) {

		GarageBuy garageBuy = new GarageBuy();

		super.doTransform(unit, garageBuy, context);

		return garageBuy;
	}

	// @Override
	// protected GarageRent doTransform(Unit arg0, ITransformContext arg1) {
	// // TODO Auto-generated method stub
	// return null;
	// }
}
