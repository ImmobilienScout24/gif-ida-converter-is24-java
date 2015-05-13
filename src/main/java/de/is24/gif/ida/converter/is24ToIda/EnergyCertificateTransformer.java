package de.is24.gif.ida.converter.is24ToIda;

import java.util.Collection;
import java.util.logging.Logger;

import de.immobilienscout24.rest.facades.offer.realestates._1.EnergyCertificateFacade;
import de.immobilienscout24.rest.schema.common._1.BuildingEnergyRatingType;
import de.immobilienscout24.rest.schema.common._1.EnergyCertificateAvailability;
import de.immobilienscout24.rest.schema.common._1.EnergyCertificateCreationDate;
import de.immobilienscout24.rest.schema.common._1.EnergyPerformanceCertificate;
import de.immobilienscout24.rest.schema.common._1.EnergySourcesEnev2014;
import de.immobilienscout24.rest.schema.common._1.HeatingTypeEnev2014;
import de.immobilienscout24.rest.schema.common._1.RealEstateState;
import de.immobilienscout24.rest.schema.common._1.YesNotApplicableType;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.is24ToIda.helpers.EnergyCertificateAvailabilityHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.EnergyCertificateCreationDateHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.EnergySourceEnev2014Helper;
import de.is24.gif.ida.converter.is24ToIda.helpers.HeatingTypeEnev2014Helper;
import de.is24.gif.ida.converter.is24ToIda.helpers.OptionalTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.RealestateHelper;

public class EnergyCertificateTransformer {
	private static Logger LOG = Logger.getLogger(EnergyCertificateTransformer.class);

	private final EnergyCertificateAvailabilityHelper energyCertificateAvailabilityHelper = new EnergyCertificateAvailabilityHelper();
	protected EnergySourceEnev2014Helper energySourceEnev2014Helper = new EnergySourceEnev2014Helper();
	protected HeatingTypeEnev2014Helper heatingTypeEnev2014Helper = new HeatingTypeEnev2014Helper();

	public void updateEnergyCertificate(EnergyCertificateFacade facade, Ch__Angebot__c angebot) {

		preprocessEnevData(facade, angebot);

		updateEnergyPerformanceCertificate(facade, angebot);
		updateBuildingEnergyRatingType(facade, angebot);
		updateThermalCharacteristics(facade, angebot);
		updateEnergySourceEnev2014(facade, angebot);
		updateConstructionYear(facade, angebot);
		updateHeatingTypeEnev2014(facade, angebot);
		updateEnergyConsumptionContainsWarmWater(facade, angebot);
	}

	private void preprocessEnevData(EnergyCertificateFacade facade, Ch__Angebot__c angebot) {

		RealEstateState realEstateState = facade.get().getRealEstateState();

		if (RealEstateState.ARCHIVED.equals(realEstateState)) {

			EnergyPerformanceCertificate energyCertificate = facade.getEnergyCertificate();
			BuildingEnergyRatingType buildingEnergyRatingType = facade.getBuildingEnergyRatingType();
			if (energyCertificate != null && buildingEnergyRatingType != null && !BuildingEnergyRatingType.NO_INFORMATION.equals(buildingEnergyRatingType)) {
				// we assume that Enev data is available
				energyCertificate.setEnergyCertificateAvailability(EnergyCertificateAvailability.AVAILABLE);
				EnergyCertificateCreationDate energyCertificateCreationDate = energyCertificate.getEnergyCertificateCreationDate();

				if (energyCertificateCreationDate == null) {
					energyCertificate.setEnergyCertificateCreationDate(EnergyCertificateCreationDate.BEFORE_01_MAY_2014);
				}
			}
		}
	}

	protected void updateHeatingTypeEnev2014(EnergyCertificateFacade facade, Ch__Angebot__c angebot) {
		HeatingTypeEnev2014 heatingTypeEnev2014 = facade.getHeatingTypeEnev2014();
		angebot.setCh__Heizungsart__c(heatingTypeEnev2014Helper.getSalesforceValue(heatingTypeEnev2014));
	}

	private void updateConstructionYear(EnergyCertificateFacade facade, Ch__Angebot__c angebot) {
		angebot.setCh__Baujahr__c(OptionalTypeHelper.stringValue(facade.getConstructionYear()));
		// todo: bei ConstructionYearUnknown Feld leer überschreiben
		/*
		 * Boolean unknown = facade.getConstructionYearUnknown(); if (unknown !=
		 * null && unknown) { angebot.setCh__Baujahr__c(""); }
		 */
	}

	private void updateEnergySourceEnev2014(EnergyCertificateFacade facade, Ch__Angebot__c angebot) {
		EnergySourcesEnev2014 sources = facade.getEnergySourcesEnev2014();
		if (sources != null) {
			final Collection<String> mappedSources = energySourceEnev2014Helper.getSalesforceValues(sources.getEnergySourceEnev2014());
			angebot.setCh__Befeuerungsart__c(StringUtils.join(mappedSources, ";"));
		}
	}

	@SuppressWarnings("incomplete-switch")
	private void updateThermalCharacteristics(EnergyCertificateFacade facade, Ch__Angebot__c angebot) {

		EnergyPerformanceCertificate energyCertificate = facade.getEnergyCertificate();

		if (energyCertificate != null) {

			Double thermalCharacteristics = facade.getThermalCharacteristic();
			BuildingEnergyRatingType buildingEnergyRatingType = facade.getBuildingEnergyRatingType();
			if (thermalCharacteristics != null && buildingEnergyRatingType != null) {
				switch (buildingEnergyRatingType) {
				case ENERGY_CONSUMPTION: {
					EnergyCertificateCreationDate energyCertificateCreationDate = energyCertificate.getEnergyCertificateCreationDate();
					if (energyCertificateCreationDate != null) {

						switch (energyCertificateCreationDate) {
						case BEFORE_01_MAY_2014:
							angebot.setCh__Energieverbrauchskennwert_kWh_m_a__c(thermalCharacteristics);
							break;
						case FROM_01_MAY_2014:
							angebot.setCh__Endenergieverbrauch_kWh_m_a__c(thermalCharacteristics);
							break;
						case NOT_APPLICABLE:
							break;
						default:
							break;
						}
					}
					break;

				}
				case ENERGY_REQUIRED: {
					angebot.setCh__Endenergiebedarf_kWh_m_a__c(thermalCharacteristics);
					break;
				}
				}
			}
		}
	}

	private void updateEnergyPerformanceCertificate(EnergyCertificateFacade facade, Ch__Angebot__c angebot) {
		EnergyPerformanceCertificate energyCertificate = facade.getEnergyCertificate();

		// We fill all fields that are delivered by is24 API although some
		// fields are not relevant for some real estate types.
		// We trust is24 API to only deliver relevant values and null otherwise.
		if (energyCertificate != null) {
			angebot.setCh__Stromverbrauchskennwert__c(energyCertificate.getElectricityConsumption());
			angebot.setCh__Energieausweis_Status__c(energyCertificateAvailabilityHelper.getSalesforceValue(energyCertificate.getEnergyCertificateAvailability()));
			angebot.setCh__Endenergieverbrauch_Strom_kWh_m_a__c(energyCertificate.getEnergyConsumptionElectricity());
			angebot.setCh__Endenergieverbrauch_Waerme_kwh_m_a__c(energyCertificate.getEnergyConsumptionHeating());
			angebot.setCh__Energieeffizienzklasse__c(energyCertificate.getEnergyEfficiencyClass());
			angebot.setCh__Heizenergieverbrauchskennwert__c(energyCertificate.getHeatingConsumption());
			angebot.setCh__Endenergiebedarf_Strom_kWh_m_a__c(energyCertificate.getThermalCharacteristicElectricity());
			angebot.setCh__Endenergiebedarf_Waerme_kWh_m_a__c(energyCertificate.getThermalCharacteristicHeating());

			updateEnergyCertificateCreationDate(angebot, facade.get(), energyCertificate);
		}
	}

	private void updateEnergyCertificateCreationDate(Ch__Angebot__c angebot, RealEstate realestate, EnergyPerformanceCertificate energyCertificate) {
		EnergyCertificateCreationDate energyCertificateCreationDate = energyCertificate.getEnergyCertificateCreationDate();

		if (energyCertificateCreationDate != null) {

			LOG.info("updating updateEnergyCertificateCreationDate for " + realestate.getId() + " " + energyCertificateCreationDate);

			if (EnergyCertificateCreationDate.BEFORE_01_MAY_2014.equals(energyCertificateCreationDate)) {
				angebot.setCh__Erstellungsdatum_Energieausweis__c(EnergyCertificateCreationDateHelper.BIS_30_APRIL_2014_EN_EV_2009);

				LOG.info("Set creation date to 'Bis 30. April 2014 (EnEV 2009)' for" + angebot.getCh__Anbieter_Objekt_Id__c());

				if (RealestateHelper.instance.isLiving(realestate)) {
					angebot.setCh__Energieverbrauch_Warmwasser_Is_Null__c(true);
				}

			} else if (EnergyCertificateCreationDate.FROM_01_MAY_2014.equals(energyCertificateCreationDate)) {
				angebot.setCh__Erstellungsdatum_Energieausweis__c(EnergyCertificateCreationDateHelper.AB_01_MAI_2014_EN_EV_2014);
				LOG.info("Set creation date to 'Ab 01. Mai 2014 (EnEV 2014)' for" + angebot.getCh__Anbieter_Objekt_Id__c());
			} else {
				LOG.warn("No valid creation date for" + angebot.getCh__Anbieter_Objekt_Id__c());
			}

			if (RealestateHelper.instance.isMixed(realestate)) {
				angebot.setCh__Energieverbrauch_Warmwasser_Is_Null__c(true);
			}
		}
	}

	protected void updateBuildingEnergyRatingType(EnergyCertificateFacade facade, Ch__Angebot__c angebot) {
		BuildingEnergyRatingType buildingEnergyRateType = facade.getBuildingEnergyRatingType();

		if (buildingEnergyRateType != null) {
			String name = "";

			if (buildingEnergyRateType.equals(BuildingEnergyRatingType.ENERGY_CONSUMPTION)) {
				name = "Verbrauchsausweis";
			} else if (buildingEnergyRateType.equals(BuildingEnergyRatingType.ENERGY_REQUIRED)) {
				name = "Bedarfsausweis";
			}
			angebot.setCh__Energieausweistyp__c(name);
		}
	}

	public void updateEnergyConsumptionContainsWarmWater(EnergyCertificateFacade facade, Ch__Angebot__c angebot) {
		YesNotApplicableType value = facade.getEnergyConsumptionContainsWarmWater();
		angebot.setCh__Energieverbrauch_Warmwasser_enthalten__c(OptionalTypeHelper.boolValue(value));
	}

}
