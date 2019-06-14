SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuarios`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `mydb`.`Usuarios` (
  `codigoUsuario` INT NOT NULL AUTO_INCREMENT,
  `loginUsuario` VARCHAR(45) NULL,
  `senhaUsuario` VARCHAR(45) NULL,
  PRIMARY KEY (`codigoUsuario`));

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
  `cpfProfessorFormulario` VARCHAR(14) NULL,
  `cargoResponsavelFormulario` VARCHAR(45) NULL,
  `nomeResponsavelFormulario` VARCHAR(100) NULL,
  `rgResponsavelFormulario` VARCHAR(45) NULL,
  `cpfResponsavelFormulario` VARCHAR(14) NULL,
  `nomeEstudanteFormulario` VARCHAR(100) NULL,
  `nascimentoEstudanteFormulario` VARCHAR(10) NULL,
  `cpfEstudanteFormulario` VARCHAR(14) NULL,
  `rgEstudanteFormulario` VARCHAR(45) NULL,
  `logradouroEstudanteFormulario` VARCHAR(45) NULL,
  `enderecoEstudanteFormulario` VARCHAR(100) NULL,
  `complementoEstudanteFormulario` VARCHAR(45) NULL,
  `bairroEstudanteFormulario` VARCHAR(45) NULL,
  `cepEstudanteFormulario` VARCHAR(9) NULL,
  `cidadeEstudanteFormulario` VARCHAR(100) NULL,
  `ufEstudanteFormulario` VARCHAR(45) NULL,
  `idCursoEstudante` INT NOT NULL,
  `matriculaEstudanteFormulario` VARCHAR(45) NULL,
  `semestreEstudanteFormulario` INT NULL,
  `areaEstagioFormulario` VARCHAR(45) NULL,
  `tempoEstagioFormulario` VARCHAR(45) NULL,
  `inicioEstagioFormulario` VARCHAR(10) NULL,
  `finalEstagioFormulario` VARCHAR(10) NULL,
  `cargaHorarioEstagioFormulario` VARCHAR(10) NULL,
  `numeroApoliceEstagioFormulario` VARCHAR(45) NULL,
  `seguradorEstagioFormulario` VARCHAR(45) NULL,
  `supervisaoEstagioFormulario` VARCHAR(100) NULL,
  `siapSupervisorFormulario` VARCHAR(45) NULL,
  `orientadorEstagioFormulario` VARCHAR(100) NULL,
  `cargoOrientadorEstagioFormulario` VARCHAR(45) NULL,
  `atividadesEstagioFormulario` TEXT NULL,
  `dataPreenchimentoFormulario` VARCHAR(10) NULL,
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

-- -------------------------------------------------
-- Insere cursos
-- -------------------------------------------------
INSERT INTO cursos VALUES (null,'Biomedicina Diurno', null);
INSERT INTO cursos VALUES (null,'Biomedicina Noturno', null);
INSERT INTO cursos VALUES (null,'Enfermagem', null);
INSERT INTO cursos VALUES (null,'Farmácia', null);
INSERT INTO cursos VALUES (null,'Física Médica', null);
INSERT INTO cursos VALUES (null,'Fisioterapia', null);
INSERT INTO cursos VALUES (null,'Fonoaudiologia', null);
INSERT INTO cursos VALUES (null,'Gastronomia', null);
INSERT INTO cursos VALUES (null,'Gestão em Saúde', null);
INSERT INTO cursos VALUES (null,'Informática Biomédica', 'Melhor curso da universidade.');
INSERT INTO cursos VALUES (null,'Medicina', null);
INSERT INTO cursos VALUES (null,'Nutrição', null);
INSERT INTO cursos VALUES (null,'Psicologia', null);
INSERT INTO cursos VALUES (null,'Química Medicinal', null);
INSERT INTO cursos VALUES (null,'Tecnologia de Alimentos', null);
INSERT INTO cursos VALUES (null,'Toxicologia Analítica', null);

-- ----------------------------------------------------------
-- Insere login e senha
-- ----------------------------------------------------------
INSERT INTO usuarios VALUES (null, 'admin', 'admin');

-- -----------------------------------------------------------
-- Insere formulários
-- -----------------------------------------------------------

INSERT INTO formularios VALUES (
null,
'João da Silva',
1,
'123456789',
'012.345.678-91',
'Coordenador',
'Ariana Teixos',
'987654321',
'987.654.321-00',
'Darcy Nusite',
'01/01/1990',
'001.122.334-45',
'1166112233',
'Rua',
'Rua dos Bobos',
'666',
'Jardim dos Carvalhos',
'90000-010',
'Porto Alegre',
'Rio Grande do Sul',
1,
'18000000000001',
3,
'Hacker',
'60',
'01/01/2019',
'02/01/2019',
'6',
'000111222333444',
'Bem Cuidado S/A',
'Pepe Guardiola',
'1234',
'Juliene Hobart',
'Programador',
'O aluno vai criar muitos JFrames.',
'06/10/2019'
);

INSERT INTO formularios VALUES (
null,
'Crispiano Onlyone',
2,
'023456789',
'912.345.678-91',
'Vice Coordenador',
'Ariana Aoutra',
'187654321',
'187.654.321-00',
'Dia Bets',
'01/01/1993',
'111.122.334-45',
'2266112233',
'Av',
'Av Infinita',
'123',
'Castelinho',
'90000-020',
'Porto Alegre',
'Rio Grande do Sul',
2,
'18000000000002',
5,
'Almoxarifado',
'60',
'29/01/2019',
'02/03/2019',
'6',
'555111222333444',
'Tá de boa S/A',
'Celso Roth',
'5678',
'Wanda Binck',
'Diretor',
'O aluno vai criar muitas Threads.',
'06/10/2019'
);
