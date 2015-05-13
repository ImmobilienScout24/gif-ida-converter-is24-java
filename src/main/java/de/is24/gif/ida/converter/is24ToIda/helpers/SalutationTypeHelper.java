package de.is24.gif.ida.converter.is24ToIda.helpers;

import java.util.HashMap;
import java.util.Map;

import de.immobilienscout24.rest.schema.common._1.SalutationType;

/**
 * @author Martin Fluegge
 * 
 */
public class SalutationTypeHelper extends TypeMapHelper<SalutationType, String> {

	private final static Map<SalutationType, String> MAP = new HashMap<SalutationType, String>();

	{
		MAP.put(SalutationType.COMPANY, "Firma");
		MAP.put(SalutationType.MALE, "Herr");
		MAP.put(SalutationType.FEMALE, "Frau");
		MAP.put(SalutationType.NO_SALUTATION, "Kein Angabe");
	}

	public SalutationTypeHelper() {
		super(MAP);
	}
}
