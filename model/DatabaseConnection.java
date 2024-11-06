package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que maneja la conexión a la base de datos MySQL.
 * Proporciona un método para obtener la conexión utilizando 
 * las credenciales y URL de la base de datos.
 */
public class DatabaseConnection {
    // URL de la base de datos
    private static final String URL = "jdbc:mysql://127.0.0.1/gimnasio";
    // Usuario de la base de datos
    private static final String USER = "root";
    // Contraseña de la base de datos
    private static final String PASSWORD = "rb26dett";

    /**
     * Obtiene una conexión a la base de datos.
     * @return Connection objeto de conexión a la base de datos.
     * @throws SQLException si hay un error al intentar conectarse.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
