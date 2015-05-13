package de.is24.gif.ida.converter.is24ToIda.helpers;

import java.util.HashSet;
import java.util.Set;

import de.immobilienscout24.rest.schema.offer.realestates._1.CompulsoryAuction;
import de.immobilienscout24.rest.schema.offer.realestates._1.FlatShareRoom;
import de.immobilienscout24.rest.schema.offer.realestates._1.HouseBuy;
import de.immobilienscout24.rest.schema.offer.realestates._1.HouseRent;
import de.immobilienscout24.rest.schema.offer.realestates._1.Investment;
import de.immobilienscout24.rest.schema.offer.realestates._1.LivingBuySite;
import de.immobilienscout24.rest.schema.offer.realestates._1.LivingRentSite;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.immobilienscout24.rest.schema.offer.realestates._1.ShortTermAccommodation;
import de.immobilienscout24.rest.schema.offer.realestates._1.SpecialPurpose;

/**
 * @author Martin Fluegge
 * 
 */
public class RealestateHelper {

	public static RealestateHelper instance = new RealestateHelper();
	private final Set<Class<?>> residentials = new HashSet<Class<?>>();
	private final Set<Class<?>> mixed = new HashSet<Class<?>>();

	private RealestateHelper() {
		residentials.add(LivingBuySite.class);
		residentials.add(LivingRentSite.class);
		residentials.add(HouseRent.class);
		residentials.add(HouseBuy.class);
		residentials.add(ShortTermAccommodation.class);
		residentials.add(FlatShareRoom.class);
		residentials.add(LivingBuySite.class);

		mixed.add(SpecialPurpose.class);
		mixed.add(Investment.class);
		mixed.add(CompulsoryAuction.class);
	}

	public boolean isLiving(RealEstate realestate) {
		return residentials.contains(realestate.getClass());
	}

	public boolean isMixed(RealEstate realestate) {
		return mixed.contains(realestate.getClass());
	}
}
