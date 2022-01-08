package back.backend.repositories;
import back.backend.models.Producto;
import java.util.List;

public interface ProductoRepository{
    public List<Producto> getAllProducto();
    public Producto addProducto(Producto producto);
    public void deleteAllProducto();
    public void deleteProductoById(Long id);
    public Producto getProductoById(Long id);
    public Long contadorProducto();
}