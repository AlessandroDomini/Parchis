# Parchis


CREATE TABLE `players` (
  `iduser` int(10) NOT NULL AUTO_INCREMENT,
  `User` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `token1` int(10) DEFAULT NULL,
  `token2` int(10) DEFAULT NULL,
  `token3` int(10) DEFAULT NULL,
  `token4` int(10) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1
