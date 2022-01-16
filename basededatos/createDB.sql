DROP DATABASE db_tingeso;

-- Creación de la base de datos.
CREATE DATABASE db_tingeso 
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    TEMPLATE = template0
    LC_COLLATE = 'es_CL.UTF-8' 
    LC_CTYPE = 'es_CL.UTF-8';

-- Conexión de la Base de datos.
\connect db_tingeso;

DROP TABLE IF EXISTS Producto CASCADE;

CREATE TABLE Producto(
 id serial NOT NULL,
 codigoProducto text NOT NULL,
 nombreProducto text NOT NULL,
 fechaVencimiento DATE NOT NULL,
 categoriaProducto integer NOT NULL,
 precioProducto integer NOT NULL, 
 CONSTRAINT id PRIMARY KEY (id)
);

