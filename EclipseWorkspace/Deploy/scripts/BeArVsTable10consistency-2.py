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
u5=Array('u5',I,R)
y5=Array('y5',I,R)

# Quantification variables
j = Int('j')
i = Int('i')
k = Int('k')
# Timestamp structure
tau = Array('tau', I, R)
# Timestamp structure monotonicity
s.add(And(tau[0]<tau[0 + 1]))
# Requirements Table
s.add(ForAll([y1,y2,y3,y4,y5] , Or(Or(True),Or(Not(Implies(u2[0]==10,y2[0]==20)),Not(Implies(u2[1]==10,y2[1]==20))),Or(Not(Implies(u3[0]<100,y3[0]<150)),Not(Implies(u3[1]<100,y3[1]<150))),Or(Not(Implies(u4[0]<10,y4[0]<20)),Not(Implies(u4[0]<10,y4[1]<20))),Or(Not(Implies(u1[0]>5,y5[0]==5)),Not(Implies(u5[0]<50,y5[0]==30)),Not(Implies(u1[1]>5,y5[1]==5)),Not(Implies(u5[1]<50,y5[1]==30))))))
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
