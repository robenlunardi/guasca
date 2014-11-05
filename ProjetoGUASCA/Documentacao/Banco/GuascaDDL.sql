SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `guasca` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `guasca` ;

-- -----------------------------------------------------
-- Table `guasca`.`area`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`area` (
  `id_area` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_area`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`indisponibilidade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`indisponibilidade` (
  `id_ind` INT(11) NOT NULL AUTO_INCREMENT ,
  `id_prof` INT(11) NULL DEFAULT NULL ,
  `segM` INT(11) NULL DEFAULT NULL ,
  `segT` INT(11) NULL DEFAULT NULL ,
  `segN` INT(11) NULL ,
  `terM` INT(11) NULL DEFAULT NULL ,
  `terT` INT(11) NULL DEFAULT NULL ,
  `terN` INT(11) NULL DEFAULT NULL ,
  `quaM` INT(11) NULL DEFAULT NULL ,
  `quaT` INT(11) NULL DEFAULT NULL ,
  `quaN` INT(11) NULL DEFAULT NULL ,
  `quiM` INT(11) NULL DEFAULT NULL ,
  `quiT` INT(11) NULL DEFAULT NULL ,
  `quiN` INT(11) NULL DEFAULT NULL ,
  `sexM` INT(11) NULL DEFAULT NULL ,
  `sexT` INT(11) NULL DEFAULT NULL ,
  `sexN` INT(11) NULL DEFAULT NULL ,
  `sabM` INT(11) NULL DEFAULT NULL ,
  `sabT` INT(11) NULL DEFAULT NULL ,
  `sabN` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_ind`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`professor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`professor` (
  `id_professor` INT(11) NOT NULL AUTO_INCREMENT ,
  `matricula` VARCHAR(7) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `id_ind` INT(11) NULL ,
  PRIMARY KEY (`id_professor`) ,
  INDEX `fk_professor_indisponibilidade1_idx` (`id_ind` ASC) ,
  CONSTRAINT `fk_professor_indisponibilidade1`
    FOREIGN KEY (`id_ind` )
    REFERENCES `guasca`.`indisponibilidade` (`id_ind` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`professor_has_area`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`professor_has_area` (
  `id_professor_has_area` INT(11) NOT NULL AUTO_INCREMENT ,,
  `id_professor` INT(11) NOT NULL ,
  `id_area` INT(11) NOT NULL ,
  INDEX `idx_area_id` (`id_area` ASC) ,
  INDEX `idx_professor_id` (`id_professor` ASC) ,
  PRIMARY KEY (`id_professor_has_area`) ,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `guasca`.`dia_turno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`dia_turno` (
  `id_dia_turno` INT(11) NOT NULL AUTO_INCREMENT ,
  `cod_dia` INT(1) NULL ,
  `cod_turno` INT(1) NULL ,
  `dia_periodo` INT(1) NULL ,
  PRIMARY KEY (`id_dia_turno`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guasca`.`credito`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`credito` (
  `id_credito` INT(11) NOT NULL AUTO_INCREMENT ,
  `id_dia_turno` INT NULL ,
  PRIMARY KEY (`id_credito`) ,
  INDEX `fk_credito_dia_turno1_idx` (`id_dia_turno` ASC) ,
  CONSTRAINT `fk_credito_dia_turno1`
    FOREIGN KEY (`id_dia_turno` )
    REFERENCES `guasca`.`dia_turno` (`id_dia_turno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guasca`.`disciplina`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`disciplina` (
  `id_disciplina` INT(11) NOT NULL AUTO_INCREMENT ,
  `qtdAlunos` INT(3) NOT NULL ,
  `qtdCreditos` INT(3) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `turno` VARCHAR(45) NOT NULL ,
  `tipo_sala1` VARCHAR(45),
  `tipo_sala2` VARCHAR(45),
  `id_area` INT(11) NULL ,
  `id_credito` INT(11) NULL ,
  PRIMARY KEY (`id_disciplina`) ,
  INDEX `fk_disciplina_area1_idx` (`id_area` ASC) ,
  INDEX `fk_disciplina_credito1_idx` (`id_credito` ASC) ,
  CONSTRAINT `fk_disciplina_area1`
    FOREIGN KEY (`id_area` )
    REFERENCES `guasca`.`area` (`id_area` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_credito1`
    FOREIGN KEY (`id_credito` )
    REFERENCES `guasca`.`credito` (`id_credito` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


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
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guasca`.`sala`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`sala` (
  `id_sala` INT(11) NOT NULL AUTO_INCREMENT ,
  `qtdAlunos` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `tipo` VARCHAR(45) NOT NULL ,
  `id_credito` INT(11) NULL ,
  PRIMARY KEY (`id_sala`) ,
  INDEX `fk_sala_credito1_idx` (`id_credito` ASC) ,
  CONSTRAINT `fk_sala_credito1`
    FOREIGN KEY (`id_credito` )
    REFERENCES `guasca`.`credito` (`id_credito` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guasca`.`curso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`curso` (
  `id_curso` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_curso`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guasca`.`turma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `guasca`.`turma` (
  `id_turma` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `id_curso` INT(11) NULL ,
  `id_credito` INT(11) NULL ,
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
ENGINE = InnoDB;

USE `guasca` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
