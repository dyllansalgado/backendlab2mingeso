package back.backend.models;
import java.util.Date;

public class Producto{
    private Long id;
    private String codigoProducto;
    private String nombreProducto;
    private Date fechaVencimiento;
    private Integer categoriaProducto;
    private Integer precioProducto;

    //******GETTERS*******//
    public Long getId(){
        return id;
    }
    public String getCodigoProducto(){
        return codigoProducto;
    }
    public String getNombreProducto(){
        return nombreProducto;
    }
    public Date getFechaVencimiento(){
        return fechaVencimiento;
    }
    public Integer getCategoriaProducto(){
        return categoriaProducto;
    }
    public Integer getPrecioProducto(){
        return precioProducto;
    }

    //*****SETTERS******//
    public void setId(Long id){
        this.id = id;
    }
    public void setCodigoProducto(String codigoproducto){
        this.codigoProducto = codigoproducto;
    }
    public void setNombreProducto(String nombreproducto){
        this.nombreProducto = nombreproducto;
    }
    public void setFechaVencimiento(Date fechavencimiento){
        this.fechaVencimiento = fechavencimiento;
    }
    public void setCategoriaProducto(Integer categoriaproducto){
        this.categoriaProducto = categoriaproducto;
    }
    public void setPrecioProducto(Integer precioproducto){
        this.precioProducto = precioproducto;
    }
}
