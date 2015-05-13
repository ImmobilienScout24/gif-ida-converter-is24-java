package de.is24.gif.ida.converter.is24ToIda.helpers;

import java.util.HashMap;
import java.util.Map;

import de.immobilienscout24.rest.schema.common._1.YesNotApplicableType;

/**
 * @author Martin Fluegge
 * 
 */
public class YesNotApplicableBooleanTypeHelper extends TypeMapHelper<YesNotApplicableType, Boolean> {

	private final static Map<YesNotApplicableType, Boolean> MAP = new HashMap<YesNotApplicableType, Boolean>() {
		{
			put(YesNotApplicableType.YES, true);
			put(YesNotApplicableType.NOT_APPLICABLE, false);
		}
	};

	public YesNotApplicableBooleanTypeHelper() {
		super(MAP);
	}
}
