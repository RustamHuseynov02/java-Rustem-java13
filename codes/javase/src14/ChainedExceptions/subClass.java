package ChainedExceptions;

public class subClass extends ParentClass {

	@Override
	public int Method(int a) throws ArithmeticException {

		int result = 0;
		if (a > 0) {
			result  = a / 0;
			//throw new ArithmeticException();
		}
		return result;
		
	}

	
}
