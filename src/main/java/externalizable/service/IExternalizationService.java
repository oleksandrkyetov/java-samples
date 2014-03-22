package externalizable.service;

import java.io.Externalizable;
import java.io.InvalidClassException;

public interface IExternalizationService {

	String objectToString(final Externalizable object);

	<T extends Externalizable> T stringToObject(final String string, final Class<T> clazz)  throws InvalidClassException;
}
