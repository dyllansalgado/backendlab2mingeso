package back.backend.services;

//import back.backend.repositories.ProductoRepository;
import back.backend.models.Producto;
import back.backend.repositories.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;




@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ProductoService {

    private final ProductoRepository productoRepository;
    ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    //Obtener todos los productos lista
    @GetMapping("/producto/")
    public List<Producto> getAllProducto(){
        return productoRepository.getAllProducto();
    }
    //Agregar un producto
    @PostMapping("/producto/")
    @ResponseBody
    public Producto addProducto(@RequestBody Producto producto){
        Producto result = productoRepository.addProducto(producto);
        return result;
    }
    //Borrar todos los productos
    @DeleteMapping("/producto/")
    public String deleteAllProducto(){
        productoRepository.deleteAllProducto();
        return "Se han eliminado todos los productos";
    }
    //Obtener producto por id lista
    @GetMapping("/producto/{id}")
    public Producto getProducto(@PathVariable Long id){
        return productoRepository.getProductoById(id);
    }
    //Borrar un producto con id especifica
    @DeleteMapping("/producto/{id}")
    public String deleteProducto(@PathVariable Long id){
        productoRepository.deleteProductoById(id);
        return String.format("Se ha eliminado el producto con id=%s",id);
    }
}















