package de.is24.gif.ida.converter.is24ToIda.helpers;

import de.immobilienscout24.rest.schema.common._1.EnergyCertificateCreationDate;


/**
 * @author Martin Fluegge
 * 
 */
public class EnergyCertificateCreationDateHelper extends TypeMapHelper<EnergyCertificateCreationDate, String> {

	public static final String BIS_30_APRIL_2014_EN_EV_2009 = "Bis 30. April 2014 (EnEV 2009)";
	public static final String AB_01_MAI_2014_EN_EV_2014 = "Ab 01. Mai 2014 (EnEV 2014)";

	@Override
	protected void fillMap() {

		reverseMap.put(EnergyCertificateCreationDate.NOT_APPLICABLE, "");
		reverseMap.put(EnergyCertificateCreationDate.BEFORE_01_MAY_2014, BIS_30_APRIL_2014_EN_EV_2009);
		reverseMap.put(EnergyCertificateCreationDate.FROM_01_MAY_2014, AB_01_MAI_2014_EN_EV_2014);
	}
}
