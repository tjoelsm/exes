DROP TABLE IF EXISTS TIA_SEG_PERSONAS;
DROP TABLE IF EXISTS TIA_SEG_MESES;
DROP TABLE IF EXISTS TIA_APP_TIPOGASTO;
DROP TABLE IF EXISTS TIA_APP_GASTOS;
DROP TABLE IF EXISTS TIA_APP_GASTOS_GRUPO;
DROP TABLE IF EXISTS TIA_APP_INGRESOS;
DROP TABLE IF EXISTS TIA_APP_INGRESOSMES;
CREATE TABLE IF NOT EXISTS TIA_SEG_PERSONAS (
  TIA01_COD_PERSONA INT NOT NULL AUTO_INCREMENT,
  TIA01_NOMBRE VARCHAR(200) NULL,
  TIA01_APELLIDOS VARCHAR(200) NULL,
  TIA01_DIRELEC VARCHAR(200) NOT NULL,
  TIA01_ULTIMO_ACCESS DATETIME NULL,
  TIA01_LOGIN_PASS VARCHAR(10) NULL,
  PRIMARY KEY (TIA01_COD_PERSONA, TIA01_DIRELEC)
 );
INSERT INTO TIA_SEG_PERSONAS VALUES(1,'Tiago Joel', 'Da Silva Monteiro', 'tjoelsm@gmail.com', CURRENT_DATE, 'tiago123');
-- -----------------------------------------------------
-- Table TIA_SEG_MESES
-- Corresponde a los meses
-- TABLA PORTEGIDA
-- -----------------------------------------------------
DROP TABLE IF EXISTS TIA_SEG_MESES;
CREATE TABLE IF NOT EXISTS TIA_SEG_MESES (
  TIA01_COD_MES VARCHAR(3) NOT NULL,
  TIA01_DESC_MES VARCHAR(10) NOT NULL,
  PRIMARY KEY (TIA01_COD_MES)
);
INSERT INTO TIA_SEG_MESES VALUES('ENE', 'ENERO');
INSERT INTO TIA_SEG_MESES VALUES('FEB', 'FEBRERO');
INSERT INTO TIA_SEG_MESES VALUES('MAR', 'MARZO');
INSERT INTO TIA_SEG_MESES VALUES('ABR', 'ABRIL');
INSERT INTO TIA_SEG_MESES VALUES('MAY', 'MAYO');
INSERT INTO TIA_SEG_MESES VALUES('JUN', 'JUNIO');
INSERT INTO TIA_SEG_MESES VALUES('JUL', 'JULIO');
INSERT INTO TIA_SEG_MESES VALUES('AGO', 'AGOSTO');
INSERT INTO TIA_SEG_MESES VALUES('SEP', 'SEPTIEMBRE');
INSERT INTO TIA_SEG_MESES VALUES('OCT', 'OCTUBRE');
INSERT INTO TIA_SEG_MESES VALUES('NOV', 'NOVIEMBRE');
INSERT INTO TIA_SEG_MESES VALUES('DIC', 'DICIEMBRE');
-- -----------------------------------------------------
-- Table TIA_APP_TIPOGASTO
-- Esta tabla es una tabla que guarda los tipos de gasto, posibles.
-- se puede dar de alta un gasto.
-- Obligatorio todos los Datos.
-- -----------------------------------------------------
DROP TABLE IF EXISTS TIA_APP_TIPOGASTO;
CREATE TABLE IF NOT EXISTS TIA_APP_TIPOGASTO (
  TAP01_COD_TIPOGASTO VARCHAR(3) NOT NULL,
  TAP01_DESC_GASTO VARCHAR(50) NOT NULL,
  TAP01_PRIOCIDAD INT NOT NULL, -- SI EL GASTO ES ANUAL=12, BI-ANUAL=2, ETC... 0=EXPORADICO,
  TAP01_FECHA_INICIO DATE NULL,
  TAP01_FECHA_FIN DATE NOT NULL,
  TAP01_IMP_PERVISTO DECIMAL(17,2) NOT NULL,
  PRIMARY KEY (TAP01_COD_TIPOGASTO)
);
INSERT INTO TIA_APP_TIPOGASTO VALUES('HES','Hipoteca España',12,2016-07-01,2020-07-31, 181.27);
INSERT INTO TIA_APP_TIPOGASTO VALUES('HPT','Hipoteca Portugal',12,2016-07-01,2020-07-31, 178.48);
INSERT INTO TIA_APP_TIPOGASTO VALUES('PRE','Prestatamos Personal',12,2016-07-01,2020-07-31, 512.45);
-- -----------------------------------------------------
-- Table TIA_APP_GASTOS
-- Esta tabla 
-- -----------------------------------------------------
DROP TABLE IF EXISTS TIA_APP_GASTOS;
CREATE TABLE IF NOT EXISTS TIA_APP_GASTOS (
  TAP02_COD_GASTO VARCHAR(6) NOT NULL,
  TAP02_COD_TIPOGASTO VARCHAR(3) NULL,
  TAP02_MES VARCHAR(3) NULL,
  TAP02_IMP_COBRADO DECIMAL(17,2) NULL,
  TAP02_OBSERVACIOENS VARCHAR(100) NULL,
  PRIMARY KEY (TAP02_COD_GASTO)
);
INSERT INTO TIA_APP_GASTOS VALUES('HESENE','HES','ENE',170.32);
INSERT INTO TIA_APP_GASTOS VALUES('HPTENE','HPT','ENE',169.21);
-- -----------------------------------------------------
-- Table TIA_APP_GASTOS_GRUPO
-- codigo de grupo, para poder agrupar los gastos
-- -----------------------------------------------------
DROP TABLE IF EXISTS TIA_APP_GASTOS_GRUPO;
CREATE TABLE IF NOT EXISTS TIA_APP_GASTOS_GRUPO (
  TAP03_COD_GRUPO VARCHAR(6) NOT NULL,
  TAP03_COD_TIPOGASTO VARCHAR(3) NOT NULL,
  TAP03_NOMBRE_GRUPO VARCHAR(45) NULL,
  PRIMARY KEY (TAP04_COD_GRUPO, TAP_COD_TIPOGASTO)
);
INSERT INTO TIA_APP_GASTOS_GRUPO VALUES('FIJOS','HES','Gastos Fijos - Hipoteca España');
INSERT INTO TIA_APP_GASTOS_GRUPO VALUES('FIJOS','HPT','Gastos Fijos - Hipoteca Portugal');
INSERT INTO TIA_APP_GASTOS_GRUPO VALUES('FIJOS','PRE','Gastos Fijos - Prestamos Personal');
-- -----------------------------------------------------
-- Table TIA_APP_INGRESOS
-- Tabla donde se guardan los ingresos
-- -----------------------------------------------------
DROP TABLE IF EXISTS TIA_APP_INGRESOS;

CREATE TABLE IF NOT EXISTS TIA_APP_INGRESOS (
  TAP04_COD_TIPOINGRESO VARCHAR(3) NOT NULL,
  TAP04_DEC_INGRESO VARCHAR(45) NULL,
  TAP04_PRIOCIDAD INT NULL, -- NUMERO DE MESES QUE SE COBRA ANULAMENTE.
  TAP04_IMP_PERVISTO DECIMAL(17,2) NULL,
  PRIMARY KEY (TAP05_COD_TIPOINGRESO)
);
INSERT INTO TIA_APP_INGRESOS VALUES('NTI','Nomina Tiago',12,2000);
INSERT INTO TIA_APP_INGRESOS VALUES('NTI','Nomina ANA',12,1000);
INSERT INTO TIA_APP_INGRESOS VALUES('RPT','Alquilar Casa PT',12,320);
-- -----------------------------------------------------
-- Table TIA_APP_INGRESOSMES
-- En esta tabla se guarda los ingrasos mensuales
-- Se guarda con el codigo del mes, que es compuesto por el Tipo de ingreso y el mes
-- MES
-- tipo de gasto
-- importe cobrado
-- y observaciones.
-- -----------------------------------------------------
DROP TABLE IF EXISTS TIA_APP_INGRESOSMES;
CREATE TABLE IF NOT EXISTS TIA_APP_INGRESOSMES (
  TAP05_COD_INGRESO VARCHAR(6) NOT NULL,
  TAP05_COD_TIPOINGRESO VARCHAR(3) NULL,
  TAP05_MES VARCHAR(3) NULL,
  TAP05_IMP DECIMAL(17,2) NULL,
  TAP05_OBSERVACIONES VARCHAR(45) NULL,
  PRIMARY KEY (TAP06_COD_INGRESO)
);
INSERT INTO TIA_APP_INGRESOSMES VALUES('NTIENE','ENE','NTI',2100,'Nomina de Enero');


