package de.is24.gif.ida.converter.is24ToIda.helpers;

import java.util.HashMap;
import java.util.Map;

import de.immobilienscout24.rest.schema.common._1.EnergyCertificateAvailability;


public class EnergyCertificateAvailabilityHelper extends TypeMapHelper<EnergyCertificateAvailability, String> {
	private final static Map<EnergyCertificateAvailability, String> MAP = new HashMap<EnergyCertificateAvailability, String>(){{
		put(EnergyCertificateAvailability.AVAILABLE, "Energieausweis liegt für das Gebäude vor"); 
		put(EnergyCertificateAvailability.NOT_AVAILABLE_YET, "Es liegt noch kein Energieausweis für das Gebäude vor");
		put(EnergyCertificateAvailability.NOT_REQUIRED, "Dieses Gebäude unterliegt nicht den Anforderungen der EnEV");
	}};

	public EnergyCertificateAvailabilityHelper() {
		super(MAP);
	}
}
