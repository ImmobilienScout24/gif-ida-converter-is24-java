package de.is24.gif.ida.converter.examples;

import org.junit.Assert;
import org.junit.Test;
import org.zgif.converter.sdk.MapperValidationException;
import org.zgif.model.subset_4_1.entity.Unit;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageRent;
import de.is24.gif.ida.converter.is24ToIda.GarageRent2UnitTransformer;
import de.is24.gif.ida.converter.marshall.MarshallHelper;

/**
 * @author Martin Fluegge
 * 
 */
public class GarageRentMappingTest {

	@Test
	public void testMapping() throws MapperValidationException {

		GarageRent garage = new GarageRent();

		garage.setTitle("My great garage");

		GarageRent2UnitTransformer garageRent2UnitTransformer = new GarageRent2UnitTransformer();

		Unit unit = garageRent2UnitTransformer.transform(garage, null);

		Assert.assertEquals(garage.getTitle(), unit.getTitleOfExposee());

		System.out.println(MarshallHelper.doMarshall(unit));

	}
}
