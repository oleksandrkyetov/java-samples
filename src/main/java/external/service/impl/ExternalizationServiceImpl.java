package external.service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import external.service.IExternalizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

//TODO
@Service
public class ExternalizationServiceImpl implements IExternalizationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalizationServiceImpl.class);

	@Override
	public String objectToString(final Externalizable object) {
		String string = null;

		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

			objectOutputStream.writeObject(object);

			string = Base64.encode(byteArrayOutputStream.toByteArray());
		} catch (IOException ioe) {
			LOGGER.error("Object externalization exception ...", ioe);
		}

		return string;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Externalizable> T stringToObject(final String string, final Class<T> clazz) throws InvalidClassException {
		T object = null;

		try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string));
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

			object = (T) objectInputStream.readObject();
		} catch (InvalidClassException ice) {
			throw ice;
		} catch (ClassNotFoundException | IOException e) {
			LOGGER.error("Object deexternalization exception ...", e);
		}

		return object;
	}

}
