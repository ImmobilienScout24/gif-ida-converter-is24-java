package de.is24.gif.ida.converter.is24ToIda;

import java.util.List;

import de.gifev.ida.converter.sdk.ITransformContext;
import de.gifev.ida.converter.sdk.ITransformer;
import de.gifev.ida.converter.sdk.MapperValidationException;
import de.gifev.ida.converter.sdk.ValidationError;

/**
 * @author Martin Fluegge
 * 
 */
public abstract class BasicTransformer<A, B> implements ITransformer<A, B> {

	static final Log LOG = LogFactory.getLog(BasicTransformer.class);
	private boolean validate = true;
	private Validator validator;

	protected abstract B doTransform(A a, ITransformContext context);

	@Override
	public B transform(A a, ITransformContext context) throws MapperValidationException {

		if (isValidate()) {

			validate(a);
		}

		return doTransform(a, context);
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	protected void validate(A o) throws MapperValidationException {
		Validator validator = getValidator();

		if (validator != null) {

			List<ValidationError> validationResults = validator.validate(o);

			for (ValidationError e : validationResults) {
				LOG.warn(e.getMessage());
			}

			if (validationResults != null && validationResults.size() > 0) {
				throw new MapperValidationException(validationResults);
			}
		}
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
