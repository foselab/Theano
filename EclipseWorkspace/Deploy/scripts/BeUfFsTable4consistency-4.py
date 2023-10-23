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
s.add(And(tau(1)-tau(0)==2.0,tau(2)-tau(1)==2.0,tau(3)-tau(2)==2.0))
# Requirements Table
s.add(ForAll([y1,y2] , Or(Or(Not(Implies(u1[0]!=1,y1[0]!=3)),Not(Implies(u1[0]==1,y1[0]==3)),Not(Implies(u1[1]!=1,y1[1]!=3)),Not(Implies(u1[1]==1,y1[1]==3)),Not(Implies(u1[2]!=1,y1[2]!=3)),Not(Implies(u1[2]==1,y1[2]==3)),Not(Implies(u1[3]!=1,y1[3]!=3)),Not(Implies(u1[3]==1,y1[3]==3))),Or(Not(Implies(u1[0]==2,y2[0]==3)),Not(Implies(u1[0]!=2,y2[0]!=3)),Not(Implies(u1[1]==2,y2[1]==3)),Not(Implies(u1[1]!=2,y2[1]!=3)),Not(Implies(u1[2]==2,y2[2]==3)),Not(Implies(u1[2]!=2,y2[2]!=3)),Not(Implies(u1[3]==2,y2[3]==3)),Not(Implies(u1[3]!=2,y2[3]!=3))))))
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
