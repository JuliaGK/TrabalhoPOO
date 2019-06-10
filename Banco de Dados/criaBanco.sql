-- MySQL Script generated by MySQL Workbench
-- Fri Jun  7 17:21:20 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cursos` (
  `idCurso` INT NOT NULL AUTO_INCREMENT,
  `nomeCurso` VARCHAR(100) NULL,
  `observacoesCurso` TEXT NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Formularios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Formularios` (
  `idFormulario` INT NOT NULL AUTO_INCREMENT,
  `nomeProfessorFormulario` VARCHAR(100) NULL,
  `idCursoCoordenador` INT NOT NULL,
  `rgProfessorFormulario` VARCHAR(45) NULL,
  `cpfProfessorFormulario` VARCHAR(11) NULL,
  `cargoResponsavelFormulario` VARCHAR(45) NULL,
  `nomeResponsavelFormulario` VARCHAR(100) NULL,
  `rgResponsavelFormulario` VARCHAR(45) NULL,
  `cpfResponsavelFormulario` VARCHAR(11) NULL,
  `nomeEstudanteFormulario` VARCHAR(100) NULL,
  `nascimentoEstudanteFormulario` VARCHAR(10) NULL,
  `cpfEstudanteFormulario` VARCHAR(11) NULL,
  `rgEstudanteFormulario` VARCHAR(45) NULL,
  `logradouroEstudanteFormulario` VARCHAR(45) NULL,
  `enderecoEstudanteFormulario` VARCHAR(100) NULL,
  `complementoEstudanteFormulario` VARCHAR(45) NULL,
  `bairroEstudanteFormulario` VARCHAR(45) NULL,
  `cepEstudanteFormulario` VARCHAR(45) NULL,
  `cidadeEstudanteFormulario` VARCHAR(100) NULL,
  `ufEstudanteFormulario` VARCHAR(45) NULL,
  `idCursoEstudante` INT NOT NULL,
  `matriculaEstudanteFormulario` VARCHAR(45) NULL,
  `semestreEstudanteFormulario` INT NULL,
  `areaEstagioFormulario` VARCHAR(45) NULL,
  `tempoEstagioFormulario` VARCHAR(45) NULL,
  `inicioEstagioFormulario` DATE NULL,
  `finalEstagioFormulario` DATE NULL,
  `cargaHorarioEstagioFormulario` VARCHAR(10) NULL,
  `numeroApoliceEstagioFormulario` VARCHAR(45) NULL,
  `seguradorEstagioFormulario` VARCHAR(45) NULL,
  `supervisaoEstagioFormulario` VARCHAR(100) NULL,
  `siapSupervisorFormulario` VARCHAR(45) NULL,
  `orientadorEstagioFormulario` VARCHAR(100) NULL,
  `cargoOrientadorEstagioFormulario` VARCHAR(45) NULL,
  `atividadesEstagioFormulario` TEXT NULL,
  `dataPreenchimentoFormulario` DATE NULL,
  PRIMARY KEY (`idFormulario`),
  INDEX `fk_Formularios_Cursos_idx` (`idCursoCoordenador` ASC),
  INDEX `fk_Formularios_Cursos1_idx` (`idCursoEstudante` ASC),
  CONSTRAINT `fk_Formularios_Cursos`
    FOREIGN KEY (`idCursoCoordenador`)
    REFERENCES `mydb`.`Cursos` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Formularios_Cursos1`
    FOREIGN KEY (`idCursoEstudante`)
    REFERENCES `mydb`.`Cursos` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
