package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.SiteConstructibleType;


/**
 * @author Martin Fluegge
 * 
 */
public class SiteConstructibleTypeHelper extends TypeMapHelper<SiteConstructibleType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(SiteConstructibleType.CONSTRUCTIONPLAN, "Bebauungsplan");
		reverseMap.put(SiteConstructibleType.NEIGHBOURCONSTRUCTION, "Wie Nachbarbebauung");
		reverseMap.put(SiteConstructibleType.EXTERNALAREA, "Außengebiet");
		reverseMap.put(SiteConstructibleType.NO_INFORMATION, "");
	}
}
