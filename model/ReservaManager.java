package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona las operaciones relacionadas con la tabla de reservas.
 * Proporciona métodos para agregar, mostrar, actualizar y eliminar reservas.
 */
public class ReservaManager {

    /**
     * Agrega una nueva reserva a la base de datos.
     * @param idUsuario ID del usuario que realiza la reserva.
     * @param idEspacio ID del espacio reservado.
     * @param fechaReserva Fecha y hora de la reserva.
     */
    public void agregarReserva(int idUsuario, int idEspacio, Timestamp fechaReserva) {
        String query = "INSERT INTO reservas (id_usuario, id_espacio, fecha_reserva, estado, fecha_creacion) " +
                       "VALUES (?, ?, ?, 'confirmada', NOW())";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idEspacio);
            stmt.setTimestamp(3, fechaReserva);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra todas las reservas en la base de datos.
     * @return Listado de reservas en formato de texto.
     */
    public List<String> mostrarReservas() {
        List<String> reservas = new ArrayList<>();
        String query = "SELECT r.id_reserva, c.nombre AS cliente, e.nombre AS espacio, r.fecha_reserva, r.estado " +
                       "FROM reservas r " +
                       "JOIN clientes c ON r.id_usuario = c.id_cliente " +
                       "JOIN espacios e ON r.id_espacio = e.id_espacio";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                reservas.add("Reserva ID: " + rs.getInt("id_reserva") +
                              ", Cliente: " + rs.getString("cliente") +
                              ", Espacio: " + rs.getString("espacio") +
                              ", Fecha: " + rs.getTimestamp("fecha_reserva") +
                              ", Estado: " + rs.getString("estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("Reservas encontradas: " + reservas.size());
        
        return reservas;
    }

    /**
     * Actualiza el estado de una reserva existente en la base de datos.
     * @param id ID de la reserva a actualizar.
     * @param nuevoEstado Nuevo estado de la reserva (debe ser 'confirmada', 'cancelada' o 'completada').
     */
    public void actualizarReserva(int id, String nuevoEstado) {
        if (!nuevoEstado.equals("confirmada") && !nuevoEstado.equals("cancelada") && !nuevoEstado.equals("completada")) {
            System.out.println("Estado no válido. Los estados permitidos son 'confirmada', 'cancelada' o 'completada'.");
            return;
        }

        String query = "UPDATE reservas SET estado = ? WHERE id_reserva = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nuevoEstado);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una reserva de la base de datos por su ID.
     * @param id ID de la reserva a eliminar.
     */
    public void eliminarReserva(int id) {
        String query = "DELETE FROM reservas WHERE id_reserva = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
