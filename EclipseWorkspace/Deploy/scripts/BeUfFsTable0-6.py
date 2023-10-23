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
s.add(And(tau(1)-tau(0)==2.0,tau(2)-tau(1)==2.0,tau(3)-tau(2)==2.0,tau(4)-tau(3)==2.0,tau(5)-tau(4)==2.0))
# Requirements Table
s.add(Or(Not(And(Not(True),y[0]==1023)),Or(Not(And(Not(True),y[0]==1023)),Not(And(Not(False),y[0]==1023))),Or(Or(Not(And(Not(True),y[0]==1023)),Not(And(Not(False),y[0]==1023))),Not(And(Not(False),y[1]==1023))),Or(Or(Or(Not(And(Not(True),y[0]==1023)),Not(And(Not(False),y[0]==1023))),Not(And(Not(False),y[1]==1023))),Not(And(Not(False),y[2]==1023))),Or(Or(Or(Or(Not(And(Not(True),y[0]==1023)),Not(And(Not(False),y[0]==1023))),Not(And(Not(False),y[1]==1023))),Not(And(Not(False),y[2]==1023))),Not(And(Not(False),y[3]==1023))),Or(Or(Or(Or(Or(Not(And(Not(True),y[0]==1023)),Not(And(Not(False),y[0]==1023))),Not(And(Not(False),y[1]==1023))),Not(And(Not(False),y[2]==1023))),Not(And(Not(False),y[3]==1023))),Not(And(Not(False),y[4]==1023))),Or(Or(Or(Or(Or(Or(Not(And(Not(True),y[0]==1023)),Not(And(Not(False),y[0]==1023))),Not(And(Not(False),y[1]==1023))),Not(And(Not(False),y[2]==1023))),Not(And(Not(False),y[3]==1023))),Not(And(Not(False),y[4]==1023))),Not(And(Not(False),y[5]==1023)))))
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
