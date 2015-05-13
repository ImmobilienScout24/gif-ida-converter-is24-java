package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.FlooringType;


/**
 * @author Martin Fluegge
 * 
 */
public class FlooringTypeHelper extends TypeMapHelper<FlooringType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(FlooringType.NO_INFORMATION, "");
		reverseMap.put(FlooringType.CONCRETE, "Beton");
		reverseMap.put(FlooringType.EPOXY_RESIN, "Epoxidharzboden");
		reverseMap.put(FlooringType.TILES, "Fliesen");
		reverseMap.put(FlooringType.PLANKS, "Dielen");
		reverseMap.put(FlooringType.LAMINATE, "Laminat");
		reverseMap.put(FlooringType.PARQUET, "Parkett");
		reverseMap.put(FlooringType.PVC, "PVC");
		reverseMap.put(FlooringType.CARPET, "Teppichboden");
		reverseMap.put(FlooringType.ANTISTATIC_FLOOR, "Antistatischer Teppichboden");
		reverseMap.put(FlooringType.OFFICE_CARPET, "Stuhlrollenfeste Teppichfliesen");
		reverseMap.put(FlooringType.STONE, "Stein");
		reverseMap.put(FlooringType.CUSTOMIZABLE, "Nach Mieterwunsch");
		reverseMap.put(FlooringType.WITHOUT, "Ohne Bodenbelag");
	}
}
