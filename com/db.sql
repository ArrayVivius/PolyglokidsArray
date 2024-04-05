CREATE TABLE IF NOT EXISTS polyglokids_db.user (
    id_user CHAR(36) PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    correo VARCHAR(255),
    contraseña VARCHAR(255),
    fecha_de_creacion DATE,
    cursos TEXT
);

-- Insertar un registro en la tabla 'user'
INSERT INTO polyglokids_db.user (id_user, nombre, apellido, correo, contraseña, fecha_de_creacion, cursos)
VALUES (
    '7c73c864-27c7-4d32-8e61-7e3de4a04a5e',
    'Nombre',
    'Apellido',
    'correo@example.com',
    'password',
    '2024-02-10',
    'Curso 1, Curso 2'
);
