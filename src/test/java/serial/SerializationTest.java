package serial;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import serial.entity.SerializedChildOfDefaultConstructorParent;
import serial.entity.SerializedChildOfNoDefaultConstructorParent;
import serial.entity.SerializedChildOfObject;
import serial.service.ISerializationService;

import java.io.InvalidClassException;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-application-context.xml")
public class SerializationTest {

	private final static String TEST_PARENT_STRING = "TEST_PARENT_STRING";
	private final static String TEST_CHILD_STRING = "TEST_CHILD_STRING";
	private final static String TEST_STRING = "TEST_STRING";

	private final static Integer TEST_PARENT_INTEGER = 197344;
	private final static Integer TEST_INTEGER = 990424;

	private final static long TEST_LONG = 9904L;

	private SerializedChildOfNoDefaultConstructorParent serializedChildOfNoDefaultConstructorParent;
	private SerializedChildOfDefaultConstructorParent serializedChildOfDefaultConstructorParent;
	private SerializedChildOfObject serializedChildOfObject;

	private ISerializationService serializationService;

	@Autowired
	public void setSerializationService(final ISerializationService serializationService) {
		this.serializationService = serializationService;
	}

	@Before
	public void before() {
		serializedChildOfNoDefaultConstructorParent = new SerializedChildOfNoDefaultConstructorParent(TEST_PARENT_STRING, TEST_PARENT_INTEGER);
		serializedChildOfNoDefaultConstructorParent.setChildString(TEST_CHILD_STRING);

		serializedChildOfDefaultConstructorParent = new SerializedChildOfDefaultConstructorParent(TEST_PARENT_STRING, TEST_PARENT_INTEGER);
		serializedChildOfDefaultConstructorParent.setChildString(TEST_CHILD_STRING);

		serializedChildOfObject = new SerializedChildOfObject(TEST_STRING, TEST_INTEGER);
		serializedChildOfObject.setTransientLong(TEST_LONG);
	}

	@After
	public void after() {

	}

	/**
	 * Can not deserialize object without default constructor in parent
	 * @throws InvalidClassException
	 */
	@Test(expected = InvalidClassException.class)
	public void testChildOfNoDefaultConstructorParent() throws InvalidClassException {
		final String string = serializationService.objectToString(serializedChildOfNoDefaultConstructorParent);
		final SerializedChildOfNoDefaultConstructorParent object = serializationService.stringToObject(string, SerializedChildOfNoDefaultConstructorParent.class);
	}

	/**
	 * Can deserialize object with default constructor in parent
	 * @throws InvalidClassException
	 */
	@Test
	public void testChildOfDefaultConstructorParent() throws InvalidClassException {
		final String string = serializationService.objectToString(serializedChildOfDefaultConstructorParent);
		final SerializedChildOfDefaultConstructorParent object = serializationService.stringToObject(string, SerializedChildOfDefaultConstructorParent.class);

		Assert.assertEquals(serializedChildOfDefaultConstructorParent.getChildString(), object.getChildString());
		Assert.assertEquals(null, object.getParentString());
		Assert.assertEquals(null, object.getParentInteger());
	}

	/**
	 * Can deserialize object with {@link java.lang.Object} as parent
	 * @throws InvalidClassException
	 */
	@Test
	public void testSerializedChildOfObject() throws InvalidClassException {
		final String string = serializationService.objectToString(serializedChildOfObject);
		final SerializedChildOfObject object = serializationService.stringToObject(string, SerializedChildOfObject.class);

		Assert.assertEquals(serializedChildOfObject.getString(), object.getString());
		Assert.assertEquals(serializedChildOfObject.getInteger(), object.getInteger());
		Assert.assertEquals(0L, object.getTransientLong());
	}

}
