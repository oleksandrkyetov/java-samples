package external;

import external.service.IExternalizationService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InvalidClassException;

//TODO
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-application-context.xml")
public class ExternalizationTest {

	private final static String TEST_STRING = "TEST_STRING";
	private final static Integer TEST_INTEGER = 990424;
	private final static long TEST_LONG = 9904L;

	private IExternalizationService externalizationService;

	@Autowired
	public void setSerializationService(final IExternalizationService externalizationService) {
		this.externalizationService = externalizationService;
	}

	@Before
	public void before() {

	}

	@After
	public void after() {

	}

	/**
	 * Can deexternalize object with {@link Object} as parent
	 * @throws java.io.InvalidClassException
	 */
	@Test
	public void testExternalizedChildOfObject() throws InvalidClassException {

	}

}
