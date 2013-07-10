-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.5.27 - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para learning_jsf_maven_db
DROP DATABASE IF EXISTS `learning_jsf_maven_db`;
CREATE DATABASE IF NOT EXISTS `learning_jsf_maven_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `learning_jsf_maven_db`;


-- Copiando estrutura para tabela learning_jsf_maven_db.cidade
DROP TABLE IF EXISTS `cidade`;
CREATE TABLE IF NOT EXISTS `cidade` (
  `IdCidade` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(80) NOT NULL,
  PRIMARY KEY (`IdCidade`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela learning_jsf_maven_db.cidade: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` (`IdCidade`, `Nome`) VALUES
	(1, 'BRASILIA CIDADE DA CORRUPÇÃO'),
	(2, 'SÃO PAULO'),
	(3, 'CIDADE 1'),
	(4, 'CISADE 2'),
	(5, 'CISADE 3'),
	(6, 'CIDADE 4');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;


-- Copiando estrutura para tabela learning_jsf_maven_db.endereco
DROP TABLE IF EXISTS `endereco`;
CREATE TABLE IF NOT EXISTS `endereco` (
  `IdEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `Bairro` varchar(80) DEFAULT NULL,
  `CEP` varchar(9) DEFAULT NULL,
  `Complemento` varchar(50) DEFAULT NULL,
  `NomeLogradouro` varchar(80) DEFAULT NULL,
  `Numero` int(11) DEFAULT NULL,
  `IdCidade` int(11) NOT NULL,
  `IdEstado` int(11) NOT NULL,
  `IdPessoa` int(11) DEFAULT NULL,
  `IdTipoEndereco` int(11) NOT NULL,
  `IdTipoLogradouro` int(11) NOT NULL,
  PRIMARY KEY (`IdEndereco`),
  KEY `Endereco_TipoLogradouro` (`IdTipoLogradouro`),
  KEY `EnderecoCidade` (`IdCidade`),
  KEY `Endereco_TipoEndereco` (`IdTipoEndereco`),
  KEY `Endereco_Estado` (`IdEstado`),
  KEY `EnderecoPessoa` (`IdPessoa`),
  CONSTRAINT `EnderecoCidade` FOREIGN KEY (`IdCidade`) REFERENCES `cidade` (`IdCidade`),
  CONSTRAINT `EnderecoPessoa` FOREIGN KEY (`IdPessoa`) REFERENCES `pessoa` (`IdPessoa`),
  CONSTRAINT `Endereco_Estado` FOREIGN KEY (`IdEstado`) REFERENCES `estado` (`IdEstado`),
  CONSTRAINT `Endereco_TipoEndereco` FOREIGN KEY (`IdTipoEndereco`) REFERENCES `tipoendereco` (`IdTipoEndereco`),
  CONSTRAINT `Endereco_TipoLogradouro` FOREIGN KEY (`IdTipoLogradouro`) REFERENCES `tipologradouro` (`IdTipoLogradouro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela learning_jsf_maven_db.endereco: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` (`IdEndereco`, `Bairro`, `CEP`, `Complemento`, `NomeLogradouro`, `Numero`, `IdCidade`, `IdEstado`, `IdPessoa`, `IdTipoEndereco`, `IdTipoLogradouro`) VALUES
	(1, 'TESTE', '11111-111', '0', 'ALEGRIA', 11, 1, 1, 2, 1, 1),
	(2, 'SINCITY', '11111-111', '2', 'CORRUPÇÃO', 99999, 1, 1, 3, 1, 5),
	(3, 'TESTE', '11111-111', '111', 'TESTE DO TESTE', 111, 1, 1, 6, 1, 1);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;


-- Copiando estrutura para tabela learning_jsf_maven_db.estado
DROP TABLE IF EXISTS `estado`;
CREATE TABLE IF NOT EXISTS `estado` (
  `IdEstado` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(40) NOT NULL,
  PRIMARY KEY (`IdEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela learning_jsf_maven_db.estado: ~27 rows (aproximadamente)
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` (`IdEstado`, `Nome`) VALUES
	(1, 'ACRE'),
	(2, 'ALAGOAS'),
	(3, 'AMAZONAS'),
	(4, 'AMAPÁ'),
	(5, 'BAHIA'),
	(6, 'CEARÁ'),
	(7, 'DISTRITO FEDERAL'),
	(8, 'ESPÍRITO SANTO'),
	(9, 'GOIÁS'),
	(10, 'MARANHÃO'),
	(11, 'MINAS GERAIS'),
	(12, 'MATO GROSSO DO SUL'),
	(13, 'MATO GROSSO'),
	(14, 'PARÁ'),
	(15, 'PARAÍBA'),
	(16, 'PERNAMBUCO'),
	(17, 'PIAUÍ'),
	(18, 'PARANÁ'),
	(19, 'RIO DE JANEIRO'),
	(20, 'RIO GRANDE DO NORTE'),
	(21, 'RORAIMA'),
	(22, 'RONDÔNIA'),
	(23, 'RIO GRANDE DO SUL'),
	(24, 'SANTA CATARINA'),
	(25, 'SERGIPE'),
	(26, 'SÃO PAULO'),
	(27, 'TOCANTINS');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;


-- Copiando estrutura para tabela learning_jsf_maven_db.pessoa
DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `IdPessoa` int(11) NOT NULL AUTO_INCREMENT,
  `CPF` varchar(14) NOT NULL,
  `DataDeCadastro` date NOT NULL,
  `DataDeNascimento` date NOT NULL,
  `Email` varchar(80) NOT NULL,
  `Name` varchar(80) NOT NULL,
  `Telefone` varchar(15) NOT NULL,
  `IdSexo` int(11) NOT NULL,
  `Login` varchar(25) DEFAULT NULL,
  `Permissao` varchar(36) DEFAULT NULL,
  `Senha` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`IdPessoa`),
  UNIQUE KEY `Login` (`Login`),
  KEY `PessoaSexo` (`IdSexo`),
  CONSTRAINT `PessoaSexo` FOREIGN KEY (`IdSexo`) REFERENCES `sexo` (`IdSexo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela learning_jsf_maven_db.pessoa: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` (`IdPessoa`, `CPF`, `DataDeCadastro`, `DataDeNascimento`, `Email`, `Name`, `Telefone`, `IdSexo`, `Login`, `Permissao`, `Senha`) VALUES
	(2, '49837218606', '2013-06-26', '2013-06-04', 'a@g.b', 'PYTHON', '(11) 1111-1111', 1, 'admin', 'admin', 'd4e8e6deaa7b1f8381e09e3e6b83e36f0b681c5c'),
	(3, '27485587404', '2013-06-27', '2003-06-01', 'eva@eva.devil', 'EVA GINA', '(11) 11111-1111', 1, 'eva#1apecadora', 'admin', ''),
	(6, '31886137170', '2013-07-01', '2004-07-01', 'a@b.c', 'TESTE', '(11) 11111-1111', 1, 'teste!@#123', NULL, 'teste!@#123');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;


-- Copiando estrutura para tabela learning_jsf_maven_db.sexo
DROP TABLE IF EXISTS `sexo`;
CREATE TABLE IF NOT EXISTS `sexo` (
  `IdSexo` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(9) NOT NULL,
  PRIMARY KEY (`IdSexo`),
  UNIQUE KEY `Descricao` (`Descricao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela learning_jsf_maven_db.sexo: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` (`IdSexo`, `Descricao`) VALUES
	(1, 'Feminino'),
	(2, 'Masculino');
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;


-- Copiando estrutura para tabela learning_jsf_maven_db.tipoendereco
DROP TABLE IF EXISTS `tipoendereco`;
CREATE TABLE IF NOT EXISTS `tipoendereco` (
  `IdTipoEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(35) NOT NULL,
  PRIMARY KEY (`IdTipoEndereco`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela learning_jsf_maven_db.tipoendereco: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `tipoendereco` DISABLE KEYS */;
INSERT INTO `tipoendereco` (`IdTipoEndereco`, `Nome`) VALUES
	(1, 'RESIDENCIAL'),
	(2, 'COMERCIAL'),
	(3, 'RODOVIA'),
	(4, 'FAZENDA'),
	(5, 'INDÚSTRIA'),
	(6, 'CHÁCARA'),
	(7, 'VILA');
/*!40000 ALTER TABLE `tipoendereco` ENABLE KEYS */;


-- Copiando estrutura para tabela learning_jsf_maven_db.tipologradouro
DROP TABLE IF EXISTS `tipologradouro`;
CREATE TABLE IF NOT EXISTS `tipologradouro` (
  `IdTipoLogradouro` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(40) NOT NULL,
  PRIMARY KEY (`IdTipoLogradouro`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela learning_jsf_maven_db.tipologradouro: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `tipologradouro` DISABLE KEYS */;
INSERT INTO `tipologradouro` (`IdTipoLogradouro`, `Nome`) VALUES
	(1, 'RUA'),
	(2, 'ALAMEDA'),
	(3, 'AVENIDA'),
	(4, 'VIELA'),
	(5, 'BECO'),
	(6, 'TRAVESSA'),
	(7, 'PRAÇA');
/*!40000 ALTER TABLE `tipologradouro` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
