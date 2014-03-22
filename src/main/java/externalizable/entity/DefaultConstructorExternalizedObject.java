package externalizable.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DefaultConstructorExternalizedObject implements Externalizable {

	private String string;
	private Integer integer;
	private transient long transientLong;

	public DefaultConstructorExternalizedObject() {}

	public DefaultConstructorExternalizedObject(final String string) {
		this.string = string;
	}

	public DefaultConstructorExternalizedObject(final Integer integer) {
		this.integer = integer;
	}

	public DefaultConstructorExternalizedObject(final String string, final Integer integer) {
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

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeObject(string);
		objectOutput.writeObject(integer);
		objectOutput.writeLong(transientLong);
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
		string = (String) objectInput.readObject();
		integer = (Integer) objectInput.readObject();
		transientLong = objectInput.readLong();
	}

}
