package serial.entity;

import java.io.Serializable;

public class ChildOfObject implements Serializable {

	private String string;
	private Integer integer;
	private transient long transientLong;

	public ChildOfObject(final String string) {
		this.string = string;
	}

	public ChildOfObject(final Integer integer) {
		this.integer = integer;
	}

	public ChildOfObject(final String string, final Integer integer) {
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
