package exceptions;

public class NotRuntimeException extends Exception {

	private static final long serialVersionUID = 792512626481977928L;

	private final String value;

	public NotRuntimeException() {
		this("");
	}

	public NotRuntimeException(final String value) {
		this.value = value;
	}

}
