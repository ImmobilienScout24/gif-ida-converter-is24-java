package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;

import de.immobilienscout24.rest.facades.offer.realestates._1.GarageFacade;
import de.immobilienscout24.rest.schema.offer.realestates._1.GarageBuy;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

/**
 * @author Martin Fluegge
 * 
 */
public class GarageBuyTransformer extends Garage2UnitTransformer<GarageBuy> {

	@Override
	protected Ch__Angebot__c doTransform(GarageBuy garageBuy, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(garageBuy, (SalesforceTransformContext) context, angebot);

		GarageFacade facade = DuckType.coerce(garageBuy).to(GarageFacade.class);
		updateGarageFields(facade, angebot);

		angebot.setCh__Kaufpreis__c(OptionalTypeHelper.priceValue(garageBuy.getPrice()));

		return angebot;
	}

	@Override
	protected String getImmotypeName(GarageBuy realestate) {
		return "Kauf - Garage / Stellplatz";
	}
}
