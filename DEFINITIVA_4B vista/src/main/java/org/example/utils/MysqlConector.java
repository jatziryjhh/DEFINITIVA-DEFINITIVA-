package org.example.utils;

import org.example.dao.Tarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlConector {
    static final String DBNAME = "eda";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static final String TIMEZONE = "America/Mexico_City";
    static final String USESSL = "false";
    static final String PUBLICKEY = "true";
    static final String DDLAUTO = "true";
    static final String HOST = "localhost";

    public static Connection connect() {
        String dataSource =
                String.format("jdbc:mysql://%s:3306/%s?user=%s&password=%s&serverTimezone=%s&useSSL=%s&allowPublicKeyRetrieval=%s&createDatabaseIfNotExist=%s", HOST, DBNAME, USER, PASSWORD, TIMEZONE, USESSL, PUBLICKEY, DDLAUTO);
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void guardarTarea(Tarea tarea) {
        try (Connection connection = connect()) {
            if (connection != null) {
                String sql = "INSERT INTO tareas (nombre, descripcion, fecha, estado) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, tarea.getNombre());
                    statement.setString(2, tarea.getDescripcion());
                    statement.setString(3, tarea.getFecha());
                    statement.setString(4, tarea.getEstado());
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
