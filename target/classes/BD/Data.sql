
drop database if exists skillswap;
create database skillswap;
use skillswap;
-- -----------------------------------------------------
-- Inserts for `tipo_usuario`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`tipo_usuario` (`descripcion`) VALUES 
('Admin'), 
('Usuario');

-- -----------------------------------------------------
-- Inserts for `usuarios`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`usuarios` (`contrasenia`, `correo`, `estado`, `fecha_registro`, `tipo_usuarioid`) VALUES 
('contrasenia1', 'admin@example.com', b'1', '2023-01-01 00:00:00', 1),
('contrasenia2', 'usuario@example.com', b'1', '2023-01-02 00:00:00', 2);

-- -----------------------------------------------------
-- Inserts for `amistades`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`amistades` (`amistad_aceptada`, `fecha_amistad`, `amigo_id`, `usuarioid`) VALUES 
(b'1', '2023-01-03', 2, 1);

-- -----------------------------------------------------
-- Inserts for `categoria_foros`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`categoria_foros` (`descripcion`, `fecha_creacion`, `nombre`) VALUES 
('Discusión General', '2023-01-01 00:00:00', 'General'), 
('Charla Técnica', '2023-01-02 00:00:00', 'Técnica');

-- -----------------------------------------------------
-- Inserts for `imagen`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`imagen` (`contenido`, `estado`) VALUES 
(LOAD_FILE('/path/to/image1.jpg'), b'1'), 
(LOAD_FILE('/path/to/image2.jpg'), b'0');

-- -----------------------------------------------------
-- Inserts for `categoria_habilidad`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`categoria_habilidad` (`nombre`, `imagen_id`) VALUES 
('Programación', 1), 
('Diseño', 2);

-- -----------------------------------------------------
-- Inserts for `chat`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`chat` (`fecha_creacion`, `fecha_modificacion`, `nombre`) VALUES 
('2023-01-01 00:00:00', '2023-01-01 01:00:00', 'Sala de Chat 1'), 
('2023-01-02 00:00:00', '2023-01-02 01:00:00', 'Sala de Chat 2');

-- -----------------------------------------------------
-- Inserts for `chat_usuario`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`chat_usuario` (`chat_id`, `usuario_id`) VALUES 
(1, 1), 
(1, 2), 
(2, 1);

-- -----------------------------------------------------
-- Inserts for `foros`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`foros` (`descripcion`, `fecha_creacion`, `titulo`, `categoria_foro_id`, `usuario_id`) VALUES 
('Discusión sobre temas generales', '2023-01-01 00:00:00', 'Foro General', 1, 1), 
('Discusión sobre tecnología', '2023-01-02 00:00:00', 'Foro Técnico', 2, 2);

-- -----------------------------------------------------
-- Inserts for `discuciones`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`discuciones` (`descripcion`, `fecha_creacion`, `titulo`, `foro_id`, `usuario_id`) VALUES 
('Discusión sobre nuevas características', '2023-01-03 00:00:00', 'Nuevas Características', 1, 1), 
('Discusión sobre lenguajes de programación', '2023-01-04 00:00:00', 'Lenguajes de Programación', 2, 2);

-- -----------------------------------------------------
-- Inserts for `tags`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`tags` (`nombre`) VALUES 
('PHP'), 
('MySQL'), 
('JavaScript');

-- -----------------------------------------------------
-- Inserts for `discuciones_tags`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`discuciones_tags` (`tags_id`, `discuciones_id`) VALUES 
(1, 1), 
(2, 1), 
(3, 2);

-- -----------------------------------------------------
-- Inserts for `perfil`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`perfil` (`apellido`, `biografia`, `fecha_nacimiento`, `nombre`, `telefono`, `usuarioid`, `imagen_cabecera_id`, `imagen_perfil_id`) VALUES 
('Pérez', 'Desarrollador apasionado', '1990-01-01 00:00:00', 'Juan', '123456789', 1, 1, 2), 
('Gómez', 'Diseñadora creativa', '1992-02-02 00:00:00', 'Ana', '987654321', 2, 2, 1);

-- -----------------------------------------------------
-- Inserts for `habilidad`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`habilidad` (`descripcion`, `nombre`, `categoria_habilidad_id`, `perfil_id`) VALUES 
('Experto en PHP', 'PHP', 1, 1), 
('Experta en Photoshop', 'Photoshop', 2, 2);

-- -----------------------------------------------------
-- Inserts for `mensaje`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`mensaje` (`contenido`, `fecha_envio`, `chat_id`, `usuario_id`) VALUES 
('Hola, ¿cómo estás?', '2023-01-01 00:00:00', 1, 1), 
('Estoy bien, gracias!', '2023-01-01 00:05:00', 1, 2);

-- -----------------------------------------------------
-- Inserts for `notificaciones`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`notificaciones` (`contenido`, `fecha_creacion`, `leido`, `titulo`, `usuarioid`, `imagen_id`) VALUES 
('Tienes una nueva solicitud de amistad', '2023-01-01 00:00:00', b'0', 'Solicitud de Amistad', 1, 1), 
('Tu publicación recibió un nuevo comentario', '2023-01-02 00:00:00', b'1', 'Nuevo Comentario', 2, 2);

-- -----------------------------------------------------
-- Inserts for `respuestas`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`respuestas` (`contenido`, `fecha_creacion`, `discuciones_id`, `usuarioid`) VALUES 
('Estoy de acuerdo con este punto', '2023-01-01 00:00:00', 1, 1), 
('Tengo una opinión diferente', '2023-01-02 00:00:00', 2, 2);

-- -----------------------------------------------------
-- Inserts for `sesion`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`sesion` (`usuarioid`) VALUES 
(1), 
(2);

-- -----------------------------------------------------
-- Inserts for `transaccion_log`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`transaccion_log` (`descripcion`, `fecha_creacion`, `usuarioid`) VALUES 
('Usuario inició sesión', '2023-01-01 00:00:00', 1), 
('Usuario actualizó su perfil', '2023-01-02 00:00:00', 2);

-- -----------------------------------------------------
-- Inserts for `votos`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`votos` (`fecha_voto`, `tipo_voto`, `respuesta_id`, `usuarioid`) VALUES 
('2023-01-01 00:00:00', b'1', 1, 1), 
('2023-01-02 00:00:00', b'0', 2, 2);
