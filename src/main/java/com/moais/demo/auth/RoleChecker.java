package com.moais.demo.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RoleChecker {
	public enum Role{
		NONE(0),
        USER(1);
		
        private final double value;

		Role(final double newValue) {
            value = newValue;
        }
        public double getValue() { return value; }
    }

	public Role role() default Role.NONE;
}
