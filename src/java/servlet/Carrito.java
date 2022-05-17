package servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.HashSet;
import java.util.Set;

public class Carrito {
    private Set<String> productos;

    public Carrito() {
        this.productos = new HashSet<String>();
    }

    public void insertarProducto(String producto) {
        this.productos.add(producto);
    }

    public void removerProducto(String producto){
        this.productos.remove(producto);
    }  

    public void limpiar(){  
        this.productos.clear();
    }  

    public Set<String> getProductos() {
        return productos;
    }
}
