package view;

import model.ClaseManager;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ClaseView {
    private static final Scanner scanner = new Scanner(System.in); // Usar un solo scanner
    private static final ClaseManager claseManager = new ClaseManager(); // Instancia estática de ClaseManager

    // Menú principal de gestión de clases
    public static void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Gestión de Clases ===");
            System.out.println("1. Agregar Clase");
            System.out.println("2. Mostrar Clases");
            System.out.println("3. Actualizar Clase");
            System.out.println("4. Eliminar Clase");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarClase();
                    break;
                case 2:
                    mostrarClases();
                    break;
                case 3:
                    actualizarClase();
                    break;
                case 4:
                    eliminarClase();
                    break;
                case 5:
                    return; // Volver al menú principal
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Método para agregar una clase
    private static void agregarClase() {
        System.out.print("Nombre de la Clase: ");
        scanner.nextLine(); // Limpiar el buffer
        String nombreClase = scanner.nextLine(); // Lee el nombre de la clase

        System.out.print("ID del Entrenador: ");
        int idEntrenador = scanner.nextInt(); // Lee el ID del Entrenador

        System.out.print("ID del Espacio: ");
        int idEspacio = scanner.nextInt(); // Lee el ID del Espacio

        System.out.print("Fecha de la Clase (YYYY-MM-DD HH:MM:SS): ");
        String fechaStr = scanner.next(); // Lee la fecha en formato String

        // Validación de la fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false); // Desactivar la interpretación flexible de fechas
        Timestamp fechaClase = null;

        try {
            java.util.Date parsedDate = dateFormat.parse(fechaStr); // Intentamos analizar la fecha
            fechaClase = new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            System.out.println("Error: La fecha ingresada no tiene el formato correcto. Asegúrese de usar 'yyyy-MM-dd HH:mm:ss'.");
            return; // Salir del método si la fecha no es válida
        }

        System.out.print("Duración (en minutos): ");
        while (!scanner.hasNextInt()) {  // Verifica si la entrada es un número entero
            System.out.println("Entrada no válida. Por favor ingrese un número.");
            scanner.next(); // Limpiar la entrada no válida
        }
        int duracion = scanner.nextInt(); // Lee la duración en minutos

        // Llama al método para agregar la clase con los parámetros correctos
        claseManager.agregarClase(nombreClase, idEntrenador, idEspacio, fechaClase, duracion);
    }

    // Método para mostrar todas las clases
    private static void mostrarClases() {
        List<String> clases = claseManager.mostrarClases(); // Llamada estática
        System.out.println("\nClases:");
        for (String clase : clases) {
            System.out.println(clase);
        }
    }

    // Método para actualizar una clase
    private static void actualizarClase() {
        System.out.print("ID de la clase a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Nuevo Nombre de Clase: ");
        String nuevoNombreClase = scanner.nextLine();

        System.out.print("Nuevo ID del Entrenador: ");
        int nuevoIdEntrenador = scanner.nextInt();

        System.out.print("Nuevo ID del Espacio: ");
        int nuevoIdEspacio = scanner.nextInt();

        System.out.print("Nueva Fecha de Clase (YYYY-MM-DD HH:MM:SS): ");
        String nuevaFechaClaseStr = scanner.next();
        Timestamp nuevaFechaClase = Timestamp.valueOf(nuevaFechaClaseStr); // Convertir String a Timestamp

        System.out.print("Nueva Duración: ");
        int nuevaDuracion = scanner.nextInt();

        // Llamada para actualizar la clase
        claseManager.actualizarClase(id, nuevoNombreClase, nuevoIdEntrenador, nuevoIdEspacio, nuevaFechaClase, nuevaDuracion);
    }

    // Método para eliminar una clase
    private static void eliminarClase() {
        System.out.print("ID de la clase a eliminar: ");
        int id = scanner.nextInt();

        // Llamada para eliminar la clase
        claseManager.eliminarClase(id);
    }
}
