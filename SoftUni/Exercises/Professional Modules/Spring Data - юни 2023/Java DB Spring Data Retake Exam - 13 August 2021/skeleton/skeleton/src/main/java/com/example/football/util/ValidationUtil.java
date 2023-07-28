package com.example.football.util;

import java.util.Set;

import javax.validation.ConstraintViolation;

public interface ValidationUtil {

	<E> boolean isValid(E entity);
	
	<E> Set<ConstraintViolation<E>> getConstraintViolations(E entity);
	
}
