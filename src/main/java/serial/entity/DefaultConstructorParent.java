package serial.entity;

public class DefaultConstructorParent {

	private String parentString;
	private transient Integer parentInteger;

	DefaultConstructorParent() {}

	DefaultConstructorParent(final String parentString) {
		this(parentString, null);
	}

	DefaultConstructorParent(final Integer parentInteger) {
		this(null, parentInteger);
	}

	DefaultConstructorParent(final String parentString, final Integer parentInteger) {
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
