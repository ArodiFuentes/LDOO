/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Arodi Fuentes 1837486
 */
public class ComentariosDAO {

    private Connection conexion;

    private void abrirConexion() throws SQLException {
        String dbURI = "jdbc:derby://localhost:1527/COMENTARIOS";

        String username = "fcfm";
        String password = "lsti01";
        conexion = DriverManager.getConnection(dbURI, username, password);

    }

    private void cerrarConexion() throws SQLException {
        conexion.close();
    }

    public void insertar(ComentariosPOJO cm) {
        try {
            abrirConexion();
            String sql = "insert into COMENTARIOS values('" + cm.getNombre() + "'," + "'" + cm.getComentario() + "')";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            cerrarConexion();

        } catch (SQLException sqle) {
            System.out.println("Something went wrong =( ");
        }

    }

    public List buscar(ComentariosPOJO pojo) {
        ResultSet result;
        List beans = new ArrayList();
        try {
            abrirConexion();
            String sql = "select * from COMENTARIOS where NOMBRE = '" + pojo.getNombre() + "' and COMENTARIO like '%" + pojo.getComentario() + "%'";
            Statement stmt = conexion.createStatement();
            ResultSet mensajes = stmt.executeQuery(sql);
            while (mensajes.next()) {
                String nombre = mensajes.getString("nombre");
                String comentarios = mensajes.getString("comentario");
                ComentariosPOJO POJO = new ComentariosPOJO();
                POJO.setNombre(nombre);
                POJO.setComentario(comentarios);
                beans.add(POJO);
            }
            cerrarConexion();
        } catch (SQLException sq) {
            System.out.println("Algo salio mal");
        }
        return beans;
    }

}
