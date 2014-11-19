SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `guasca` DEFAULT CHARACTER SET latin1 ;
USE `guasca` ;

-- -----------------------------------------------------
-- Table `guasca`.`area`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`area` (
  `id_area` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id_area`) ,
  INDEX `idx_area_nome` (`nome` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`dia_turno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`dia_turno` (
  `id_dia_turno` INT(11) NOT NULL AUTO_INCREMENT ,
  `cod_dia` INT(1) NULL DEFAULT NULL ,
  `cod_turno` INT(1) NULL DEFAULT NULL ,
  `dia_periodo` INT(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_dia_turno`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`credito`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`credito` (
  `id_credito` INT(11) NOT NULL AUTO_INCREMENT ,
  `id_dia_turno` INT(11) NULL ,
  `valor` INT NOT NULL ,
  PRIMARY KEY (`id_credito`) ,
  INDEX `fk_credito_dia_turno1_idx` (`id_dia_turno` ASC) ,
  CONSTRAINT `fk_credito_dia_turno1`
    FOREIGN KEY (`id_dia_turno` )
    REFERENCES `guasca`.`dia_turno` (`id_dia_turno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`curso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`curso` (
  `id_curso` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id_curso`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`disciplina`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`disciplina` (
  `id_disciplina` INT(11) NOT NULL AUTO_INCREMENT ,
  `qtdAlunos` INT(3) NOT NULL ,
  `nome` VARCHAR(100) NOT NULL ,
  `turno` INT NOT NULL ,
  `id_area` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_disciplina`) ,
  INDEX `fk_disciplina_area1_idx` (`id_area` ASC) ,
  CONSTRAINT `fk_disciplina_area1`
    FOREIGN KEY (`id_area` )
    REFERENCES `guasca`.`area` (`id_area` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`professor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`professor` (
  `id_professor` INT(11) NOT NULL AUTO_INCREMENT ,
  `matricula` VARCHAR(7) NOT NULL ,
  `nome` VARCHAR(100) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id_professor`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`disciplina_has_professor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`disciplina_has_professor` (
  `id_disciplina_has_professor` INT(11) NOT NULL AUTO_INCREMENT ,
  `id_disciplina` INT(11) NOT NULL ,
  `id_professor` INT(11) NOT NULL ,
  PRIMARY KEY (`id_disciplina_has_professor`) ,
  INDEX `fk_disciplina_has_professor_professor1_idx` (`id_professor` ASC) ,
  INDEX `fk_disciplina_has_professor_disciplina1_idx` (`id_disciplina` ASC) ,
  CONSTRAINT `fk_disciplina_has_professor_disciplina`
    FOREIGN KEY (`id_disciplina` )
    REFERENCES `guasca`.`disciplina` (`id_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_has_professor_professor`
    FOREIGN KEY (`id_professor` )
    REFERENCES `guasca`.`professor` (`id_professor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`indisponibilidade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`indisponibilidade` (
  `id_ind` INT(11) NOT NULL AUTO_INCREMENT ,
  `dia` INT(11) NULL ,
  `turno` INT(11) NULL DEFAULT NULL ,
  `valor` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_ind`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`tipo_sala`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`tipo_sala` (
  `id_tipo_sala` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id_tipo_sala`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guasca`.`sala`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`sala` (
  `id_sala` INT(11) NOT NULL AUTO_INCREMENT ,
  `qtdAlunos` INT(11) NOT NULL ,
  `nome` VARCHAR(100) NOT NULL ,
  `id_tipo_sala` INT NOT NULL ,
  PRIMARY KEY (`id_sala`) ,
  INDEX `fk_sala_tipo_sala1_idx` (`id_tipo_sala` ASC) ,
  CONSTRAINT `fk_sala_tipo_sala1`
    FOREIGN KEY (`id_tipo_sala` )
    REFERENCES `guasca`.`tipo_sala` (`id_tipo_sala` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`turma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`turma` (
  `id_turma` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `id_curso` INT(11) NULL DEFAULT NULL ,
  `id_credito` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_turma`) ,
  INDEX `fk_turma_curso1_idx` (`id_curso` ASC) ,
  INDEX `fk_turma_credito1_idx` (`id_credito` ASC) ,
  CONSTRAINT `fk_turma_curso1`
    FOREIGN KEY (`id_curso` )
    REFERENCES `guasca`.`curso` (`id_curso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_credito1`
    FOREIGN KEY (`id_credito` )
    REFERENCES `guasca`.`credito` (`id_credito` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`disciplina_has_credito`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`disciplina_has_credito` (
  `id_disciplina_has_credito` INT NOT NULL AUTO_INCREMENT ,
  `id_credito` INT(11) NOT NULL ,
  `id_disciplina` INT(11) NOT NULL ,
  `id_tipo_sala` INT NOT NULL ,
  PRIMARY KEY (`id_disciplina_has_credito`) ,
  INDEX `fk_disciplina_has_credito_credito1_idx` (`id_credito` ASC) ,
  INDEX `fk_disciplina_has_credito_disciplina1_idx` (`id_disciplina` ASC) ,
  INDEX `fk_disciplina_has_credito_tipo_sala1_idx` (`id_tipo_sala` ASC) ,
  CONSTRAINT `fk_disciplina_has_credito_credito`
    FOREIGN KEY (`id_credito` )
    REFERENCES `guasca`.`credito` (`id_credito` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_has_credito_disciplina`
    FOREIGN KEY (`id_disciplina` )
    REFERENCES `guasca`.`disciplina` (`id_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_has_credito_tipo_sala1`
    FOREIGN KEY (`id_tipo_sala` )
    REFERENCES `guasca`.`tipo_sala` (`id_tipo_sala` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guasca`.`professor_has_ind`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`professor_has_ind` (
  `id_prof_has_ind` INT NOT NULL AUTO_INCREMENT ,
  `id_ind` INT(11) NOT NULL ,
  `id_professor` INT(11) NOT NULL ,
  `ano` YEAR NULL ,
  `periodo` INT(11) NULL ,
  `datetime` DATETIME NULL ,
  PRIMARY KEY (`id_prof_has_ind`) ,
  INDEX `fk_professor_has_ind_indisponibilidade1_idx` (`id_ind` ASC) ,
  INDEX `fk_professor_has_ind_professor1_idx` (`id_professor` ASC) ,
  CONSTRAINT `fk_professor_has_ind_indisponibilidade1`
    FOREIGN KEY (`id_ind` )
    REFERENCES `guasca`.`indisponibilidade` (`id_ind` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_has_ind_professor1`
    FOREIGN KEY (`id_professor` )
    REFERENCES `guasca`.`professor` (`id_professor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guasca`.`professor_has_area`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`professor_has_area` (
  `id_prof_has_area` INT NOT NULL AUTO_INCREMENT ,
  `id_area` INT(11) NOT NULL ,
  `id_professor` INT(11) NOT NULL ,
  PRIMARY KEY (`id_prof_has_area`) ,
  INDEX `fk_professor_has_area_area1_idx` (`id_area` ASC) ,
  INDEX `fk_professor_has_area_professor1_idx` (`id_professor` ASC) ,
  CONSTRAINT `fk_professor_has_area_area`
    FOREIGN KEY (`id_area` )
    REFERENCES `guasca`.`area` (`id_area` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_has_area_professor`
    FOREIGN KEY (`id_professor` )
    REFERENCES `guasca`.`professor` (`id_professor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guasca`.`curso_has_disciplina`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`curso_has_disciplina` (
  `id_curso_has_disciplinacol` INT NOT NULL AUTO_INCREMENT ,
  `id_curso` INT(11) NOT NULL ,
  `id_disciplina` INT(11) NOT NULL ,
  INDEX `fk_curso_has_disciplina_disciplina1_idx` (`id_disciplina` ASC) ,
  INDEX `fk_curso_has_disciplina_curso1_idx` (`id_curso` ASC) ,
  PRIMARY KEY (`id_curso_has_disciplinacol`) ,
  CONSTRAINT `fk_curso_has_disciplina_curso1`
    FOREIGN KEY (`id_curso` )
    REFERENCES `guasca`.`curso` (`id_curso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_has_disciplina_disciplina1`
    FOREIGN KEY (`id_disciplina` )
    REFERENCES `guasca`.`disciplina` (`id_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `guasca` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
