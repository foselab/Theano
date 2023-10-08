from z3 import *;
I = IntSort()
R = RealSort()
tau = Function('tau', IntSort(), RealSort())
j = Int('j')
i = Int('i')
k = Int('k')
u=Array('u', I, I)
y=Array('y', I, I)
Ts = Real('Ts')
s = Solver()
s.add(And(And(tau(0)<tau(1),tau(1)<tau(2),tau(2)<tau(3),tau(3)<tau(4),tau(4)<tau(5),tau(5)<tau(6),tau(6)<tau(7),tau(7)<tau(8)),ForAll([y] , And(Or(Not(y[0]==0),Not(Implies(u[1]>0,y[1]==y[0]+1)),Not(Implies(y[0]==1023,y[1]==23)),Not(Implies(u[2]>0,y[2]==y[1]+1)),Not(Implies(y[1]==1023,y[2]==23)),Not(Implies(u[3]>0,y[3]==y[2]+1)),Not(Implies(y[2]==1023,y[3]==23)),Not(Implies(u[4]>0,y[4]==y[3]+1)),Not(Implies(y[3]==1023,y[4]==23)),Not(Implies(u[5]>0,y[5]==y[4]+1)),Not(Implies(y[4]==1023,y[5]==23)),Not(Implies(u[6]>0,y[6]==y[5]+1)),Not(Implies(y[5]==1023,y[6]==23)),Not(Implies(u[7]>0,y[7]==y[6]+1)),Not(Implies(y[6]==1023,y[7]==23)),Not(Implies(u[8]>0,y[8]==y[7]+1)),Not(Implies(y[7]==1023,y[8]==23)))))))
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
