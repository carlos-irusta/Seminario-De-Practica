package controller;

import model.EspacioManager; // Asegúrate de que este paquete y clase existen
import java.util.List;

public class EspacioController {
    private EspacioManager espacioManager;

    public EspacioController() {
        this.espacioManager = new EspacioManager(); // Inicializa el gestor de espacios
    }

    // Método para agregar un espacio
    public void agregarEspacio(String nombre, int capacidad, String estado, String tipoEspacio) {
        // Llama al método de EspacioManager con los parámetros correctos
        espacioManager.agregarEspacio(nombre, capacidad, estado, tipoEspacio);
    }

    // Método para mostrar los espacios
    public List<String> mostrarEspacios() {
        return espacioManager.mostrarEspacios(); // Llama al método de EspacioManager
    }

    // Método para actualizar un espacio
    public void actualizarEspacio(int id, String nuevoNombre, int nuevaCapacidad, String nuevoEstado, String nuevoTipoEspacio) {
        // Llama al método de EspacioManager con los parámetros correctos
        espacioManager.actualizarEspacio(id, nuevoNombre, nuevaCapacidad, nuevoEstado, nuevoTipoEspacio);
    }

    // Método para eliminar un espacio
    public void eliminarEspacio(int id) {
        espacioManager.eliminarEspacio(id); // Llama al método de EspacioManager
    }
}
