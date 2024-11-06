package view;

import model.ClienteManager;
import java.util.List;
import java.util.Scanner;

public class ClienteView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Gestión de Clientes ===");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void agregarCliente() {
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellido: ");
        String apellido = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Contraseña: ");
        String contraseña = scanner.next();
        System.out.print("Tipo de Usuario (cliente/administrador/entrenador): ");
        String tipoUsuario = scanner.next();

        ClienteManager.agregarCliente(nombre, apellido, email, contraseña, tipoUsuario);
    }

    private static void mostrarClientes() {
        List<String> clientes = ClienteManager.mostrarClientes();
        System.out.println("\nClientes:");
        for (String cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void actualizarCliente() {
        System.out.print("ID del cliente a actualizar: ");
        int id = scanner.nextInt();
        System.out.print("Nuevo Nombre: ");
        String nuevoNombre = scanner.next();
        System.out.print("Nuevo Apellido: ");
        String nuevoApellido = scanner.next();
        System.out.print("Nuevo Email: ");
        String nuevoEmail = scanner.next();
        System.out.print("Nueva Contraseña: ");
        String nuevoContraseña = scanner.next();
        System.out.print("Nuevo Tipo de Usuario: ");
        String nuevoTipoUsuario = scanner.next();

        ClienteManager.actualizarCliente(id, nuevoNombre, nuevoApellido, nuevoEmail, nuevoContraseña, nuevoTipoUsuario);
    }

    private static void eliminarCliente() {
        System.out.print("ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        ClienteManager.eliminarCliente(id);
    }
}
