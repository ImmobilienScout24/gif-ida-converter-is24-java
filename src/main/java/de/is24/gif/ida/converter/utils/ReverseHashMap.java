package de.is24.gif.ida.converter.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Martin Fluegge
 */
public class ReverseHashMap<Key, Value> {

	private Map<Key, Value> keyToValueMap = new HashMap<Key, Value>();
	private Map<Value, Key> valueToKeyMap = new HashMap<Value, Key>();

	public ReverseHashMap() {
	}

	public ReverseHashMap(Map<Key, Value> map) {
		keyToValueMap = map;
		for (Key key : map.keySet()) {
			valueToKeyMap.put(map.get(key), key);
		}
	}

	synchronized public void put(Key key, Value value) {
		keyToValueMap.put(key, value);
		valueToKeyMap.put(value, key);
	}

	synchronized public Value removeByKey(Key key) {
		Value removedValue = keyToValueMap.remove(key);
		valueToKeyMap.remove(removedValue);
		return removedValue;
	}

	synchronized public Key removeByValue(Value value) {
		Key removedKey = valueToKeyMap.remove(value);
		keyToValueMap.remove(removedKey);
		return removedKey;
	}

	public boolean containsKey(Key key) {
		return keyToValueMap.containsKey(key);
	}

	public boolean containsValue(Value value) {
		return keyToValueMap.containsValue(value);
	}

	public Key getKey(Value value) {
		return valueToKeyMap.get(value);
	}

	public Value getValue(Key key) {
		return keyToValueMap.get(key);
	}
}
