package az.developia.springjava13.exception;

import org.springframework.validation.BindingResult;

import lombok.Getter;

@Getter
public class OurRuntimeException extends RuntimeException {

	private BindingResult br;

	public OurRuntimeException(BindingResult br, String m) {
		super(m);
		this.br = br;
	}

	
}
