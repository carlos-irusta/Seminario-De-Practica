-- Creación de tablas

-- Tabla clientes
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    contraseña VARCHAR(255),
    tipo_usuario ENUM('cliente', 'administrador', 'entrenador'),
    fecha_creacion DATETIME
);

-- Tabla espacios
CREATE TABLE espacios (
    id_espacio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    capacidad INT,
    estado ENUM('disponible', 'ocupado', 'mantenimiento'),
    tipo_espacio VARCHAR(100)
);

-- Tabla Entrenador
CREATE TABLE entrenadores (
    id_entrenador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    especialidad VARCHAR(150)
);

-- Tabla reservas
CREATE TABLE reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_espacio INT,
    fecha_reserva DATETIME,
    estado ENUM('confirmada', 'cancelada', 'completada'),
    fecha_creacion DATETIME,
    FOREIGN KEY (id_usuario) REFERENCES clientes(id_cliente) ON DELETE CASCADE,
    FOREIGN KEY (id_espacio) REFERENCES espacios(id_espacio)
);

-- Tabla Clase/Sesión
CREATE TABLE clases (
    id_clase INT AUTO_INCREMENT PRIMARY KEY,
    nombre_clase VARCHAR(100),
    id_entrenador INT,
    id_espacio INT,
    fecha_clase DATETIME,
    duracion INT,
    FOREIGN KEY (id_entrenador) REFERENCES Entrenador(id_entrenador),
    FOREIGN KEY (id_espacio) REFERENCES espacios(id_espacio)
);

-- Inserción de registros

-- Insertar múltiples clientes
INSERT INTO clientes (nombre, apellido, email, contraseña, tipo_usuario, fecha_creacion)
VALUES 
('Juan', 'Pérez', 'juan.perez@email.com', 'password123', 'cliente', NOW()),
('María', 'Gómez', 'maria.gomez@email.com', 'password456', 'cliente', NOW()),
('Pedro', 'Martínez', 'pedro.martinez@email.com', 'password789', 'cliente', NOW()),
('Ana', 'López', 'ana.lopez@email.com', 'password101', 'cliente', NOW()),
('Carlos', 'Hernández', 'carlos.hernandez@email.com', 'password102', 'cliente', NOW());

-- Insertar una nueva reserva
INSERT INTO reservas (id_usuario, id_espacio, fecha_reserva, estado, fecha_creacion)
VALUES (1, 2, '2024-10-05 10:00:00', 'confirmada', NOW());

-- Insertar un nuevo espacio
INSERT INTO espacios (nombre, capacidad, estado, tipo_espacio)
VALUES ('Sala de Yoga', 20, 'disponible', 'sala');

-- Insertar una nueva clase/sesión
INSERT INTO clases (nombre_clase, id_entrenador, id_espacio, fecha_clase, duracion)
VALUES ('Clase de CrossFit', 1, 3, '2024-10-06 15:00:00', 60);

-- Consultas

-- Consultar todos los clientes
SELECT * FROM clientes;

-- Consultar todas las reservas de un cliente específico
SELECT * FROM reservas
WHERE id_usuario = 1;

-- Consultar disponibilidad de un espacio
SELECT * FROM espacios
WHERE estado = 'disponible';

-- Consultar las clases asignadas a un entrenador
SELECT * FROM clases
WHERE id_entrenador = 1;

-- Borrado de registros

-- Eliminar un cliente (y sus reservas asociadas, si tienes ON DELETE CASCADE)
DELETE FROM clientes
WHERE id_cliente = 1;

-- Eliminar una reserva específica
DELETE FROM reservas
WHERE id_reserva = 5;

-- Eliminar un espacio (solo si no tiene reservas activas)
DELETE FROM espacios
WHERE id_espacio = 3;

-- Eliminar una clase/sesión
DELETE FROM clases
WHERE id_clase = 2;

