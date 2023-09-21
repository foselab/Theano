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
Ts = Real('Ts')
s = Solver()
s.add(And(ForAll(j,Implies(j>=0,(tau[j+1]-tau[j]==2.0))),ForAll([y1,y1,y2] , Exists(i,And(Not(Implies(u1[i]==1,y1[i]==3)),Not(Implies(u1[i]!=2,y2[i]!=3)),Not(Implies(u1[i]!=1,y1[i]!=3)),Not(Implies(u1[i]==2,y2[i]==3)))))))
res=s.check()
if (res.r ==  Z3_L_FALSE):
	 print('Requirements Table Complete (unsat)')
	 sys.exit(1)
else:
	 if (res.r == Z3_L_TRUE):
		 print('Requirements Table InComplete (sat)')
		 sys.exit(-1)
	 else:
		 print('unknown')
		 sys.exit(0)
