package exceptions;

import com.google.common.collect.ImmutableList;
import exceptions.entity.ExceptionFinallyCatchFinished;
import exceptions.result.DefaultExceptionResult;
import exceptions.result.ExceptionResult;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class ExceptionsTest {

	@Before
	public void before() { }

	@After
	public void after() { }

	@Test
	public void testFinallyCatchDone() {
		final ExceptionResult exceptionFinallyCatchDoneResult = new DefaultExceptionResult();
		final List<String> finallyCatchDoneExpectedResult = new ImmutableList.Builder<String>().add(ExceptionFinallyCatchFinished.EXCEPTION,//
			ExceptionFinallyCatchFinished.FINALLY, ExceptionFinallyCatchFinished.CATCH, ExceptionFinallyCatchFinished.DONE).build();

		new ExceptionFinallyCatchFinished().catchBlock(exceptionFinallyCatchDoneResult);

		Assert.assertEquals(exceptionFinallyCatchDoneResult.getResults().size(), finallyCatchDoneExpectedResult.size());
		for (int i = 0; i < finallyCatchDoneExpectedResult.size(); i++) {
			Assert.assertEquals(exceptionFinallyCatchDoneResult.getResults().get(i), finallyCatchDoneExpectedResult.get(i));
		}
	}

}
