package Validator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Validar {
	@SuppressWarnings("unused")
	private static Validator validator = getFabricaValidacao();
	
	public static Validator getFabricaValidacao(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    return factory.getValidator();
	}
}
