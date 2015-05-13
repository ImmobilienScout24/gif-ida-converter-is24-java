package de.is24.gif.ida.converter.is24ToIda.helpers;

import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

import de.immobilienscout24.rest.schema.common._1.Price;
import de.immobilienscout24.rest.schema.common._1.YesNotApplicableType;

/**
 * 
 * @author Robert Will
 * 
 */
public final class OptionalTypeHelper {

	public static Double doubleValue(Integer integer) {
		return (integer != null) ? integer.doubleValue() : null;
	}

	public static String stringValue(Integer integer) {
		return (integer != null) ? integer.toString() : null;
	}

	public static String stringValue(Long integer) {
		return (integer != null) ? integer.toString() : null;
	}

	public static GregorianCalendar toGregorian(XMLGregorianCalendar value) {
		return value == null ? null : value.toGregorianCalendar();
	}

	public static boolean boolValue(YesNotApplicableType value) {
		return value == YesNotApplicableType.YES;
	}

	public static Double stringToDouble(String value) {
		return value == null ? null : Double.parseDouble(value);
	}

	public static String doubleString(Double value) {
		return (value != null) ? value.toString() : null;
	}

	public static Double priceValue(Price value) {
		return value == null ? null : value.getValue();
	}
}
