-- database: ../Database/Antbot.sqlite
DROP TABLE IF EXISTS ClasificacionHormigas;

CREATE TABLE
ClasificacionHormigas (
    IdCategoriaHormiga INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    ClasificacionHormiga TEXT NOT  NULL,
    FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')),
    FechaModifica DATETIME

);

-- DROP TABLE IF EXISTS InformacionHormigas;

-- CREATE TABLE
-- InformacionHormigas (
--     IdHormiga INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
--     CodigoHormiga TEXT NOT NULL,
--     IdCategoriaHormigas INTEGER NOT NULL REFERENCES ClasificacionHormigas(IdCategoriaHormiga),
--     SerieAntBot INTEGER NOT NULL,
--     FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')),
--     FechaModifica DATETIME
-- );