package serializable.service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import serializable.service.ISerializationService;

import java.io.*;

@Service
public class SerializationServiceImpl implements ISerializationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SerializationServiceImpl.class);

	@Override
	public String objectToString(final Serializable object) {
		String string = null;

		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

			objectOutputStream.writeObject(object);

			string = Base64.encode(byteArrayOutputStream.toByteArray());
		} catch (IOException ioe) {
			LOGGER.error("Object serialization exception ...", ioe);
		}

		return string;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T stringToObject(final String string, final Class<T> clazz) throws InvalidClassException {
		T object = null;

		try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string));
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

			object = (T) objectInputStream.readObject();
		} catch (InvalidClassException ice) {
			throw ice;
		} catch (ClassNotFoundException | IOException e) {
			LOGGER.error("Object deserialization exception ...", e);
		}

		return object;
	}

}
