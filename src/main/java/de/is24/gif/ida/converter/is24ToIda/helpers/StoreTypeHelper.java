package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.StoreType;


/**
 * @author Martin Fluegge
 * 
 */
public class StoreTypeHelper extends TypeMapHelper<StoreType, String> {

	@Override
	protected void fillMap() {

		reverseMap.put(StoreType.SHOWROOM_SPACE, "Ausstellungsfläche");
		reverseMap.put(StoreType.SHOPPING_CENTRE, "Einkaufszentrum");
		reverseMap.put(StoreType.FACTORY_OUTLET, "Factory Outlet");
		reverseMap.put(StoreType.DEPARTMENT_STORE, "Kaufhaus");
		reverseMap.put(StoreType.KIOSK, "Kiosk");
		reverseMap.put(StoreType.STORE, "Laden");
		reverseMap.put(StoreType.SELF_SERVICE_MARKET, "SB-Markt");
		reverseMap.put(StoreType.SALES_AREA, "Verkaufsfläche");
		reverseMap.put(StoreType.SALES_HALL, "Verkaufshalle");
	}
}
