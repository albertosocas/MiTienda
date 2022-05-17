package servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Eliminar extends FrontCommand{
    public void process(){
        HttpSession session = request.getSession(true);

        Carrito carro;
        carro = (Carrito)session.getAttribute("carroCompras");

        carro.removerProducto(request.getParameter("producto"));


        try {
            forward("/carrito.jsp");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
