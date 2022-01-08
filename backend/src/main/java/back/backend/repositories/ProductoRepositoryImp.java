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
    public Long contadorProducto(){
        String query = "select count(*) from producto";
        Connection conn = sql2o.open();
        Long resultado = (Long) conn.createQuery(query,true).executeAndFetchFirst(Long.class);
        return resultado + 1; 
    }
    @Override
    public List<Producto> getAllProducto(){
        String sql = "Select * from Producto";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Producto.class);
        }
    }
    @Override
    public Producto addProducto(Producto producto) {
        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery("INSERT INTO producto (codigoProducto,nombreProducto,fechaVencimiento,categoriaProducto,precioProducto) values (:codigoProducto,:nombreProducto,:fechaVencimiento,:categoriaProducto,:precioProducto)", true)
                    .addParameter("codigoProducto", producto.getCodigoProducto())
                    .addParameter("nombreProducto",producto.getNombreProducto())
                    .addParameter("fechaVencimiento", producto.getFechaVencimiento())
                    .addParameter("categoriaProducto", producto.getCategoriaProducto())
                    .addParameter("precioProducto", producto.getPrecioProducto())
                    .executeUpdate().getKey();
            producto.setId(insertedId);
            return producto;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    @Override
    public void deleteAllProducto(){
        String sql = "delete from Producto";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        }
    }

    @Override
    public Producto getProductoById(Long id){
        String sql = "select * from Producto where id= :id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Producto.class);
        }
    }
    public void deleteProductoById(Long id){
        String sql = "delete from Producto where id = :id;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }
    }
    
}