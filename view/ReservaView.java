package view;

import model.ReservaManager;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ReservaView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ReservaManager reservaManager = new ReservaManager();

    public static void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Menú de Reservas ===");
            System.out.println("1. Agregar Reserva");
            System.out.println("2. Mostrar Reservas");
            System.out.println("3. Actualizar Reserva");
            System.out.println("4. Eliminar Reserva");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    actualizarReserva();
                    break;
                case 4:
                    eliminarReserva();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void agregarReserva() {
        System.out.print("Ingrese el ID del cliente: ");
        int idCliente = scanner.nextInt();
    
        System.out.print("Ingrese el ID del espacio: ");
        int idEspacio = scanner.nextInt();
    
        // Limpiar el buffer de scanner
        scanner.nextLine();  // Esto es importante para que no quede información pendiente en el buffer
    
        System.out.print("Ingrese la fecha de reserva (YYYY-MM-DD HH:MM): ");
        String fechaStr = scanner.nextLine().trim();  // Usamos trim() para eliminar espacios adicionales
    
        // Definir el formato con solo año, mes, día y hora:minutos
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);  // Para evitar interpretaciones erróneas
    
        Timestamp fechaReserva = null;
    
        try {
            java.util.Date parsedDate = dateFormat.parse(fechaStr);
            fechaReserva = new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            System.out.println("Error: La fecha ingresada no tiene el formato correcto. Asegúrese de usar 'YYYY-MM-DD HH:MM'.");
            return;  // Si la fecha no es válida, se detiene la ejecución del método
        }
    
        // Llamada al método para agregar la reserva con la fecha y hora correcta
        reservaManager.agregarReserva(idCliente, idEspacio, fechaReserva);
        System.out.println("Reserva agregada exitosamente.");
    }
    
    private static void mostrarReservas() {
    System.out.println("\n=== Reservas Actuales ===");
    List<String> reservas = reservaManager.mostrarReservas();  // Cambié 'var' por 'List<String>'
    
    if (reservas.isEmpty()) {
        System.out.println("No hay reservas disponibles.");
    } else {
        for (String reserva : reservas) {
            System.out.println(reserva);
        }
    }
}

    private static void actualizarReserva() {
        System.out.print("Ingrese el ID de la reserva a actualizar: ");
        int idReserva = scanner.nextInt();

        System.out.println("Ingrese el nuevo estado de la reserva: ");
        System.out.println("1. Confirmada");
        System.out.println("2. Cancelada");
        System.out.println("3. Completada");
        int opcionEstado = scanner.nextInt();

        String nuevoEstado = null;
        switch (opcionEstado) {
            case 1:
                nuevoEstado = "confirmada";
                break;
            case 2:
                nuevoEstado = "cancelada";
                break;
            case 3:
                nuevoEstado = "completada";
                break;
            default:
                System.out.println("Opción no válida. El estado no ha sido actualizado.");
                return;
        }

        reservaManager.actualizarReserva(idReserva, nuevoEstado);
        System.out.println("Reserva actualizada exitosamente.");
    }

    private static void eliminarReserva() {
        System.out.print("Ingrese el ID de la reserva a eliminar: ");
        int idReserva = scanner.nextInt();

        reservaManager.eliminarReserva(idReserva);
        System.out.println("Reserva eliminada exitosamente.");
    }
}
