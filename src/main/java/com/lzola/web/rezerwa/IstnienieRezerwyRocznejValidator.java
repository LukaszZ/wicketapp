package com.lzola.web.rezerwa;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import com.lzola.dao.RezerwaRocznaDao;

public class IstnienieRezerwyRocznejValidator implements IValidator<String>{

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = -247626804201675841L;
	
	private RezerwaRocznaDao rezerwaRocznaDao;
	
	public IstnienieRezerwyRocznejValidator(RezerwaRocznaDao rezerwaRocznaDao) {
		this.rezerwaRocznaDao = rezerwaRocznaDao;
	}

	@Override
	public void validate(IValidatable<String> validatable) {
		String numerSzkody = validatable.getValue();
		Long count = rezerwaRocznaDao.countByNumerSzkody(numerSzkody);
		if (count == 0) {
			error(validatable, "nieIstniejeRezerwaRocznaValidator");
		}
	}

	private void error(IValidatable<String> validatable, String errorKey) {
		ValidationError error = new ValidationError();
		error.addMessageKey(getClass().getSimpleName() + "." + errorKey);
		error.setVariable("numerSzkody", validatable.getValue());
		validatable.error(error);
	}
}
