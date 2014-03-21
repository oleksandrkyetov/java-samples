package serial.entity;

import java.io.Serializable;

public class ChildOfNoDefaultConstructorParent extends NoDefaultConstructorParent implements Serializable {

	private String childString;

	public ChildOfNoDefaultConstructorParent(final String parentString) {
		super(parentString + " " + ChildOfNoDefaultConstructorParent.class.toString());
	}

	public ChildOfNoDefaultConstructorParent(final Integer parentInteger) {
		super(parentInteger);
	}

	public ChildOfNoDefaultConstructorParent(final String parentString, final Integer parentInteger) {
		super(parentString, parentInteger);
	}

	public String getChildString() {
		return childString;
	}

	public void setChildString(final String childString) {
		this.childString = childString;
	}

}
