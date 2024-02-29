-- database: ../Database/Antbot.sqlite
INSERT INTO
    ClasificacionHormigas (IdCategoriaHormiga, ClasificacionHormiga) VALUES 
    (1, 'Soldado'),
    (2, 'Rastreadora'),
    (3, 'Larva'),
    (4, 'Reina'),
    (5, 'Zangano');

INSERT INTO
    InformacionHormigas (CodigoHormiga, IdCategoriaHormigas, SerieAntBot) VALUES
    ('1A2B3C', 1, 1234);