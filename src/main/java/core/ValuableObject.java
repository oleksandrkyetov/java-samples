package core;

public class ValuableObject {

	private String value;

	public ValuableObject() {
		this("");
	}

	public ValuableObject(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
