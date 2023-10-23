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
tau = Function('tau', IntSort(), RealSort())
# Timestamp structure monotonicity
s.add(And(tau(1)-tau(0)==2.0,tau(2)-tau(1)==2.0,tau(3)-tau(2)==2.0,tau(4)-tau(3)==2.0,tau(5)-tau(4)==2.0))
# Requirements Table
s.add(Or(And(Not(u2[0]<7),Not(u5[0]>0)),And(Not(u3[0]==5),Not(u1[0]<10)),And(Not(u4[0]==3)),And(Not(u5[0]>0)),And(Not(u2[1]<7),Not(u5[1]>0)),And(Not(u3[1]==5),Not(u1[1]<10)),And(Not(u4[0]==3)),And(Not(u5[1]>0)),And(Not(u2[2]<7),Not(u5[2]>0)),And(Not(u3[2]==5),Not(u1[2]<10)),And(Not(u4[1]==3)),And(Not(u5[2]>0)),And(Not(u2[3]<7),Not(u5[3]>0)),And(Not(u3[3]==5),Not(u1[3]<10)),And(Not(u4[2]==3)),And(Not(u5[3]>0)),And(Not(u2[4]<7),Not(u5[4]>0)),And(Not(u3[4]==5),Not(u1[4]<10)),And(Not(u4[3]==3)),And(Not(u5[4]>0)),And(Not(u2[5]<7),Not(u5[5]>0)),And(Not(u3[5]==5),Not(u1[5]<10)),And(Not(u4[4]==3)),And(Not(u5[5]>0)),And(Not(u2[6]<7),Not(u5[6]>0)),And(Not(u3[6]==5),Not(u1[6]<10)),And(Not(u4[5]==3)),And(Not(u5[6]>0))))
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
