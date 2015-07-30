package de.is24.gif.ida.converter.is24ToIda;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageBuy;

/**
 * @author Martin Fluegge
 * 
 */
public class GarageBuy2PropertyTransformer extends Garage2UnitTransformer<GarageBuy> {

	@Override
	protected Property doTransform(GarageBuy garageBuy, ITransformContext context) {

		Property property = new Property();

		super.doTransform(garageBuy, property, context);

		property.setTitleOfExposee(garageBuy.getTitle());

		return property;
	}
}
