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
  `segN` INT(11) NULL DEFAULT NULL ,
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
  `id_ind` INT(11) NOT NULL ,
  PRIMARY KEY (`id_professor`, `matricula`) ,
  INDEX `idx_indisponibilidade_id` (`id_ind` ASC) ,
  CONSTRAINT `fk_Professor_Indisponibilidade1`
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
  `id_prof_has_area` INT(11) NOT NULL AUTO_INCREMENT ,
  `id_professor` INT(11) NOT NULL ,
  `id_area` INT(11) NOT NULL ,
  INDEX `idx_area_id` (`id_area` ASC) ,
  INDEX `idx_professor_id` (`id_professor` ASC) ,
  PRIMARY KEY (`id_prof_has_area`) ,
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



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
