package java.serialization.entity;

public class NonSerializableParent {

	final private String parentString;
	final private transient Integer parentInteger;

	NonSerializableParent(final String parentString) {
		this(parentString, null);
	}

	NonSerializableParent(final Integer parentInteger) {
		this(null, parentInteger);
	}

	NonSerializableParent(final String parentString, final Integer parentInteger) {
		this.parentString = parentString;
		this.parentInteger = parentInteger;
	}

	public String getParentString() {
		return parentString;
	}

	public Integer getParentInteger() {
		return parentInteger;
	}

}
