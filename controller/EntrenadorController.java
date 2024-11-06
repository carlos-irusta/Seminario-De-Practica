package controller;

import model.EntrenadorManager;
import java.util.List;

/**
 * Controlador que gestiona las operaciones relacionadas con los entrenadores.
 */
public class EntrenadorController {
    private EntrenadorManager entrenadorManager;

    public EntrenadorController() {
        this.entrenadorManager = new EntrenadorManager();
    }

    /**
     * Agrega un nuevo entrenador.
     */
    public void agregarEntrenador(String nombre, String apellido, String especialidad) {
        entrenadorManager.agregarEntrenador(nombre, apellido, especialidad);
    }

    /**
     * Obtiene la lista de todos los entrenadores.
     * @return Lista de entrenadores en formato de texto.
     */
    public List<String> mostrarEntrenadores() {
        return entrenadorManager.mostrarEntrenadores();
    }

    /**
     * Actualiza la información de un entrenador.
     */
    public void actualizarEntrenador(int id, String nuevoNombre, String nuevoApellido, String nuevaEspecialidad) {
        entrenadorManager.actualizarEntrenador(id, nuevoNombre, nuevoApellido, nuevaEspecialidad);
    }

    /**
     * Elimina un entrenador por su ID.
     */
    public void eliminarEntrenador(int id) {
        entrenadorManager.eliminarEntrenador(id);
    }
}

