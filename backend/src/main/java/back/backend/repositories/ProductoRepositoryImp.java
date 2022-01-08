package back.backend.repositories;


import back.backend.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ProductoRepositoryImp implements ProductoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Producto> getAllProducto(){
        String sql = "Select * from \"Producto\";";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Producto.class);
        }
    }

    @Override
    public Producto addProducto(Producto producto){
        String sql = "insert into \"Producto\"(codigoProducto,nombreProducto,fechaVencimiento,categoriaProducto,precioProducto) values (:codigo,:nombre,:fecha_vencimiento,:categoria,:precio);";
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery(sql)
                    .addParameter("codigoProducto", producto.getCodigoProducto())
                    .addParameter("nombreProducto",producto.getNombreProducto())
                    .addParameter("fechaVencimiento", producto.getFechaVencimiento())
                    .addParameter("categoriaProducto", producto.getCategoriaProducto())
                    .addParameter("precioProducto", producto.getPrecioProducto())
                    .executeUpdate().getKey();
            producto.setId(id);
            return producto;
        }
    }
    @Override
    public void deleteAllProducto(){
        String sql = "delete from \"Producto\";";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        }
    }

    @Override
    public Producto getProductoById(Long id){
        String sql = "select * from \"Producto\" where id_producto= :id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Producto.class);
        }
    }
    public void deleteProductoById(Long id){
        String sql = "delete from \"Producto\" where id_producto = :id;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }
    }
    
}