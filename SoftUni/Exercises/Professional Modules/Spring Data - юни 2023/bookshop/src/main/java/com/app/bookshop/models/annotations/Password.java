package com.app.bookshop.models.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

	public int minLength() default 0;
	public int maxLength() default 255;
	public boolean containsDigit() default false;
	public boolean containsLowerCase() default false;
}
