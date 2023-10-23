from z3 import *;
# Defines the Z3 solver
s = Solver()
# Define I and R
I = IntSort()
R = RealSort()
# Signal variables definition
u=Array('u',I,I)
y=Array('y',I,I)

# Quantification variables
j = Int('j')
i = Int('i')
k = Int('k')
# Timestamp structure
tau = Function('tau', IntSort(), RealSort())
# Timestamp structure monotonicity
s.add(And(tau(0)<tau(0 + 1)))
# Requirements Table
s.add(Or(Not(And(Not(True),y[0]==1023)),Or(Not(And(Not(True),y[0]==1023)),Not(And(Not(False),y[0]==1023))),Or(Or(Not(And(Not(True),y[0]==1023)),Not(And(Not(False),y[0]==1023))),Not(And(Not(False),y[1]==1023)))))
# Processing the result
res=s.check()
if (res.r ==  Z3_L_FALSE):
	 print('Requirements Table Complete (unsat)')
	 sys.exit(1)
else:
	 if (res.r == Z3_L_TRUE):
		 print('Requirements Table Incomplete (sat)')
		 sys.exit(-1)
	 else:
		 print('unknown')
		 sys.exit(0)
