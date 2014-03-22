package serializable.entity;

import java.io.Serializable;

public class SerializedChildOfDefaultConstructorParent extends DefaultConstructorParent implements Serializable {

	private String childString;

	public SerializedChildOfDefaultConstructorParent(final String parentString) {
		super(parentString + " " + SerializedChildOfDefaultConstructorParent.class.toString());
	}

	public SerializedChildOfDefaultConstructorParent(final Integer parentInteger) {
		super(parentInteger);
	}

	public SerializedChildOfDefaultConstructorParent(final String parentString, final Integer parentInteger) {
		super(parentString, parentInteger);
	}

	public String getChildString() {
		return childString;
	}

	public void setChildString(final String childString) {
		this.childString = childString;
	}

}
