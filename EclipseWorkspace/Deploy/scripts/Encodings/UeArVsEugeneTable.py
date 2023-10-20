from z3 import *;
I = IntSort()
R = RealSort()
tau = Array('tau', I, R)
j = Int('j')
i = Int('i')
k = Int('k')
u=Array('u', I, I)
y=Array('y', I, I)
s = Solver()
s.add(And(And(ForAll(j,Implies(j>=0,(tau[j]<tau[j+1]))),tau[0]==0),ForAll([y,y] , Exists(i,Not(And(Implies(tau[i]==0,y[i]==0),Implies(And(tau[i]!=0,u[i]>0),y[i]==((i==0)*(y[i])+(i>0)*(y[i-1]))+1),Implies(And(tau[i]!=0,((i==0)*(y[i])+(i>0)*(y[i-1]))==1023),y[i]==23)))))))
res=s.check()
if (res.r ==  Z3_L_FALSE):
	 print('Requirements Table Consistent (unsat)')
	 sys.exit(1)
else:
	 if (res.r == Z3_L_TRUE):
		 print('Requirements Table Inconsistent (sat)')
		 sys.exit(-1)
	 else:
		 print('unknown')
		 sys.exit(0)
