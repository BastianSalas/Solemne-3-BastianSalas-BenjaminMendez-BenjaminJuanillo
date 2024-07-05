import java.util.Scanner;
import java.util.LinkedList;
public class menu {

    Scanner scanner = new Scanner(System.in);
    listadoble listadoble = new listadoble();
    listasimplevuelo listavuelo = new listasimplevuelo();

    public void Menu1() {
        int inicio = 0;
        int opcion1 = 0;
        while (inicio == 0) {
            System.out.println("·········································································");
            System.out.println("                              Menú de Vuelos                             ");
            System.out.println("                                                                         ");
            System.out.println("Crear Vuelo.............................................................1");
            System.out.println("Editar Vuelo............................................................2");
            System.out.println("Eliminar Vuelo..........................................................3");
            System.out.println("Mostrar Lista de Vuelos.................................................4");
            System.out.println("Salir...................................................................5");
            System.out.println("                                                                         ");
            System.out.println("·········································································");
            int bandera = 0;
            while (bandera == 0) {
                try {
                    System.out.print("Ingrese su opción: ");
                    opcion1 = scanner.nextInt();
                    scanner.nextLine();
                    bandera = 1;
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida");
                    scanner.nextLine();
                }
            }
            switch (opcion1) {
                case 1:
                    System.out.println("·········································································");
                    System.out.print("Ingrese Destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Ingrese Horario: ");
                    String horario = scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Capacidad: ");
                    int capacidad = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer
                    Vuelo vuelo = new Vuelo(destino, horario, nombre, capacidad);
                    listavuelo.Agregar(vuelo);
                    System.out.println("Vuelo Creado con éxito");
                    break;
                case 2:
                    System.out.println("·········································································");
                    System.out.print("Ingrese el nombre del vuelo: ");
                    nombre = scanner.nextLine();
                    listavuelo.Editar(nombre);
                    break;
                case 3:
                    System.out.println("·········································································");
                    System.out.print("Ingrese el nombre del vuelo: ");
                    nombre = scanner.nextLine();
                    listavuelo.Eliminar(nombre);
                    break;
                case 4:
                    listavuelo.imprimirLista();
                    break;
                case 5:
                    inicio = 1;
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }

    public void Menu2() {
        int inicio = 0;
        int opcion2 = 0;
        while (inicio == 0) {
            System.out.println("·········································································");
            System.out.println("                            Menú de Pasajeros                            ");
            System.out.println("                                                                         ");
            System.out.println("Crear Pasajero..........................................................1");
            System.out.println("Editar Pasajero.........................................................2");
            System.out.println("Eliminar Pasajero.......................................................3");
            System.out.println("Asociar Pasajero a Vuelo................................................4");
            System.out.println("Mostrar Lista de Pasajeros..............................................5");
            System.out.println("Salir...................................................................6");
            System.out.println("                                                                         ");
            System.out.println("·········································································");
            int bandera = 0;
            while (bandera == 0) {
                try {
                    System.out.print("Ingrese su opción: ");
                    opcion2 = scanner.nextInt();
                    scanner.nextLine();
                    bandera = 1;
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida");
                    scanner.nextLine();
                }
            }
            switch (opcion2) {
                case 1:
                    System.out.println("·········································································");
                    System.out.print("Ingrese ID del pasajero: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese nombre del pasajero: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese nacionalidad del pasajero: ");
                    String nacionalidad = scanner.nextLine();
                    System.out.print("Ingrese número de asiento del pasajero: ");
                    String asiento = scanner.nextLine();
                    Pasajero pasajero = new Pasajero(id, nombre, nacionalidad, asiento);
                    listadoble.AgregarPasajero(pasajero);
                    System.out.println("Pasajero Creado con éxito");
                    break;
                case 2:
                    System.out.println("·········································································");
                    System.out.print("Ingrese el ID del pasajero: ");
                    id = scanner.nextLine();
                    listadoble.Editar(id);
                    break;
                case 3:
                    System.out.println("·········································································");
                    System.out.print("Ingrese el ID del pasajero: ");
                    id = scanner.nextLine();
                    listadoble.EliminarPasajero(id);
                    break;
                case 4:
                    System.out.println("·········································································");
                    System.out.print("Ingrese el ID del pasajero: ");
                    String buscarid = scanner.nextLine();
                    nodo buscado = listadoble.Buscar(buscarid);
                    if (buscado != null) {
                        System.out.print("Ingrese el nombre del vuelo: ");
                        String nombrevuelo = scanner.nextLine();
                        nodovuelo vueloEncontrado = listavuelo.Buscar(nombrevuelo);
                        if (vueloEncontrado != null) {
                            Vuelo vuelo = vueloEncontrado.getVuelo();
                            if (!vuelo.ContienePasajero(buscarid)) {
                                vuelo.AsociarPasajero((Pasajero) buscado.getPasajero());
                            } else {
                                System.out.println("El pasajero ya está asociado a este vuelo");
                            }
                        } else {
                            System.out.println("Vuelo no encontrado");
                        }
                    } else {
                        System.out.println("Pasajero no encontrado");
                    }
                    break;
                case 5:
                    System.out.println("·········································································");
                    System.out.print("Ingrese nombre del vuelo: ");
                    String nombrevuelo = scanner.nextLine();
                    nodovuelo vuelo = listavuelo.Buscar(nombrevuelo);
                    if (vuelo != null) {
                        vuelo.getVuelo().imprimirListaPasajeros();
                    } else {
                        System.out.println("Vuelo no encontrado");
                    }
                    break;
                case 6:
                    inicio = 1;
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }

    public void Menu3() {
        System.out.println("·········································································");
        System.out.print("Ingrese el nombre del vuelo: ");
        String nombrevuelo = scanner.nextLine();
        nodovuelo vuelo = listavuelo.Buscar(nombrevuelo);
        if (vuelo != null) {
            vuelo.getVuelo().Abordaje();
        } else {
            System.out.println("Vuelo no encontrado");
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        menu Menus = new menu();
        int inicio = 0;
        int opcion = 0;
        while (inicio == 0) {
            System.out.println("·········································································");
            System.out.println("                                Aerolínea                                ");
            System.out.println("                                                                         ");
            System.out.println("Menú Vuelo..............................................................1");
            System.out.println("Menú Pasajeros..........................................................2");
            System.out.println("Abordaje................................................................3");
            System.out.println("Salir...................................................................4");
            System.out.println("                                                                         ");
            System.out.println("·········································································");
            int bandera = 0;
            while (bandera == 0) {
                try {
                    System.out.print("Ingrese su opción: ");
                    opcion = leer.nextInt();
                    leer.nextLine();
                    bandera = 1;
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida");
                    leer.nextLine();
                }
            }
            switch (opcion) {
                case 1:
                    Menus.Menu1();
                    break;
                case 2:
                    Menus.Menu2();
                    break;
                case 3:
                    Menus.Menu3();
                    break;
                case 4:
                    System.out.println("Adiós");
                    inicio = 1;
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }
}
class colaabordaje {

    //Declaramos la cola que contendra objetos Pasajero
    private final LinkedList<Pasajero> cola = new LinkedList<>();

    //Meotodo para agregar un pasajero al final 
    public void agregar(Pasajero pasajero) {
        cola.addLast(pasajero); 
    }

    //Metodo para mostrar los pasajeros en la cola
    public void mostrar() {
        for (Pasajero pasajero : cola) {
            System.out.println("Pasajero: " + pasajero.Mostrar());
        }
    }
}