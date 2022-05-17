package servlet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Comparator;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Catalogo {
    private SortedSet<Producto> productos;

    public Catalogo() {
        this.productos = new TreeSet<Producto>(new Comparator<Producto>(){
            @Override
            public int compare(Producto l1, Producto l2){
                return l1.getNombre().compareTo(l2.getNombre());
            }
        });

        Set<Producto> productoAux = new HashSet<>();

        try {
            productoAux = cargaProductos();
        } catch (Exception ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        insertarProductos(productoAux);
    }

    private void insertarProductos(Set<Producto> productos) {
        this.productos.addAll(productos);
    }

    private Set<Producto> cargaProductos() throws ParseException, org.json.simple.parser.ParseException {
        Set<Producto> productoAux = new HashSet<>();

        try{

            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\alber\\OneDrive\\Documentos\\NetBeansProjects\\MiTienda\\src\\java\\Productos\\productos.json"));
            
            for(Object o:a){
                JSONObject producto = (JSONObject) o;

                String codigo = (String) producto.get("codigo");
                String nombre = (String) producto.get("nombre");
                String precio = (String) producto.get("precio");
                

                productoAux.add(new Producto(codigo, nombre, precio));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productoAux;
    }

    public SortedSet<Producto> getProductos() {
        return productos;
    }

    public Producto getProducto(String name){
        for(Producto l:productos){
            if(l.getNombre().equals(name)){
                return l;
            }
        }
        return null;
    }







}
