package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public void mostrarMenuPrincipal() {
        EntrenadorView entrenadorView = new EntrenadorView(); // Instancia de EntrenadorView
        EspacioView espacioView = new EspacioView(); // Instancia de EspacioView
        ReservaView reservaView = new ReservaView(); // Instancia de ReservaView
        while (true) {
            try {
                System.out.println("\n=== Menú Principal ===");
                System.out.println("1. Gestión de Entrenadores");
                System.out.println("2. Gestión de Espacios");
                System.out.println("3. Gestión de Clases");
                System.out.println("4. Gestión de Reservas");
                System.out.println("5. Gestión de Clientes");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        entrenadorView.mostrarMenu(); // Llamamos a mostrarMenu() de EntrenadorView
                        break;
                    case 2:
                        espacioView.mostrarMenu(); // Llamamos a mostrarMenu() de EspacioView
                        break;
                    case 3:
                        ClaseView.mostrarMenu(); // Llamamos a mostrarMenu() de ClaseView
                        break;
                    case 4:
                        ReservaView.mostrarMenu(); // Llamamos a mostrarMenu() de ReservaView
                        break;
                    case 5:
                        ClienteView.mostrarMenu(); // Llamamos a mostrarMenu() de ClienteView
                        break;
                    case 6:
                        System.out.println("¡Gracias por usar la aplicación!");
                        return; // Salir del programa
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
    }

    public static void main(String[] args) {
        MainView mainView = new MainView(); // Crear instancia de la vista principal
        mainView.mostrarMenuPrincipal(); // Iniciar el menú principal
    }
}
