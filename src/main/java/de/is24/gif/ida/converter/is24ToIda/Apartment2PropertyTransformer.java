package de.is24.gif.ida.converter.is24ToIda;

import de.immobilienscout24.rest.facades.offer.realestates._1.ApartmentFacade;
import de.immobilienscout24.rest.facades.offer.realestates._1.GarageFacade;
import de.immobilienscout24.rest.schema.common._1.*;
import de.immobilienscout24.rest.schema.common._1.ApartmentType;
import de.immobilienscout24.rest.schema.common._1.InteriorQuality;
import de.immobilienscout24.rest.schema.common._1.ParkingSpaceType;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.facade.DuckType;
import de.is24.gif.ida.converter.is24ToIda.helpers.BuildingEnergyTypeHelper;
import de.is24.gif.ida.converter.is24ToIda.helpers.FlooringTypeHelper;
import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.datatype.enumeration.*;
import org.zgif.model.datatype.enumeration.HeatingType;
import org.zgif.model.node.entity.Property;
import org.zgif.model.node.entity.Unit;
import org.zgif.model.node.group.EnergyRating;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AStaeck on 03.08.2015.
 */
public abstract class Apartment2PropertyTransformer <T extends RealEstate> extends Realestate2PropertyTransformer<T> {

    private Map<de.immobilienscout24.rest.schema.common._1.ApartmentType,ApartmentType> apartmentTypeMapping = new HashMap<de.immobilienscout24.rest.schema.common._1.ApartmentType, ApartmentType>();
    private Map<de.immobilienscout24.rest.schema.common._1.RealEstateCondition,ObjectCondition> conditionMapping = new HashMap<de.immobilienscout24.rest.schema.common._1.RealEstateCondition, ObjectCondition>();
    private Map<InteriorQuality, org.zgif.model.datatype.enumeration.InteriorQuality> interiorMapping = new HashMap<InteriorQuality, org.zgif.model.datatype.enumeration.InteriorQuality>();
    private Map<ParkingSpaceType, org.zgif.model.datatype.enumeration.ParkingSpaceType> parkingSpaceTypeMapping = new HashMap<ParkingSpaceType, org.zgif.model.datatype.enumeration.ParkingSpaceType>();
    private Map<BuildingEnergyRatingType, EnergyRatingType> buildingenergyRatingTypeMapping = new HashMap<BuildingEnergyRatingType, EnergyRatingType>();
    private Map<EnergySourceEnev2014, EnergySource> energySourceMapping = new HashMap<EnergySourceEnev2014, EnergySource>();
    private Map<HeatingTypeEnev2014, org.zgif.model.datatype.enumeration.HeatingType> heatingTypeMapping = new HashMap<HeatingTypeEnev2014, HeatingType>();

    public Apartment2PropertyTransformer() {
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.APARTMENT,ApartmentType.APARTMENT);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.ROOF_STOREY,ApartmentType.ROOF_STOREY);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.LOFT,ApartmentType.LOFT);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.MAISONETTE,ApartmentType.MAISONETTE);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.PENTHOUSE,ApartmentType.PENTHOUSE);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.TERRACED_FLAT,ApartmentType.TERRACED_FLAT);
        //apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.GROUND_FLOOR,ApartmentType.GROUND_FLAT);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.RAISED_GROUND_FLOOR,ApartmentType.RAISED_GROUND_FLOOR);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.HALF_BASEMENT,ApartmentType.HALF_BASEMENT);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.OTHER,ApartmentType.OTHER);

        conditionMapping.put(RealEstateCondition.FIRST_TIME_USE,ObjectCondition.NEW);
        conditionMapping.put(RealEstateCondition.FIRST_TIME_USE_AFTER_REFURBISHMENT,ObjectCondition.NEW);
        conditionMapping.put(RealEstateCondition.FULLY_RENOVATED,ObjectCondition.NEW);
        conditionMapping.put(RealEstateCondition.MODERNIZED,ObjectCondition.NEW);
        conditionMapping.put(RealEstateCondition.MINT_CONDITION,ObjectCondition.NEW);
        conditionMapping.put(RealEstateCondition.NEED_OF_RENOVATION,ObjectCondition.IN_NEED_OF_REPAIR);
        conditionMapping.put(RealEstateCondition.NEGOTIABLE,ObjectCondition.NOT_AVAILABLE);
        conditionMapping.put(RealEstateCondition.NO_INFORMATION,ObjectCondition.NOT_AVAILABLE);
        conditionMapping.put(RealEstateCondition.REFURBISHED,ObjectCondition.NEW);
        conditionMapping.put(RealEstateCondition.RIPE_FOR_DEMOLITION,ObjectCondition.IN_NEED_OF_REPAIR);
        conditionMapping.put(RealEstateCondition.FULLY_RENOVATED,ObjectCondition.NEW);
        conditionMapping.put(RealEstateCondition.WELL_KEPT,ObjectCondition.NEW);

        //TODO interiorMapping.put(InteriorQuality.NO_INFORMATION, NULL??);
        interiorMapping.put(InteriorQuality.LUXURY, org.zgif.model.datatype.enumeration.InteriorQuality.LUXURY);
        interiorMapping.put(InteriorQuality.NORMAL, org.zgif.model.datatype.enumeration.InteriorQuality.NORMAL);
        interiorMapping.put(InteriorQuality.SIMPLE, org.zgif.model.datatype.enumeration.InteriorQuality.SIMPLE);
        interiorMapping.put(InteriorQuality.SOPHISTICATED, org.zgif.model.datatype.enumeration.InteriorQuality.SOPHISTICATED);

        parkingSpaceTypeMapping.put(ParkingSpaceType.CAR_PARK, org.zgif.model.datatype.enumeration.ParkingSpaceType.CAR_PARK);
        parkingSpaceTypeMapping.put(ParkingSpaceType.CARPORT, org.zgif.model.datatype.enumeration.ParkingSpaceType.CARPORT);
        parkingSpaceTypeMapping.put(ParkingSpaceType.DUPLEX, org.zgif.model.datatype.enumeration.ParkingSpaceType.GARAGE);
        //TODO parkingSpaceTypeMapping.put(ParkingSpaceType.NO_INFORMATION, org.zgif.model.datatype.enumeration.ParkingSpaceType.NOT_AVAILABLE); ??
        parkingSpaceTypeMapping.put(ParkingSpaceType.GARAGE, org.zgif.model.datatype.enumeration.ParkingSpaceType.GARAGE);
        parkingSpaceTypeMapping.put(ParkingSpaceType.OUTSIDE, org.zgif.model.datatype.enumeration.ParkingSpaceType.OUTDOOR);
        parkingSpaceTypeMapping.put(ParkingSpaceType.UNDERGROUND_GARAGE, org.zgif.model.datatype.enumeration.ParkingSpaceType.UNDERGROUND);

        buildingenergyRatingTypeMapping.put(BuildingEnergyRatingType.ENERGY_CONSUMPTION, EnergyRatingType.USAGE_DEPENDING);
        buildingenergyRatingTypeMapping.put(BuildingEnergyRatingType.ENERGY_REQUIRED, EnergyRatingType.REQUIREMENTS_DEPENDING);
        //TODO buildingenergyRatingTypeMapping.put(BuildingEnergyRatingType.NO_INFORMATION, NULL??);

        energySourceMapping.put(EnergySourceEnev2014.ACID_GAS, EnergySource.GAS);
        energySourceMapping.put(EnergySourceEnev2014.BIO_ENERGY, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.COAL, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.COAL_COKE, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.COMBINED_HEAT_AND_POWER_BIO_ENERGY, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.COMBINED_HEAT_AND_POWER_FOSSIL_FUELS, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.COMBINED_HEAT_AND_POWER_REGENERATIVE_ENERGY, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.COMBINED_HEAT_AND_POWER_RENEWABLE_ENERGY, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.DISTRICT_HEATING, EnergySource.LOCAL_DISTRICT_HEATING);
        energySourceMapping.put(EnergySourceEnev2014.ELECTRICITY, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.ENVIRONMENTAL_THERMAL_ENERGY, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.GEOTHERMAL, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.GAS, EnergySource.GAS);
        energySourceMapping.put(EnergySourceEnev2014.LOCAL_HEATING, EnergySource.LOCAL_DISTRICT_HEATING);
        energySourceMapping.put(EnergySourceEnev2014.OIL, EnergySource.OIL);
        energySourceMapping.put(EnergySourceEnev2014.HEAT_SUPPLY, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.SOUR_GAS, EnergySource.GAS);
        energySourceMapping.put(EnergySourceEnev2014.WOOD_CHIPS, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.SOLAR_HEATING, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.WOOD, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.HYDRO_ENERGY, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.WIND_ENERGY, EnergySource.OTHER);
        //TODO energySourceMapping.put(EnergySourceEnev2014.NO_INFORMATION, NULL??);
        energySourceMapping.put(EnergySourceEnev2014.STEAM_DISTRICT_HEATING, EnergySource.LOCAL_DISTRICT_HEATING);
        energySourceMapping.put(EnergySourceEnev2014.PELLET_HEATING, EnergySource.OTHER);
        energySourceMapping.put(EnergySourceEnev2014.LIQUID_GAS, EnergySource.GAS);

        heatingTypeMapping.put(HeatingTypeEnev2014.CENTRAL_HEATING,HeatingType.CENTRAL_HEATING);
        heatingTypeMapping.put(HeatingTypeEnev2014.COMBINED_HEAT_AND_POWER_PLANT,HeatingType.OTHER);
        heatingTypeMapping.put(HeatingTypeEnev2014.DISTRICT_HEATING,HeatingType.OTHER);
        heatingTypeMapping.put(HeatingTypeEnev2014.ELECTRIC_HEATING,HeatingType.OTHER);
        heatingTypeMapping.put(HeatingTypeEnev2014.FLOOR_HEATING,HeatingType.OTHER);
        heatingTypeMapping.put(HeatingTypeEnev2014.GAS_HEATING,HeatingType.SINGLE_STORY_GAS_HEATING);
        heatingTypeMapping.put(HeatingTypeEnev2014.HEAT_PUMP,HeatingType.OTHER);
        heatingTypeMapping.put(HeatingTypeEnev2014.NIGHT_STORAGE_HEATER,HeatingType.OTHER);
        //TODO heatingTypeMapping.put(HeatingTypeEnev2014.NO_INFORMATION, NULL??);
        heatingTypeMapping.put(HeatingTypeEnev2014.OIL_HEATING,HeatingType.OTHER);
        heatingTypeMapping.put(HeatingTypeEnev2014.SELF_CONTAINED_CENTRAL_HEATING,HeatingType.OTHER);
        heatingTypeMapping.put(HeatingTypeEnev2014.SOLAR_HEATING,HeatingType.OTHER);
        heatingTypeMapping.put(HeatingTypeEnev2014.STOVE_HEATING,HeatingType.OTHER);
        heatingTypeMapping.put(HeatingTypeEnev2014.WOOD_PELLET_HEATING,HeatingType.OTHER);


    }

    protected void doTransform(RealEstate apartment, Property property, ITransformContext context) {

        super.doTransform(apartment, property, context);
        ApartmentFacade facade = DuckType.coerce(apartment).to(ApartmentFacade.class);

        de.immobilienscout24.rest.schema.common._1.ApartmentType apartmentType = facade.getApartmentType();

        ApartmentType apartmentType1 = apartmentTypeMapping.get(apartmentType);
        Unit unit= property.getUnits().getUnit().get(0);
      //  unit.setApartmentType(apartmentType1);

//TODO        facade.getCellar()  //?

        ObjectCondition objectCondition = conditionMapping.get(facade.getCondition());
        property.setCondition(objectCondition);

        org.zgif.model.datatype.enumeration.InteriorQuality interiorQuality = interiorMapping.get(facade.getInteriorQuality());
        property.setInteriorQuality(interiorQuality);

        org.zgif.model.datatype.enumeration.ParkingSpaceType parkingSpaceType = parkingSpaceTypeMapping.get(facade.getParkingSpaceType());
        unit.setParkingSpaceType(parkingSpaceType);

        EnergyRatingType energyRatingType = buildingenergyRatingTypeMapping.get(facade.getBuildingEnergyRatingType());
        //TODO property.setEnergyRatingType(energyRatingType); ??

        EnergySource energySource = energySourceMapping.get(facade.getEnergySourcesEnev2014());
        //TODO property.setEnergySource(energySource); ??
        //facade.getHeatingTypeEnev2014()
    }
}
