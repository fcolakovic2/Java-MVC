BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Bus" (
	"bus_id"	INTEGER PRIMARY KEY AUTOINCREMENT,
    "proizvodjac"	text,                  /*u sql se ne koristi camelCase*/
	"serija"	text,
	"broj_sjedista"	int

);
CREATE TABLE IF NOT EXISTS "dodjela" (
	"bus_id"	INTEGER NOT NULL,
	"driver_id"	INTEGER NOT NULL,
	FOREIGN KEY("bus_id") REFERENCES "buses",
	CONSTRAINT "dodjelaPk" PRIMARY KEY("bus_id","driver_id"),
	CONSTRAINT "driver_id" FOREIGN KEY("driver_id") REFERENCES "drivers",
);
CREATE TABLE IF NOT EXISTS "Vozac" (
    "vozac_id"	int,
    "ime"	text,
	"prezime"	text,
	"JMB"	text,
	"datum_rodjenja"	date,
	"datum_zaposlenja"	date,

	CONSTRAINT "VozacPk" PRIMARY KEY("vozac_id")
);
COMMIT;
