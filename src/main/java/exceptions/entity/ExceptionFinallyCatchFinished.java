package exceptions.entity;

import exceptions.NotRuntimeException;
import exceptions.result.ExceptionResult;

public class ExceptionFinallyCatchFinished {

	public static final String FINALLY = "finally";
	public static final String EXCEPTION = "exception";
	public static final String CATCH = "catch";
	public static final String DONE = "done";

	private void finallyBlock(final ExceptionResult exceptionResult) throws NotRuntimeException {
		try {
			exceptionResult.addResult(EXCEPTION);
			throw new NotRuntimeException();
		} finally {
			exceptionResult.addResult(FINALLY);
		}
	}

	public void catchBlock(final ExceptionResult exceptionResult) {
		try {
			finallyBlock(exceptionResult);
		} catch (NotRuntimeException re) {
			exceptionResult.addResult(CATCH);
		}

		exceptionResult.addResult(DONE);
	}

}
