DROP TABLE IF EXISTS FamiliarBeneficiario ;
DROP TABLE IF EXISTS BeneficiarioAyuda ;
DROP TABLE IF EXISTS ModificacionAyuda ;
DROP TABLE IF EXISTS Movimiento ;
DROP TABLE IF EXISTS Ayuda ;
DROP TABLE IF EXISTS Beneficiario ;
DROP TABLE IF EXISTS Voluntario ;
DROP TABLE IF EXISTS Asociacion ;
DROP TABLE IF EXISTS TipoAyuda ;
DROP TABLE IF EXISTS Familiar ;

CREATE TABLE Asociacion (
      AsociacionID INTEGER DEFAULT '1' NOT NULL PRIMARY KEY
    , Direccion VARCHAR (50)
    , Nombre VARCHAR (20)
);

CREATE TABLE Beneficiario (
      NIF VARCHAR(9) NOT NULL PRIMARY KEY
    , Nombre VARCHAR (15)
    , Apellidos VARCHAR (20)
    , FechaNacimiento DATE
    , CP INTEGER
    , TelefonoFijo INTEGER
    , TelefonoMovil INTEGER
    , Domicilio VARCHAR (50)
    , EstadoCivil VARCHAR (10)
    , Localidad VARCHAR (15)
    , Nacionalidad VARCHAR (15)
    , NivelDeEstudio VARCHAR (20)
    , Observaciones TEXT
    , Ocupacion TEXT
    , Profesion TEXT
    , SituacionEconomica TEXT
    , Vivienda VARCHAR (20)
    , ViviendaAlquiler DECIMAL
    , ViviendaObservaciones VARCHAR (100)
    , AsociacionID INTEGER
    , CONSTRAINT FkBeneficiario FOREIGN KEY (AsociacionID)
                  REFERENCES Asociacion (AsociacionID)
);

CREATE TABLE Familiar (
      NIF VARCHAR(9) NOT NULL PRIMARY KEY
    , Nombre VARCHAR (15)
    , Apellidos VARCHAR (15)
    , FechaNacimiento DATE
    , Ocupacion VARCHAR (15)
    , Parentesco VARCHAR (20)
);

CREATE TABLE FamiliarBeneficiario (
      BeneficiarioNIF VARCHAR (9) NOT NULL
    , FamiliarNIF VARCHAR (9) NOT NULL
    , PRIMARY KEY (BeneficiarioNIF, FamiliarNIF)
    , CONSTRAINT FkFamiliarBeneficiario1 FOREIGN KEY (BeneficiarioNIF)
                  REFERENCES Beneficiario (NIF)
    , CONSTRAINT FkFamiliarBeneficiario2 FOREIGN KEY (FamiliarNIF)
                  REFERENCES Familiar (NIF)
);

CREATE TABLE Voluntario (
      NIF VARCHAR (9) NOT NULL PRIMARY KEY
    , Nombre VARCHAR (15)
    , Apellidos VARCHAR (20)
    , CP INTEGER
    , TelefonoFijo INTEGER
    , TelefonoMoviL INTEGER
    , Domicilio VARCHAR (100)
    , Localidad VARCHAR (50)
    , FechaNacimiento DATE
    , Password VARCHAR (20)
    , AsociacionID INTEGER
    , CONSTRAINT FkVoluntario FOREIGN KEY (AsociacionID)
                  REFERENCES Asociacion (AsociacionID)
);

CREATE TABLE TipoAyuda (
      OID VARCHAR (20) NOT NULL PRIMARY KEY
    , Descripcion TEXT
    , Monetaria INTEGER
    , Titulo VARCHAR (50)
);

CREATE TABLE Ayuda (
      OID VARCHAR (20) NOT NULL PRIMARY KEY
    , Fecha DATE
    , Importe DECIMAL
    , Observaciones TEXT
    , TipoAyudaOID VARCHAR (50)
    , AsociacionID INTEGER
    , VoluntarioNIF VARCHAR (9)
    , CONSTRAINT FkAyuda1 FOREIGN KEY (TipoAyudaOID)
                  REFERENCES TipoAyuda (OID)
    , CONSTRAINT FkAyuda2 FOREIGN KEY (AsociacionID)
                  REFERENCES Asociacion (AsociacionID)
    , CONSTRAINT FkAyuda3 FOREIGN KEY (VoluntarioNIF)
                  REFERENCES Voluntario (NIF)
);

CREATE TABLE BeneficiarioAyuda (
      BeneficiarioNIF VARCHAR (9)
    , AyudaOID VARCHAR (20)
    , PRIMARY KEY (BeneficiarioNIF, AyudaOID)
    , CONSTRAINT FkBeneficiarioAyuda FOREIGN KEY (BeneficiarioNIF)
                  REFERENCES Beneficiario (NIF)
    , CONSTRAINT FkBeneficiarioAyuda2 FOREIGN KEY (AyudaOID)
                  REFERENCES Ayuda (OID)
);

CREATE TABLE ModificacionAyuda (
      ModificacionID INTEGER DEFAULT '1' NOT NULL PRIMARY KEY
    , AyudaOID VARCHAR (20)
    , VoluntarioNIF VARCHAR (9)
    , Fecha DATE
    , CONSTRAINT FkModificacionAyuda FOREIGN KEY (VoluntarioNIF)
                  REFERENCES Voluntario (NIF)
);

CREATE TABLE Movimiento (
      MovimientoID INTEGER DEFAULT '1' NOT NULL PRIMARY KEY
    , Fecha DATE
    , Importe DECIMAL
    , concepto VARCHAR (50)
    , tipo CHAR
    , AsociacionID INTEGER
    , AyudaOID VARCHAR (20)
    , CONSTRAINT FkMovimiento1 FOREIGN KEY (AsociacionID)
                  REFERENCES Asociacion (AsociacionID)
, CONSTRAINT FkMovimiento2 FOREIGN KEY (AyudaOID)
                  REFERENCES Ayuda (OID)
);
