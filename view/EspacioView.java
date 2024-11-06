package view;

import controller.EspacioController;
import java.util.List;
import java.util.Scanner;

public class EspacioView {
    private EspacioController espacioController;
    private Scanner scanner; // Declarar el Scanner como atributo de la clase

    public EspacioView() {
        this.espacioController = new EspacioController(); // Inicializa el controlador
        this.scanner = new Scanner(System.in); // Inicializa el Scanner
    }

    // Método para mostrar el menú y manejar las opciones
    public void mostrarMenu() {
        int opcion;

        do {
            // Muestra el menú
            System.out.println("=== Gestión de Espacios ===");
            System.out.println("1. Agregar Espacio");
            System.out.println("2. Mostrar Espacios");
            System.out.println("3. Actualizar Espacio");
            System.out.println("4. Eliminar Espacio");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt(); // Lee la opción seleccionada

            // Maneja las opciones del menú
            switch (opcion) {
                case 1:
                    agregarEspacio();
                    break;
                case 2:
                    mostrarEspacios();
                    break;
                case 3:
                    actualizarEspacio();
                    break;
                case 4:
                    eliminarEspacio();
                    break;
                case 5:
                    System.out.println("Saliendo del menú de Espacios...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close(); // Cierra el Scanner al finalizar
    }

    // Método para agregar un espacio
    private void agregarEspacio() {
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nombre del espacio: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la capacidad del espacio: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el estado del espacio (disponible, ocupado, mantenimiento): ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese el tipo de espacio: ");
        String tipoEspacio = scanner.nextLine();

        // Llama al controlador con los nuevos parámetros
        espacioController.agregarEspacio(nombre, capacidad, estado, tipoEspacio);
        System.out.println("Espacio agregado exitosamente.");
    }

    // Método para mostrar los espacios
    private void mostrarEspacios() {
        List<String> espacios = espacioController.mostrarEspacios(); // Llama al controlador

        if (espacios.isEmpty()) {
            System.out.println("No hay espacios disponibles.");
        } else {
            System.out.println("=== Espacios Disponibles ===");
            for (int i = 0; i < espacios.size(); i++) {
                System.out.println(i + ". " + espacios.get(i)); // Muestra los espacios
            }
        }
    }

    // Método para actualizar un espacio
    private void actualizarEspacio() {
        scanner.nextLine(); // Limpiar el buffer
        mostrarEspacios();
        System.out.print("Seleccione el ID del espacio a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese la nueva capacidad: ");
        int nuevaCapacidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nuevo estado (disponible, ocupado, mantenimiento): ");
        String nuevoEstado = scanner.nextLine();
        System.out.print("Ingrese el nuevo tipo de espacio: ");
        String nuevoTipoEspacio = scanner.nextLine();

        // Llama al controlador con los nuevos parámetros
        espacioController.actualizarEspacio(id, nuevoNombre, nuevaCapacidad, nuevoEstado, nuevoTipoEspacio);
        System.out.println("Espacio actualizado exitosamente.");
    }

    // Método para eliminar un espacio
    private void eliminarEspacio() {
        System.out.print("Ingrese el ID del espacio a eliminar: ");
        int id = scanner.nextInt();

        // Llama al controlador para eliminar el espacio
        espacioController.eliminarEspacio(id);
        System.out.println("Espacio eliminado exitosamente.");
    }
}
