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
s.add(And(tau(0)<tau(0 + 1),tau(1)<tau(1 + 1),tau(2)<tau(2 + 1),tau(3)<tau(3 + 1),tau(4)<tau(4 + 1)))
# Requirements Table
s.add(Or(And(Not(u1[0]<1)),And(Not(u4[0]>0),Not(u2[0]>5)),And(Not(u3[0]<100)),And(Not(u4[0]>0),Not(u4[0]>2)),And(Not(u1[1]<1)),And(Not(u4[1]>0),Not(u2[1]>5)),And(Not(u3[1]<100)),And(Not(u4[1]>0),Not(u4[0]>2)),And(Not(u1[2]<1)),And(Not(u4[2]>0),Not(u2[2]>5)),And(Not(u3[2]<100)),And(Not(u4[2]>0),Not(u4[1]>2)),And(Not(u1[3]<1)),And(Not(u4[3]>0),Not(u2[3]>5)),And(Not(u3[3]<100)),And(Not(u4[3]>0),Not(u4[2]>2)),And(Not(u1[4]<1)),And(Not(u4[4]>0),Not(u2[4]>5)),And(Not(u3[4]<100)),And(Not(u4[4]>0),Not(u4[3]>2)),And(Not(u1[5]<1)),And(Not(u4[5]>0),Not(u2[5]>5)),And(Not(u3[5]<100)),And(Not(u4[5]>0),Not(u4[4]>2)),And(Not(u1[6]<1)),And(Not(u4[6]>0),Not(u2[6]>5)),And(Not(u3[6]<100)),And(Not(u4[6]>0),Not(u4[5]>2))))
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
