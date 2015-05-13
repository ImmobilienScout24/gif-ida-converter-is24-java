package de.is24.gif.ida.converter.is24ToIda.helpers;

import java.util.HashMap;
import java.util.Map;

import de.immobilienscout24.rest.schema.common._1.RealEstateState;

/**
 * @author Martin Fluegge
 * 
 */
public class RealestateStateHelper extends TypeMapHelper<RealEstateState, String> {

	private final static Map<RealEstateState, String> MAP = new HashMap<RealEstateState, String>() {
		{
			put(RealEstateState.ACTIVE, "Aktiv");
			put(RealEstateState.ARCHIVED, "Archiviert");
			put(RealEstateState.DRAFT, "In Vorbereitung");
			put(RealEstateState.INACTIVE, "Inaktiv");
			// not mapped in MM
			put(RealEstateState.TO_BE_DELETED, null);
		}
	};

	public RealestateStateHelper() {
		super(MAP);
	}
}
