package softuni.exam.util;

import java.util.Set;

import javax.validation.ConstraintViolation;

public interface ValidationUtil {

	<E> Set<ConstraintViolation<E>> getConstraintViolation(E entity);
}
