from z3 import *;
# Defines the Z3 solver
s = Solver()
# Define I and R
I = IntSort()
R = RealSort()
# Signal variables definition
u=Array('u',I,I)
y=Array('y',I,I)

# Quantification variables
j = Int('j')
i = Int('i')
k = Int('k')
# Timestamp structure
tau = Function('tau', IntSort(), RealSort())
# Timestamp structure monotonicity
s.add(And(tau(0)<tau(1),tau(1)<tau(2),tau(2)<tau(3),tau(3)<tau(4),tau(4)<tau(5),tau(5)<tau(6),tau(6)<tau(7),tau(7)<tau(8),tau(8)<tau(9),tau(9)<tau(10),tau(10)<tau(11),tau(11)<tau(12),tau(12)<tau(13),tau(13)<tau(14),tau(14)<tau(15),tau(15)<tau(16),tau(16)<tau(17),tau(17)<tau(18),tau(18)<tau(19)))
# Requirements Table
s.add(ForAll([y],Or(Not(Implies(u[3]==u[2]+1,y[3]==y[2]+1)),Not(Implies(u[17]==u[16]+1,y[17]==y[16]+1)),Not(Implies(And(u[15]!=u[14]+1,y[15]<40),y[15]<23)),Not(Implies(And(u[19]!=u[18]+1,y[19]<40),y[19]<23)),Not(Implies(u[10]==u[9]+1,y[10]==y[9]+1)),Not(Implies(u[4]==u[3]+1,y[4]==y[3]+1)),Not(Implies(And(y[4]<40,u[4]!=u[3]+1),y[4]<23)),Not(Implies(And(u[5]!=u[4]+1,y[5]<40),y[5]<23)),Not(Implies(u[12]==u[11]+1,y[12]==y[11]+1)),Not(Implies(And(y[16]<40,u[16]!=u[15]+1),y[16]<23)),Not(Implies(And(u[1]!=u[0]+1,y[1]<40),y[1]<23)),Not(Implies(u[14]==u[13]+1,y[14]==y[13]+1)),Not(Implies(And(u[7]!=u[6]+1,y[7]<40),y[7]<23)),Not(Implies(And(u[6]!=u[5]+1,y[6]<40),y[6]<23)),Not(Implies(u[19]==u[18]+1,y[19]==y[18]+1)),Not(Implies(u[16]==u[15]+1,y[16]==y[15]+1)),Not(Implies(u[6]==u[5]+1,y[6]==y[5]+1)),Not(Implies(u[8]==u[7]+1,y[8]==y[7]+1)),Not(Implies(And(y[14]<40,u[14]!=u[13]+1),y[14]<23)),Not(Implies(u[11]==u[10]+1,y[11]==y[10]+1)),Not(Implies(And(y[8]<40,u[8]!=u[7]+1),y[8]<23)),Not(Implies(u[1]==u[0]+1,y[1]==y[0]+1)),Not(y[0]==0),Not(Implies(And(u[12]!=u[11]+1,y[12]<40),y[12]<23)),Not(Implies(u[5]==u[4]+1,y[5]==y[4]+1)),Not(Implies(u[18]==u[17]+1,y[18]==y[17]+1)),Not(Implies(And(y[2]<40,u[2]!=u[1]+1),y[2]<23)),Not(Implies(And(u[3]!=u[2]+1,y[3]<40),y[3]<23)),Not(Implies(And(u[10]!=u[9]+1,y[10]<40),y[10]<23)),Not(Implies(And(y[17]<40,u[17]!=u[16]+1),y[17]<23)),Not(Implies(And(y[18]<40,u[18]!=u[17]+1),y[18]<23)),Not(Implies(And(u[9]!=u[8]+1,y[9]<40),y[9]<23)),Not(Implies(And(y[11]<40,u[11]!=u[10]+1),y[11]<23)),Not(Implies(u[13]==u[12]+1,y[13]==y[12]+1)),Not(Implies(u[2]==u[1]+1,y[2]==y[1]+1)),Not(Implies(u[7]==u[6]+1,y[7]==y[6]+1)),Not(Implies(u[15]==u[14]+1,y[15]==y[14]+1)),Not(Implies(u[9]==u[8]+1,y[9]==y[8]+1)),Not(Implies(And(u[13]!=u[12]+1,y[13]<40),y[13]<23)))))
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
