package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona las operaciones relacionadas con la tabla de entrenadores.
 * Proporciona métodos para agregar, mostrar, actualizar y eliminar entrenadores.
 */
public class EntrenadorManager {

    /**
     * Agrega un nuevo entrenador a la base de datos.
     * @param nombre Nombre del entrenador.
     * @param apellido Apellido del entrenador.
     * @param especialidad Especialidad del entrenador.
     */
    public void agregarEntrenador(String nombre, String apellido, String especialidad) {
        String query = "INSERT INTO entrenadores (nombre, apellido, especialidad) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, especialidad);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> mostrarEntrenadores() {
        List<String> entrenadores = new ArrayList<>();
        String query = "SELECT * FROM entrenadores";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                entrenadores.add(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entrenadores;
    }

    /**
     * Actualiza los datos de un entrenador existente en la base de datos.
     * @param id ID del entrenador a actualizar.
     * @param nuevoNombre Nuevo nombre del entrenador.
     * @param nuevoApellido Nuevo apellido del entrenador.
     * @param nuevaEspecialidad Nueva especialidad del entrenador.
     */
    public void actualizarEntrenador(int id, String nuevoNombre, String nuevoApellido, String nuevaEspecialidad) {
        String query = "UPDATE entrenadores SET nombre = ?, apellido = ?, especialidad = ? WHERE id_entrenador = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoApellido);
            stmt.setString(3, nuevaEspecialidad);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un entrenador de la base de datos por su ID.
     * @param id ID del entrenador a eliminar.
     */
    public void eliminarEntrenador(int id) {
        String query = "DELETE FROM entrenadores WHERE id_entrenador = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

