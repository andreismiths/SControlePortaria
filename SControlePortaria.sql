-- MySQL Script generated by MySQL Workbench
-- qua 26 jul 2017 10:04:10 UTC
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SControlePortaria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SControlePortaria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SControlePortaria` DEFAULT CHARACTER SET utf8 ;
USE `SControlePortaria` ;

-- -----------------------------------------------------
-- Table `SControlePortaria`.`Portaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SControlePortaria`.`Portaria` (
  `numeroPortaria` VARCHAR(45) NOT NULL,
  `ementaPortaria` VARCHAR(45) NOT NULL,
  `projetoPortaria` VARCHAR(45) NOT NULL,
  `tituloProjetoPortaria` VARCHAR(45) NOT NULL,
  `faculdadePortaria` VARCHAR(45) NOT NULL,
  `professorCoordenador` VARCHAR(45) NOT NULL,
  `siapeCoordenador` VARCHAR(45) NOT NULL,
  `inicioVigencia` DATE NOT NULL,
  `fimVigencia` DATE NOT NULL,
  `colaborador1` VARCHAR(45) NULL,
  `siapeColaborador1` VARCHAR(45) NULL,
  `colaborador2` VARCHAR(45) NULL,
  `siapeColaborador2` VARCHAR(45) NULL,
  `colaborador3` VARCHAR(45) NULL,
  `siapeColaborador3` VARCHAR(45) NULL,
  `statusPortaria` VARCHAR(45) NOT NULL,
  `PK_portaria` INT NOT NULL AUTO_INCREMENT,
  `relatorioProjeto` SET('ENTREGUE', 'PENDENTE') NOT NULL,
  PRIMARY KEY (`PK_portaria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SControlePortaria`.`RelatorioF`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SControlePortaria`.`RelatorioF` (
  `PK_relatorioF` INT NOT NULL AUTO_INCREMENT,
  `numeroDeProtocolo` VARCHAR(45) NOT NULL,
  `pesquisaExtensao` SET('PESQUISA', 'EXTENSÃO') NOT NULL,
  `relatorioFTituloDoProjeto` VARCHAR(45) NOT NULL,
  `relatorioFCoordenador` VARCHAR(45) NOT NULL,
  `memorandoDirecaoFaculdade` VARCHAR(45) NOT NULL,
  `ataReuniao` VARCHAR(45) NOT NULL,
  `relatorioFExecutadoFormatoProReitoria` VARCHAR(45) NOT NULL,
  `parecerRelatorioFinal` VARCHAR(45) NOT NULL,
  `dataRecebido` DATE NOT NULL,
  `assinaturaRespEntrega` VARCHAR(45) NOT NULL,
  `assinaturaRescRecebimento` VARCHAR(45) NOT NULL,
  `formacaoRecursosHumanosPesquisa` VARCHAR(45) NOT NULL,
  `contatosNacionaisInternacionais` VARCHAR(45) NOT NULL,
  `trabalhosPublicadosAceitos` VARCHAR(45) NOT NULL,
  `patenteRegistroInvencao` VARCHAR(45) NOT NULL,
  `atividadesCientificasAdministrativas` VARCHAR(45) NOT NULL,
  `contribuicaoPEnsinoGraduacao` VARCHAR(45) NOT NULL,
  `faculdadeRelatorioF` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PK_relatorioF`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SControlePortaria`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SControlePortaria`.`Funcionario` (
  `PK_funcionario` INT NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` VARCHAR(45) NULL,
  `siapeFuncionario` INT NULL,
  `cpfFuncionario` VARCHAR(45) NULL,
  `senhaFuncionario` VARCHAR(100) NULL,
  `dataNascimentoFuncionario` DATE NULL,
  `emailFuncionario` VARCHAR(45) NULL,
  `tipoFuncionario` VARCHAR(45) NULL,
  PRIMARY KEY (`PK_funcionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SControlePortaria`.`Funcionario_has_Portaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SControlePortaria`.`Funcionario_has_Portaria` (
  `PK_Funcionario_has_Portaria` INT NOT NULL AUTO_INCREMENT,
  `FK_funcionario` INT NOT NULL,
  `FK_portaria` INT NOT NULL,
  PRIMARY KEY (`PK_Funcionario_has_Portaria`, `FK_funcionario`, `FK_portaria`),
  INDEX `fk_Funcionario_has_Portaria_Portaria1_idx` (`FK_portaria` ASC),
  INDEX `fk_Funcionario_has_Portaria_Funcionario_idx` (`FK_funcionario` ASC),
  CONSTRAINT `fk_Funcionario_has_Portaria_Funcionario`
    FOREIGN KEY (`FK_funcionario`)
    REFERENCES `SControlePortaria`.`Funcionario` (`PK_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_has_Portaria_Portaria1`
    FOREIGN KEY (`FK_portaria`)
    REFERENCES `SControlePortaria`.`Portaria` (`PK_portaria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `SControlePortaria`.`Funcionario`
-- -----------------------------------------------------
START TRANSACTION;
USE `SControlePortaria`;
INSERT INTO `SControlePortaria`.`Funcionario` (`PK_funcionario`, `nomeFuncionario`, `siapeFuncionario`, `cpfFuncionario`, `senhaFuncionario`, `dataNascimentoFuncionario`, `emailFuncionario`, `tipoFuncionario`) VALUES (1, 'ANDREI SMITH', 666666, '111.111.111-11', '3dde1603316fbcf44b66e03ee279ec9f', '1994-01-07', 'andreismiths@hotmail.com', 'Administrador');

COMMIT;

