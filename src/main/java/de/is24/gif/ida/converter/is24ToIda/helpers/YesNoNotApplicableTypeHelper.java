package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.YesNoNotApplicableType;


/**
 * @author Martin Fluegge
 * 
 */
public class YesNoNotApplicableTypeHelper extends TypeMapHelper<YesNoNotApplicableType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(YesNoNotApplicableType.YES, "Ja");
		reverseMap.put(YesNoNotApplicableType.NO, "Nein");
		reverseMap.put(YesNoNotApplicableType.NOT_APPLICABLE, "");
	}
}
