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
import serial.entity.ChildOfDefaultConstructorParent;
import serial.entity.ChildOfNoDefaultConstructorParent;
import serial.entity.ChildOfObject;
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

	private ChildOfNoDefaultConstructorParent childOfNoDefaultConstructorParent;
	private ChildOfDefaultConstructorParent childOfDefaultConstructorParent;
	private ChildOfObject childOfObject;

	private ISerializationService serializationService;

	@Autowired
	public void setSerializationService(final ISerializationService serializationService) {
		this.serializationService = serializationService;
	}

	@Before
	public void before() {
		childOfNoDefaultConstructorParent = new ChildOfNoDefaultConstructorParent(TEST_PARENT_STRING, TEST_PARENT_INTEGER);
		childOfNoDefaultConstructorParent.setChildString(TEST_CHILD_STRING);

		childOfDefaultConstructorParent = new ChildOfDefaultConstructorParent(TEST_PARENT_STRING, TEST_PARENT_INTEGER);
		childOfDefaultConstructorParent.setChildString(TEST_CHILD_STRING);

		childOfObject = new ChildOfObject(TEST_STRING, TEST_INTEGER);
		childOfObject.setTransientLong(TEST_LONG);
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
		final String string = serializationService.objectToString(childOfNoDefaultConstructorParent);
		final ChildOfNoDefaultConstructorParent object = serializationService.stringToObject(string, ChildOfNoDefaultConstructorParent.class);
	}

	/**
	 * Can deserialize object with default constructor in parent
	 * @throws InvalidClassException
	 */
	@Test
	public void testChildOfDefaultConstructorParent() throws InvalidClassException {
		final String string = serializationService.objectToString(childOfDefaultConstructorParent);
		final ChildOfDefaultConstructorParent object = serializationService.stringToObject(string, ChildOfDefaultConstructorParent.class);

		Assert.assertEquals(childOfDefaultConstructorParent.getChildString(), object.getChildString());
		Assert.assertEquals(null, object.getParentString());
		Assert.assertEquals(null, object.getParentInteger());
	}

	/**
	 * Can deserialize object with {@link java.lang.Object} as parent
	 * @throws InvalidClassException
	 */
	@Test
	public void testChildOfObject() throws InvalidClassException {
		final String string = serializationService.objectToString(childOfObject);
		final ChildOfObject object = serializationService.stringToObject(string, ChildOfObject.class);

		Assert.assertEquals(childOfObject.getString(), object.getString());
		Assert.assertEquals(childOfObject.getInteger(), object.getInteger());
		Assert.assertEquals(0L, object.getTransientLong());
	}

}
