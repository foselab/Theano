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
s.add(And(And(tau(0)<tau(1),tau(1)<tau(2),tau(2)<tau(3),tau(3)<tau(4),tau(4)<tau(5),tau(5)<tau(6),tau(6)<tau(7),tau(7)<tau(8),tau(8)<tau(9),tau(9)<tau(10),tau(10)<tau(11),tau(11)<tau(12),tau(12)<tau(13),tau(13)<tau(14),tau(14)<tau(15),tau(15)<tau(16),tau(16)<tau(17),tau(17)<tau(18),tau(18)<tau(19),tau(19)<tau(20),tau(20)<tau(21),tau(21)<tau(22),tau(22)<tau(23),tau(23)<tau(24),tau(24)<tau(25),tau(25)<tau(26),tau(26)<tau(27),tau(27)<tau(28),tau(28)<tau(29),tau(29)<tau(30),tau(30)<tau(31),tau(31)<tau(32),tau(32)<tau(33),tau(33)<tau(34),tau(34)<tau(35),tau(35)<tau(36),tau(36)<tau(37),tau(37)<tau(38),tau(38)<tau(39),tau(39)<tau(40),tau(40)<tau(41),tau(41)<tau(42),tau(42)<tau(43),tau(43)<tau(44),tau(44)<tau(45),tau(45)<tau(46),tau(46)<tau(47),tau(47)<tau(48),tau(48)<tau(49),tau(49)<tau(50),tau(50)<tau(51),tau(51)<tau(52),tau(52)<tau(53),tau(53)<tau(54),tau(54)<tau(55),tau(55)<tau(56),tau(56)<tau(57),tau(57)<tau(58),tau(58)<tau(59),tau(59)<tau(60),tau(60)<tau(61),tau(61)<tau(62),tau(62)<tau(63),tau(63)<tau(64),tau(64)<tau(65),tau(65)<tau(66),tau(66)<tau(67),tau(67)<tau(68),tau(68)<tau(69),tau(69)<tau(70),tau(70)<tau(71),tau(71)<tau(72),tau(72)<tau(73),tau(73)<tau(74),tau(74)<tau(75),tau(75)<tau(76),tau(76)<tau(77),tau(77)<tau(78),tau(78)<tau(79),tau(79)<tau(80),tau(80)<tau(81),tau(81)<tau(82),tau(82)<tau(83),tau(83)<tau(84),tau(84)<tau(85),tau(85)<tau(86),tau(86)<tau(87),tau(87)<tau(88),tau(88)<tau(89),tau(89)<tau(90),tau(90)<tau(91),tau(91)<tau(92),tau(92)<tau(93),tau(93)<tau(94),tau(94)<tau(95),tau(95)<tau(96),tau(96)<tau(97),tau(97)<tau(98),tau(98)<tau(99)),ForAll([y] , And(Or(Not(y[0]==0),Not(Implies(u[1]>0,y[1]==y[0]+1)),Not(Implies(y[0]==1023,y[1]==23)),Not(Implies(u[2]>0,y[2]==y[1]+1)),Not(Implies(y[1]==1023,y[2]==23)),Not(Implies(u[3]>0,y[3]==y[2]+1)),Not(Implies(y[2]==1023,y[3]==23)),Not(Implies(u[4]>0,y[4]==y[3]+1)),Not(Implies(y[3]==1023,y[4]==23)),Not(Implies(u[5]>0,y[5]==y[4]+1)),Not(Implies(y[4]==1023,y[5]==23)),Not(Implies(u[6]>0,y[6]==y[5]+1)),Not(Implies(y[5]==1023,y[6]==23)),Not(Implies(u[7]>0,y[7]==y[6]+1)),Not(Implies(y[6]==1023,y[7]==23)),Not(Implies(u[8]>0,y[8]==y[7]+1)),Not(Implies(y[7]==1023,y[8]==23)),Not(Implies(u[9]>0,y[9]==y[8]+1)),Not(Implies(y[8]==1023,y[9]==23)),Not(Implies(u[10]>0,y[10]==y[9]+1)),Not(Implies(y[9]==1023,y[10]==23)),Not(Implies(u[11]>0,y[11]==y[10]+1)),Not(Implies(y[10]==1023,y[11]==23)),Not(Implies(u[12]>0,y[12]==y[11]+1)),Not(Implies(y[11]==1023,y[12]==23)),Not(Implies(u[13]>0,y[13]==y[12]+1)),Not(Implies(y[12]==1023,y[13]==23)),Not(Implies(u[14]>0,y[14]==y[13]+1)),Not(Implies(y[13]==1023,y[14]==23)),Not(Implies(u[15]>0,y[15]==y[14]+1)),Not(Implies(y[14]==1023,y[15]==23)),Not(Implies(u[16]>0,y[16]==y[15]+1)),Not(Implies(y[15]==1023,y[16]==23)),Not(Implies(u[17]>0,y[17]==y[16]+1)),Not(Implies(y[16]==1023,y[17]==23)),Not(Implies(u[18]>0,y[18]==y[17]+1)),Not(Implies(y[17]==1023,y[18]==23)),Not(Implies(u[19]>0,y[19]==y[18]+1)),Not(Implies(y[18]==1023,y[19]==23)),Not(Implies(u[20]>0,y[20]==y[19]+1)),Not(Implies(y[19]==1023,y[20]==23)),Not(Implies(u[21]>0,y[21]==y[20]+1)),Not(Implies(y[20]==1023,y[21]==23)),Not(Implies(u[22]>0,y[22]==y[21]+1)),Not(Implies(y[21]==1023,y[22]==23)),Not(Implies(u[23]>0,y[23]==y[22]+1)),Not(Implies(y[22]==1023,y[23]==23)),Not(Implies(u[24]>0,y[24]==y[23]+1)),Not(Implies(y[23]==1023,y[24]==23)),Not(Implies(u[25]>0,y[25]==y[24]+1)),Not(Implies(y[24]==1023,y[25]==23)),Not(Implies(u[26]>0,y[26]==y[25]+1)),Not(Implies(y[25]==1023,y[26]==23)),Not(Implies(u[27]>0,y[27]==y[26]+1)),Not(Implies(y[26]==1023,y[27]==23)),Not(Implies(u[28]>0,y[28]==y[27]+1)),Not(Implies(y[27]==1023,y[28]==23)),Not(Implies(u[29]>0,y[29]==y[28]+1)),Not(Implies(y[28]==1023,y[29]==23)),Not(Implies(u[30]>0,y[30]==y[29]+1)),Not(Implies(y[29]==1023,y[30]==23)),Not(Implies(u[31]>0,y[31]==y[30]+1)),Not(Implies(y[30]==1023,y[31]==23)),Not(Implies(u[32]>0,y[32]==y[31]+1)),Not(Implies(y[31]==1023,y[32]==23)),Not(Implies(u[33]>0,y[33]==y[32]+1)),Not(Implies(y[32]==1023,y[33]==23)),Not(Implies(u[34]>0,y[34]==y[33]+1)),Not(Implies(y[33]==1023,y[34]==23)),Not(Implies(u[35]>0,y[35]==y[34]+1)),Not(Implies(y[34]==1023,y[35]==23)),Not(Implies(u[36]>0,y[36]==y[35]+1)),Not(Implies(y[35]==1023,y[36]==23)),Not(Implies(u[37]>0,y[37]==y[36]+1)),Not(Implies(y[36]==1023,y[37]==23)),Not(Implies(u[38]>0,y[38]==y[37]+1)),Not(Implies(y[37]==1023,y[38]==23)),Not(Implies(u[39]>0,y[39]==y[38]+1)),Not(Implies(y[38]==1023,y[39]==23)),Not(Implies(u[40]>0,y[40]==y[39]+1)),Not(Implies(y[39]==1023,y[40]==23)),Not(Implies(u[41]>0,y[41]==y[40]+1)),Not(Implies(y[40]==1023,y[41]==23)),Not(Implies(u[42]>0,y[42]==y[41]+1)),Not(Implies(y[41]==1023,y[42]==23)),Not(Implies(u[43]>0,y[43]==y[42]+1)),Not(Implies(y[42]==1023,y[43]==23)),Not(Implies(u[44]>0,y[44]==y[43]+1)),Not(Implies(y[43]==1023,y[44]==23)),Not(Implies(u[45]>0,y[45]==y[44]+1)),Not(Implies(y[44]==1023,y[45]==23)),Not(Implies(u[46]>0,y[46]==y[45]+1)),Not(Implies(y[45]==1023,y[46]==23)),Not(Implies(u[47]>0,y[47]==y[46]+1)),Not(Implies(y[46]==1023,y[47]==23)),Not(Implies(u[48]>0,y[48]==y[47]+1)),Not(Implies(y[47]==1023,y[48]==23)),Not(Implies(u[49]>0,y[49]==y[48]+1)),Not(Implies(y[48]==1023,y[49]==23)),Not(Implies(u[50]>0,y[50]==y[49]+1)),Not(Implies(y[49]==1023,y[50]==23)),Not(Implies(u[51]>0,y[51]==y[50]+1)),Not(Implies(y[50]==1023,y[51]==23)),Not(Implies(u[52]>0,y[52]==y[51]+1)),Not(Implies(y[51]==1023,y[52]==23)),Not(Implies(u[53]>0,y[53]==y[52]+1)),Not(Implies(y[52]==1023,y[53]==23)),Not(Implies(u[54]>0,y[54]==y[53]+1)),Not(Implies(y[53]==1023,y[54]==23)),Not(Implies(u[55]>0,y[55]==y[54]+1)),Not(Implies(y[54]==1023,y[55]==23)),Not(Implies(u[56]>0,y[56]==y[55]+1)),Not(Implies(y[55]==1023,y[56]==23)),Not(Implies(u[57]>0,y[57]==y[56]+1)),Not(Implies(y[56]==1023,y[57]==23)),Not(Implies(u[58]>0,y[58]==y[57]+1)),Not(Implies(y[57]==1023,y[58]==23)),Not(Implies(u[59]>0,y[59]==y[58]+1)),Not(Implies(y[58]==1023,y[59]==23)),Not(Implies(u[60]>0,y[60]==y[59]+1)),Not(Implies(y[59]==1023,y[60]==23)),Not(Implies(u[61]>0,y[61]==y[60]+1)),Not(Implies(y[60]==1023,y[61]==23)),Not(Implies(u[62]>0,y[62]==y[61]+1)),Not(Implies(y[61]==1023,y[62]==23)),Not(Implies(u[63]>0,y[63]==y[62]+1)),Not(Implies(y[62]==1023,y[63]==23)),Not(Implies(u[64]>0,y[64]==y[63]+1)),Not(Implies(y[63]==1023,y[64]==23)),Not(Implies(u[65]>0,y[65]==y[64]+1)),Not(Implies(y[64]==1023,y[65]==23)),Not(Implies(u[66]>0,y[66]==y[65]+1)),Not(Implies(y[65]==1023,y[66]==23)),Not(Implies(u[67]>0,y[67]==y[66]+1)),Not(Implies(y[66]==1023,y[67]==23)),Not(Implies(u[68]>0,y[68]==y[67]+1)),Not(Implies(y[67]==1023,y[68]==23)),Not(Implies(u[69]>0,y[69]==y[68]+1)),Not(Implies(y[68]==1023,y[69]==23)),Not(Implies(u[70]>0,y[70]==y[69]+1)),Not(Implies(y[69]==1023,y[70]==23)),Not(Implies(u[71]>0,y[71]==y[70]+1)),Not(Implies(y[70]==1023,y[71]==23)),Not(Implies(u[72]>0,y[72]==y[71]+1)),Not(Implies(y[71]==1023,y[72]==23)),Not(Implies(u[73]>0,y[73]==y[72]+1)),Not(Implies(y[72]==1023,y[73]==23)),Not(Implies(u[74]>0,y[74]==y[73]+1)),Not(Implies(y[73]==1023,y[74]==23)),Not(Implies(u[75]>0,y[75]==y[74]+1)),Not(Implies(y[74]==1023,y[75]==23)),Not(Implies(u[76]>0,y[76]==y[75]+1)),Not(Implies(y[75]==1023,y[76]==23)),Not(Implies(u[77]>0,y[77]==y[76]+1)),Not(Implies(y[76]==1023,y[77]==23)),Not(Implies(u[78]>0,y[78]==y[77]+1)),Not(Implies(y[77]==1023,y[78]==23)),Not(Implies(u[79]>0,y[79]==y[78]+1)),Not(Implies(y[78]==1023,y[79]==23)),Not(Implies(u[80]>0,y[80]==y[79]+1)),Not(Implies(y[79]==1023,y[80]==23)),Not(Implies(u[81]>0,y[81]==y[80]+1)),Not(Implies(y[80]==1023,y[81]==23)),Not(Implies(u[82]>0,y[82]==y[81]+1)),Not(Implies(y[81]==1023,y[82]==23)),Not(Implies(u[83]>0,y[83]==y[82]+1)),Not(Implies(y[82]==1023,y[83]==23)),Not(Implies(u[84]>0,y[84]==y[83]+1)),Not(Implies(y[83]==1023,y[84]==23)),Not(Implies(u[85]>0,y[85]==y[84]+1)),Not(Implies(y[84]==1023,y[85]==23)),Not(Implies(u[86]>0,y[86]==y[85]+1)),Not(Implies(y[85]==1023,y[86]==23)),Not(Implies(u[87]>0,y[87]==y[86]+1)),Not(Implies(y[86]==1023,y[87]==23)),Not(Implies(u[88]>0,y[88]==y[87]+1)),Not(Implies(y[87]==1023,y[88]==23)),Not(Implies(u[89]>0,y[89]==y[88]+1)),Not(Implies(y[88]==1023,y[89]==23)),Not(Implies(u[90]>0,y[90]==y[89]+1)),Not(Implies(y[89]==1023,y[90]==23)),Not(Implies(u[91]>0,y[91]==y[90]+1)),Not(Implies(y[90]==1023,y[91]==23)),Not(Implies(u[92]>0,y[92]==y[91]+1)),Not(Implies(y[91]==1023,y[92]==23)),Not(Implies(u[93]>0,y[93]==y[92]+1)),Not(Implies(y[92]==1023,y[93]==23)),Not(Implies(u[94]>0,y[94]==y[93]+1)),Not(Implies(y[93]==1023,y[94]==23)),Not(Implies(u[95]>0,y[95]==y[94]+1)),Not(Implies(y[94]==1023,y[95]==23)),Not(Implies(u[96]>0,y[96]==y[95]+1)),Not(Implies(y[95]==1023,y[96]==23)),Not(Implies(u[97]>0,y[97]==y[96]+1)),Not(Implies(y[96]==1023,y[97]==23)),Not(Implies(u[98]>0,y[98]==y[97]+1)),Not(Implies(y[97]==1023,y[98]==23)),Not(Implies(u[99]>0,y[99]==y[98]+1)),Not(Implies(y[98]==1023,y[99]==23)))))))
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
