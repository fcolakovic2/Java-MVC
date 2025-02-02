BEGIN TRANSACTION;

CREATE TABLE IF NOT EXISTS "Vozac" (
	"vozac_id"	INTEGER,
	"ime"	TEXT,
	"prezime"	TEXT,
	"JMB"	TEXT,
	"datum_rodjenja"	DATE,
	"datum_zaposljenja"	DATE,
	PRIMARY KEY("vozac_id")
);
CREATE TABLE IF NOT EXISTS "Bus" (
	"bus_id"	INTEGER,
	"proizvodjac"	TEXT,
	"serija"	TEXT,
	"broj_sjedista"	INTEGER,
	"broj_vozaca"	INTEGER,
	PRIMARY KEY("bus_id")
);

CREATE TABLE IF NOT EXISTS "VozaciBuseva" (
"VozaciBuseva_id"	int,
	"driverId"	int,
	"busId"	int,
	PRIMARY KEY("VozaciBuseva_id"),
	FOREIGN KEY("busId") REFERENCES "Bus"("bus_id"),
	FOREIGN KEY("driverId") REFERENCES "Vozac"("vozac_id")
);

COMMIT;