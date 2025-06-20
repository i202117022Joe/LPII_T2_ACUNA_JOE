-- Eliminar la base de datos si ya existe
DROP DATABASE IF EXISTS BD_T2_ACUNA_ORTIZ_JOE;

-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS BD_T2_ACUNA_ORTIZ_JOE;
USE BD_T2_ACUNA_ORTIZ_JOE;

-- Tabla: responsable
CREATE TABLE responsable (
    id_responsable INT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL
);

-- Tabla: especie
CREATE TABLE especie (
    id_especie INT AUTO_INCREMENT PRIMARY KEY,
    nombre_comun VARCHAR(100) NOT NULL,
    nombre_cientifico VARCHAR(150) NOT NULL
);

-- Tabla: arbol
CREATE TABLE arbol (
    id_arbol INT AUTO_INCREMENT PRIMARY KEY,
    id_responsable INT NOT NULL,
    id_especie INT NOT NULL,
    fecha_plantacion DATE NOT NULL,
    coordenadas VARCHAR(50) NOT NULL, -- Ej: "12.04318,-77.02824"
    hash_registro VARCHAR(64) NOT NULL, -- SHA-256 o similar

    -- Claves foráneas
    CONSTRAINT fk_responsable FOREIGN KEY (id_responsable) REFERENCES responsable(id_responsable),
    CONSTRAINT fk_especie FOREIGN KEY (id_especie) REFERENCES especie(id_especie)
);
