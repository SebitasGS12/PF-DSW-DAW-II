
drop database if exists skillswap;
create database skillswap;
use skillswap;
-- Insertar datos de prueba para tabla tipo_usuario
INSERT INTO tipo_usuario (descripcion) VALUES
('Usuario estándar'),
('Usuario premium');

-- Insertar datos de prueba para tabla usuarios
INSERT INTO usuarios (contrasenia, correo, estado, fecha_registro, tipo_usuarioid) VALUES
('contrasenia123', 'usuario1@example.com', 1, '2024-06-30', 1),
('clave456', 'usuario2@example.com', 1, '2024-06-30', 2),
('password789', 'usuario3@example.com', 1, '2024-07-01', 1);

-- Insertar datos de prueba para tabla amistades
INSERT INTO amistades (amistad_aceptada, fecha_amistad, amigo_id, usuarioid) VALUES
(1, '2024-06-30', 2, 1),
(1, '2024-06-30', 1, 2),
(0, '2024-07-01', 3, 1);

-- Insertar datos de prueba para tabla categoria_foros
INSERT INTO categoria_foros (descripcion, fecha_creacion, nombre) VALUES
('Categoría 1', '2024-06-30', 'Deportes'),
('Categoría 2', '2024-06-30', 'Tecnología');

-- Insertar datos de prueba para tabla imagen
INSERT INTO imagen (contenido, estado) VALUES
(NULL, 1),
(NULL, 1),
(NULL, 1);

-- Insertar datos de prueba para tabla categoria_habilidad
INSERT INTO categoria_habilidad (nombre, imagen_id) VALUES
('Programación', 1),
('Diseño gráfico', 2),
('Inglés', 3);

-- Insertar datos de prueba para tabla chat
INSERT INTO chat (fecha_creacion, fecha_modificacion, nombre) VALUES
('2024-06-30', '2024-06-30', 'Chat de Deportes'),
('2024-06-30', '2024-06-30', 'Chat de Tecnología');

-- Insertar datos de prueba para tabla chat_usuario
INSERT INTO chat_usuario (amigo_id, chat_id, usuario_id) VALUES
(2, 1, 1),
(1, 2, 2),
(3, 2, 3);

-- Insertar datos de prueba para tabla foros
INSERT INTO foros (descripcion, fecha_creacion, titulo, categoria_foro_id, usuario_id) VALUES
('Foro sobre fútbol', '2024-06-30', 'Fútbol en América Latina', 1, 1),
('Foro sobre gadgets', '2024-06-30', 'Últimos lanzamientos tecnológicos', 2, 2);

-- Insertar datos de prueba para tabla discuciones
INSERT INTO discuciones (descripcion, fecha_creacion, titulo, foro_id, usuario_id) VALUES
('Discusión sobre la liga nacional', '2024-06-30', 'Liga de fútbol peruana', 1, 1),
('Discusión sobre smartphones', '2024-06-30', 'Comparación de modelos', 2, 2);

-- Insertar datos de prueba para tabla tags
INSERT INTO tags (nombre) VALUES
('Deporte'),
('Tecnología'),
('Fútbol');

-- Insertar datos de prueba para tabla discuciones_tags
INSERT INTO discuciones_tags (tags_id, discuciones_id) VALUES
(1, 1),
(2, 2),
(3, 1);

-- Insertar datos de prueba para tabla perfil
INSERT INTO perfil (apellido, biografia, fecha_nacimiento, nombre, telefono, imagen_cabecera_id, imagen_perfil_id, usuarioid) VALUES
('Pérez', 'Apasionado por el fútbol', '1990-01-01', 'Juan', '123456789', 1, 2, 1),
('López', 'Entusiasta de la tecnología', '1985-03-15', 'Ana', '987654321', 2, 3, 2),
('García', 'Interesado en múltiples habilidades', '1995-07-20', 'Pedro', '567890123', 3, 1, 3);

-- Insertar datos de prueba para tabla habilidad
INSERT INTO habilidad (descripcion, nombre, categoria_habilidad_id, perfil_id) VALUES
('Desarrollo web', 'Programación', 1, 1),
('Edición de imágenes', 'Diseño gráfico', 2, 2),
('Conversación fluida', 'Inglés', 3, 3);

-- Insertar datos de prueba para tabla mensaje
INSERT INTO mensaje (contenido, fecha_envio, chat_id, usuario_id) VALUES
('Hola amigo', '2024-06-30', 1, 1),
('Hola qué tal', '2024-06-30', 2, 2),
('Buenos días', '2024-07-01', 2, 3);

-- Insertar datos de prueba para tabla notificaciones
INSERT INTO notificaciones (contenido, fecha_creacion, leido, titulo, amigoid, imagen_id, usuarioid) VALUES
('Nuevo mensaje recibido', '2024-06-30', 0, 'Notificación 1', 2, 1, 1),
('Actualización de perfil', '2024-06-30', 1, 'Notificación 2', 1, 2, 2),
('Nueva solicitud de amistad', '2024-07-01', 0, 'Notificación 3', 3, 3, 3);

-- Insertar datos de prueba para tabla respuestas
INSERT INTO respuestas (contenido, fecha_creacion, discuciones_id, usuarioid) VALUES
('Totalmente de acuerdo', '2024-06-30', 1, 1),
('Interesante punto de vista', '2024-06-30', 2, 2),
('No estoy seguro', '2024-07-01', 1, 3);

-- Insertar datos de prueba para tabla sesion
INSERT INTO sesion (usuarioid) VALUES
(1),
(2),
(3);

-- Insertar datos de prueba para tabla votos
INSERT INTO votos (fecha_voto, tipo_voto, respuesta_id, usuarioid) VALUES
('2024-06-30', 1, 1, 1),
('2024-06-30', 0, 2, 2),
('2024-07-01', 1, 1, 3);
