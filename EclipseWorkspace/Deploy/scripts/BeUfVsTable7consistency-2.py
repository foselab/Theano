from z3 import *;
# Defines the Z3 solver
s = Solver()
# Define I and R
I = IntSort()
R = RealSort()
# Signal variables definition
u1=Array('u1',I,R)
y1=Array('y1',I,R)
u2=Array('u2',I,R)
y2=Array('y2',I,R)
u3=Array('u3',I,R)
y3=Array('y3',I,R)
u4=Array('u4',I,R)
y4=Array('y4',I,R)

# Quantification variables
j = Int('j')
i = Int('i')
k = Int('k')
# Timestamp structure
tau = Function('tau', IntSort(), RealSort())
# Timestamp structure monotonicity
s.add(And(tau(0)<tau(0 + 1)))
# Requirements Table
s.add(ForAll([y1,y2,y3,y4] , Or(Or(Not(Implies(u1[0]<1,y1[0]<0)),Not(Implies(u1[1]<1,y1[1]<0))),Or(Not(Implies(u2[0]>5,y2[0]>5)),Not(Implies(u2[1]>5,y2[1]>5))),Or(Not(Implies(u3[0]<100,y3[0]==100)),Not(Implies(u4[0]>0,And(y4[0]>0,y3[0]>10))),Not(Implies(u3[1]<100,y3[1]==100)),Not(Implies(u4[1]>0,And(y4[1]>0,y3[1]>10)))),Or(Not(Implies(u4[0]>0,And(y4[0]>0,y3[0]>10))),Not(Implies(u4[0]>2,y4[0]>20)),Not(Implies(u4[1]>0,And(y4[1]>0,y3[1]>10))),Not(Implies(u4[0]>2,y4[0]>20))))))
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
