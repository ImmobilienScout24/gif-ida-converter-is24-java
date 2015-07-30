package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.node.entity.Property;

import de.immobilienscout24.rest.schema.offer.realestates._1.Store;

/**
 * @author Martin Fluegge
 */

public class StoreTransformer extends CommercialTransformer<Store> {

	@Override
	protected Property doTransform(Store a, ITransformContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	// protected StoreTypeHelper storeTypeHelper = new StoreTypeHelper();
	// protected LocationClassificationTypeHelper
	// locationClassificationTypeHelper = new
	// LocationClassificationTypeHelper();
	// protected SupplyTypeHelper supplyTypeHelper = new SupplyTypeHelper();
	//
	// @Override
	// protected Ch__Angebot__c doTransform(Store store, ITransformContext
	// context) {
	//
	// Ch__Angebot__c angebot = new Ch__Angebot__c();
	// updateRealestateGenericFields(store, (SalesforceTransformContext)
	// context, angebot);
	//
	// CommercialFacade facade =
	// DuckType.coerce(store).to(CommercialFacade.class);
	// updateCommercialFields(facade, angebot);
	//
	// angebot.setCh__Objektart__c(storeTypeHelper.getSalesforceValue(store.getStoreType()));
	// angebot.setCh__Schaufensterfront_in_m__c(store.getShopWindowLength());
	// angebot.setCh__Denkmalschutzobjekt__c(OptionalTypeHelper.boolValue(store.getListed()));
	// angebot.setCh__Lastenaufzug__c(OptionalTypeHelper.boolValue(store.getGoodsLift()));
	// angebot.setCh__Tragkraft_Lastenaufzug_in_kg__c(store.getGoodsLiftLoad());
	// angebot.setCh__Deckenlast__c(store.getFloorLoad());
	// angebot.setCh__Rampe__c(OptionalTypeHelper.boolValue(store.getRamp()));
	// angebot.setCh__Keller__c(OptionalTypeHelper.boolValue(store.getCellar()));
	// angebot.setCh__Zulieferung__c(supplyTypeHelper.getSalesforceValue(store.getSupplyType()));
	// angebot.setCh__Bodenbelag__c(flooringTypeHelper.getSalesforceValue(store.getFlooringType()));
	// angebot.setCh__Verkaufsflaeche_teilbar_ab__c(store.getMinDivisible());
	// angebot.setCh__Verkaufsflaeche_in_m2__c(store.getNetFloorSpace());
	// angebot.setCh__Lageart__c(locationClassificationTypeHelper.getSalesforceValue(store.getLocationClassificationType()));
	//
	// return angebot;
	// }
	//
	// @Override
	// protected String getImmotypeName(Store store) {
	// return "Gewerbe - Einzelhandel";
	// }
}
