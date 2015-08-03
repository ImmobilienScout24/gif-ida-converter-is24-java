package de.is24.gif.ida.converter.is24ToIda;

import de.immobilienscout24.rest.schema.offer.realestates._1.ApartmentRent;
import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

/**
 * Created by AStaeck on 03.08.2015.
 */
public class ApartmentRent2PropertyTransformer extends Apartment2PropertyTransformer<ApartmentRent> {
    @Override
    protected Property doTransform(ApartmentRent apartmentRent, ITransformContext context) {
        Property property = new Property();

        super.doTransform(apartmentRent,property,context);

        return property;
    }
}
