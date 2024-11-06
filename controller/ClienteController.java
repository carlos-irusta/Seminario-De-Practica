package controller;

import model.ClienteManager;
import java.util.List;

/**
 * Controlador que gestiona las operaciones relacionadas con los clientes.
 */
public class ClienteController {
    public ClienteController() {
        new ClienteManager();
    }

    /**
     * Agrega un nuevo cliente.
     */
    public void agregarCliente(String nombre, String apellido, String email, String contraseña, String tipoUsuario) {
        ClienteManager.agregarCliente(nombre, apellido, email, contraseña, tipoUsuario);
    }

    /**
     * Obtiene la lista de todos los clientes.
     * @return Lista de clientes en formato de texto.
     */
    public List<String> mostrarClientes() {
        return ClienteManager.mostrarClientes();
    }

    /**
     * Actualiza la información de un cliente.
     */
    public void actualizarCliente(int id, String nuevoNombre, String nuevoApellido, String nuevoEmail, String nuevoContraseña, String nuevoTipoUsuario) {
        ClienteManager.actualizarCliente(id, nuevoNombre, nuevoApellido, nuevoEmail, nuevoContraseña, nuevoTipoUsuario);
    }

    /**
     * Elimina un cliente por su ID.
     */
    public void eliminarCliente(int id) {
        ClienteManager.eliminarCliente(id);
    }
}

