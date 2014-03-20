package java.serialization.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public interface SerializationService {

	String objectToString(final Serializable object);

	<T extends Serializable> T stringToObject(final String string, final Class<T> clazz);
}
