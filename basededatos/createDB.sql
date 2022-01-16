DROP DATABASE db_tingeso;

-- Creación de la base de datos.
CREATE DATABASE db_tingeso;

-- Conexión de la Base de datos.
--\connect db_tingeso;

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

INSERT INTO PRODUCTO(codigoProducto, nombreProducto,fechaVencimiento,categoriaProducto,precioProducto)
VALUES (100,'nombre_1','10-10-2022',0,2000);
INSERT INTO PRODUCTO(codigoProducto, nombreProducto,fechaVencimiento,categoriaProducto,precioProducto)
VALUES (1000,'nombre_2','10-10-2022',1,1000);
INSERT INTO PRODUCTO(codigoProducto, nombreProducto,fechaVencimiento,categoriaProducto,precioProducto)
VALUES (2000,'nombre_3','10-10-2022',1,1500);