CREATE TABLE IF NOT EXISTS "MusculoEjercicio" (
	"idEjercicio"	INTEGER,
	"idMusculo"	INTEGER,
	"idMusculoEjercicio"	INTEGER,
	FOREIGN KEY("idMusculo") REFERENCES "Musculo"("idMusculo"),
	FOREIGN KEY("idEjercicio") REFERENCES "Ejercicio"("idEjercicio"),
	PRIMARY KEY("idMusculoEjercicio")
);
CREATE TABLE IF NOT EXISTS "Rutina" (
	"idRutina"	INTEGER,
	"nombreRutina"	TEXT,
	"duracionRutina"	INTEGER,
	"fechaCreacion"	TEXT,
	"descripcionRutina"	TEXT,
	PRIMARY KEY("idRutina")
);
CREATE TABLE IF NOT EXISTS "EjercicioRutina" (
	"idEjercicioRutina"	INTEGER,
	"idEjercicio"	INTEGER,
	"idRutina"	INTEGER,
	"repeticiones"	INTEGER,
	"series"	INTEGER,
	FOREIGN KEY("idEjercicio") REFERENCES "Ejercicio"("idEjercicio"),
	FOREIGN KEY("idRutina") REFERENCES "Rutina"("idRutina"),
	PRIMARY KEY("idEjercicioRutina")
);
CREATE TABLE IF NOT EXISTS "RegistroEjercicio" (
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
CREATE TABLE IF NOT EXISTS "Musculo" (
	"idMusculo"	INTEGER NOT NULL,
	"nombreMusculo"	TEXT NOT NULL UNIQUE,
	"imagenMusculo"	BLOB,
	"nombreAltMusculo"	TEXT,
	PRIMARY KEY("idMusculo" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Ejercicio" (
	"idEjercicio"	INTEGER,
	"nombreEjercicio"	TEXT,
	"descripcionEjercicio"	TEXT,
	"urlVideoDemostracion"	TEXT,
	"caloriasEjercicio"	NUMERIC,
	PRIMARY KEY("idEjercicio")
);
INSERT INTO "MusculoEjercicio" VALUES (1,1,1);
INSERT INTO "MusculoEjercicio" VALUES (3,1,2);
INSERT INTO "MusculoEjercicio" VALUES (5,1,3);
INSERT INTO "MusculoEjercicio" VALUES (2,11,4);
INSERT INTO "MusculoEjercicio" VALUES (2,4,5);
INSERT INTO "MusculoEjercicio" VALUES (4,2,6);
INSERT INTO "MusculoEjercicio" VALUES (6,2,7);
INSERT INTO "MusculoEjercicio" VALUES (7,2,8);
INSERT INTO "MusculoEjercicio" VALUES (8,2,9);
INSERT INTO "MusculoEjercicio" VALUES (9,2,10);
INSERT INTO "MusculoEjercicio" VALUES (10,3,11);
INSERT INTO "MusculoEjercicio" VALUES (11,3,12);
INSERT INTO "MusculoEjercicio" VALUES (12,3,13);
INSERT INTO "MusculoEjercicio" VALUES (13,3,14);
INSERT INTO "MusculoEjercicio" VALUES (14,3,15);
INSERT INTO "MusculoEjercicio" VALUES (13,10,16);
INSERT INTO "MusculoEjercicio" VALUES (15,4,17);
INSERT INTO "MusculoEjercicio" VALUES (16,4,18);
INSERT INTO "MusculoEjercicio" VALUES (17,4,19);
INSERT INTO "MusculoEjercicio" VALUES (18,4,20);
INSERT INTO "MusculoEjercicio" VALUES (18,2,21);
INSERT INTO "MusculoEjercicio" VALUES (18,11,22);
INSERT INTO "MusculoEjercicio" VALUES (19,5,23);
INSERT INTO "MusculoEjercicio" VALUES (19,4,24);
INSERT INTO "MusculoEjercicio" VALUES (19,10,25);
INSERT INTO "MusculoEjercicio" VALUES (20,5,26);
INSERT INTO "MusculoEjercicio" VALUES (20,10,27);
INSERT INTO "MusculoEjercicio" VALUES (21,4,28);
INSERT INTO "MusculoEjercicio" VALUES (22,6,29);
INSERT INTO "MusculoEjercicio" VALUES (23,6,30);
INSERT INTO "MusculoEjercicio" VALUES (23,2,31);
INSERT INTO "MusculoEjercicio" VALUES (23,11,32);
INSERT INTO "MusculoEjercicio" VALUES (23,7,33);
INSERT INTO "MusculoEjercicio" VALUES (24,6,34);
INSERT INTO "MusculoEjercicio" VALUES (24,7,35);
INSERT INTO "MusculoEjercicio" VALUES (25,7,36);
INSERT INTO "MusculoEjercicio" VALUES (26,7,37);
INSERT INTO "MusculoEjercicio" VALUES (27,7,38);
INSERT INTO "MusculoEjercicio" VALUES (28,8,39);
INSERT INTO "MusculoEjercicio" VALUES (29,8,40);
INSERT INTO "MusculoEjercicio" VALUES (30,8,41);
INSERT INTO "MusculoEjercicio" VALUES (31,8,42);
INSERT INTO "MusculoEjercicio" VALUES (32,9,43);
INSERT INTO "MusculoEjercicio" VALUES (33,9,44);
INSERT INTO "MusculoEjercicio" VALUES (34,9,45);
INSERT INTO "MusculoEjercicio" VALUES (35,10,46);
INSERT INTO "MusculoEjercicio" VALUES (36,10,47);
INSERT INTO "MusculoEjercicio" VALUES (37,10,48);
INSERT INTO "MusculoEjercicio" VALUES (38,11,49);
INSERT INTO "MusculoEjercicio" VALUES (39,11,50);
INSERT INTO "Rutina" VALUES (1,'Pierna',40,'31/03/23','Rutina centrada en trabajar las piernas, en este caso cuadriceps y gemelos');
INSERT INTO "Rutina" VALUES (2,'Pectoral',50,'20/03/23','Rutina exclusivamente de pecho');
INSERT INTO "Rutina" VALUES (3,'Brazos',55,'28/03/23','Rutina para brazos, biceps, triceps y antebrazo');
INSERT INTO "EjercicioRutina" VALUES (1,30,1,10,5);
INSERT INTO "EjercicioRutina" VALUES (2,28,1,15,5);
INSERT INTO "EjercicioRutina" VALUES (3,31,1,10,3);
INSERT INTO "EjercicioRutina" VALUES (4,32,1,10,5);
INSERT INTO "EjercicioRutina" VALUES (5,10,2,20,5);
INSERT INTO "EjercicioRutina" VALUES (6,11,2,15,5);
INSERT INTO "EjercicioRutina" VALUES (7,12,2,15,5);
INSERT INTO "EjercicioRutina" VALUES (8,13,2,15,5);
INSERT INTO "EjercicioRutina" VALUES (9,15,3,15,5);
INSERT INTO "EjercicioRutina" VALUES (10,18,3,10,3);
INSERT INTO "EjercicioRutina" VALUES (11,19,3,15,5);
INSERT INTO "EjercicioRutina" VALUES (12,21,3,10,3);
INSERT INTO "Musculo" VALUES (1,'Trapecio',NULL,'Traps');
INSERT INTO "Musculo" VALUES (2,'Hombro',NULL,'Shoulders');
INSERT INTO "Musculo" VALUES (3,'Pectoral',NULL,'Chest');
INSERT INTO "Musculo" VALUES (4,'Biceps',NULL,'Biceps');
INSERT INTO "Musculo" VALUES (5,'Antebrazo',NULL,'Forearms');
INSERT INTO "Musculo" VALUES (6,'Oblicuos',NULL,'Obliques');
INSERT INTO "Musculo" VALUES (7,'Abdominal',NULL,'Abdominals');
INSERT INTO "Musculo" VALUES (8,'Cuadriceps',NULL,'Quadriceps');
INSERT INTO "Musculo" VALUES (9,'Gemelos',NULL,'Calves');
INSERT INTO "Musculo" VALUES (10,'Tríceps',NULL,'Triceps');
INSERT INTO "Musculo" VALUES (11,'Espalda',NULL,'Back');
INSERT INTO "Ejercicio" VALUES (1,'Elevaciones de hombros con mancuernas','Sostén una mancuerna en cada mano y levanta los hombros hacia las orejas, manteniendo los brazos rectos. Mantén la posición durante un segundo y luego baja los hombros lentamente.','https://youtu.be/xeJjTRIYOIM',0.06);
INSERT INTO "Ejercicio" VALUES (2,'Remo con barra','Mantén la espalda recta y levanta la barra hacia tu pecho, manteniendo los codos cerca del cuerpo. Baja la barra lentamente y repite el ejercicio.','https://www.youtube.com/watch?v=G8l_8chR5BE',0.1);
INSERT INTO "Ejercicio" VALUES (3,'Encogimientos de hombros con cable',' Agarra un cable con una polea baja en cada mano y tira de ellos hacia arriba hasta que tus hombros estén cerca de tus oídos. Mantén la posición durante un segundo y luego baja lentamente los cables.','https://youtu.be/v7QczJNuWIg',0.06);
INSERT INTO "Ejercicio" VALUES (4,'Elevaciones laterales de mancuernas','Sostén una mancuerna en cada mano y levanta los brazos hacia los lados, manteniéndolos rectos. Detente cuando los brazos estén paralelos al piso y luego baja lentamente los brazos','https://www.youtube.com/watch?v=3VcKaXpzqRo',0.06);
INSERT INTO "Ejercicio" VALUES (5,'Encogimientos de trapecio','Sostén una mancuerna en cada mano y levántalas hacia los lados hasta que estén paralelas al piso. Levanta los hombros hacia las orejas mientras mantienes los brazos rectos. Mantén la posición durante un segundo y luego baja lentamente los hombros. Este ejercicio trabaja el trapecio superior y medio.','',0.06);
INSERT INTO "Ejercicio" VALUES (6,'Press de hombros con mancuernas','Sostén una mancuerna en cada mano y levanta los brazos hacia los lados hasta que estén paralelos al piso. Luego, levanta las mancuernas por encima de la cabeza y baja lentamente los brazos','https://www.youtube.com/watch?v=qEwKCR5JCog',0.1);
INSERT INTO "Ejercicio" VALUES (7,'Remo alta con barra','Agarra una barra con las manos separadas a la altura de los hombros y levanta la barra hasta la barbilla, manteniendo los codos cerca del cuerpo. Luego, baja lentamente la barra hacia abajo','https://www.youtube.com/watch?v=F3QY5vMz_6I',0.1);
INSERT INTO "Ejercicio" VALUES (8,'Elevaciones frontales con mancuernas','Sostén una mancuerna en cada mano y levanta los brazos hacia adelante, manteniéndolos rectos. Detente cuando los brazos estén paralelos al piso y luego baja lentamente los brazos.','https://www.youtube.com/watch?v=-t7fuZ0KhDA',0.07);
INSERT INTO "Ejercicio" VALUES (9,'Elevaciones de hombros con cable','Agarra un cable con una polea baja en cada mano y levanta los brazos hacia los lados, manteniéndolos rectos. Detente cuando los brazos estén paralelos al piso y luego baja lentamente los brazos','',0.06);
INSERT INTO "Ejercicio" VALUES (10,'Press de banca con barra','Acuéstate en un banco plano y sostén una barra con las manos separadas a la altura de los hombros. Luego, baja lentamente la barra hacia el pecho y luego levanta la barra hacia arriba. Este ejercicio trabaja principalmente el pectoral mayor.','https://www.youtube.com/watch?v=XSza8hVTlmM',0.1);
INSERT INTO "Ejercicio" VALUES (11,'Press de banca con mancuernas','Acuéstate en un banco plano y sostén una mancuerna en cada mano con los brazos extendidos. Luego, baja lentamente las mancuernas hacia el pecho y luego levanta las mancuernas hacia arriba.','https://www.youtube.com/watch?v=VmB1G1K7v94',0.09);
INSERT INTO "Ejercicio" VALUES (12,'Aperturas con mancuernas',' Acuéstate en un banco plano y sostén una mancuerna en cada mano con los brazos extendidos hacia el techo. Luego, baja lentamente las mancuernas hacia los lados, manteniendo los brazos rectos, y luego levanta las mancuernas hacia arriba.','https://youtu.be/xyHdY99F640',0.075);
INSERT INTO "Ejercicio" VALUES (13,'Fondos en paralelas','Sostén el borde de dos barras paralelas y levanta el cuerpo hacia arriba. Luego, baja lentamente el cuerpo hacia abajo y luego levanta el cuerpo hacia arriba','https://www.youtube.com/watch?v=wjUmnZH528Y',0.12);
INSERT INTO "Ejercicio" VALUES (14,'Flexiones de pecho',' Acuéstate en el suelo con las manos apoyadas en el suelo y los brazos extendidos. Luego, baja lentamente el cuerpo hacia abajo, manteniendo los codos cerca del cuerpo, y luego levanta el cuerpo hacia arriba.','https://www.youtube.com/watch?v=IODxDxX7oi4',0.075);
INSERT INTO "Ejercicio" VALUES (15,'Curl de bíceps con mancuernas','Este ejercicio se realiza de pie, con las piernas ligeramente separadas y los brazos extendidos hacia abajo, sosteniendo una mancuerna en cada mano. Desde esta posición, se flexionan los codos para levantar las mancuernas hacia los hombros, manteniendo los codos cerca del cuerpo','https://www.youtube.com/watch?v=uO_CNYidOw0',0.027);
INSERT INTO "Ejercicio" VALUES (16,'Curl de bíceps con barra',' Este ejercicio se realiza de pie, con las piernas ligeramente separadas y los brazos extendidos hacia abajo, sosteniendo una barra con pesas. Desde esta posición, se flexionan los codos para levantar la barra hacia los hombros, manteniendo los codos cerca del cuerpo','https://www.youtube.com/watch?v=kwG2ipFRgfo',0.03);
INSERT INTO "Ejercicio" VALUES (17,'Curl de bíceps con cable','Este ejercicio se realiza de pie, con una polea ajustada a una altura media, sosteniendo una empuñadura en cada mano. Desde esta posición, se flexionan los codos para levantar las empuñaduras hacia los hombros, manteniendo los codos cerca del cuerpo.','https://youtu.be/U6op1JiV0T8',0.027);
INSERT INTO "Ejercicio" VALUES (18,'Chin-ups',' Este ejercicio se realiza suspendido en una barra, con las palmas de las manos mirando hacia el cuerpo. Desde esta posición, se flexionan los codos para levantar el cuerpo hacia la barra, manteniendo los codos cerca del cuerpo','https://www.youtube.com/watch?v=-HVWW4pYo9E',0.04);
INSERT INTO "Ejercicio" VALUES (19,'Extensiones de tríceps con mancuernas','Acuéstate en un banco plano y sostén una mancuerna en cada mano con los brazos extendidos hacia el techo. Desde esta posición, flexiona los codos para bajar las mancuernas hacia la cabeza y luego extiende los codos para levantar las mancuernas hacia arriba.','https://www.youtube.com/watch?v=-Vyt2QdsR7E',0.045);
INSERT INTO "Ejercicio" VALUES (20,'Extensiones de antebrazo con mancuernas',' Este ejercicio se realiza sentado o de pie, sosteniendo una mancuerna en cada mano con los brazos extendidos hacia arriba y las palmas hacia abajo. Desde esta posición, se flexionan las muñecas para bajar las mancuernas hacia los antebrazos, manteniendo los codos apoyados.','https://www.youtube.com/watch?v=HrZ4NRvvZxc',0.02);
INSERT INTO "Ejercicio" VALUES (21,'Agarre con pinza','Este ejercicio se realiza con una pinza de agarre especial que permite fortalecer los músculos de la mano y los dedos. El ejercicio consiste en apretar la pinza de agarre con la mano y mantener la presión durante varios segundos antes de soltarla.','https://youtu.be/F_kWKT9IanU',0.02);
INSERT INTO "Ejercicio" VALUES (22,'Extensión de tríceps con cuerda en polea','Sujeta una cuerda en una polea alta con las manos y, con los codos pegados al cuerpo, extiende los brazos hacia abajo para trabajar los tríceps.','https://www.youtube.com/watch?v=2-LAMcpzODU',0.06);
INSERT INTO "Ejercicio" VALUES (23,'Plancha lateral','Este ejercicio se realiza en posición de plancha con los codos apoyados en el suelo y el cuerpo recto. Desde esta posición, se gira el cuerpo hacia un lado, apoyando un brazo en el suelo y levantando el otro brazo hacia el techo.','https://www.youtube.com/watch?v=bRivOELQVOs',0.03);
INSERT INTO "Ejercicio" VALUES (24,'Crunches laterales','Este ejercicio se realiza tumbado en el suelo con las piernas dobladas y los pies apoyados en el suelo. Desde esta posición, se levanta el torso hacia un lado, llevando el codo hacia la rodilla opuesta.','https://youtu.be/4sk9Z1Jbxkc',0.02);
INSERT INTO "Ejercicio" VALUES (25,'Crunch abdominal',' Acuéstate boca arriba con las rodillas flexionadas y las manos detrás de la cabeza. Levanta los hombros y la cabeza del suelo, contrayendo los abdominales. Vuelve a la posición inicial y repite','https://www.youtube.com/watch?v=Xyd_fa5zoEU',0.07);
INSERT INTO "Ejercicio" VALUES (26,'Plancha','Colócate en posición de flexión, apoyando los antebrazos en el suelo y manteniendo el cuerpo recto. Mantén esta posición durante unos segundos, contrayendo los músculos abdominales y manteniendo la espalda recta.','https://www.youtube.com/watch?v=pSHjTRCQxIw',0.05);
INSERT INTO "Ejercicio" VALUES (27,'Elevación de piernas','Acuéstate boca arriba con las manos debajo de los glúteos y levanta las piernas hacia el techo, manteniendo los abdominales contraídos. Baja las piernas lentamente sin tocar el suelo y repite.','https://www.youtube.com/watch?v=JB2oyawG9KI',0.09);
INSERT INTO "Ejercicio" VALUES (28,'Sentadillas','Colócate de pie con los pies separados a la altura de los hombros y baja el cuerpo doblando las rodillas y llevando las caderas hacia atrás. Mantén la espalda recta y vuelve a la posición inicial.','https://www.youtube.com/watch?v=aclHkVaku9U',0.09);
INSERT INTO "Ejercicio" VALUES (29,'Zancadas','Colócate de pie con los pies separados a la altura de los hombros y da un paso hacia adelante con una pierna, doblando la rodilla hasta que el muslo quede paralelo al suelo. Vuelve a la posición inicial y repite con la otra pierna.','https://www.youtube.com/watch?v=QF0BQS2W80k',0.1);
INSERT INTO "Ejercicio" VALUES (30,'Extensiones de piernas','Siéntate en una máquina de extensiones de piernas y levanta las piernas hacia arriba, extendiendo las rodillas hasta que las piernas estén completamente rectas. Baja las piernas lentamente y repite. ','https://www.youtube.com/watch?v=YyvSfVjQeL0',0.06);
INSERT INTO "Ejercicio" VALUES (31,'Sentadillas con salto','Colócate de pie con los pies separados a la altura de los hombros y baja el cuerpo doblando las rodillas y llevando las caderas hacia atrás. Salta hacia arriba desde la posición baja y vuelve a la posición inicial.','https://www.youtube.com/watch?v=CVaEhXotL7M',0.11);
INSERT INTO "Ejercicio" VALUES (32,'Elevación de talones con mancuernas','Párate con los pies separados a la anchura de los hombros y sostén una mancuerna en cada mano. Eleva los talones del suelo y mantén la posición por un momento antes de bajar los talones de nuevo. Este ejercicio puede ser realizado tanto de pie como sentado.','https://www.youtube.com/watch?v=kT-daLh6V2k',0.066);
INSERT INTO "Ejercicio" VALUES (33,'Saltos de tijera','Este es un ejercicio aeróbico que también ayuda a trabajar los gemelos. Comienza con los pies juntos y salta hacia adelante y hacia los lados, alternando las piernas mientras saltas.','https://www.youtube.com/watch?v=2P2_TjzqGLQ',0.122);
INSERT INTO "Ejercicio" VALUES (34,'Elevacion de talones en máquina',' Este ejercicio se realiza en una máquina de elevación de talones y consiste en elevar los talones del suelo y luego bajarlos de nuevo, utilizando la resistencia de la máquina.','',0.06);
INSERT INTO "Ejercicio" VALUES (35,'Extensiones de trícpes con mancuernas','De pie o sentado, sosteniendo una mancuerna con ambas manos detrás de la cabeza, extender los brazos hacia arriba.','https://www.youtube.com/watch?v=_gsUck-7M74',0.07);
INSERT INTO "Ejercicio" VALUES (36,'Extensiones de tríceps en polea alta','De pie, sujetando una cuerda o barra en una polea alta y extendiendo los brazos hacia abajo.','https://www.youtube.com/watch?v=-Vyt2QdsR7E',0.068);
INSERT INTO "Ejercicio" VALUES (37,'Press francés con mancuernas','Acostado en un banco, sostener una mancuerna con ambas manos y bajarla detrás de la cabeza, luego extender los brazos hacia arriba.','https://www.youtube.com/watch?v=Rn6LgSEPsDc',0.065);
INSERT INTO "Ejercicio" VALUES (38,'Dominadas','Agarrate a una barra por encima de la cabeza con las manos separadas al ancho de los hombros y levanta el cuerpo hasta que la barbilla esté por encima de la barra. Baja lentamente y repite.','',0.071);
INSERT INTO "Ejercicio" VALUES (39,'Remo con barra',' Agarra una barra con las manos separadas al ancho de los hombros y lleva la barra hacia el torso, manteniendo los codos cerca del cuerpo. Baja lentamente y repite.','https://www.youtube.com/watch?v=G8l_8chR5BE',0.064);
COMMIT;
