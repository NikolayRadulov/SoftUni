package exam.util;

import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.stereotype.Component;

@Component
public class ValidationUtilImpl implements ValidationUtil {

	private final Validator validator; 
	public ValidationUtilImpl() {
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Override
	public <E> boolean isValid(E entity) {
		// TODO Auto-generated method stub
		return validator.validate(entity).isEmpty();
	}

}
