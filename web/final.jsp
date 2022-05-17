<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/header.css">
        <title>Final</title>
    </head>
    <body>
        
        <article>
            <h1>Mi Tienda</h1>
            <form  id="carrito" action="FrontServlet">
                <input type="hidden" name="command" value="CarritoCom"/>
                <input type="submit" value="Carrito"/> 
            </form>
        </article>
        <h1>Gracias por su compra</h1>
        <form action="FrontServlet">
            <input type="hidden" name="command" value="Volver"/>
            <input type="submit" value="volver al catalogo"/>
        </form>
    </body>
</html>
