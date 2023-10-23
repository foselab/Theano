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
s.add(And(tau[1]-tau[0]==2.0,tau[2]-tau[1]==2.0,tau[3]-tau[2]==2.0,tau[4]-tau[3]==2.0,tau[5]-tau[4]==2.0))
# Requirements Table
s.add(ForAll([y] , Or(Or(Not(Implies(True,y[0]==0)),Not(Implies(And(Not(True),u[0]>0),y[0]==y[0]+1)),Not(Implies(False,y[1]==0)),Not(Implies(And(Not(False),u[1]>0),y[1]==y[0]+1)),Not(Implies(False,y[2]==0)),Not(Implies(And(Not(False),u[2]>0),y[2]==y[1]+1)),Not(Implies(False,y[3]==0)),Not(Implies(And(Not(False),u[3]>0),y[3]==y[2]+1)),Not(Implies(False,y[4]==0)),Not(Implies(And(Not(False),u[4]>0),y[4]==y[3]+1)),Not(Implies(False,y[5]==0)),Not(Implies(And(Not(False),u[5]>0),y[5]==y[4]+1))))))
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
