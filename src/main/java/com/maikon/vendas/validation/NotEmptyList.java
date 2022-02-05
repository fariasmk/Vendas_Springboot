package com.maikon.vendas.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.maikon.vendas.validation.constraintvalidation.NotEmptyListValidator;

@Retention(RetentionPolicy.RUNTIME) // Indica que as anotações estarão disponíveis em tempo de execução
@Target(ElementType.FIELD) // É possível estabelecer que elementos de uma classe podem ser anotados com
							// ele.
@Constraint(validatedBy = NotEmptyListValidator.class) // Define que é uma annotation de validação
public @interface NotEmptyList {

	String message() default "A lista não pode ser vazia.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
