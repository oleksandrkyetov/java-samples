package java.serialization;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;

import java.serialization.entity.SerializableChildOfNonSerializableParent;
import java.serialization.service.SerializationService;

@RunWith(JUnit4.class)
public class SerializationTest {

	private final static String TEST_PARENT_STRING = "TEST_PARENT_STRING";
	private final static Integer TEST_PARENT_INTEGER = 197344;

	private SerializableChildOfNonSerializableParent serializableChildOfNonSerializableParent;

	@Autowired
	private SerializationService serializationService;

	@Before
	public void before() {
		serializableChildOfNonSerializableParent = new SerializableChildOfNonSerializableParent(TEST_PARENT_STRING, TEST_PARENT_INTEGER);
	}

	@After
	public void after() {

	}

	@Test
	public void testSerializableChildOfNonSerializableParent() {

	}

}
