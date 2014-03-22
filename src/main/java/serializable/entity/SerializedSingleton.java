package serializable.entity;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SerializedSingleton implements Serializable {

	private String string;
	private Integer integer;
	private transient long transientLong;

	private static class SerializedSingletonHolder {
		private static final SerializedSingleton INSTANCE = new SerializedSingleton();
	}

	public static SerializedSingleton getInstance() {
		return SerializedSingletonHolder.INSTANCE;
	}

	private SerializedSingleton() {}

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

	/**
	 * Rewrite default mechanism to use {@link #getInstance()} instead of default constructor
	 * @return
	 * @throws ObjectStreamException
	 */
	/*
	public Object readResolve() throws ObjectStreamException {
		return getInstance();
	}
	*/

}
