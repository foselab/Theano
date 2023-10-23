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
s.add(And(ForAll(j,Implies(j>=0,(tau[j]<tau[j + 1]))),tau[0]==0))
# Requirements Table
s.add(ForAll([y1,y2,y3,y4,y5] , Exists(i,Not(And(Implies(u1[i]>0,y1[i]<0),Implies(u2[i]==0,y2[i]>0),Implies(u3[i]>0,y2[i]>0),Implies(((i==0)*(u4[i])+(i>0)*(u4[i-1]))<0,y4[i]==0),Implies(u5[i]>0,u5[i]<0))))))
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
