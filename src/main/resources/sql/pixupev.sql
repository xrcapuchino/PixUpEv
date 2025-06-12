-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pixupev
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pixupev` ;

-- -----------------------------------------------------
-- Schema pixupev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pixupev` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `pixupev` ;

-- -----------------------------------------------------
-- Table `pixupev`.`artista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixupev`.`artista` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixupev`.`artista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixupev`.`disquera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixupev`.`disquera` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixupev`.`disquera` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixupev`.`genero_musical`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixupev`.`genero_musical` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixupev`.`genero_musical` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixupev`.`disco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixupev`.`disco` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixupev`.`disco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NOT NULL,
  `precio` FLOAT(5,2) NOT NULL,
  `existencia` INT NOT NULL,
  `descuento` FLOAT(2,2) NOT NULL,
  `fecha_lanzamiento` DATE NOT NULL,
  `imagen` VARCHAR(120) NOT NULL,
  `id_artista` INT NOT NULL,
  `id_disquera` INT NOT NULL,
  `id_genero_musical` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_disco_artista`
    FOREIGN KEY (`id_artista`)
    REFERENCES `pixupev`.`artista` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disco_Disquera1`
    FOREIGN KEY (`id_disquera`)
    REFERENCES `pixupev`.`disquera` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disco_genero_musical1`
    FOREIGN KEY (`id_genero_musical`)
    REFERENCES `pixupev`.`genero_musical` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_disco_artista_idx` ON `pixupev`.`disco` (`id_artista` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_disco_Disquera1_idx` ON `pixupev`.`disco` (`id_disquera` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_disco_genero_musical1_idx` ON `pixupev`.`disco` (`id_genero_musical` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixupev`.`cancion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixupev`.`cancion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixupev`.`cancion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `duracion` TIME NOT NULL,
  `disco_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cancion_disco1`
    FOREIGN KEY (`disco_id`)
    REFERENCES `pixupev`.`disco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_cancion_disco1_idx` ON `pixupev`.`cancion` (`disco_id` ASC) VISIBLE;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
