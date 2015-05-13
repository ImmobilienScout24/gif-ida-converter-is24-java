package de.is24.gif.ida.converter.is24ToIda.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import de.is24.gif.ida.converter.utils.ReverseHashMap;

/**
 * @author Martin Fluegge
 * 
 *         See YesNotApplicableTypeHelper for the preferred way of using this
 *         class.
 * 
 */
public class TypeMapHelper<Is24Type, SalesforceType> {

	protected final ReverseHashMap<Is24Type, SalesforceType> reverseMap;

	@Deprecated
	public TypeMapHelper() {
		reverseMap = new ReverseHashMap<>();
		fillMap();
	}

	public TypeMapHelper(Map<Is24Type, SalesforceType> map) {
		this.reverseMap = new ReverseHashMap<>(map);
	}

	@Deprecated
	protected void fillMap() {
	};

	public synchronized Is24Type getIs24Value(SalesforceType salesforceValue) {
		return reverseMap.getKey(salesforceValue);
	}

	public synchronized SalesforceType getSalesforceValue(Is24Type scoutValue) {
		return reverseMap.getValue(scoutValue);
	}

	/**
	 * Applies sfValue() element-wise to a collection.
	 */
	public final Collection<SalesforceType> getSalesforceValues(Collection<Is24Type> scoutValues) {
		List<SalesforceType> result = new ArrayList<>();
		for (Is24Type scoutDuration : scoutValues) {
			result.add(getSalesforceValue(scoutDuration));
		}
		return result;
	}
}
