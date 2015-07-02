package de.is24.gif.ida.converter.is24ToIda.old;

import org.zgif.converter.sdk.ITransformContext;

import de.immobilienscout24.rest.schema.common._1.CountyCourt;
import de.immobilienscout24.rest.schema.offer.realestates._1.CompulsoryAuction;
import de.is24.gif.ida.converter.is24ToIda.helpers.CompulsoryAuctionTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;

/**
 * @author Martin Fluegge
 */

public class CompulsoryAuctionTransformer extends RealestateTransformer<CompulsoryAuction> {

	protected CompulsoryAuctionTypeHelper compulsoryAuctionTypeHelper = new CompulsoryAuctionTypeHelper();

	@Override
	protected Ch__Angebot__c doTransform(CompulsoryAuction compulsoryAuction, ITransformContext context) {

		Ch__Angebot__c angebot = new Ch__Angebot__c();
		updateRealestateGenericFields(compulsoryAuction, (SalesforceTransformContext) context, angebot);

		angebot.setCh__Preis__c(OptionalTypeHelper.priceValue(compulsoryAuction.getMarketValue()));
		angebot.setCh__Wiederholungstermin__c(compulsoryAuction.isRecurrenceAppointment());
		angebot.setCh__Termin_der_Versteigerung__c(OptionalTypeHelper.toGregorian(compulsoryAuction.getDateOfAuction()));
		angebot.setCh__Aenderungsdatum__c(OptionalTypeHelper.toGregorian(compulsoryAuction.getLastChangeDate()));
		angebot.setCh__Aufhebungsdatum__c(OptionalTypeHelper.toGregorian(compulsoryAuction.getCancellationDate()));
		angebot.setCh__Erfassungsdatum__c(OptionalTypeHelper.toGregorian(compulsoryAuction.getRecordationDate()));
		angebot.setCh__Gesamtflaeche_in_m2__c(compulsoryAuction.getArea());
		angebot.setCh__Objektart__c(compulsoryAuctionTypeHelper.getSalesforceValue(compulsoryAuction.getAuctionObjectType()));
		angebot.setCh__Aktenzeichennummer_des_Amtsgerichts__c(compulsoryAuction.getFileReferenceAtCountyCourt());
		angebot.setCh__Grundbuch_BlattNr__c(compulsoryAuction.getNumberOfFolio());
		angebot.setCh__Teilungsversteigerung__c(compulsoryAuction.isSplittingAuction());

		CountyCourt countyCourt = compulsoryAuction.getCountyCourt();
		if (countyCourt != null) {
			angebot.setCh__Name_des_Amtgerichts__c(countyCourt.getName());
			angebot.setCh__Telefonnummer_des_Amtsgerichts__c(countyCourt.getCourtNumber());
		}

		// No LowestBit in SF
		// No Owner, as we need a qualified contact

		return angebot;
	}

	@Override
	protected String getImmotypeName(CompulsoryAuction compulsoryAuction) {
		return "Zwangsversteigerung";
	}
}
