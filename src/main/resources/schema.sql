-- Eliminar tablas existentes (en caso de que existan)
DROP TABLE IF EXISTS cazadoresparanormales.equipo_encuentro;
DROP TABLE IF EXISTS cazadoresparanormales.encuentro_paranormal;
DROP TABLE IF EXISTS cazadoresparanormales.caso;
DROP TABLE IF EXISTS cazadoresparanormales.equipo;
DROP TABLE IF EXISTS cazadoresparanormales.miembro;

-- Crear tabla Miembro
CREATE TABLE cazadoresparanormales.miembro
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(255)                                              NOT NULL,
    rol          ENUM ('Investigador', 'Medium', 'Tecnico', 'Historiador') NOT NULL,
    edad         INT                                                       NOT NULL,
    especialidad TEXT                                                      NOT NULL

);

-- Crear tabla Equipo (relación 1 a 1 con Miembro)
CREATE TABLE cazadoresparanormales.equipo
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre           VARCHAR(255)                                                  NOT NULL,
    tipo             ENUM ('ELECTROMAGNETICO', 'TERMICO', 'FOTOGRAFICO', 'SONORO') NOT NULL,
    estado_funcional BOOLEAN                                                       NOT NULL,
    id_miembro       BIGINT UNIQUE                                                 NOT NULL, -- Relación 1 a 1 con Miembro
    FOREIGN KEY (id_miembro) REFERENCES cazadoresparanormales.miembro (id)
);

-- Crear tabla Caso (relación 1 a muchos con Miembro)
CREATE TABLE cazadoresparanormales.caso
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre          VARCHAR(255)                   NOT NULL,
    ubicacion       VARCHAR(255)                   NOT NULL,
    nivel_actividad ENUM ('BAJO', 'MEDIO', 'ALTO') NOT NULL,
    fecha_apertura  DATE                           NOT NULL,
    id_miembro      BIGINT                         NOT NULL, -- Relación 1 a muchos con Miembro
    FOREIGN KEY (id_miembro) REFERENCES cazadoresparanormales.miembro (id)
);

-- Crear tabla Encuentro Paranormal
CREATE TABLE cazadoresparanormales.encuentro_paranormal
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(255)                                        NOT NULL,
    descripcion   TEXT                                                NOT NULL,
    fecha         DATE                                                NOT NULL,
    tipo_fenomeno ENUM ('APARICION', 'POLTERGEIST', 'EVP', 'DEMONIO') NOT NULL
);

CREATE TABLE cazadoresparanormales.equipo_encuentro
(
    id           BIGINT auto_increment PRIMARY KEY,
    id_equipo    BIGINT NOT NULL,
    id_encuentro BIGINT NOT NULL,
    FOREIGN KEY (id_equipo) REFERENCES cazadoresparanormales.equipo (id),
    FOREIGN KEY (id_encuentro) REFERENCES cazadoresparanormales.encuentro_paranormal (id)
);

SHOW COLUMNS FROM encuentro_paranormal;
SHOW COLUMNS FROM equipo_encuentro;

SELECT COUNT(*)
FROM equipo_encuentro
WHERE id_equipo = ?
  AND id_encuentro = ?;
