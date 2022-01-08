DROP TABLE IF EXISTS Producto CASCADE;
CREATE TABLE Producto(
 idProducto serial NOT NULL,
 codigoProducto int NOT NULL,
 nombreProducto text NOT NULL,
 fechaVencimiento DATE NOT NULL,
 categoriaProducto int NOT NULL,
 precioProducto int NOT NULL,
 deleted boolean NOT NULL,
 CONSTRAINT idProducto PRIMARY KEY (idProducto)
);

