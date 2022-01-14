package back.backend.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import back.backend.models.Producto;
import java.util.Date;

@SpringBootTest
public class ProductoTest {
    int id = 3;
    String codigoProducto = "1000100";
    String nombreProducto = "producto_4";
    Integer categoriaProducto = 1;
    Integer precioProducto = 2500;

    Producto producto = new Producto();

    @Test
    public void testCodigoProducto() {
        producto.setCodigoProducto("1000100");
        Assertions.assertEquals(codigoProducto, producto.getCodigoProducto(), "Listo");
    }

    @Test
    public void testPrecioProducto() {
        producto.setPrecioProducto(2500);
        Assertions.assertEquals(precioProducto, producto.getPrecioProducto(), "Listo");
    }

    @Test
    public void testNombreProducto() {
        producto.setNombreProducto("nombre_4");
        Assertions.assertEquals(nombreProducto, producto.getNombreProducto(), "Listo");
    }

}
