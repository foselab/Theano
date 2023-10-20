from z3 import *;
# Defines the Z3 solver
s = Solver()
# Define I and R
I = IntSort()
R = RealSort()
# Signal variables definition
u=Array('u',I,R)
y=Array('y',I,R)

# Quantification variables
j = Int('j')
i = Int('i')
k = Int('k')
# Timestamp structure
tau = Array('tau', I, R)
# Timestamp structure monotonicity
s.add(And(ForAll(j,Implies(j>=0,(tau[j + 1]-tau[j]==2.0))),tau[0]==0))
# Requirements Table
# Requirement: 0
s.add(Implies(tau[i]==0,y[i]==0))
# Requirement: 1
s.add(Implies(And(!(tau[i]==0),u[i]>0),y[i]==((i==0)*(y[i])+(i>0)*(y[i-1]))+1))
# Requirement: 2
s.add(Implies(And(!(tau[i]==0),((i==0)*(y[i])+(i>0)*(y[i-1]))==1023),y[i]==23))
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
