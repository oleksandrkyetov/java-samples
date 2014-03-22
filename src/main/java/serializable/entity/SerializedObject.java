package serializable.entity;

import java.io.Serializable;

public class SerializedObject implements Serializable {

	private String string;
	private Integer integer;
	private transient long transientLong;

	public SerializedObject(final String string) {
		this.string = string;
	}

	public SerializedObject(final Integer integer) {
		this.integer = integer;
	}

	public SerializedObject(final String string, final Integer integer) {
		this.string = string;
		this.integer = integer;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public long getTransientLong() {
		return transientLong;
	}

	public void setTransientLong(long transientLong) {
		this.transientLong = transientLong;
	}

}
