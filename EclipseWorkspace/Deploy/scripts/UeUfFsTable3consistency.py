from z3 import *;
# Defines the Z3 solver
s = Solver()
# Define I and R
I = IntSort()
R = RealSort()
# Signal variables definition
u2=Array('u2',I,R)
y1=Array('y1',I,R)
y2=Array('y2',I,R)
u1=Array('u1',I,R)

# Quantification variables
j = Int('j')
i = Int('i')
k = Int('k')
# Timestamp structure
tau = Function('tau', IntSort(), RealSort())
# Timestamp structure monotonicity
s.add(And(ForAll(j,Implies(j>=0,(tau(j + 1)-tau(j)==2.0))),tau(0)==0))
# Requirements Table
s.add(ForAll([y1,y2] , Exists(i,Not(And(Implies(u1[i]>=1,y1[i]!=3),Implies(u1[i]==2,y2[i]==3),Implies(u1[i]==1,y1[i]==3),Implies(u1[i]!=2,y2[i]!=3))))))
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
