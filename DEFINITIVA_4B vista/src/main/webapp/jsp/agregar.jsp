<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%
    // Obtener los datos del formulario
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    String fecha = request.getParameter("fecha");
    int estado = Integer.parseInt(request.getParameter("estado"));

    // Configurar los detalles de conexión a la base de datos
    String url = "jdbc:mysql://localhost:3306/nombre_de_tu_base_de_datos"; // Reemplaza "nombre_de_tu_base_de_datos" con el nombre de tu base de datos
    String username = "tu_usuario";  // Reemplaza "tu_usuario" con tu nombre de usuario de MySQL
    String password = "tu_contraseña";  // Reemplaza "tu_contraseña" con tu contraseña de MySQL

    // Establecer la conexión a la base de datos
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);

        // Preparar la consulta SQL
        String sql = "INSERT INTO tabla_tareas (nombre, descripcion, fecha, estado) VALUES (?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, descripcion);
        stmt.setString(3, fecha);
        stmt.setInt(4, estado);

        // Ejecutar la consulta
        stmt.executeUpdate();

        System.out.println("Los datos se guardaron correctamente en la base de datos.");
    } catch (Exception e) {
        System.out.println("Error al guardar los datos: " + e.getMessage());
    } finally {
        // Cerrar la conexión y liberar recursos
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
%>