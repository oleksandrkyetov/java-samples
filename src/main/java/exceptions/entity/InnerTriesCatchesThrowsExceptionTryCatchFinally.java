package exceptions.entity;

import exceptions.NotRuntimeException;
import exceptions.result.ExceptionResult;

public class InnerTriesCatchesThrowsExceptionTryCatchFinally {

	public static final String INNER_TRY_IN_TRY = "inner catch in try";
	public static final String INNER_CATCH_IN_TRY = "inner catch in try";
	public static final String INNER_FINALLY_IN_TRY = "inner finally in try";

	public static final String INNER_TRY_IN_CATCH = "inner catch in catch";
	public static final String INNER_CATCH_IN_CATCH = "inner catch in catch";
	public static final String INNER_FINALLY_IN_CATCH = "inner finally in catch";

	public static final String INNER_TRY_IN_FINALLY = "inner catch in finally";
	public static final String INNER_CATCH_IN_FINALLY = "inner catch in finally";
	public static final String INNER_FINALLY_IN_FINALLY = "inner finally in finally";

	public void tryBlock(final ExceptionResult exceptionResult) {
		try {
			try {
				exceptionResult.addResult(INNER_TRY_IN_TRY);
				throw new NotRuntimeException(INNER_TRY_IN_TRY);
			} catch (NotRuntimeException nreInTry) {
				exceptionResult.addResult(INNER_CATCH_IN_TRY);
				throw new NotRuntimeException(INNER_CATCH_IN_TRY);
			} finally {
				exceptionResult.addResult(INNER_FINALLY_IN_TRY);
				throw new NotRuntimeException(INNER_FINALLY_IN_TRY);
			}
		} catch (NotRuntimeException nreInCatch) {
			try {
				exceptionResult.addResult(INNER_TRY_IN_CATCH);
				throw new NotRuntimeException(INNER_TRY_IN_CATCH);
			} catch (NotRuntimeException nre2) {
				exceptionResult.addResult(INNER_CATCH_IN_CATCH);
				//throw new NotRuntimeException(INNER_CATCH_IN_CATCH);
			} finally {
				exceptionResult.addResult(INNER_FINALLY_IN_CATCH);
				//throw new NotRuntimeException(INNER_FINALLY_IN_CATCH);
			}
		} finally{
			try {
				exceptionResult.addResult(INNER_TRY_IN_FINALLY);
				throw new NotRuntimeException(INNER_TRY_IN_FINALLY);
			} catch (NotRuntimeException nreInTry) {
				exceptionResult.addResult(INNER_CATCH_IN_FINALLY);
				//throw new NotRuntimeException(INNER_CATCH_IN_FINALLY);
			} finally {
				exceptionResult.addResult(INNER_FINALLY_IN_FINALLY);
				//throw new NotRuntimeException(INNER_FINALLY_IN_FINALLY);
			}
		}
	}

}
