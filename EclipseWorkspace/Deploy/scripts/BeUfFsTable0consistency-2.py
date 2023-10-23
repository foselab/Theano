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
s.add(And(tau(1)-tau(0)==2.0))
# Requirements Table
s.add(ForAll([y] , Or(Or(Not(Implies(True,y[0]==0)),Not(Implies(And(Not(True),u[0]>0),y[0]==y[0]+1)),Not(Implies(And(Not(True),y[0]==1023),y[0]==23)),Not(Implies(False,y[1]==0)),Not(Implies(And(Not(False),u[1]>0),y[1]==y[0]+1)),Not(Implies(And(Not(False),y[0]==1023),y[1]==23))))))
# Processing the result
res=s.check()
if (res.r ==  Z3_L_FALSE):
	 print('Requirements Table Consistent (unsat)')
	 sys.exit(1)
else:
	 if (res.r == Z3_L_TRUE):
		 print('Requirements Table Not Consistent (sat)')
		 sys.exit(-1)
	 else:
		 print('unknown')
		 sys.exit(0)
