package exceptions.entity;

import exceptions.NotRuntimeException;
import exceptions.result.ExceptionResult;

public class InnerTryThrowsExceptionInTryCatch {

	public static final String TRY = "try";
	public static final String INNER_TRY = "inner catch";
	public static final String INNER_CATCH = "inner catch";
	public static final String FINALLY = "finally";

	public void tryBlock(final ExceptionResult exceptionResult) {
		try {
			exceptionResult.addResult(TRY);
			throw new NotRuntimeException(TRY);
		} catch (NotRuntimeException nre1) {
			try {
				exceptionResult.addResult(INNER_TRY);
				throw new NotRuntimeException(INNER_TRY);
			} catch (NotRuntimeException nre2) {
				exceptionResult.addResult(INNER_CATCH);
			}
		} finally {
			exceptionResult.addResult(FINALLY);
		}
	}

}
