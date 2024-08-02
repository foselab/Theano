package requirements2Z3.rqt;

public enum RelationalOperator {
	
	GE_OP(">"), LE_OP("<"), EQ_OP("="), LEQ_OP("<="), GEQ_OP(">=");
	
	private final String operator;
	
	private RelationalOperator(final String operator){
		this.operator=operator;
	}

	public String getOperator() {
		return operator;
	}
	
	public String toString() {
		return operator;
	}
	
	public static RelationalOperator toRelationalOperator(String arg0) {
		switch(arg0) {
			case ">":
				return RelationalOperator.GE_OP;
			case "<": 
				return RelationalOperator.LE_OP;
			case "=":
				return RelationalOperator.EQ_OP;
			case "<=":
				return RelationalOperator.LEQ_OP;
			case ">=":
				return RelationalOperator.GEQ_OP;
			default:
				throw new IllegalArgumentException("No alternative is present for the operator: "+arg0);
		}
		
	}
}
