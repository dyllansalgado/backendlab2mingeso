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

