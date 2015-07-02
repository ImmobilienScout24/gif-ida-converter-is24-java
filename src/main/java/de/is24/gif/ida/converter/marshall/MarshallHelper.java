package de.is24.gif.ida.converter.marshall;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author Martin Fluegge
 * 
 */
public class MarshallHelper {

	public static String doMarshall(Object o) {

		try {

			JAXBContext contextIs24 = JAXBContext.newInstance(o.getClass());
			// JAXBContext contextIs24 =
			// JAXBContext.newInstance(IS24ApiOffer.class);
			Marshaller is24Marshaller = contextIs24.createMarshaller();
			is24Marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// is24Marshaller.setProperty(Marshaller.JAXB_FRAGMENT,
			// Boolean.FALSE);

			StringWriter writer = new StringWriter();

			is24Marshaller.marshal(o, writer);
			return writer.toString();

		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	public Object unmarshall(String o) {

		// // TODO vorbehandlung: finde heraus welches Objekt instanziiert
		// werden
		// // muss
		// Class<?> objectClass = IS24ApiOffer.class;
		// try {
		// JAXBContext context = JAXBContext.newInstance(objectClass);
		// Unmarshaller unmarshaller = context.createUnmarshaller();
		//
		// StringReader reader = new StringReader(o);
		//
		// return (IOffer) unmarshaller.unmarshal(reader);
		// } catch (JAXBException e) {
		// throw new RuntimeException(e);
		// }
		return null;
	}
}
