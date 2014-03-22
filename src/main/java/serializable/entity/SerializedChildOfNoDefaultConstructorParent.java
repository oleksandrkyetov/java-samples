package serializable.entity;

import java.io.Serializable;

public class SerializedChildOfNoDefaultConstructorParent extends NoDefaultConstructorParent implements Serializable {

	private String childString;

	public SerializedChildOfNoDefaultConstructorParent(final String parentString) {
		super(parentString + " " + SerializedChildOfNoDefaultConstructorParent.class.toString());
	}

	public SerializedChildOfNoDefaultConstructorParent(final Integer parentInteger) {
		super(parentInteger);
	}

	public SerializedChildOfNoDefaultConstructorParent(final String parentString, final Integer parentInteger) {
		super(parentString, parentInteger);
	}

	public String getChildString() {
		return childString;
	}

	public void setChildString(final String childString) {
		this.childString = childString;
	}

}
