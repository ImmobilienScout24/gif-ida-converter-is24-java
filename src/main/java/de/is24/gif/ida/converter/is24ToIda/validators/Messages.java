package de.is24.gif.ida.converter.is24ToIda.validators;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	// Though generated by Eclipse, this doesn't work
	// the Properties file has to be located under resources and referenced
	// accordingly
	//private static final String BUNDLE_NAME = "de.is24.maklermanager.export.mapping.validators.impl.messages_de"; //$NON-NLS-1$

	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$
	private static final Locale LOCALE = new Locale("de", "DE");
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, LOCALE);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
