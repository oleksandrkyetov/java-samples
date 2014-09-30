package exceptions.entity;

import exceptions.NotRuntimeException;
import exceptions.result.ExceptionResult;

public class InnerTryThrowsExceptionInTry {

	public static final String INNER_TRY = "inner catch";
	public static final String INNER_FINALLY = "inner finally";
	public static final String CATCH = "catch";

	public void tryBlock(final ExceptionResult exceptionResult) {
		try {
			try {
				exceptionResult.addResult(INNER_TRY);
				throw new NotRuntimeException(INNER_TRY);
			} finally {
				exceptionResult.addResult(INNER_FINALLY);
			}
		} catch (NotRuntimeException nre) {
			exceptionResult.addResult(CATCH);
		}
	}

}
