import org.example.dao.Tarea;
import org.example.utils.MysqlConector;

import java.sql.Connection;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        post("http://localhost:8080/api/tareas/", (request, response) -> {
            // Obtener los datos de la solicitud
            String nombre = request.queryParams("nombre");
            String descripcion = request.queryParams("descripcion");
            String fecha = request.queryParams("fecha");
            String estado = request.queryParams("estado");

            // Crear un objeto Tarea con los datos recibidos
            Tarea tarea = new Tarea(nombre, descripcion, fecha, estado);

            // Guardar la tarea en la base de datos usando MysqlConector
            MysqlConector.guardarTarea(tarea);
                    try {
                        Connection connection = MysqlConector.connect();
                        if (connection != null) {
                            System.out.println("Conexión exitosa a la base de datos");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            // Puedes devolver una respuesta de éxito si lo deseas
            return "Tarea guardada exitosamente";
        });

    }
}