CREATE TABLE foros (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       idUsuario INT NOT NULL,
                       mensaje TEXT NOT NULL,
                       nombreCurso VARCHAR(255) NOT NULL,
                       titulo VARCHAR(255) NOT NULL
);
