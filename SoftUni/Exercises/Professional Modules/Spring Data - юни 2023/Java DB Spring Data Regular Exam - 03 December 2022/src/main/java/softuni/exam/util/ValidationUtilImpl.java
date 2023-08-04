package softuni.exam.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
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
	public <E> Set<ConstraintViolation<E>> getConstraintViolation(E entity) {
		// TODO Auto-generated method stub
		return validator.validate(entity);
	}

}
