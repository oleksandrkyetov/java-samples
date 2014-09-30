package core.service.impl;

import core.ValuableObject;
import core.service.IValuableObjectChanger;
import org.springframework.stereotype.Service;

@Service
public class SetValueValuableObjectChangerImpl implements IValuableObjectChanger {

	@Override
	public void change(ValuableObject valuableObject, String value) {
		valuableObject.setValue(value);
	}

}
