package java.serialization.entity;

import java.io.Serializable;

public class SerializableChildOfNonSerializableParent extends NonSerializableParent implements Serializable {

	private String childString;

	public SerializableChildOfNonSerializableParent(final String parentString) {
		super(parentString + " " + SerializableChildOfNonSerializableParent.class.toString());
	}

	public SerializableChildOfNonSerializableParent(final Integer parentInteger) {
		super(parentInteger);
	}

	public SerializableChildOfNonSerializableParent(final String parentString, final Integer parentInteger) {
		super(parentString, parentInteger);
	}

	public String getChildString() {
		return childString;
	}

	public void setChildString(final String childString) {
		this.childString = childString;
	}

}
