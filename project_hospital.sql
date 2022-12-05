drop database if exists Hospitais;
create database if not exists Hospitais;

use Hospitais;

CREATE TABLE Hospital (
  `idHospital` INT NOT NULL,
  `CNPJ` VARCHAR(45) NOT NULL,
  `quantFunc` INT NOT NULL,
  PRIMARY KEY (`idHospital`)
  );

CREATE TABLE Medico (
  `nomeMedico` VARCHAR(45) NOT NULL,
  `idadeMedico` INT NOT NULL,
  `licencaMedico` VARCHAR(45) NOT NULL,
  `Especialidade` VARCHAR(45) NOT NULL,
  `Hospital_idHospital` INT NOT NULL,
  `Telefone` VARCHAR(45) NULL,
  `CPF` VARCHAR(45) NOT NULL,
  `Salario` FLOAT NOT NULL,
  PRIMARY KEY (`CPF`),
  CONSTRAINT fk_Hospital 
  FOREIGN KEY (Hospital_idHospital)
  REFERENCES Hospital (idHospital) ON UPDATE CASCADE
  );
  
  CREATE TABLE `Telefone` (
  `idTelefone` INT NOT NULL,
  `Telefone1` VARCHAR(45) NOT NULL,
	`Medico_CPF` VARCHAR(45) NOT NULL,
      CONSTRAINT `fk_medico_telefone`
    FOREIGN KEY (`Medico_CPF`)
    REFERENCES Medico (`CPF`)
  );
  
  CREATE TABLE Paciente (
  `cpf` VARCHAR(45) NOT NULL,
  `uNome` VARCHAR(45) NOT NULL,
  `pNome` VARCHAR(45) NOT NULL,
  `Idade` INT NOT NULL,
  PRIMARY KEY (`cpf`));
  
  CREATE TABLE Consulta (
  `Paciente_cpf` VARCHAR(45) NOT NULL,
  `Medico_CPF` VARCHAR(45) NOT NULL,
  `problemaConsulta` VARCHAR(45) NULL,
  `dataConsulta` VARCHAR(45) NULL,
  PRIMARY KEY (`Paciente_cpf`,  `Medico_CPF`),
  	CONSTRAINT `fk_paciente`
    FOREIGN KEY (`Paciente_cpf`)
    REFERENCES Paciente (`cpf`),
    
    CONSTRAINT `fk_medico`
    FOREIGN KEY ( `Medico_CPF`)
    REFERENCES Medico (`CPF`)
  );
  
  
  CREATE TABLE Predio (
  `idPredio` INT NOT NULL,
  `Localizacao` VARCHAR(45) NOT NULL,
  `Espaco` INT NOT NULL,
  `qntSalas` INT NOT NULL,
  `Hospital_idHospital` INT NOT NULL,
  PRIMARY KEY (`idPredio`),
  CONSTRAINT `fk_Hospital_predio`
    FOREIGN KEY (`Hospital_idHospital`)
    REFERENCES Hospital (`idHospital`)
  );
  
  CREATE TABLE `Enfermeira` (
  `NomeEnfermeira` VARCHAR(45) NOT NULL,
  `idadeEnfermeira` VARCHAR(45) NOT NULL,
  `HorasTrabalhadas` INT NOT NULL,
  `Hospital_idHospital` INT NOT NULL,
  `CPF` VARCHAR(45) NOT NULL,
  `Salario` FLOAT NOT NULL,
    PRIMARY KEY (`CPF`, `Hospital_idHospital`),
    CONSTRAINT `fk_Secretaria_Hospital`
    FOREIGN KEY (`Hospital_idHospital`)
    REFERENCES `Hospital` (`idHospital`));
    

/**  
SET @qntFunc = 0; 
DELIMITER $$
#drop procedure if exists quantidade_funcionarios; 
CREATE PROCEDURE quantidade_funcionarios (IN nomeMedico VARCHAR(45), idadeMedico INT, licencaMedico VARCHAR(45),idMedico INT, Especialidade VARCHAR(45),  Hospital_idHospital INT)
BEGIN 
DECLARE qntFunc INT; 
SET @qntFunc = @qntFunc + 1; 
INSERT INTO Medico(idMedico, nomeMedico, idadeMedico, licencaMedico , Especialidade, idCliente) VALUES (idMedico, nomeMedico, idadeMedico, licencaMedico , Especialidade, idCliente);
END $$
DELIMITER ;
**/  
  
  
