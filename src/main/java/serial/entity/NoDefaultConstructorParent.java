package serial.entity;

public class NoDefaultConstructorParent {

	private String parentString;
	private transient Integer parentInteger;

	NoDefaultConstructorParent(final String parentString) {
		this(parentString, null);
	}

	NoDefaultConstructorParent(final Integer parentInteger) {
		this(null, parentInteger);
	}

	NoDefaultConstructorParent(final String parentString, final Integer parentInteger) {
		this.parentString = parentString;
		this.parentInteger = parentInteger;
	}

	public void setParentString(final String parentString) {
		this.parentString = parentString;
	}

	public String getParentString() {
		return parentString;
	}

	public void setParentInteger(final Integer parentInteger) {
		this.parentInteger = parentInteger;
	}

	public Integer getParentInteger() {
		return parentInteger;
	}

}
