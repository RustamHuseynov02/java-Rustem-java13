package az.developia.springjava13.exception;

import org.springframework.validation.BindingResult;

public class OurRuntimeException extends RuntimeException {

	private BindingResult br;

	public OurRuntimeException(BindingResult br) {
		super();
		this.br = br;
	}

	public BindingResult getBr() {
		return br;
	}
	
	
}
