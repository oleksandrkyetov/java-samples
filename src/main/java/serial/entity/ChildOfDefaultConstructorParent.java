package serial.entity;

import java.io.Serializable;

public class ChildOfDefaultConstructorParent extends DefaultConstructorParent implements Serializable {

	private String childString;

	public ChildOfDefaultConstructorParent(final String parentString) {
		super(parentString + " " + ChildOfDefaultConstructorParent.class.toString());
	}

	public ChildOfDefaultConstructorParent(final Integer parentInteger) {
		super(parentInteger);
	}

	public ChildOfDefaultConstructorParent(final String parentString, final Integer parentInteger) {
		super(parentString, parentInteger);
	}

	public String getChildString() {
		return childString;
	}

	public void setChildString(final String childString) {
		this.childString = childString;
	}

}
