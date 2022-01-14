package back.backend.Test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductoSelenium {

    // Se declara el driver para el navegador Web
    private static WebDriver driver;

    // Antes de hace cualquier test se instancia el driver de firefox
    // Y se configura el wait implicito
    @BeforeAll
    public static void setupDriver() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Despues de ejecutar todos los test se cierra el driver del navegador Web
    @AfterAll
    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Despues de cada test se espera un tiempo de 5 segundos
    // Para ver el resultado y dejar que los datos se actualicen
    @AfterEach
    public void afterSleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }

    // Prueba para derigirse a la página de los productos y visualizar todos los
    // productos
    @Test
    @Order(1)
    public void initWeb() {
        // Se dirige a la página de Log In
        driver.get("http://localhost:3000/home");
        // Se busca el boton de inicio
        WebElement iniciar = driver.findElement(By.linkText("Ir a productos"));
        iniciar.click();
    }

    @Test
    @Order(2)
    public void deleteProducto() {
        // Se busca un elemento a eliminar
        driver.get("http://localhost:3000/productos");
        // Se elimina el producto con el nombre_!
        WebElement delete = driver.findElement(By.linkText("Nombre Producto: nombre_1"));
        // Luego que encuentra el elemento lo elimina en la misma tarde
        WebElement deletes = delete.findElement(By.linkText("Eliminar"));
        deletes.click();

    }

}
