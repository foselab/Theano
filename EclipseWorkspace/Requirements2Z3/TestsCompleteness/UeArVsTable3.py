from z3 import *;
I = IntSort()
R = RealSort()
tau = Array('tau', I, R)
j = Int('j')
i = Int('i')
k = Int('k')
u2=Array('u2', I, R)
y1=Array('y1', I, R)
y2=Array('y2', I, R)
u1=Array('u1', I, R)
s = Solver()
s.add(Exists([u1, u2, tau, i] ,And(ForAll(j,Implies(j>=0,(tau[j]<tau[j+1]))),Or(And(Not(Exists(j,And(j<=i,tau[i]-tau[j]>=3,ForAll(k,Implies(And(j<=k,k<=i),y1[i]>1))))),Not(u1[i]==1)),And(Not(u1[i]!=2),Not(u1[i]==2))))))
res=s.check()
if (res.r ==  Z3_L_FALSE):
	 print('Requirements Table Complete (unsat)')
else:
	 if (res.r == Z3_L_TRUE):
		 print('Requirements Table InComplete (sat)')
	 else:
		 print('unknown')
if (res.r ==  Z3_L_FALSE):
	 print('Correct!')
else:
	 if (res.r == Z3_L_TRUE):
		 print('Error')
	 else:
		 print('MissRes')
