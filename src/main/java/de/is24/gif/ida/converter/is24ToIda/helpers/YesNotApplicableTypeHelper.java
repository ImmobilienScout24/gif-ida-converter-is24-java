package de.is24.gif.ida.converter.is24ToIda.helpers;

import java.util.HashMap;
import java.util.Map;

import de.immobilienscout24.rest.schema.common._1.YesNotApplicableType;

/**
 * @author Martin Fluegge
 * 
 */
public class YesNotApplicableTypeHelper extends TypeMapHelper<YesNotApplicableType, String> {

	private final static Map<YesNotApplicableType, String> MAP = new HashMap<YesNotApplicableType, String>() {
		{
			put(YesNotApplicableType.YES, "Ja");
			put(YesNotApplicableType.NOT_APPLICABLE, "");
		}
	};

	public YesNotApplicableTypeHelper() {
		super(MAP);
	}
}
