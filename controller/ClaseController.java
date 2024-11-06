package controller;

import model.ClaseManager;
import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador que gestiona las operaciones relacionadas con las clases.
 */
public class ClaseController {
    private ClaseManager claseManager;

    public ClaseController() {
        this.claseManager = new ClaseManager();
    }

    /**
     * Agrega una nueva clase.
     */
    public void agregarClase(String nombreClase, int idEntrenador, int idEspacio, Timestamp fechaClase, int duracion) {
        claseManager.agregarClase(nombreClase, idEntrenador, idEspacio, fechaClase, duracion);
    }

    /**
     * Obtiene la lista de todas las clases.
     * @return Lista de clases en formato de texto.
     */
    public List<String> mostrarClases() {
        return claseManager.mostrarClases();
    }

    /**
     * Actualiza la información de una clase.
     */
    public void actualizarClase(int id, String nuevoNombre, int nuevoIdEntrenador, int nuevoIdEspacio, Timestamp nuevaFecha, int nuevaDuracion) {
        claseManager.actualizarClase(id, nuevoNombre, nuevoIdEntrenador, nuevoIdEspacio, nuevaFecha, nuevaDuracion);
    }

    /**
     * Elimina una clase por su ID.
     */
    public void eliminarClase(int id) {
        claseManager.eliminarClase(id);
    }
}
