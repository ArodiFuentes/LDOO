<%-- 
    Document   : buscar
    Created on : 25/10/2017, 10:05:26 PM
    Author     : Arodi Fuentes 1837486
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.ComentariosPOJO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if (session != null) {
                List comentarios = (List) session.getAttribute("comentarios");
                if (comentarios != null) {
        %>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Comentario</th>
            </tr>
            <%
                for (Object o : comentarios) {
                    ComentariosPOJO comentario = (ComentariosPOJO) o;

            %>
            <tr>
                <td><%=comentario.getNombre()%></td>
                <td><%=comentario.getComentario()%></td>
            </tr>
            <% }  %>
        </table>
        <% }
            }%>
        <form action="ComentariosControlador" method="POST">
            Busqueda de comentarios
            <br>
           Nombre
            <input type="text" name="nombre"/>
            <br>
            Comentario
            <textarea rows="4" cols="50" name="comentario"></textarea>
            <input type="submit" value="Enviar"/>
            <input type="hidden" name="accion" value="buscar"/>

        </form>
    </body>
</html>
