package core.service;

import core.ValuableObject;

public interface IValuableObjectChanger {

	/**
	 *
	 * @param valuableObject object need to be changed
	 * @param value new value for an object
	 */
	public void change(ValuableObject valuableObject, String value);

}
