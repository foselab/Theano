package requirements2Z3.rqt;

public enum ArithmeticOperator {

	PLUS("+"), MINUS("-"), MULT("*"), DIV("/");
	
	private final String operator;
	
	private ArithmeticOperator(final String operator){
		this.operator=operator;
	}

	public String getOperator() {
		return operator;
	}
	
	public static ArithmeticOperator toArithmeticOperator(String arg0) {
		switch(arg0) {
			case "+":
				return ArithmeticOperator.PLUS;
			case "-": 
				return ArithmeticOperator.MINUS;
			case "*":
				return ArithmeticOperator.MULT;
			case "/":
				return ArithmeticOperator.DIV;
			default:
				throw new IllegalArgumentException("No alternative is present for the operator: "+arg0);
		}
		
	}
	
}
