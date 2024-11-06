package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspacioManager {

    // Método para agregar un espacio
    public void agregarEspacio(String nombre, int capacidad, String estado, String tipoEspacio) {
        String query = "INSERT INTO espacios (nombre, capacidad, estado, tipo_espacio) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setInt(2, capacidad);
            stmt.setString(3, estado);
            stmt.setString(4, tipoEspacio);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar los espacios
    public List<String> mostrarEspacios() {
        List<String> espacios = new ArrayList<>();
        String query = "SELECT * FROM espacios";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Modificado para incluir los nuevos campos
                espacios.add("ID: " + rs.getInt("id_espacio") + 
                             ", Nombre: " + rs.getString("nombre") + 
                             ", Capacidad: " + rs.getInt("capacidad") + 
                             ", Estado: " + rs.getString("estado") + 
                             ", Tipo: " + rs.getString("tipo_espacio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return espacios;
    }

    // Método para actualizar un espacio
    public void actualizarEspacio(int id, String nuevoNombre,int nuevaCapacidad, String nuevoEstado, String nuevoTipoEspacio) {
        String query = "UPDATE espacios SET nombre = ?, capacidad = ?, estado = ?, tipo_espacio = ? WHERE id_espacio = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nuevoNombre);
            stmt.setInt(2, nuevaCapacidad);
            stmt.setString(3, nuevoEstado);
            stmt.setString(4, nuevoTipoEspacio);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un espacio
    public void eliminarEspacio(int id) {
        String query = "DELETE FROM espacios WHERE id_espacio = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEspacio(int id, String nuevoNombre, String nuevaDescripcion) {
        
        throw new UnsupportedOperationException("Unimplemented method 'actualizarEspacio'");
    }

    public void agregarEspacio(String nombre, String descripcion) {
     
        throw new UnsupportedOperationException("Unimplemented method 'agregarEspacio'");
    }
}
