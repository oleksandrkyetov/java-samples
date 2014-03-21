package serial.service;

import java.io.InvalidClassException;
import java.io.Serializable;

public interface ISerializationService {

	String objectToString(final Serializable object);

	<T extends Serializable> T stringToObject(final String string, final Class<T> clazz)  throws InvalidClassException;
}
