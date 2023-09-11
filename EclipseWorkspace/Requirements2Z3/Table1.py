from z3 import *;
I = IntSort()
R = RealSort()
pi = Array('pi', I, R)
j = Int('j')


u2=Array('pi', I, R)
y1=Array('pi', I, R)
y2=Array('pi', I, R)
u1=Array('pi', I, R)

s = Solver()
s.add(Exists(pi,Not(Exists(j,And(j>=0,(pi[j]>=pi[j+1]))))))
print (s.check())