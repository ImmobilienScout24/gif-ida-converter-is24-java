package de.is24.gif.ida.converter.tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.zgif.converter.sdk.MapperValidationException;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageRent;
import de.is24.gif.ida.converter.is24ToIda.GarageRent2PropertyTransformer;
import de.is24.gif.ida.converter.marshall.MarshallHelper;

/**
 * @author Martin Fluegge
 * 
 */
public class GarageRentMappingTest {

	@Test
	@Ignore
	public void testMapping() throws MapperValidationException {

		GarageRent garage = new GarageRent();

		garage.setTitle("My great garage");

		GarageRent2PropertyTransformer garageRent2PropertyTransformer = new GarageRent2PropertyTransformer();

		Property property = garageRent2PropertyTransformer.transform(garage, null);

		Assert.assertEquals(garage.getTitle(), property.getTitleOfExposee());

		System.out.println(MarshallHelper.doMarshall(property));

	}
}
