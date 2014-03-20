package java.serialization.service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.serialization.service.SerializationService;

public class SerializationServiceImpl implements SerializationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SerializationServiceImpl.class);

	@Override
	public String objectToString(final Serializable object) {
		String string = null;

		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

			objectOutputStream.writeObject(object);

			string = Base64.encode(byteArrayOutputStream.toByteArray());
		} catch (IOException ioe) {
			LOGGER.error("", ioe);
		}

		return string;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T stringToObject(final String string, final Class<T> clazz) {
		T object = null;

		try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string));
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

			object = (T) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			LOGGER.error("", e);
		}

		return object;
	}

}
