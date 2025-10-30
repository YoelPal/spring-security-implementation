package com.yoel.springboot.app.springboot_crud.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistsByUsernameValidator.class)
@Target(ElementType.FIELD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)    
public @interface ExistsByUsername {
String message() default "Ya existe en la base de datos un usuario con este nombre de usuario";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
