package com.example.football.util;

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
	public <E> boolean isValid(E entity) {
		// TODO Auto-generated method stub
		return this.getConstraintViolations(entity).isEmpty();
	}

	@Override
	public <E> Set<ConstraintViolation<E>> getConstraintViolations(E entity) {
		return validator.validate(entity);
	}

}
