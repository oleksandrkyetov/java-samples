package exceptions;

import com.google.common.collect.ImmutableList;
import exceptions.entity.InnerTriesCatchesThrowsExceptionTryCatchFinally;
import exceptions.entity.InnerTryThrowsExceptionInTry;
import exceptions.entity.InnerTryThrowsExceptionInTryCatch;
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
	public void testInnersTryCatchFinally() {
		final ExceptionResult exceptionResult = new DefaultExceptionResult();
		final List<String> expectedResult = new ImmutableList.Builder<String>().add(InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_TRY_IN_TRY,//
			InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_CATCH_IN_TRY, InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_FINALLY_IN_TRY,//
			InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_TRY_IN_CATCH, InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_CATCH_IN_CATCH,//
			InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_FINALLY_IN_CATCH, InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_TRY_IN_FINALLY,//
			InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_CATCH_IN_FINALLY, InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_FINALLY_IN_FINALLY).build();

		new InnerTriesCatchesThrowsExceptionTryCatchFinally().tryBlock(exceptionResult);

		Assert.assertEquals(exceptionResult.getResults().size(), expectedResult.size());
		for (int i = 0; i < expectedResult.size(); i++) {
			Assert.assertEquals(exceptionResult.getResults().get(i), expectedResult.get(i));
		}
	}

	@Test
	public void testFinallyInInnerTryExecutesBeforeOuterCatch() {
		final ExceptionResult exceptionResult = new DefaultExceptionResult();
		final List<String> expectedResult = new ImmutableList.Builder<String>().add(InnerTryThrowsExceptionInTry.INNER_TRY,//
			InnerTryThrowsExceptionInTry.INNER_FINALLY, InnerTryThrowsExceptionInTry.CATCH).build();

		new InnerTryThrowsExceptionInTry().tryBlock(exceptionResult);

		Assert.assertEquals(exceptionResult.getResults().size(), expectedResult.size());
		for (int i = 0; i < expectedResult.size(); i++) {
			Assert.assertEquals(exceptionResult.getResults().get(i), expectedResult.get(i));
		}
	}

	@Test
	public void testCatchInInnerCatchExecutesBeforeFinally() {
		final ExceptionResult exceptionResult = new DefaultExceptionResult();
		final List<String> expectedResult = new ImmutableList.Builder<String>().add(InnerTryThrowsExceptionInTryCatch.TRY,//
			InnerTryThrowsExceptionInTryCatch.INNER_TRY, InnerTryThrowsExceptionInTryCatch.INNER_CATCH, InnerTryThrowsExceptionInTryCatch.FINALLY).build();

		new InnerTryThrowsExceptionInTryCatch().tryBlock(exceptionResult);

		Assert.assertEquals(exceptionResult.getResults().size(), expectedResult.size());
		for (int i = 0; i < expectedResult.size(); i++) {
			Assert.assertEquals(exceptionResult.getResults().get(i), expectedResult.get(i));
		}
	}

	@Test
	public void testExceptionThrownInFinallyAlwaysLast() {
		final ExceptionResult exceptionResult = new DefaultExceptionResult();
		final String expectedResult = InnerTriesCatchesThrowsExceptionTryCatchFinally.INNER_FINALLY_IN_FINALLY;

		new InnerTriesCatchesThrowsExceptionTryCatchFinally().tryBlock(exceptionResult);

		Assert.assertEquals(expectedResult, exceptionResult.getLastResult());
	}

}
