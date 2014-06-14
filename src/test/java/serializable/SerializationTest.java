package serializable;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import serializable.entity.SerializedObject;
import serializable.entity.SerializedChildOfDefaultConstructorParent;
import serializable.entity.SerializedChildOfNoDefaultConstructorParent;
import serializable.entity.SerializedSingleton;
import serializable.service.ISerializationService;

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

	private ISerializationService serializationService;

	@Autowired
	public void setSerializationService(final ISerializationService serializationService) {
		this.serializationService = serializationService;
	}

	@Before
	public void before() { }

	@After
	public void after() { }

	/**
	 * Can not deserialize object without default constructor in parent
	 * @throws InvalidClassException
	 */
	@Test(expected = InvalidClassException.class)
	public void testSerializedChildOfNoDefaultConstructorParent() throws InvalidClassException {
		final SerializedChildOfNoDefaultConstructorParent serializedChildOfNoDefaultConstructorParent = new SerializedChildOfNoDefaultConstructorParent(TEST_PARENT_STRING, TEST_PARENT_INTEGER);
		serializedChildOfNoDefaultConstructorParent.setChildString(TEST_CHILD_STRING);

		final String string = serializationService.objectToString(serializedChildOfNoDefaultConstructorParent);
		final SerializedChildOfNoDefaultConstructorParent object = serializationService.stringToObject(string, SerializedChildOfNoDefaultConstructorParent.class);
	}

	/**
	 * Can deserialize object with default constructor in parent
	 * @throws InvalidClassException
	 */
	@Test
	public void testSerializedChildOfDefaultConstructorParent() throws InvalidClassException {
		final SerializedChildOfDefaultConstructorParent serializedChildOfDefaultConstructorParent = new SerializedChildOfDefaultConstructorParent(TEST_PARENT_STRING, TEST_PARENT_INTEGER);
		serializedChildOfDefaultConstructorParent.setChildString(TEST_CHILD_STRING);

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
	public void testSerializedObject() throws InvalidClassException {
		final SerializedObject serializedObject = new SerializedObject(TEST_STRING, TEST_INTEGER);
		serializedObject.setTransientLong(TEST_LONG);

		final String string = serializationService.objectToString(serializedObject);
		final SerializedObject object = serializationService.stringToObject(string, SerializedObject.class);

		Assert.assertEquals(serializedObject.getString(), object.getString());
		Assert.assertEquals(serializedObject.getInteger(), object.getInteger());
		Assert.assertEquals(0L, object.getTransientLong());
	}

	@Test
	public void testSerializedSingleton() throws InvalidClassException {
		final SerializedSingleton serializedSingleton = SerializedSingleton.getInstance();
		serializedSingleton.setInteger(TEST_INTEGER);
		serializedSingleton.setString(TEST_STRING);
		serializedSingleton.setTransientLong(TEST_LONG);

		final String string = serializationService.objectToString(serializedSingleton);
		final SerializedSingleton object = serializationService.stringToObject(string, SerializedSingleton.class);

		Assert.assertEquals(serializedSingleton.getString(), object.getString());
		Assert.assertEquals(serializedSingleton.getInteger(), object.getInteger());
		Assert.assertEquals(serializedSingleton.getTransientLong(), object.getTransientLong());
		Assert.assertEquals(serializedSingleton, object);
	}

}
