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
s.add(And(tau(1)-tau(0)==2.0,tau(2)-tau(1)==2.0,tau(3)-tau(2)==2.0,tau(4)-tau(3)==2.0,tau(5)-tau(4)==2.0,tau(6)-tau(5)==2.0,tau(7)-tau(6)==2.0,tau(8)-tau(7)==2.0,tau(9)-tau(8)==2.0,tau(10)-tau(9)==2.0,tau(11)-tau(10)==2.0,tau(12)-tau(11)==2.0,tau(13)-tau(12)==2.0,tau(14)-tau(13)==2.0,tau(15)-tau(14)==2.0,tau(16)-tau(15)==2.0,tau(17)-tau(16)==2.0,tau(18)-tau(17)==2.0,tau(19)-tau(18)==2.0,tau(20)-tau(19)==2.0,tau(21)-tau(20)==2.0,tau(22)-tau(21)==2.0,tau(23)-tau(22)==2.0,tau(24)-tau(23)==2.0,tau(25)-tau(24)==2.0,tau(26)-tau(25)==2.0,tau(27)-tau(26)==2.0,tau(28)-tau(27)==2.0,tau(29)-tau(28)==2.0,tau(30)-tau(29)==2.0,tau(31)-tau(30)==2.0,tau(32)-tau(31)==2.0,tau(33)-tau(32)==2.0,tau(34)-tau(33)==2.0,tau(35)-tau(34)==2.0,tau(36)-tau(35)==2.0,tau(37)-tau(36)==2.0,tau(38)-tau(37)==2.0,tau(39)-tau(38)==2.0,tau(40)-tau(39)==2.0,tau(41)-tau(40)==2.0,tau(42)-tau(41)==2.0,tau(43)-tau(42)==2.0,tau(44)-tau(43)==2.0,tau(45)-tau(44)==2.0,tau(46)-tau(45)==2.0,tau(47)-tau(46)==2.0,tau(48)-tau(47)==2.0,tau(49)-tau(48)==2.0,tau(50)-tau(49)==2.0,tau(51)-tau(50)==2.0,tau(52)-tau(51)==2.0,tau(53)-tau(52)==2.0,tau(54)-tau(53)==2.0,tau(55)-tau(54)==2.0,tau(56)-tau(55)==2.0,tau(57)-tau(56)==2.0,tau(58)-tau(57)==2.0,tau(59)-tau(58)==2.0,tau(60)-tau(59)==2.0,tau(61)-tau(60)==2.0,tau(62)-tau(61)==2.0,tau(63)-tau(62)==2.0,tau(64)-tau(63)==2.0,tau(65)-tau(64)==2.0,tau(66)-tau(65)==2.0,tau(67)-tau(66)==2.0,tau(68)-tau(67)==2.0,tau(69)-tau(68)==2.0,tau(70)-tau(69)==2.0,tau(71)-tau(70)==2.0,tau(72)-tau(71)==2.0,tau(73)-tau(72)==2.0,tau(74)-tau(73)==2.0,tau(75)-tau(74)==2.0,tau(76)-tau(75)==2.0,tau(77)-tau(76)==2.0,tau(78)-tau(77)==2.0,tau(79)-tau(78)==2.0,tau(80)-tau(79)==2.0,tau(81)-tau(80)==2.0,tau(82)-tau(81)==2.0,tau(83)-tau(82)==2.0,tau(84)-tau(83)==2.0,tau(85)-tau(84)==2.0,tau(86)-tau(85)==2.0,tau(87)-tau(86)==2.0,tau(88)-tau(87)==2.0,tau(89)-tau(88)==2.0,tau(90)-tau(89)==2.0,tau(91)-tau(90)==2.0,tau(92)-tau(91)==2.0,tau(93)-tau(92)==2.0,tau(94)-tau(93)==2.0,tau(95)-tau(94)==2.0,tau(96)-tau(95)==2.0,tau(97)-tau(96)==2.0,tau(98)-tau(97)==2.0,tau(99)-tau(98)==2.0,tau(100)-tau(99)==2.0,tau(101)-tau(100)==2.0,tau(102)-tau(101)==2.0,tau(103)-tau(102)==2.0,tau(104)-tau(103)==2.0,tau(105)-tau(104)==2.0,tau(106)-tau(105)==2.0,tau(107)-tau(106)==2.0,tau(108)-tau(107)==2.0,tau(109)-tau(108)==2.0,tau(110)-tau(109)==2.0,tau(111)-tau(110)==2.0,tau(112)-tau(111)==2.0,tau(113)-tau(112)==2.0,tau(114)-tau(113)==2.0,tau(115)-tau(114)==2.0,tau(116)-tau(115)==2.0,tau(117)-tau(116)==2.0,tau(118)-tau(117)==2.0,tau(119)-tau(118)==2.0,tau(120)-tau(119)==2.0,tau(121)-tau(120)==2.0,tau(122)-tau(121)==2.0,tau(123)-tau(122)==2.0,tau(124)-tau(123)==2.0,tau(125)-tau(124)==2.0,tau(126)-tau(125)==2.0,tau(127)-tau(126)==2.0,tau(128)-tau(127)==2.0,tau(129)-tau(128)==2.0,tau(130)-tau(129)==2.0,tau(131)-tau(130)==2.0,tau(132)-tau(131)==2.0,tau(133)-tau(132)==2.0,tau(134)-tau(133)==2.0,tau(135)-tau(134)==2.0,tau(136)-tau(135)==2.0,tau(137)-tau(136)==2.0,tau(138)-tau(137)==2.0,tau(139)-tau(138)==2.0,tau(140)-tau(139)==2.0,tau(141)-tau(140)==2.0,tau(142)-tau(141)==2.0,tau(143)-tau(142)==2.0,tau(144)-tau(143)==2.0,tau(145)-tau(144)==2.0,tau(146)-tau(145)==2.0,tau(147)-tau(146)==2.0,tau(148)-tau(147)==2.0,tau(149)-tau(148)==2.0,tau(150)-tau(149)==2.0,tau(151)-tau(150)==2.0,tau(152)-tau(151)==2.0,tau(153)-tau(152)==2.0,tau(154)-tau(153)==2.0,tau(155)-tau(154)==2.0,tau(156)-tau(155)==2.0,tau(157)-tau(156)==2.0,tau(158)-tau(157)==2.0,tau(159)-tau(158)==2.0,tau(160)-tau(159)==2.0,tau(161)-tau(160)==2.0,tau(162)-tau(161)==2.0,tau(163)-tau(162)==2.0,tau(164)-tau(163)==2.0,tau(165)-tau(164)==2.0,tau(166)-tau(165)==2.0,tau(167)-tau(166)==2.0,tau(168)-tau(167)==2.0,tau(169)-tau(168)==2.0,tau(170)-tau(169)==2.0,tau(171)-tau(170)==2.0,tau(172)-tau(171)==2.0,tau(173)-tau(172)==2.0,tau(174)-tau(173)==2.0,tau(175)-tau(174)==2.0,tau(176)-tau(175)==2.0,tau(177)-tau(176)==2.0,tau(178)-tau(177)==2.0,tau(179)-tau(178)==2.0,tau(180)-tau(179)==2.0,tau(181)-tau(180)==2.0,tau(182)-tau(181)==2.0,tau(183)-tau(182)==2.0,tau(184)-tau(183)==2.0,tau(185)-tau(184)==2.0,tau(186)-tau(185)==2.0,tau(187)-tau(186)==2.0,tau(188)-tau(187)==2.0,tau(189)-tau(188)==2.0,tau(190)-tau(189)==2.0,tau(191)-tau(190)==2.0,tau(192)-tau(191)==2.0,tau(193)-tau(192)==2.0,tau(194)-tau(193)==2.0,tau(195)-tau(194)==2.0,tau(196)-tau(195)==2.0,tau(197)-tau(196)==2.0,tau(198)-tau(197)==2.0,tau(199)-tau(198)==2.0,tau(200)-tau(199)==2.0,tau(201)-tau(200)==2.0,tau(202)-tau(201)==2.0,tau(203)-tau(202)==2.0,tau(204)-tau(203)==2.0,tau(205)-tau(204)==2.0,tau(206)-tau(205)==2.0,tau(207)-tau(206)==2.0,tau(208)-tau(207)==2.0,tau(209)-tau(208)==2.0,tau(210)-tau(209)==2.0,tau(211)-tau(210)==2.0,tau(212)-tau(211)==2.0,tau(213)-tau(212)==2.0,tau(214)-tau(213)==2.0,tau(215)-tau(214)==2.0,tau(216)-tau(215)==2.0,tau(217)-tau(216)==2.0,tau(218)-tau(217)==2.0,tau(219)-tau(218)==2.0,tau(220)-tau(219)==2.0,tau(221)-tau(220)==2.0,tau(222)-tau(221)==2.0,tau(223)-tau(222)==2.0,tau(224)-tau(223)==2.0,tau(225)-tau(224)==2.0,tau(226)-tau(225)==2.0,tau(227)-tau(226)==2.0,tau(228)-tau(227)==2.0,tau(229)-tau(228)==2.0,tau(230)-tau(229)==2.0,tau(231)-tau(230)==2.0,tau(232)-tau(231)==2.0,tau(233)-tau(232)==2.0,tau(234)-tau(233)==2.0,tau(235)-tau(234)==2.0,tau(236)-tau(235)==2.0,tau(237)-tau(236)==2.0,tau(238)-tau(237)==2.0,tau(239)-tau(238)==2.0,tau(240)-tau(239)==2.0,tau(241)-tau(240)==2.0,tau(242)-tau(241)==2.0,tau(243)-tau(242)==2.0,tau(244)-tau(243)==2.0,tau(245)-tau(244)==2.0,tau(246)-tau(245)==2.0,tau(247)-tau(246)==2.0,tau(248)-tau(247)==2.0,tau(249)-tau(248)==2.0,tau(250)-tau(249)==2.0,tau(251)-tau(250)==2.0,tau(252)-tau(251)==2.0,tau(253)-tau(252)==2.0,tau(254)-tau(253)==2.0,tau(255)-tau(254)==2.0,tau(256)-tau(255)==2.0,tau(257)-tau(256)==2.0,tau(258)-tau(257)==2.0,tau(259)-tau(258)==2.0,tau(260)-tau(259)==2.0,tau(261)-tau(260)==2.0,tau(262)-tau(261)==2.0,tau(263)-tau(262)==2.0,tau(264)-tau(263)==2.0,tau(265)-tau(264)==2.0,tau(266)-tau(265)==2.0,tau(267)-tau(266)==2.0,tau(268)-tau(267)==2.0,tau(269)-tau(268)==2.0,tau(270)-tau(269)==2.0,tau(271)-tau(270)==2.0,tau(272)-tau(271)==2.0,tau(273)-tau(272)==2.0,tau(274)-tau(273)==2.0,tau(275)-tau(274)==2.0,tau(276)-tau(275)==2.0,tau(277)-tau(276)==2.0,tau(278)-tau(277)==2.0,tau(279)-tau(278)==2.0,tau(280)-tau(279)==2.0,tau(281)-tau(280)==2.0,tau(282)-tau(281)==2.0,tau(283)-tau(282)==2.0,tau(284)-tau(283)==2.0,tau(285)-tau(284)==2.0,tau(286)-tau(285)==2.0,tau(287)-tau(286)==2.0,tau(288)-tau(287)==2.0,tau(289)-tau(288)==2.0,tau(290)-tau(289)==2.0,tau(291)-tau(290)==2.0,tau(292)-tau(291)==2.0,tau(293)-tau(292)==2.0,tau(294)-tau(293)==2.0,tau(295)-tau(294)==2.0,tau(296)-tau(295)==2.0,tau(297)-tau(296)==2.0,tau(298)-tau(297)==2.0,tau(299)-tau(298)==2.0,tau(300)-tau(299)==2.0,tau(301)-tau(300)==2.0,tau(302)-tau(301)==2.0,tau(303)-tau(302)==2.0,tau(304)-tau(303)==2.0,tau(305)-tau(304)==2.0,tau(306)-tau(305)==2.0,tau(307)-tau(306)==2.0,tau(308)-tau(307)==2.0,tau(309)-tau(308)==2.0,tau(310)-tau(309)==2.0,tau(311)-tau(310)==2.0,tau(312)-tau(311)==2.0,tau(313)-tau(312)==2.0,tau(314)-tau(313)==2.0,tau(315)-tau(314)==2.0,tau(316)-tau(315)==2.0,tau(317)-tau(316)==2.0,tau(318)-tau(317)==2.0,tau(319)-tau(318)==2.0,tau(320)-tau(319)==2.0,tau(321)-tau(320)==2.0,tau(322)-tau(321)==2.0,tau(323)-tau(322)==2.0,tau(324)-tau(323)==2.0,tau(325)-tau(324)==2.0,tau(326)-tau(325)==2.0,tau(327)-tau(326)==2.0,tau(328)-tau(327)==2.0,tau(329)-tau(328)==2.0,tau(330)-tau(329)==2.0,tau(331)-tau(330)==2.0,tau(332)-tau(331)==2.0,tau(333)-tau(332)==2.0,tau(334)-tau(333)==2.0,tau(335)-tau(334)==2.0,tau(336)-tau(335)==2.0,tau(337)-tau(336)==2.0,tau(338)-tau(337)==2.0,tau(339)-tau(338)==2.0,tau(340)-tau(339)==2.0,tau(341)-tau(340)==2.0,tau(342)-tau(341)==2.0,tau(343)-tau(342)==2.0,tau(344)-tau(343)==2.0,tau(345)-tau(344)==2.0,tau(346)-tau(345)==2.0,tau(347)-tau(346)==2.0,tau(348)-tau(347)==2.0,tau(349)-tau(348)==2.0))
# Requirements Table
s.add(Or(And(Not(And(Not(True),u[0]>0)),Not(And(Not(True),y[0]==250)),Not(True)),And(Not(And(Not(False),u[1]>0)),Not(And(Not(False),y[0]==250)),Not(False)),And(Not(And(Not(False),u[2]>0)),Not(And(Not(False),y[1]==250)),Not(False)),And(Not(And(Not(False),u[3]>0)),Not(And(Not(False),y[2]==250)),Not(False)),And(Not(And(Not(False),u[4]>0)),Not(And(Not(False),y[3]==250)),Not(False)),And(Not(And(Not(False),u[5]>0)),Not(And(Not(False),y[4]==250)),Not(False)),And(Not(And(Not(False),u[6]>0)),Not(And(Not(False),y[5]==250)),Not(False)),And(Not(And(Not(False),u[7]>0)),Not(And(Not(False),y[6]==250)),Not(False)),And(Not(And(Not(False),u[8]>0)),Not(And(Not(False),y[7]==250)),Not(False)),And(Not(And(Not(False),u[9]>0)),Not(And(Not(False),y[8]==250)),Not(False)),And(Not(And(Not(False),u[10]>0)),Not(And(Not(False),y[9]==250)),Not(False)),And(Not(And(Not(False),u[11]>0)),Not(And(Not(False),y[10]==250)),Not(False)),And(Not(And(Not(False),u[12]>0)),Not(And(Not(False),y[11]==250)),Not(False)),And(Not(And(Not(False),u[13]>0)),Not(And(Not(False),y[12]==250)),Not(False)),And(Not(And(Not(False),u[14]>0)),Not(And(Not(False),y[13]==250)),Not(False)),And(Not(And(Not(False),u[15]>0)),Not(And(Not(False),y[14]==250)),Not(False)),And(Not(And(Not(False),u[16]>0)),Not(And(Not(False),y[15]==250)),Not(False)),And(Not(And(Not(False),u[17]>0)),Not(And(Not(False),y[16]==250)),Not(False)),And(Not(And(Not(False),u[18]>0)),Not(And(Not(False),y[17]==250)),Not(False)),And(Not(And(Not(False),u[19]>0)),Not(And(Not(False),y[18]==250)),Not(False)),And(Not(And(Not(False),u[20]>0)),Not(And(Not(False),y[19]==250)),Not(False)),And(Not(And(Not(False),u[21]>0)),Not(And(Not(False),y[20]==250)),Not(False)),And(Not(And(Not(False),u[22]>0)),Not(And(Not(False),y[21]==250)),Not(False)),And(Not(And(Not(False),u[23]>0)),Not(And(Not(False),y[22]==250)),Not(False)),And(Not(And(Not(False),u[24]>0)),Not(And(Not(False),y[23]==250)),Not(False)),And(Not(And(Not(False),u[25]>0)),Not(And(Not(False),y[24]==250)),Not(False)),And(Not(And(Not(False),u[26]>0)),Not(And(Not(False),y[25]==250)),Not(False)),And(Not(And(Not(False),u[27]>0)),Not(And(Not(False),y[26]==250)),Not(False)),And(Not(And(Not(False),u[28]>0)),Not(And(Not(False),y[27]==250)),Not(False)),And(Not(And(Not(False),u[29]>0)),Not(And(Not(False),y[28]==250)),Not(False)),And(Not(And(Not(False),u[30]>0)),Not(And(Not(False),y[29]==250)),Not(False)),And(Not(And(Not(False),u[31]>0)),Not(And(Not(False),y[30]==250)),Not(False)),And(Not(And(Not(False),u[32]>0)),Not(And(Not(False),y[31]==250)),Not(False)),And(Not(And(Not(False),u[33]>0)),Not(And(Not(False),y[32]==250)),Not(False)),And(Not(And(Not(False),u[34]>0)),Not(And(Not(False),y[33]==250)),Not(False)),And(Not(And(Not(False),u[35]>0)),Not(And(Not(False),y[34]==250)),Not(False)),And(Not(And(Not(False),u[36]>0)),Not(And(Not(False),y[35]==250)),Not(False)),And(Not(And(Not(False),u[37]>0)),Not(And(Not(False),y[36]==250)),Not(False)),And(Not(And(Not(False),u[38]>0)),Not(And(Not(False),y[37]==250)),Not(False)),And(Not(And(Not(False),u[39]>0)),Not(And(Not(False),y[38]==250)),Not(False)),And(Not(And(Not(False),u[40]>0)),Not(And(Not(False),y[39]==250)),Not(False)),And(Not(And(Not(False),u[41]>0)),Not(And(Not(False),y[40]==250)),Not(False)),And(Not(And(Not(False),u[42]>0)),Not(And(Not(False),y[41]==250)),Not(False)),And(Not(And(Not(False),u[43]>0)),Not(And(Not(False),y[42]==250)),Not(False)),And(Not(And(Not(False),u[44]>0)),Not(And(Not(False),y[43]==250)),Not(False)),And(Not(And(Not(False),u[45]>0)),Not(And(Not(False),y[44]==250)),Not(False)),And(Not(And(Not(False),u[46]>0)),Not(And(Not(False),y[45]==250)),Not(False)),And(Not(And(Not(False),u[47]>0)),Not(And(Not(False),y[46]==250)),Not(False)),And(Not(And(Not(False),u[48]>0)),Not(And(Not(False),y[47]==250)),Not(False)),And(Not(And(Not(False),u[49]>0)),Not(And(Not(False),y[48]==250)),Not(False)),And(Not(And(Not(False),u[50]>0)),Not(And(Not(False),y[49]==250)),Not(False)),And(Not(And(Not(False),u[51]>0)),Not(And(Not(False),y[50]==250)),Not(False)),And(Not(And(Not(False),u[52]>0)),Not(And(Not(False),y[51]==250)),Not(False)),And(Not(And(Not(False),u[53]>0)),Not(And(Not(False),y[52]==250)),Not(False)),And(Not(And(Not(False),u[54]>0)),Not(And(Not(False),y[53]==250)),Not(False)),And(Not(And(Not(False),u[55]>0)),Not(And(Not(False),y[54]==250)),Not(False)),And(Not(And(Not(False),u[56]>0)),Not(And(Not(False),y[55]==250)),Not(False)),And(Not(And(Not(False),u[57]>0)),Not(And(Not(False),y[56]==250)),Not(False)),And(Not(And(Not(False),u[58]>0)),Not(And(Not(False),y[57]==250)),Not(False)),And(Not(And(Not(False),u[59]>0)),Not(And(Not(False),y[58]==250)),Not(False)),And(Not(And(Not(False),u[60]>0)),Not(And(Not(False),y[59]==250)),Not(False)),And(Not(And(Not(False),u[61]>0)),Not(And(Not(False),y[60]==250)),Not(False)),And(Not(And(Not(False),u[62]>0)),Not(And(Not(False),y[61]==250)),Not(False)),And(Not(And(Not(False),u[63]>0)),Not(And(Not(False),y[62]==250)),Not(False)),And(Not(And(Not(False),u[64]>0)),Not(And(Not(False),y[63]==250)),Not(False)),And(Not(And(Not(False),u[65]>0)),Not(And(Not(False),y[64]==250)),Not(False)),And(Not(And(Not(False),u[66]>0)),Not(And(Not(False),y[65]==250)),Not(False)),And(Not(And(Not(False),u[67]>0)),Not(And(Not(False),y[66]==250)),Not(False)),And(Not(And(Not(False),u[68]>0)),Not(And(Not(False),y[67]==250)),Not(False)),And(Not(And(Not(False),u[69]>0)),Not(And(Not(False),y[68]==250)),Not(False)),And(Not(And(Not(False),u[70]>0)),Not(And(Not(False),y[69]==250)),Not(False)),And(Not(And(Not(False),u[71]>0)),Not(And(Not(False),y[70]==250)),Not(False)),And(Not(And(Not(False),u[72]>0)),Not(And(Not(False),y[71]==250)),Not(False)),And(Not(And(Not(False),u[73]>0)),Not(And(Not(False),y[72]==250)),Not(False)),And(Not(And(Not(False),u[74]>0)),Not(And(Not(False),y[73]==250)),Not(False)),And(Not(And(Not(False),u[75]>0)),Not(And(Not(False),y[74]==250)),Not(False)),And(Not(And(Not(False),u[76]>0)),Not(And(Not(False),y[75]==250)),Not(False)),And(Not(And(Not(False),u[77]>0)),Not(And(Not(False),y[76]==250)),Not(False)),And(Not(And(Not(False),u[78]>0)),Not(And(Not(False),y[77]==250)),Not(False)),And(Not(And(Not(False),u[79]>0)),Not(And(Not(False),y[78]==250)),Not(False)),And(Not(And(Not(False),u[80]>0)),Not(And(Not(False),y[79]==250)),Not(False)),And(Not(And(Not(False),u[81]>0)),Not(And(Not(False),y[80]==250)),Not(False)),And(Not(And(Not(False),u[82]>0)),Not(And(Not(False),y[81]==250)),Not(False)),And(Not(And(Not(False),u[83]>0)),Not(And(Not(False),y[82]==250)),Not(False)),And(Not(And(Not(False),u[84]>0)),Not(And(Not(False),y[83]==250)),Not(False)),And(Not(And(Not(False),u[85]>0)),Not(And(Not(False),y[84]==250)),Not(False)),And(Not(And(Not(False),u[86]>0)),Not(And(Not(False),y[85]==250)),Not(False)),And(Not(And(Not(False),u[87]>0)),Not(And(Not(False),y[86]==250)),Not(False)),And(Not(And(Not(False),u[88]>0)),Not(And(Not(False),y[87]==250)),Not(False)),And(Not(And(Not(False),u[89]>0)),Not(And(Not(False),y[88]==250)),Not(False)),And(Not(And(Not(False),u[90]>0)),Not(And(Not(False),y[89]==250)),Not(False)),And(Not(And(Not(False),u[91]>0)),Not(And(Not(False),y[90]==250)),Not(False)),And(Not(And(Not(False),u[92]>0)),Not(And(Not(False),y[91]==250)),Not(False)),And(Not(And(Not(False),u[93]>0)),Not(And(Not(False),y[92]==250)),Not(False)),And(Not(And(Not(False),u[94]>0)),Not(And(Not(False),y[93]==250)),Not(False)),And(Not(And(Not(False),u[95]>0)),Not(And(Not(False),y[94]==250)),Not(False)),And(Not(And(Not(False),u[96]>0)),Not(And(Not(False),y[95]==250)),Not(False)),And(Not(And(Not(False),u[97]>0)),Not(And(Not(False),y[96]==250)),Not(False)),And(Not(And(Not(False),u[98]>0)),Not(And(Not(False),y[97]==250)),Not(False)),And(Not(And(Not(False),u[99]>0)),Not(And(Not(False),y[98]==250)),Not(False)),And(Not(And(Not(False),u[100]>0)),Not(And(Not(False),y[99]==250)),Not(False)),And(Not(And(Not(False),u[101]>0)),Not(And(Not(False),y[100]==250)),Not(False)),And(Not(And(Not(False),u[102]>0)),Not(And(Not(False),y[101]==250)),Not(False)),And(Not(And(Not(False),u[103]>0)),Not(And(Not(False),y[102]==250)),Not(False)),And(Not(And(Not(False),u[104]>0)),Not(And(Not(False),y[103]==250)),Not(False)),And(Not(And(Not(False),u[105]>0)),Not(And(Not(False),y[104]==250)),Not(False)),And(Not(And(Not(False),u[106]>0)),Not(And(Not(False),y[105]==250)),Not(False)),And(Not(And(Not(False),u[107]>0)),Not(And(Not(False),y[106]==250)),Not(False)),And(Not(And(Not(False),u[108]>0)),Not(And(Not(False),y[107]==250)),Not(False)),And(Not(And(Not(False),u[109]>0)),Not(And(Not(False),y[108]==250)),Not(False)),And(Not(And(Not(False),u[110]>0)),Not(And(Not(False),y[109]==250)),Not(False)),And(Not(And(Not(False),u[111]>0)),Not(And(Not(False),y[110]==250)),Not(False)),And(Not(And(Not(False),u[112]>0)),Not(And(Not(False),y[111]==250)),Not(False)),And(Not(And(Not(False),u[113]>0)),Not(And(Not(False),y[112]==250)),Not(False)),And(Not(And(Not(False),u[114]>0)),Not(And(Not(False),y[113]==250)),Not(False)),And(Not(And(Not(False),u[115]>0)),Not(And(Not(False),y[114]==250)),Not(False)),And(Not(And(Not(False),u[116]>0)),Not(And(Not(False),y[115]==250)),Not(False)),And(Not(And(Not(False),u[117]>0)),Not(And(Not(False),y[116]==250)),Not(False)),And(Not(And(Not(False),u[118]>0)),Not(And(Not(False),y[117]==250)),Not(False)),And(Not(And(Not(False),u[119]>0)),Not(And(Not(False),y[118]==250)),Not(False)),And(Not(And(Not(False),u[120]>0)),Not(And(Not(False),y[119]==250)),Not(False)),And(Not(And(Not(False),u[121]>0)),Not(And(Not(False),y[120]==250)),Not(False)),And(Not(And(Not(False),u[122]>0)),Not(And(Not(False),y[121]==250)),Not(False)),And(Not(And(Not(False),u[123]>0)),Not(And(Not(False),y[122]==250)),Not(False)),And(Not(And(Not(False),u[124]>0)),Not(And(Not(False),y[123]==250)),Not(False)),And(Not(And(Not(False),u[125]>0)),Not(And(Not(False),y[124]==250)),Not(False)),And(Not(And(Not(False),u[126]>0)),Not(And(Not(False),y[125]==250)),Not(False)),And(Not(And(Not(False),u[127]>0)),Not(And(Not(False),y[126]==250)),Not(False)),And(Not(And(Not(False),u[128]>0)),Not(And(Not(False),y[127]==250)),Not(False)),And(Not(And(Not(False),u[129]>0)),Not(And(Not(False),y[128]==250)),Not(False)),And(Not(And(Not(False),u[130]>0)),Not(And(Not(False),y[129]==250)),Not(False)),And(Not(And(Not(False),u[131]>0)),Not(And(Not(False),y[130]==250)),Not(False)),And(Not(And(Not(False),u[132]>0)),Not(And(Not(False),y[131]==250)),Not(False)),And(Not(And(Not(False),u[133]>0)),Not(And(Not(False),y[132]==250)),Not(False)),And(Not(And(Not(False),u[134]>0)),Not(And(Not(False),y[133]==250)),Not(False)),And(Not(And(Not(False),u[135]>0)),Not(And(Not(False),y[134]==250)),Not(False)),And(Not(And(Not(False),u[136]>0)),Not(And(Not(False),y[135]==250)),Not(False)),And(Not(And(Not(False),u[137]>0)),Not(And(Not(False),y[136]==250)),Not(False)),And(Not(And(Not(False),u[138]>0)),Not(And(Not(False),y[137]==250)),Not(False)),And(Not(And(Not(False),u[139]>0)),Not(And(Not(False),y[138]==250)),Not(False)),And(Not(And(Not(False),u[140]>0)),Not(And(Not(False),y[139]==250)),Not(False)),And(Not(And(Not(False),u[141]>0)),Not(And(Not(False),y[140]==250)),Not(False)),And(Not(And(Not(False),u[142]>0)),Not(And(Not(False),y[141]==250)),Not(False)),And(Not(And(Not(False),u[143]>0)),Not(And(Not(False),y[142]==250)),Not(False)),And(Not(And(Not(False),u[144]>0)),Not(And(Not(False),y[143]==250)),Not(False)),And(Not(And(Not(False),u[145]>0)),Not(And(Not(False),y[144]==250)),Not(False)),And(Not(And(Not(False),u[146]>0)),Not(And(Not(False),y[145]==250)),Not(False)),And(Not(And(Not(False),u[147]>0)),Not(And(Not(False),y[146]==250)),Not(False)),And(Not(And(Not(False),u[148]>0)),Not(And(Not(False),y[147]==250)),Not(False)),And(Not(And(Not(False),u[149]>0)),Not(And(Not(False),y[148]==250)),Not(False)),And(Not(And(Not(False),u[150]>0)),Not(And(Not(False),y[149]==250)),Not(False)),And(Not(And(Not(False),u[151]>0)),Not(And(Not(False),y[150]==250)),Not(False)),And(Not(And(Not(False),u[152]>0)),Not(And(Not(False),y[151]==250)),Not(False)),And(Not(And(Not(False),u[153]>0)),Not(And(Not(False),y[152]==250)),Not(False)),And(Not(And(Not(False),u[154]>0)),Not(And(Not(False),y[153]==250)),Not(False)),And(Not(And(Not(False),u[155]>0)),Not(And(Not(False),y[154]==250)),Not(False)),And(Not(And(Not(False),u[156]>0)),Not(And(Not(False),y[155]==250)),Not(False)),And(Not(And(Not(False),u[157]>0)),Not(And(Not(False),y[156]==250)),Not(False)),And(Not(And(Not(False),u[158]>0)),Not(And(Not(False),y[157]==250)),Not(False)),And(Not(And(Not(False),u[159]>0)),Not(And(Not(False),y[158]==250)),Not(False)),And(Not(And(Not(False),u[160]>0)),Not(And(Not(False),y[159]==250)),Not(False)),And(Not(And(Not(False),u[161]>0)),Not(And(Not(False),y[160]==250)),Not(False)),And(Not(And(Not(False),u[162]>0)),Not(And(Not(False),y[161]==250)),Not(False)),And(Not(And(Not(False),u[163]>0)),Not(And(Not(False),y[162]==250)),Not(False)),And(Not(And(Not(False),u[164]>0)),Not(And(Not(False),y[163]==250)),Not(False)),And(Not(And(Not(False),u[165]>0)),Not(And(Not(False),y[164]==250)),Not(False)),And(Not(And(Not(False),u[166]>0)),Not(And(Not(False),y[165]==250)),Not(False)),And(Not(And(Not(False),u[167]>0)),Not(And(Not(False),y[166]==250)),Not(False)),And(Not(And(Not(False),u[168]>0)),Not(And(Not(False),y[167]==250)),Not(False)),And(Not(And(Not(False),u[169]>0)),Not(And(Not(False),y[168]==250)),Not(False)),And(Not(And(Not(False),u[170]>0)),Not(And(Not(False),y[169]==250)),Not(False)),And(Not(And(Not(False),u[171]>0)),Not(And(Not(False),y[170]==250)),Not(False)),And(Not(And(Not(False),u[172]>0)),Not(And(Not(False),y[171]==250)),Not(False)),And(Not(And(Not(False),u[173]>0)),Not(And(Not(False),y[172]==250)),Not(False)),And(Not(And(Not(False),u[174]>0)),Not(And(Not(False),y[173]==250)),Not(False)),And(Not(And(Not(False),u[175]>0)),Not(And(Not(False),y[174]==250)),Not(False)),And(Not(And(Not(False),u[176]>0)),Not(And(Not(False),y[175]==250)),Not(False)),And(Not(And(Not(False),u[177]>0)),Not(And(Not(False),y[176]==250)),Not(False)),And(Not(And(Not(False),u[178]>0)),Not(And(Not(False),y[177]==250)),Not(False)),And(Not(And(Not(False),u[179]>0)),Not(And(Not(False),y[178]==250)),Not(False)),And(Not(And(Not(False),u[180]>0)),Not(And(Not(False),y[179]==250)),Not(False)),And(Not(And(Not(False),u[181]>0)),Not(And(Not(False),y[180]==250)),Not(False)),And(Not(And(Not(False),u[182]>0)),Not(And(Not(False),y[181]==250)),Not(False)),And(Not(And(Not(False),u[183]>0)),Not(And(Not(False),y[182]==250)),Not(False)),And(Not(And(Not(False),u[184]>0)),Not(And(Not(False),y[183]==250)),Not(False)),And(Not(And(Not(False),u[185]>0)),Not(And(Not(False),y[184]==250)),Not(False)),And(Not(And(Not(False),u[186]>0)),Not(And(Not(False),y[185]==250)),Not(False)),And(Not(And(Not(False),u[187]>0)),Not(And(Not(False),y[186]==250)),Not(False)),And(Not(And(Not(False),u[188]>0)),Not(And(Not(False),y[187]==250)),Not(False)),And(Not(And(Not(False),u[189]>0)),Not(And(Not(False),y[188]==250)),Not(False)),And(Not(And(Not(False),u[190]>0)),Not(And(Not(False),y[189]==250)),Not(False)),And(Not(And(Not(False),u[191]>0)),Not(And(Not(False),y[190]==250)),Not(False)),And(Not(And(Not(False),u[192]>0)),Not(And(Not(False),y[191]==250)),Not(False)),And(Not(And(Not(False),u[193]>0)),Not(And(Not(False),y[192]==250)),Not(False)),And(Not(And(Not(False),u[194]>0)),Not(And(Not(False),y[193]==250)),Not(False)),And(Not(And(Not(False),u[195]>0)),Not(And(Not(False),y[194]==250)),Not(False)),And(Not(And(Not(False),u[196]>0)),Not(And(Not(False),y[195]==250)),Not(False)),And(Not(And(Not(False),u[197]>0)),Not(And(Not(False),y[196]==250)),Not(False)),And(Not(And(Not(False),u[198]>0)),Not(And(Not(False),y[197]==250)),Not(False)),And(Not(And(Not(False),u[199]>0)),Not(And(Not(False),y[198]==250)),Not(False)),And(Not(And(Not(False),u[200]>0)),Not(And(Not(False),y[199]==250)),Not(False)),And(Not(And(Not(False),u[201]>0)),Not(And(Not(False),y[200]==250)),Not(False)),And(Not(And(Not(False),u[202]>0)),Not(And(Not(False),y[201]==250)),Not(False)),And(Not(And(Not(False),u[203]>0)),Not(And(Not(False),y[202]==250)),Not(False)),And(Not(And(Not(False),u[204]>0)),Not(And(Not(False),y[203]==250)),Not(False)),And(Not(And(Not(False),u[205]>0)),Not(And(Not(False),y[204]==250)),Not(False)),And(Not(And(Not(False),u[206]>0)),Not(And(Not(False),y[205]==250)),Not(False)),And(Not(And(Not(False),u[207]>0)),Not(And(Not(False),y[206]==250)),Not(False)),And(Not(And(Not(False),u[208]>0)),Not(And(Not(False),y[207]==250)),Not(False)),And(Not(And(Not(False),u[209]>0)),Not(And(Not(False),y[208]==250)),Not(False)),And(Not(And(Not(False),u[210]>0)),Not(And(Not(False),y[209]==250)),Not(False)),And(Not(And(Not(False),u[211]>0)),Not(And(Not(False),y[210]==250)),Not(False)),And(Not(And(Not(False),u[212]>0)),Not(And(Not(False),y[211]==250)),Not(False)),And(Not(And(Not(False),u[213]>0)),Not(And(Not(False),y[212]==250)),Not(False)),And(Not(And(Not(False),u[214]>0)),Not(And(Not(False),y[213]==250)),Not(False)),And(Not(And(Not(False),u[215]>0)),Not(And(Not(False),y[214]==250)),Not(False)),And(Not(And(Not(False),u[216]>0)),Not(And(Not(False),y[215]==250)),Not(False)),And(Not(And(Not(False),u[217]>0)),Not(And(Not(False),y[216]==250)),Not(False)),And(Not(And(Not(False),u[218]>0)),Not(And(Not(False),y[217]==250)),Not(False)),And(Not(And(Not(False),u[219]>0)),Not(And(Not(False),y[218]==250)),Not(False)),And(Not(And(Not(False),u[220]>0)),Not(And(Not(False),y[219]==250)),Not(False)),And(Not(And(Not(False),u[221]>0)),Not(And(Not(False),y[220]==250)),Not(False)),And(Not(And(Not(False),u[222]>0)),Not(And(Not(False),y[221]==250)),Not(False)),And(Not(And(Not(False),u[223]>0)),Not(And(Not(False),y[222]==250)),Not(False)),And(Not(And(Not(False),u[224]>0)),Not(And(Not(False),y[223]==250)),Not(False)),And(Not(And(Not(False),u[225]>0)),Not(And(Not(False),y[224]==250)),Not(False)),And(Not(And(Not(False),u[226]>0)),Not(And(Not(False),y[225]==250)),Not(False)),And(Not(And(Not(False),u[227]>0)),Not(And(Not(False),y[226]==250)),Not(False)),And(Not(And(Not(False),u[228]>0)),Not(And(Not(False),y[227]==250)),Not(False)),And(Not(And(Not(False),u[229]>0)),Not(And(Not(False),y[228]==250)),Not(False)),And(Not(And(Not(False),u[230]>0)),Not(And(Not(False),y[229]==250)),Not(False)),And(Not(And(Not(False),u[231]>0)),Not(And(Not(False),y[230]==250)),Not(False)),And(Not(And(Not(False),u[232]>0)),Not(And(Not(False),y[231]==250)),Not(False)),And(Not(And(Not(False),u[233]>0)),Not(And(Not(False),y[232]==250)),Not(False)),And(Not(And(Not(False),u[234]>0)),Not(And(Not(False),y[233]==250)),Not(False)),And(Not(And(Not(False),u[235]>0)),Not(And(Not(False),y[234]==250)),Not(False)),And(Not(And(Not(False),u[236]>0)),Not(And(Not(False),y[235]==250)),Not(False)),And(Not(And(Not(False),u[237]>0)),Not(And(Not(False),y[236]==250)),Not(False)),And(Not(And(Not(False),u[238]>0)),Not(And(Not(False),y[237]==250)),Not(False)),And(Not(And(Not(False),u[239]>0)),Not(And(Not(False),y[238]==250)),Not(False)),And(Not(And(Not(False),u[240]>0)),Not(And(Not(False),y[239]==250)),Not(False)),And(Not(And(Not(False),u[241]>0)),Not(And(Not(False),y[240]==250)),Not(False)),And(Not(And(Not(False),u[242]>0)),Not(And(Not(False),y[241]==250)),Not(False)),And(Not(And(Not(False),u[243]>0)),Not(And(Not(False),y[242]==250)),Not(False)),And(Not(And(Not(False),u[244]>0)),Not(And(Not(False),y[243]==250)),Not(False)),And(Not(And(Not(False),u[245]>0)),Not(And(Not(False),y[244]==250)),Not(False)),And(Not(And(Not(False),u[246]>0)),Not(And(Not(False),y[245]==250)),Not(False)),And(Not(And(Not(False),u[247]>0)),Not(And(Not(False),y[246]==250)),Not(False)),And(Not(And(Not(False),u[248]>0)),Not(And(Not(False),y[247]==250)),Not(False)),And(Not(And(Not(False),u[249]>0)),Not(And(Not(False),y[248]==250)),Not(False)),And(Not(And(Not(False),u[250]>0)),Not(And(Not(False),y[249]==250)),Not(False)),And(Not(And(Not(False),u[251]>0)),Not(And(Not(False),y[250]==250)),Not(False)),And(Not(And(Not(False),u[252]>0)),Not(And(Not(False),y[251]==250)),Not(False)),And(Not(And(Not(False),u[253]>0)),Not(And(Not(False),y[252]==250)),Not(False)),And(Not(And(Not(False),u[254]>0)),Not(And(Not(False),y[253]==250)),Not(False)),And(Not(And(Not(False),u[255]>0)),Not(And(Not(False),y[254]==250)),Not(False)),And(Not(And(Not(False),u[256]>0)),Not(And(Not(False),y[255]==250)),Not(False)),And(Not(And(Not(False),u[257]>0)),Not(And(Not(False),y[256]==250)),Not(False)),And(Not(And(Not(False),u[258]>0)),Not(And(Not(False),y[257]==250)),Not(False)),And(Not(And(Not(False),u[259]>0)),Not(And(Not(False),y[258]==250)),Not(False)),And(Not(And(Not(False),u[260]>0)),Not(And(Not(False),y[259]==250)),Not(False)),And(Not(And(Not(False),u[261]>0)),Not(And(Not(False),y[260]==250)),Not(False)),And(Not(And(Not(False),u[262]>0)),Not(And(Not(False),y[261]==250)),Not(False)),And(Not(And(Not(False),u[263]>0)),Not(And(Not(False),y[262]==250)),Not(False)),And(Not(And(Not(False),u[264]>0)),Not(And(Not(False),y[263]==250)),Not(False)),And(Not(And(Not(False),u[265]>0)),Not(And(Not(False),y[264]==250)),Not(False)),And(Not(And(Not(False),u[266]>0)),Not(And(Not(False),y[265]==250)),Not(False)),And(Not(And(Not(False),u[267]>0)),Not(And(Not(False),y[266]==250)),Not(False)),And(Not(And(Not(False),u[268]>0)),Not(And(Not(False),y[267]==250)),Not(False)),And(Not(And(Not(False),u[269]>0)),Not(And(Not(False),y[268]==250)),Not(False)),And(Not(And(Not(False),u[270]>0)),Not(And(Not(False),y[269]==250)),Not(False)),And(Not(And(Not(False),u[271]>0)),Not(And(Not(False),y[270]==250)),Not(False)),And(Not(And(Not(False),u[272]>0)),Not(And(Not(False),y[271]==250)),Not(False)),And(Not(And(Not(False),u[273]>0)),Not(And(Not(False),y[272]==250)),Not(False)),And(Not(And(Not(False),u[274]>0)),Not(And(Not(False),y[273]==250)),Not(False)),And(Not(And(Not(False),u[275]>0)),Not(And(Not(False),y[274]==250)),Not(False)),And(Not(And(Not(False),u[276]>0)),Not(And(Not(False),y[275]==250)),Not(False)),And(Not(And(Not(False),u[277]>0)),Not(And(Not(False),y[276]==250)),Not(False)),And(Not(And(Not(False),u[278]>0)),Not(And(Not(False),y[277]==250)),Not(False)),And(Not(And(Not(False),u[279]>0)),Not(And(Not(False),y[278]==250)),Not(False)),And(Not(And(Not(False),u[280]>0)),Not(And(Not(False),y[279]==250)),Not(False)),And(Not(And(Not(False),u[281]>0)),Not(And(Not(False),y[280]==250)),Not(False)),And(Not(And(Not(False),u[282]>0)),Not(And(Not(False),y[281]==250)),Not(False)),And(Not(And(Not(False),u[283]>0)),Not(And(Not(False),y[282]==250)),Not(False)),And(Not(And(Not(False),u[284]>0)),Not(And(Not(False),y[283]==250)),Not(False)),And(Not(And(Not(False),u[285]>0)),Not(And(Not(False),y[284]==250)),Not(False)),And(Not(And(Not(False),u[286]>0)),Not(And(Not(False),y[285]==250)),Not(False)),And(Not(And(Not(False),u[287]>0)),Not(And(Not(False),y[286]==250)),Not(False)),And(Not(And(Not(False),u[288]>0)),Not(And(Not(False),y[287]==250)),Not(False)),And(Not(And(Not(False),u[289]>0)),Not(And(Not(False),y[288]==250)),Not(False)),And(Not(And(Not(False),u[290]>0)),Not(And(Not(False),y[289]==250)),Not(False)),And(Not(And(Not(False),u[291]>0)),Not(And(Not(False),y[290]==250)),Not(False)),And(Not(And(Not(False),u[292]>0)),Not(And(Not(False),y[291]==250)),Not(False)),And(Not(And(Not(False),u[293]>0)),Not(And(Not(False),y[292]==250)),Not(False)),And(Not(And(Not(False),u[294]>0)),Not(And(Not(False),y[293]==250)),Not(False)),And(Not(And(Not(False),u[295]>0)),Not(And(Not(False),y[294]==250)),Not(False)),And(Not(And(Not(False),u[296]>0)),Not(And(Not(False),y[295]==250)),Not(False)),And(Not(And(Not(False),u[297]>0)),Not(And(Not(False),y[296]==250)),Not(False)),And(Not(And(Not(False),u[298]>0)),Not(And(Not(False),y[297]==250)),Not(False)),And(Not(And(Not(False),u[299]>0)),Not(And(Not(False),y[298]==250)),Not(False)),And(Not(And(Not(False),u[300]>0)),Not(And(Not(False),y[299]==250)),Not(False)),And(Not(And(Not(False),u[301]>0)),Not(And(Not(False),y[300]==250)),Not(False)),And(Not(And(Not(False),u[302]>0)),Not(And(Not(False),y[301]==250)),Not(False)),And(Not(And(Not(False),u[303]>0)),Not(And(Not(False),y[302]==250)),Not(False)),And(Not(And(Not(False),u[304]>0)),Not(And(Not(False),y[303]==250)),Not(False)),And(Not(And(Not(False),u[305]>0)),Not(And(Not(False),y[304]==250)),Not(False)),And(Not(And(Not(False),u[306]>0)),Not(And(Not(False),y[305]==250)),Not(False)),And(Not(And(Not(False),u[307]>0)),Not(And(Not(False),y[306]==250)),Not(False)),And(Not(And(Not(False),u[308]>0)),Not(And(Not(False),y[307]==250)),Not(False)),And(Not(And(Not(False),u[309]>0)),Not(And(Not(False),y[308]==250)),Not(False)),And(Not(And(Not(False),u[310]>0)),Not(And(Not(False),y[309]==250)),Not(False)),And(Not(And(Not(False),u[311]>0)),Not(And(Not(False),y[310]==250)),Not(False)),And(Not(And(Not(False),u[312]>0)),Not(And(Not(False),y[311]==250)),Not(False)),And(Not(And(Not(False),u[313]>0)),Not(And(Not(False),y[312]==250)),Not(False)),And(Not(And(Not(False),u[314]>0)),Not(And(Not(False),y[313]==250)),Not(False)),And(Not(And(Not(False),u[315]>0)),Not(And(Not(False),y[314]==250)),Not(False)),And(Not(And(Not(False),u[316]>0)),Not(And(Not(False),y[315]==250)),Not(False)),And(Not(And(Not(False),u[317]>0)),Not(And(Not(False),y[316]==250)),Not(False)),And(Not(And(Not(False),u[318]>0)),Not(And(Not(False),y[317]==250)),Not(False)),And(Not(And(Not(False),u[319]>0)),Not(And(Not(False),y[318]==250)),Not(False)),And(Not(And(Not(False),u[320]>0)),Not(And(Not(False),y[319]==250)),Not(False)),And(Not(And(Not(False),u[321]>0)),Not(And(Not(False),y[320]==250)),Not(False)),And(Not(And(Not(False),u[322]>0)),Not(And(Not(False),y[321]==250)),Not(False)),And(Not(And(Not(False),u[323]>0)),Not(And(Not(False),y[322]==250)),Not(False)),And(Not(And(Not(False),u[324]>0)),Not(And(Not(False),y[323]==250)),Not(False)),And(Not(And(Not(False),u[325]>0)),Not(And(Not(False),y[324]==250)),Not(False)),And(Not(And(Not(False),u[326]>0)),Not(And(Not(False),y[325]==250)),Not(False)),And(Not(And(Not(False),u[327]>0)),Not(And(Not(False),y[326]==250)),Not(False)),And(Not(And(Not(False),u[328]>0)),Not(And(Not(False),y[327]==250)),Not(False)),And(Not(And(Not(False),u[329]>0)),Not(And(Not(False),y[328]==250)),Not(False)),And(Not(And(Not(False),u[330]>0)),Not(And(Not(False),y[329]==250)),Not(False)),And(Not(And(Not(False),u[331]>0)),Not(And(Not(False),y[330]==250)),Not(False)),And(Not(And(Not(False),u[332]>0)),Not(And(Not(False),y[331]==250)),Not(False)),And(Not(And(Not(False),u[333]>0)),Not(And(Not(False),y[332]==250)),Not(False)),And(Not(And(Not(False),u[334]>0)),Not(And(Not(False),y[333]==250)),Not(False)),And(Not(And(Not(False),u[335]>0)),Not(And(Not(False),y[334]==250)),Not(False)),And(Not(And(Not(False),u[336]>0)),Not(And(Not(False),y[335]==250)),Not(False)),And(Not(And(Not(False),u[337]>0)),Not(And(Not(False),y[336]==250)),Not(False)),And(Not(And(Not(False),u[338]>0)),Not(And(Not(False),y[337]==250)),Not(False)),And(Not(And(Not(False),u[339]>0)),Not(And(Not(False),y[338]==250)),Not(False)),And(Not(And(Not(False),u[340]>0)),Not(And(Not(False),y[339]==250)),Not(False)),And(Not(And(Not(False),u[341]>0)),Not(And(Not(False),y[340]==250)),Not(False)),And(Not(And(Not(False),u[342]>0)),Not(And(Not(False),y[341]==250)),Not(False)),And(Not(And(Not(False),u[343]>0)),Not(And(Not(False),y[342]==250)),Not(False)),And(Not(And(Not(False),u[344]>0)),Not(And(Not(False),y[343]==250)),Not(False)),And(Not(And(Not(False),u[345]>0)),Not(And(Not(False),y[344]==250)),Not(False)),And(Not(And(Not(False),u[346]>0)),Not(And(Not(False),y[345]==250)),Not(False)),And(Not(And(Not(False),u[347]>0)),Not(And(Not(False),y[346]==250)),Not(False)),And(Not(And(Not(False),u[348]>0)),Not(And(Not(False),y[347]==250)),Not(False)),And(Not(And(Not(False),u[349]>0)),Not(And(Not(False),y[348]==250)),Not(False)),And(Not(And(Not(False),u[350]>0)),Not(And(Not(False),y[349]==250)),Not(False))))
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