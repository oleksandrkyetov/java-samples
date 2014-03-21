package serial.entity;

import java.io.Serializable;

public class SerializedChildOfObject implements Serializable {

	private String string;
	private Integer integer;
	private transient long transientLong;

	public SerializedChildOfObject(final String string) {
		this.string = string;
	}

	public SerializedChildOfObject(final Integer integer) {
		this.integer = integer;
	}

	public SerializedChildOfObject(final String string, final Integer integer) {
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
