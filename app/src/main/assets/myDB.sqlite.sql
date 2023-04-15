-- TABLE
CREATE TABLE demo (ID integer primary key, Name varchar(20), Hint text );
CREATE TABLE "Ejercicio" (
	"idEjercicio"	INTEGER,
	"nombreEjercicio"	TEXT,
	"descripcionEjercicio"	TEXT,
	"urlVideoDemostracion"	TEXT,
	"caloriasEjercicio"	NUMERIC,
	PRIMARY KEY("idEjercicio")
);
CREATE TABLE "EjercicioRutina" (
	"idEjercicioRutina"	INTEGER,
	"idEjercicio"	INTEGER,
	"idRutina"	INTEGER,
	"repeticiones"	INTEGER,
	"series"	INTEGER,
	FOREIGN KEY("idEjercicio") REFERENCES "Ejercicio"("idEjercicio"),
	FOREIGN KEY("idRutina") REFERENCES "Rutina"("idRutina"),
	PRIMARY KEY("idEjercicioRutina")
);
CREATE TABLE "Musculo" (
	"idMusculo"	INTEGER NOT NULL,
	"nombreMusculo"	TEXT NOT NULL UNIQUE,
	"nombreAltMusculo"	TEXT,
	PRIMARY KEY("idMusculo" AUTOINCREMENT)
);
CREATE TABLE "MusculoEjercicio" (
	"idEjercicio"	INTEGER,
	"idMusculo"	INTEGER,
	"idMusculoEjercicio"	INTEGER,
	FOREIGN KEY("idEjercicio") REFERENCES "Ejercicio"("idEjercicio"),
	FOREIGN KEY("idMusculo") REFERENCES "Musculo"("idMusculo"),
	PRIMARY KEY("idMusculoEjercicio")
);
CREATE TABLE "RegistroEjercicio" (
	"idRegistroEjercicio"	INTEGER,
	"idEjercicio"	INTEGER,
	"fechaRegistro"	TEXT,
	"tiempoEjercicio"	INTEGER,
	"repeticiones"	INTEGER,
	"series"	INTEGER,
	"pesoUtilizado"	REAL,
	FOREIGN KEY("idEjercicio") REFERENCES "Ejercicio"("idEjercicio"),
	PRIMARY KEY("idRegistroEjercicio")
);
CREATE TABLE "Rutina" (
	"idRutina"	INTEGER,
	"nombreRutina"	TEXT,
	"duracionRutina"	INTEGER,
	"fechaCreacion"	TEXT,
	"descripcionRutina"	TEXT,
	PRIMARY KEY("idRutina")
);
CREATE TABLE sqlite_sequence(name,seq);
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
