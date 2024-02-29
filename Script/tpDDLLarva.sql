-- database: ../Database/ComidasLarva.sqlite
DROP TABLE IF EXISTS Larva;

CREATE TABLE 
Larva (
  IdHormiga INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  codigoHormiga TEXT NOT NULL,
  clasificacion TEXT NOT NULL,
  Comio TEXT NOT NULL,
  Estado TEXT NOT NULL,
  Recogio TEXT NOT NULL  
);