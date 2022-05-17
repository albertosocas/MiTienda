package servlet;


public class Producto {
    private String codigo;
    private String nombre;
    private String precio;

    public Producto(String codigo, String nombre, String precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String toString(){
        return nombre + ": " + precio +"€" ;
    }

}
