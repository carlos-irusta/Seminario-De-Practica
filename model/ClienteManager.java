package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona las operaciones relacionadas con la tabla de clientes.
 * Proporciona métodos para agregar, mostrar, actualizar y eliminar clientes.
 */
public class ClienteManager {

    /**
     * Agrega un nuevo cliente a la base de datos.
     * @param nombre Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @param email Email del cliente.
     * @param contraseña Contraseña del cliente.
     * @param tipoUsuario Tipo de usuario del cliente (cliente, administrador, entrenador).
     */
    public static void agregarCliente(String nombre, String apellido, String email, String contraseña, String tipoUsuario) {
        String query = "INSERT INTO clientes (nombre, apellido, email, contraseña, tipo_usuario, fecha_creacion) VALUES (?, ?, ?, ?, ?, NOW())";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, email);
            stmt.setString(4, contraseña);
            stmt.setString(5, tipoUsuario);
            stmt.executeUpdate();
            System.out.println("Cliente agregado: " + nombre + " " + apellido);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra todos los clientes en la base de datos.
     * @return Listado de nombres completos de los clientes.
     */
    public static List<String> mostrarClientes() {
        List<String> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                clientes.add(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    /**
     * Actualiza los datos de un cliente existente en la base de datos.
     * @param id ID del cliente a actualizar.
     * @param nuevoNombre Nuevo nombre del cliente.
     * @param nuevoApellido Nuevo apellido del cliente.
     * @param nuevoEmail Nuevo email del cliente.
     * @param nuevaContraseña Nueva contraseña del cliente.
     * @param nuevoTipoUsuario Nuevo tipo de usuario del cliente.
     */
    public static void actualizarCliente(int id, String nuevoNombre, String nuevoApellido, String nuevoEmail, String nuevaContraseña, String nuevoTipoUsuario) {
        String query = "UPDATE clientes SET nombre = ?, apellido = ?, email = ?, contraseña = ?, tipo_usuario = ? WHERE id_cliente = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoApellido);
            stmt.setString(3, nuevoEmail);
            stmt.setString(4, nuevaContraseña);
            stmt.setString(5, nuevoTipoUsuario);
            stmt.setInt(6, id);
            stmt.executeUpdate();
            System.out.println("Cliente actualizado: " + nuevoNombre + " " + nuevoApellido);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un cliente de la base de datos por su ID.
     * @param id ID del cliente a eliminar.
     */
    public static void eliminarCliente(int id) {
        String query = "DELETE FROM clientes WHERE id_cliente = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
