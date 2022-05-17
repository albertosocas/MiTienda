<%@page import="servlet.Producto"%>
<%@page import="servlet.Catalogo"%>
<%@page import="servlet.FrontServlet"%>
<%@page import="servlet.Carrito"%>
<%@page import="java.util.Set"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Carrito</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/carrito.css">
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
        
        
        
            <%
                Catalogo catalogo = FrontServlet.getCatalogo();
                Carrito carro = (Carrito)session.getAttribute("carroCompras");
                Set<String> carro2 = carro.getProductos();
                for(String l:carro2){

                Producto producto = catalogo.getProducto(l);
            %>
            
            <div id="productosCarrito">
                <%= l.toString()%>
                <form action="FrontServlet">
                    <input type="hidden" name="command" value="Eliminar"/>
                    <input type="hidden" name="producto" value="<%=l%>"/>
                    <input type="submit" value="eliminar"/>
                </form>
            </div>
            <%
                }
            %>
            <section id="botones">        
                <form action="FrontServlet">

                    <input type="hidden" name="command" value="Volver"/>
                    <input type="submit" value="volver"/>
                </form>

                <form action="FrontServlet">

                    <input type="hidden" name="command" value="Final"/>
                    <input type="submit" value="comprar"/>
                </form>
            </section>
    </body>
</html>
