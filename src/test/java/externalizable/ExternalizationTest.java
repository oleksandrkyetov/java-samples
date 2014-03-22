package externalizable;

import externalizable.entity.DefaultConstructorExternalizedObject;
import externalizable.entity.NoDefaultConstructorExternalizedObject;
import externalizable.service.IExternalizationService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InvalidClassException;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-application-context.xml")
public class ExternalizationTest {

	private final static String TEST_STRING = "TEST_STRING";
	private final static Integer TEST_INTEGER = 990424;
	private final static long TEST_LONG = 9904L;

	private IExternalizationService externalizationService;

	@Autowired
	public void setExternalizationService(final IExternalizationService externalizationService) {
		this.externalizationService = externalizationService;
	}

	@Before
	public void before() {

	}

	@After
	public void after() {

	}

	/**
	 * Can not deexternalize object without default constructor
	 * @throws InvalidClassException
	 */
	@Test(expected = InvalidClassException.class)
	public void testNoDefaultConstructorExternalizedObject() throws InvalidClassException {
		final NoDefaultConstructorExternalizedObject noDefaultConstructorExternalizedObject = new NoDefaultConstructorExternalizedObject(TEST_STRING, TEST_INTEGER);

		final String string = externalizationService.objectToString(noDefaultConstructorExternalizedObject);
		final NoDefaultConstructorExternalizedObject object = externalizationService.stringToObject(string, NoDefaultConstructorExternalizedObject.class);
	}

	/**
	 * Can deexternalize object with {@link Object} as parent
	 * @throws java.io.InvalidClassException
	 */
	@Test
	public void testDefaultConstructorExternalizedObject() throws InvalidClassException {
		final DefaultConstructorExternalizedObject defaultConstructorExternalizedObject = new DefaultConstructorExternalizedObject(TEST_STRING, TEST_INTEGER);
		defaultConstructorExternalizedObject.setTransientLong(TEST_LONG);

		final String string = externalizationService.objectToString(defaultConstructorExternalizedObject);
		final DefaultConstructorExternalizedObject object = externalizationService.stringToObject(string, DefaultConstructorExternalizedObject.class);

		Assert.assertEquals(defaultConstructorExternalizedObject.getString(), object.getString());
		Assert.assertEquals(defaultConstructorExternalizedObject.getInteger(), object.getInteger());
		Assert.assertEquals(defaultConstructorExternalizedObject.getTransientLong(), object.getTransientLong());
	}

}
