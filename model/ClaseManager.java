package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona las operaciones relacionadas con la tabla de clases.
 * Proporciona métodos para agregar, mostrar, actualizar y eliminar clases.
 */
public class ClaseManager {

    /**
     * Agrega una nueva clase a la base de datos.
     * @param nombreClase Nombre de la clase.
     * @param idEntrenador ID del entrenador que dicta la clase.
     * @param idEspacio ID del espacio donde se realiza la clase.
     * @param fechaClase Fecha y hora de la clase.
     * @param duracion Duración de la clase en minutos.
     */
    public void agregarClase(String nombreClase, int idEntrenador, int idEspacio, Timestamp fechaClase, int duracion) {
        String query = "INSERT INTO clases (nombre_clase, id_entrenador, id_espacio, fecha_clase, duracion) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombreClase);
            stmt.setInt(2, idEntrenador);
            stmt.setInt(3, idEspacio);
            stmt.setTimestamp(4, fechaClase);
            stmt.setInt(5, duracion);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra todas las clases en la base de datos.
     * @return Listado de clases en formato de texto.
     */
    public List<String> mostrarClases() {
        List<String> clases = new ArrayList<>();
        String query = "SELECT c.id_clase, c.nombre_clase, e.nombre AS espacio, en.nombre AS entrenador, c.fecha_clase, c.duracion " +
                       "FROM clases c " +
                       "JOIN espacios e ON c.id_espacio = e.id_espacio " +
                       "JOIN entrenadores en ON c.id_entrenador = en.id_entrenador";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                clases.add("Clase ID: " + rs.getInt("id_clase") +
                            ", Nombre: " + rs.getString("nombre_clase") +
                            ", Espacio: " + rs.getString("espacio") +
                            ", Entrenador: " + rs.getString("entrenador") +
                            ", Fecha: " + rs.getTimestamp("fecha_clase") +
                            ", Duración: " + rs.getInt("duracion") + " minutos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clases;
    }

    /**
     * Actualiza los datos de una clase existente en la base de datos.
     * @param id ID de la clase a actualizar.
     * @param nuevoNombre Nombre nuevo de la clase.
     * @param nuevoIdEntrenador ID del nuevo entrenador.
     * @param nuevoIdEspacio ID del nuevo espacio.
     * @param nuevaFecha Nueva fecha de la clase.
     * @param nuevaDuracion Nueva duración de la clase en minutos.
     */
    public void actualizarClase(int id, String nuevoNombre, int nuevoIdEntrenador, int nuevoIdEspacio, Timestamp nuevaFecha, int nuevaDuracion) {
        String query = "UPDATE clases SET nombre_clase = ?, id_entrenador = ?, id_espacio = ?, fecha_clase = ?, duracion = ? WHERE id_clase = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nuevoNombre);
            stmt.setInt(2, nuevoIdEntrenador);
            stmt.setInt(3, nuevoIdEspacio);
            stmt.setTimestamp(4, nuevaFecha);
            stmt.setInt(5, nuevaDuracion);
            stmt.setInt(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una clase de la base de datos por su ID.
     * @param id ID de la clase a eliminar.
     */
    public void eliminarClase(int id) {
        String query = "DELETE FROM clases WHERE id_clase = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
