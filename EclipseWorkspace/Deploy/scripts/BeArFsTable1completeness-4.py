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
tau = Array('tau', I, R)
# Timestamp structure monotonicity
s.add(And(tau[1]-tau[0]==2.0,tau[2]-tau[1]==2.0,tau[3]-tau[2]==2.0))
# Requirements Table
s.add(Or(And(Not(And(Not(True),u[0]>0)),Not(True)),And(Not(And(Not(False),u[1]>0)),Not(False)),And(Not(And(Not(False),u[2]>0)),Not(False)),And(Not(And(Not(False),u[3]>0)),Not(False)),And(Not(And(Not(False),u[4]>0)),Not(False))))
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
