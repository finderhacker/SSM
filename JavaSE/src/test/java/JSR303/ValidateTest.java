package JSR303;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class ValidateTest {

	@Test
	public void aa() {
		Order order = new Order();
		System.out.println(order);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Order>> violations = validator.validate(order);
		System.out.println(violations);
	}
}
