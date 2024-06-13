
drop database if exists skillswap;
create database skillswap;
use skillswap;
-- -----------------------------------------------------
-- Inserts for `tipo_usuario`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`tipo_usuario` (`descripcion`) VALUES 
('Admin'), 
('User');

-- -----------------------------------------------------
-- Inserts for `usuarios`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`usuarios` (`contrasenia`, `correo`, `estado`, `fecha_registro`, `tipo_usuarioid`) VALUES 
('password1', 'user1@example.com', b'1', '2023-01-01 00:00:00', 1),
('password2', 'user2@example.com', b'1', '2023-01-02 00:00:00', 2);

-- -----------------------------------------------------
-- Inserts for `amistades`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`amistades` (`amistad_aceptada`, `fecha_amistad`, `amigo_id`, `usuarioid`) VALUES 
(b'1', '2023-01-03', 2, 1);
-- -----------------------------------------------------
-- Inserts for `categoria_foros`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`categoria_foros` (`descripcion`, `fecha_creacion`, `nombre`) VALUES 
('General Discussion', '2023-01-01 00:00:00', 'General'), 
('Tech Talk', '2023-01-02 00:00:00', 'Tech');

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
('Programming', 1), 
('Design', 2);

-- -----------------------------------------------------
-- Inserts for `chat`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`chat` (`fecha_creacion`, `fecha_modificacion`, `nombre`) VALUES 
('2023-01-01 00:00:00', '2023-01-01 01:00:00', 'Chat Room 1'), 
('2023-01-02 00:00:00', '2023-01-02 01:00:00', 'Chat Room 2');

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
('Discussion about general topics', '2023-01-01 00:00:00', 'General Forum', 1, 1), 
('Discussion about tech', '2023-01-02 00:00:00', 'Tech Forum', 2, 2);

-- -----------------------------------------------------
-- Inserts for `discuciones`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`discuciones` (`descripcion`, `fecha_creacion`, `titulo`, `foro_id`, `usuario_id`) VALUES 
('Discussion about new features', '2023-01-03 00:00:00', 'New Features', 1, 1), 
('Discussion about programming languages', '2023-01-04 00:00:00', 'Programming Languages', 2, 2);

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
('Smith', 'A passionate developer', '1990-01-01 00:00:00', 'John', '123456789', 1, 1, 2), 
('Doe', 'A creative designer', '1992-02-02 00:00:00', 'Jane', '987654321', 2, 2, 1);

-- -----------------------------------------------------
-- Inserts for `habilidad`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`habilidad` (`descripcion`, `nombre`, `categoria_habilidad_id`, `perfil_id`) VALUES 
('Expert in PHP', 'PHP', 1, 1), 
('Expert in Photoshop', 'Photoshop', 2, 2);

-- -----------------------------------------------------
-- Inserts for `mensaje`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`mensaje` (`contenido`, `fecha_envio`, `chat_id`, `usuario_id`) VALUES 
('Hello, how are you?', '2023-01-01 00:00:00', 1, 1), 
('I am good, thanks!', '2023-01-01 00:05:00', 1, 2);

-- -----------------------------------------------------
-- Inserts for `notificaciones`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`notificaciones` (`contenido`, `fecha_creacion`, `leido`, `titulo`, `usuarioid`, `imagen_id`) VALUES 
('You have a new friend request', '2023-01-01 00:00:00', b'0', 'Friend Request', 1, 1), 
('Your post received a new comment', '2023-01-02 00:00:00', b'1', 'New Comment', 2, 2);

-- -----------------------------------------------------
-- Inserts for `respuestas`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`respuestas` (`contenido`, `fecha_creacion`, `discuciones_id`, `usuarioid`) VALUES 
('I agree with this point', '2023-01-01 00:00:00', 1, 1), 
('I have a different opinion', '2023-01-02 00:00:00', 2, 2);

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
('User logged in', '2023-01-01 00:00:00', 1), 
('User updated profile', '2023-01-02 00:00:00', 2);

-- -----------------------------------------------------
-- Inserts for `votos`
-- -----------------------------------------------------
INSERT INTO `skillswap`.`votos` (`fecha_voto`, `tipo_voto`, `respuesta_id`, `usuarioid`) VALUES 
('2023-01-01 00:00:00', b'1', 1, 1), 
('2023-01-02 00:00:00', b'0', 2, 2);
