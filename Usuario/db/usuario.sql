DROP DATABASE IF EXISTS poo2_usuario;
CREATE DATABASE poo2_usuario;

USE poo2_usuario;

drop table if exists usuario;
create table usuario (
  id int(10) NOT NULL AUTO_INCREMENT UNIQUE,
  documento bigint NOT NULL UNIQUE,
  nombre varchar(50) NOT NULL,
  fecha_nacimiento date NOT NULL,
  creado timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ,
  modificado timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DISPARADORES
DELIMITER $$
DROP TRIGGER IF EXISTS  usuario_BEFORE_INSERT$$
CREATE TRIGGER usuario_BEFORE_INSERT BEFORE INSERT ON usuario
FOR EACH ROW BEGIN
    SET new.creado = now();
END
$$
DELIMITER ;
