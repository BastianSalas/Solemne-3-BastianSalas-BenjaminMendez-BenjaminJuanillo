import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        funciones funciones = new funciones();
        Scanner scanner = new Scanner(System.in);
        int goku;

        do {
            System.out.println("·········································································");
            System.out.println("                                  Menú                                   ");
            System.out.println("                                                                         ");
            System.out.println("Gestión de Vuelos.......................................................1");
            System.out.println("Gestión de Pasajeros....................................................2");
            System.out.println("Proceso de Abordaje.....................................................3");
            System.out.println("Salir...................................................................4");
            System.out.println("                                                                         ");
            System.out.println("·········································································");
            System.out.print("Elija opción: ");
            
            goku = scanner.nextInt();
            scanner.nextLine(); 

            switch (goku) {
                case 1:
                    menuVuelos(funciones, scanner);
                    break;
                case 2:
                    menuPasajeros(funciones, scanner);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del vuelo: ");
                    String nombreVuelo = scanner.nextLine();
                    funciones.procesoAbordaje(nombreVuelo);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (goku != 4);

        scanner.close();
    }

    public static void menuVuelos(funciones funciones, Scanner scanner) {
        int vegeta;

        do {
            System.out.println("·········································································");
            System.out.println("                              Menú de Vuelos                             ");
            System.out.println("                                                                         ");
            System.out.println("    Gestión de Vuelos:                                                   ");
            System.out.println("Crear Vuelo.............................................................1");
            System.out.println("Editar Vuelo............................................................2");
            System.out.println("Eliminar Vuelo..........................................................3");
            System.out.println("Mostrar Vuelos..........................................................4");
            System.out.println("Volver al menu principal................................................5");
            System.out.println("                                                                         ");
            System.out.println("·········································································");
            System.out.print("Elija opción: ");

            vegeta = scanner.nextInt();
            scanner.nextLine();

            switch (vegeta) {
                case 1:
                    System.out.print("Destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Horario: ");
                    String horario = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    funciones.crearVuelo(destino, horario, nombre);
                    break;
                case 2:
                    System.out.print("Nombre del vuelo a editar: ");
                    String nombreEditar = scanner.nextLine();
                    System.out.print("Nuevo destino: ");
                    String nuevoDestino = scanner.nextLine();
                    System.out.print("Nuevo horario: ");
                    String nuevoHorario = scanner.nextLine();
                    funciones.editarVuelo(nombreEditar, nuevoDestino, nuevoHorario);
                    break;
                case 3:
                    System.out.print("Nombre del vuelo a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    funciones.eliminarVuelo(nombreEliminar);
                    break;
                case 4:
                    funciones.mostrarVuelos();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (vegeta != 5);
    }

    public static void menuPasajeros(funciones funciones, Scanner scanner) {
        int gohan;

        do {
            System.out.println("Gestión de Pasajeros:");
            System.out.println("1. Crear Pasajero");
            System.out.println("2. Editar Pasajero");
            System.out.println("3. Eliminar Pasajero");
            System.out.println("4. Asociar Pasajero a Vuelo");
            System.out.println("5. Mostrar Pasajeros de un Vuelo");
            System.out.println("6. Volver");
            System.out.print("Seleccione una opción: ");
            gohan = scanner.nextInt();
            scanner.nextLine();

            switch (gohan) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nacionalidad = scanner.nextLine();
                    System.out.print("Asiento: ");
                    int asiento = scanner.nextInt();
                    scanner.nextLine();
                    funciones.crearPasajero(id, nombre, nacionalidad, asiento);
                    break;
                case 2:
                    System.out.print("ID del pasajero a editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nueva nacionalidad: ");
                    String nuevaNacionalidad = scanner.nextLine();
                    System.out.print("Nuevo asiento: ");
                    int nuevoAsiento = scanner.nextInt();
                    scanner.nextLine();
                    funciones.editarPasajero(idEditar, nuevoNombre, nuevaNacionalidad, nuevoAsiento);
                    break;
                case 3:
                    System.out.print("ID del pasajero a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();
                    funciones.eliminarPasajero(idEliminar);
                    break;
                case 4:
                    System.out.print("ID del pasajero: ");
                    int idPasajero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre del vuelo: ");
                    String nombreVuelo = scanner.nextLine();
                    funciones.asociarPasajeroAVuelo(idPasajero, nombreVuelo);
                    break;
                case 5:
                    System.out.print("Nombre del vuelo: ");
                    String vueloNombre = scanner.nextLine();
                    funciones.mostrarPasajerosDeVuelo(vueloNombre);
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (gohan != 6);
    }
}
