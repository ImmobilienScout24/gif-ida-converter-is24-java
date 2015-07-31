import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.zgif.converter.sdk.MapperValidationException;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.GarageBuy;
import de.is24.gif.ida.converter.is24ToIda.GarageBuy2PropertyTransformer;

/**
 * @author Martin Fluegge
 * 
 */
public class GarageBuy2PropertyTest {

	@Test
	@Ignore
	public void test() throws MapperValidationException {

		GarageBuy2PropertyTransformer transformer = new GarageBuy2PropertyTransformer();

		GarageBuy garageBuy = Is24ApiOfferGenerator.createGarageBuyTestObject();
		Property property = transformer.transform(garageBuy, null);

		Assert.assertEquals(property.getLabel(), garageBuy.getTitle());

	}
}
