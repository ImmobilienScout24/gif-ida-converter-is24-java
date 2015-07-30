package de.is24.gif.ida.converter.is24ToIda;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageRent;

/**
 * @author Martin Fluegge
 * 
 */
public class GarageRent2PropertyTransformer extends Garage2UnitTransformer<GarageRent> {

	@Override
	protected Property doTransform(GarageRent garageRent, ITransformContext context) {

		Property property = new Property();
		super.doTransform(garageRent, property, context);

		property.setTitleOfExposee(garageRent.getTitle());

		return property;
	}
}
