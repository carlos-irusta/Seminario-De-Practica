package view;

import controller.EntrenadorController;
import java.util.List;
import java.util.Scanner;

public class EntrenadorView {
    private static final Scanner scanner = new Scanner(System.in);
    private EntrenadorController entrenadorController = new EntrenadorController();  // Instancia de EntrenadorController

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Gestión de Entrenadores ===");
            System.out.println("1. Agregar Entrenador");
            System.out.println("2. Mostrar Entrenadores");
            System.out.println("3. Actualizar Entrenador");
            System.out.println("4. Eliminar Entrenador");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarEntrenador();
                    break;
                case 2:
                    mostrarEntrenadores();
                    break;
                case 3:
                    actualizarEntrenador();
                    break;
                case 4:
                    eliminarEntrenador();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void agregarEntrenador() {
        System.out.print("Nombre del Entrenador: ");
        String nombre = scanner.next();
        System.out.print("Apellido del Entrenador: ");
        String apellido = scanner.next();
        System.out.print("Especialidad del Entrenador: ");
        String especialidad = scanner.next();

        entrenadorController.agregarEntrenador(nombre, apellido, especialidad);
        System.out.println("Entrenador agregado con éxito.");
    }

    private void mostrarEntrenadores() {
        List<String> entrenadores = entrenadorController.mostrarEntrenadores();
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
        } else {
            System.out.println("Entrenadores registrados:");
            for (String entrenador : entrenadores) {
                System.out.println("- " + entrenador); // Mostrar cada entrenador
            }
        }
    }

    private void actualizarEntrenador() {
        System.out.print("ID del Entrenador a actualizar: ");
        int id = scanner.nextInt();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Nuevo apellido: ");
        String apellido = scanner.next();
        System.out.print("Nueva especialidad: ");
        String especialidad = scanner.next();

        entrenadorController.actualizarEntrenador(id, nombre, apellido, especialidad);
        System.out.println("Entrenador actualizado con éxito.");
    }

    private void eliminarEntrenador() {
        System.out.print("ID del Entrenador a eliminar: ");
        int id = scanner.nextInt();

        entrenadorController.eliminarEntrenador(id);
        System.out.println("Entrenador eliminado con éxito.");
    }
}
