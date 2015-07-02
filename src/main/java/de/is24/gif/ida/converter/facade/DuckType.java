package de.is24.gif.ida.converter.facade;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * from http://thinking-in-code.blogspot.de/2008/11/duck-typing-in-java-using-
 * dynamic.html by Dean Povey
 * <p/>
 * Allows "duck typing" or dynamic invocation based on method signature rather
 * than type hierarchy. In other words, rather than checking whether something
 * IS-a duck, check whether it WALKS-like-a duck or QUACKS-like a duck.
 * <p/>
 * To use first use the coerce static method to indicate the object you want to
 * do Duck Typing for, then specify an interface to the to method which you want
 * to coerce the type to, e.g:
 * <p/>
 * public interface Foo { void aMethod(); }
 * <p/>
 * class Bar { ... public void aMethod() { ... } ... }
 * <p/>
 * Bar bar = ...;
 * Foo foo = DuckType.coerce(bar).to(Foo.class);
 * foo.aMethod();
 */
public class DuckType {
	/*
	 * see http://docs.oracle.com/javase/1.5.0/docs/guide/reflection/proxy.html
	 * for the implementation technique.
	 */
	private final Object objectToCoerce;

	public DuckType(Object objectToCoerce) {
		this.objectToCoerce = objectToCoerce;
	}

	private class CoercedProxy implements InvocationHandler {
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (isUnwrappingGet(method)) {
				return DuckType.this.objectToCoerce;
			}
			Method delegateMethod = findMethodBySignature(method);
			assert delegateMethod != null;
			return delegateMethod.invoke(DuckType.this.objectToCoerce, args);
		}
	}

	private boolean isUnwrappingGet(Method method) {
		return method.getName().equals("get")
				&& method.getParameterTypes().length == 0
				&& method.getReturnType().isAssignableFrom(objectToCoerce.getClass());
	}

	/**
	 * Specify the duck typed object to coerce.
	 *
	 * @param object the object to coerce
	 * @return
	 */
	public static DuckType coerce(Object object) {
		return new DuckType(object);
	}

	/**
	 * Coerce the Duck Typed object to the given interface providing it
	 * implements all the necessary methods.
	 *
	 * @param
	 * @param iface
	 * @return an instance of the given interface that wraps the duck typed
	 * class
	 * @throws ClassCastException if the object being coerced does not implement all the
	 *                            methods in the given interface.
	 */
	public <T> T to(Class<T> iface) {
		assert iface.isInterface() : "cannot coerce object to a class, must be an interface";
		if (isA(iface)) {
			return iface.cast(objectToCoerce);
		}
		if (quacksLikeA(iface)) {
			return generateProxy(iface);
		}
		throw new ClassCastException("Could not coerce object of type " + objectToCoerce.getClass() + " to " + iface
				+ "\nMissing method: " + getMissingMethod(iface));
	}

	private boolean isA(Class iface) {
		return objectToCoerce.getClass().isInstance(iface);
	}

	/**
	 * Determine whether the duck typed object can be used with the given
	 * interface.
	 *
	 * @param iface Interface class to check
	 * @return true if the object will support all the methods in the interface,
	 * false otherwise.
	 */
	public boolean quacksLikeA(Class iface) {
		for (Method method : iface.getMethods()) {
			if (!isUnwrappingGet(method) && findMethodBySignature(method) == null) {
				return false;
			}
		}
		return true;
	}

	public String getMissingMethod(Class iface) {
		for (Method method : iface.getMethods()) {
			if (!isUnwrappingGet(method) && findMethodBySignature(method) == null) {
				return method.toString();
			}
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	private <T> T generateProxy(Class iface) {
		return (T) Proxy.newProxyInstance(iface.getClassLoader(), new Class[]{iface}, new CoercedProxy());
	}

	private Method findMethodBySignature(Method method) {
		try {
			return objectToCoerce.getClass().getMethod(method.getName(), method.getParameterTypes());
		} catch (NoSuchMethodException e) {
			return null;
		}
	}

}