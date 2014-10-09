package core;

import core.service.impl.NewInstanceValuableObjectChangerImpl;
import core.service.impl.SetValueValuableObjectChangerImpl;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RunWith(JUnit4.class)
public class CoreTest {

	final private static String STRING = "string";
	final private static String NEW_STRING = "new string";

	@Before
	public void before() { }

	@After
	public void after() { }

	@Test
	public void testChangePassedObjectByMethod() {
		final ValuableObject valuableObject = new ValuableObject(STRING);
		new SetValueValuableObjectChangerImpl().change(valuableObject, NEW_STRING);

		Assert.assertEquals(valuableObject.getValue(), NEW_STRING);
	}

	@Test
	public void testChangePassedObjectByConstructor() {
		final ValuableObject valuableObject = new ValuableObject(STRING);
		new NewInstanceValuableObjectChangerImpl().change(valuableObject, NEW_STRING);

		Assert.assertEquals(valuableObject.getValue(), STRING);
	}

	@Test
	public void testOutOfMemoryException() {
		int i = 0;
		try {
			final List<String> strings = new LinkedList<>();
			strings.add("0");

			for(;;) {
				strings.add(strings.get(strings.size() - 1) + "1");
				i++;
			}
		} finally {
			System.out.print("YAY!!! :)" + i);
		}
	}

}
