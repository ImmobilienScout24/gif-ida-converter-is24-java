package de.is24.gif.ida.converter.is24ToIda;

import de.immobilienscout24.rest.facades.offer.realestates._1.ApartmentFacade;
import de.immobilienscout24.rest.facades.offer.realestates._1.GarageFacade;
import de.immobilienscout24.rest.schema.common._1.RealEstateCondition;
import de.immobilienscout24.rest.schema.offer.realestates._1.RealEstate;
import de.is24.gif.ida.converter.facade.DuckType;
import org.zgif.converter.sdk.ITransformContext;
import org.zgif.model.datatype.enumeration.ApartmentType;
import org.zgif.model.datatype.enumeration.ObjectCondition;
import org.zgif.model.node.entity.Property;
import org.zgif.model.node.entity.Unit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AStaeck on 03.08.2015.
 */
public abstract class Apartment2PropertyTransformer <T extends RealEstate> extends Realestate2PropertyTransformer<T> {

    private Map<de.immobilienscout24.rest.schema.common._1.ApartmentType,ApartmentType> apartmentTypeMapping = new HashMap<de.immobilienscout24.rest.schema.common._1.ApartmentType, ApartmentType>();
    private Map<de.immobilienscout24.rest.schema.common._1.RealEstateCondition,ObjectCondition> conditionMapping = new HashMap<de.immobilienscout24.rest.schema.common._1.RealEstateCondition, ObjectCondition>();


    public Apartment2PropertyTransformer() {
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.APARTMENT,ApartmentType.APARTMENT);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.ROOF_STOREY,ApartmentType.ROOF_STOREY);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.LOFT,ApartmentType.LOFT);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.MAISONETTE,ApartmentType.MAISONETTE);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.PENTHOUSE,ApartmentType.PENTHOUSE);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.TERRACED_FLAT,ApartmentType.TERRACED_FLAT);
        apartmentTypeMapping.put(de.immobilienscout24.rest.schema.common._1.ApartmentType.GROUND_FLOOR,ApartmentType.GROUND_FLAT);
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
    }

    protected void doTransform(RealEstate garage, Property property, ITransformContext context) {

        super.doTransform(garage, property, context);
        ApartmentFacade facade = DuckType.coerce(garage).to(ApartmentFacade.class);

        de.immobilienscout24.rest.schema.common._1.ApartmentType apartmentType = facade.getApartmentType();

        ApartmentType apartmentType1 = apartmentTypeMapping.get(apartmentType);
        Unit unit= property.getUnits().getUnit().get(0);
        unit.setApartmentType(apartmentType1);


//TODO        facade.getCellar()  //?
        ObjectCondition objectCondition = conditionMapping.get(facade.getCondition());
        property.setCondition(objectCondition);
    }
}
