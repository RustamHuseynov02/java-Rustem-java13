package az.developia.springjava13.exception;

import org.springframework.validation.BindingResult;

public class OurRuntimeException extends RuntimeException {

	private BindingResult br;

	public OurRuntimeException(BindingResult br,String m) {
		super(m);
		this.br = br;
	}
	
	public OurRuntimeException(BindingResult br) {
		this.br = br;
	}

	public BindingResult getBr() {
		return br;
	}
	
	
}
