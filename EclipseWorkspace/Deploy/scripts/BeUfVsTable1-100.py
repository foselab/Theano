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
s.add(And(tau(0)<tau(0 + 1),tau(1)<tau(1 + 1),tau(2)<tau(2 + 1),tau(3)<tau(3 + 1),tau(4)<tau(4 + 1),tau(5)<tau(5 + 1),tau(6)<tau(6 + 1),tau(7)<tau(7 + 1),tau(8)<tau(8 + 1),tau(9)<tau(9 + 1),tau(10)<tau(10 + 1),tau(11)<tau(11 + 1),tau(12)<tau(12 + 1),tau(13)<tau(13 + 1),tau(14)<tau(14 + 1),tau(15)<tau(15 + 1),tau(16)<tau(16 + 1),tau(17)<tau(17 + 1),tau(18)<tau(18 + 1),tau(19)<tau(19 + 1),tau(20)<tau(20 + 1),tau(21)<tau(21 + 1),tau(22)<tau(22 + 1),tau(23)<tau(23 + 1),tau(24)<tau(24 + 1),tau(25)<tau(25 + 1),tau(26)<tau(26 + 1),tau(27)<tau(27 + 1),tau(28)<tau(28 + 1),tau(29)<tau(29 + 1),tau(30)<tau(30 + 1),tau(31)<tau(31 + 1),tau(32)<tau(32 + 1),tau(33)<tau(33 + 1),tau(34)<tau(34 + 1),tau(35)<tau(35 + 1),tau(36)<tau(36 + 1),tau(37)<tau(37 + 1),tau(38)<tau(38 + 1),tau(39)<tau(39 + 1),tau(40)<tau(40 + 1),tau(41)<tau(41 + 1),tau(42)<tau(42 + 1),tau(43)<tau(43 + 1),tau(44)<tau(44 + 1),tau(45)<tau(45 + 1),tau(46)<tau(46 + 1),tau(47)<tau(47 + 1),tau(48)<tau(48 + 1),tau(49)<tau(49 + 1),tau(50)<tau(50 + 1),tau(51)<tau(51 + 1),tau(52)<tau(52 + 1),tau(53)<tau(53 + 1),tau(54)<tau(54 + 1),tau(55)<tau(55 + 1),tau(56)<tau(56 + 1),tau(57)<tau(57 + 1),tau(58)<tau(58 + 1),tau(59)<tau(59 + 1),tau(60)<tau(60 + 1),tau(61)<tau(61 + 1),tau(62)<tau(62 + 1),tau(63)<tau(63 + 1),tau(64)<tau(64 + 1),tau(65)<tau(65 + 1),tau(66)<tau(66 + 1),tau(67)<tau(67 + 1),tau(68)<tau(68 + 1),tau(69)<tau(69 + 1),tau(70)<tau(70 + 1),tau(71)<tau(71 + 1),tau(72)<tau(72 + 1),tau(73)<tau(73 + 1),tau(74)<tau(74 + 1),tau(75)<tau(75 + 1),tau(76)<tau(76 + 1),tau(77)<tau(77 + 1),tau(78)<tau(78 + 1),tau(79)<tau(79 + 1),tau(80)<tau(80 + 1),tau(81)<tau(81 + 1),tau(82)<tau(82 + 1),tau(83)<tau(83 + 1),tau(84)<tau(84 + 1),tau(85)<tau(85 + 1),tau(86)<tau(86 + 1),tau(87)<tau(87 + 1),tau(88)<tau(88 + 1),tau(89)<tau(89 + 1),tau(90)<tau(90 + 1),tau(91)<tau(91 + 1),tau(92)<tau(92 + 1),tau(93)<tau(93 + 1),tau(94)<tau(94 + 1),tau(95)<tau(95 + 1),tau(96)<tau(96 + 1),tau(97)<tau(97 + 1),tau(98)<tau(98 + 1)))
# Requirements Table
s.add(Or(,Or(,),Or(Or(,),),Or(Or(Or(,),),),Or(Or(Or(Or(,),),),),Or(Or(Or(Or(Or(,),),),),),Or(Or(Or(Or(Or(Or(,),),),),),),Or(Or(Or(Or(Or(Or(Or(,),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(Or(,),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),),)))
# Processing the result
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
