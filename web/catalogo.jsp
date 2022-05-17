<%@page import="servlet.FrontServlet"%>
<%@page import="servlet.Producto"%>
<%@page import="java.util.SortedSet"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Catalogo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/header.css">
    </head>
    <body>
        <article>
            <h1>Mi Tienda</h1>
            <form  id="carrito" action="FrontServlet">
                <input type="hidden" name="command" value="CarritoCom"/>
                <input type="submit" value="Carrito"/> 
            </form>
        </article>
        
        <br/>
        
        <%
            SortedSet<Producto> catalogo = FrontServlet.getCatalogo().getProductos();
            
            for(Producto l:catalogo){
        %>

        <div id="listaproductos">
            <%= l.toString()%> 
            <form action="FrontServlet">
                <input type="hidden" name="command" value="Comprar"/>
                <input type="hidden" name="producto" value="<%=l.getNombre()%>"/>
                <input id="comprarproducto" type="submit" value="Añadir al carrito"/>
            </form>
        </div>
        <%
            }
        %>
            
    </body>
</html>
