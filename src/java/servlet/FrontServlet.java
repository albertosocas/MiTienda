package servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ApplicationException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/FrontServlet"})
public class FrontServlet extends HttpServlet {
    static Catalogo catalogo = new Catalogo();


    public static Catalogo getCatalogo() {
        return catalogo;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        Carrito carro = (Carrito)session.getAttribute("carroCompras");

        if(carro == null){
            carro = new Carrito();
            session.setAttribute("carroCompras", carro);
        }

        FrontCommand command= null;
        try {
            command = getCommand(request);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        command.init(getServletContext(), request, response);
        command.process();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    private FrontCommand getCommand(HttpServletRequest request) throws InstantiationException, IllegalAccessException{
        
        FrontCommand f = (FrontCommand) getCommandClass(request).newInstance();
        return f;
        
    }

    private Class getCommandClass(HttpServletRequest request){
        Class result;
        final String command = "servlet."+(String)request.getParameter("command") ;
        
        try {
            result = Class.forName(command);
            
        }catch(ClassNotFoundException e)    {
            result = Error.class;
            System.out.println(result);
        }
        return result;
    }


}
