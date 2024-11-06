package controller;

import model.ReservaManager;
import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador que gestiona las operaciones relacionadas con las reservas.
 */
public class ReservaController {
    private ReservaManager reservaManager;

    public ReservaController() {
        this.reservaManager = new ReservaManager();
    }

    /**
     * Agrega una nueva reserva.
     */
    public void agregarReserva(int idUsuario, int idEspacio, Timestamp fechaReserva) {
        reservaManager.agregarReserva(idUsuario, idEspacio, fechaReserva);
    }

    /**
     * Obtiene la lista de todas las reservas.
     * @return Lista de reservas en formato de texto.
     */
    public List<String> mostrarReservas() {
        return reservaManager.mostrarReservas();
    }

    /**
     * Actualiza el estado de una reserva.
     */
    public void actualizarReserva(int id, String nuevoEstado) {
        reservaManager.actualizarReserva(id, nuevoEstado);
    }

    /**
     * Elimina una reserva por su ID.
     */
    public void eliminarReserva(int id) {
        reservaManager.eliminarReserva(id);
    }
}
