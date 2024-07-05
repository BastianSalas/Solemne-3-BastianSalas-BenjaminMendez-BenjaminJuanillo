import java.util.Scanner;

public class Vuelo {

    private String destino, horario, nombre;
    private int capacidad, numpasajeros;
    private Pasajero[] pasajeros; //Define el arreglo de objetos del tipo Pasajeros

    public Vuelo(String destino, String horario, String nombre, int capacidad) {
        this.destino = destino;
        this.horario = horario;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.numpasajeros = 0;
        this.pasajeros = new Pasajero[capacidad];
    }

    //Getters and Setters
    public String getDestino() {
        return destino;
    }

    public String getHorario() {
        return horario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Pasajero[] getPasajeros() {
        return pasajeros;
    }

    public int getNumpasajeros() {
        return numpasajeros;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setPasajeros(Pasajero[] pasajeros) {
        this.pasajeros = pasajeros;
    }

    public void setNumpasajeros(int numpasajeros) {
        this.numpasajeros = numpasajeros;
    }

    //Metodo para verificar si el vuelo esta lleno
    public boolean EstaLleno() {
        return numpasajeros >= capacidad;
    }

    //Metodo para verificar si existe el pasajero con el id entregado por el usuario, retorna true or false
    public boolean ContienePasajero(String id) {
        for (int i = 0; i < numpasajeros; i++) {
            if (pasajeros[i] != null && pasajeros[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    //Metodo para asociar pasajero 
    //Pasajero pasajero para el pasajero a asociar
    public void AsociarPasajero(Pasajero pasajero) {
        if (EstaLleno()) {
            System.out.println("El vuelo esta lleno");
            return;
        }
        if (ContienePasajero(pasajero.getId())) {
            System.out.println("El pasajero con ID " + pasajero.getId() + " ya está asociado a este vuelo.");
        } else {
            pasajeros[numpasajeros] = pasajero; 
            numpasajeros++;
            System.out.println("Pasajero asociado con éxito.");
        }
    }

    //Metodo para mostrar la informacion del vuelo
    public String Mostrar() {
        return "Destino: " + destino + ", Horario: " + horario + ", Nombre: " + nombre + ", Capacidad: " + capacidad + "\n";
    }

    //Metodo para la opcion de Mostrar pasajeros indicando un vuelo
    public void imprimirListaPasajeros() {
        System.out.println("Información del Vuelo:");
        System.out.println("Destino: " + destino);
        System.out.println("Horario: " + horario);
        System.out.println("Nombre: " + nombre);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Número de Pasajeros: " + numpasajeros);
        System.out.println("Lista de Pasajeros:");
        for (int i = 0; i < numpasajeros; i++) {
            System.out.println(pasajeros[i].Mostrar());
        }
    }

    //Metodo para gestionar el abordaje OPCION 3 DEL MENU PRINCIPAL
    public void Abordaje() {
        colaabordaje cola = new colaabordaje(); 
        if (!EstaLleno()) {
            System.out.println("El vuelo no esta lleno");
            return;
        }
        //Agrega TODOS los asientos PARES del vuelo
        for (int i = 0; i < capacidad; i++) {
            Pasajero infopasajero = pasajeros[i];
            if (infopasajero != null) {
                String asiento = infopasajero.getAsiento();
                int numero = Integer.parseInt(asiento); 
                if (numero % 2 == 0) {
                    cola.agregar(infopasajero); 
                }
            }
        }
        //Agrega TODOS los asientos IMPARES del vuelo
        for (int i = 0; i < capacidad; i++) {
            Pasajero infopasajero = pasajeros[i];
            if (infopasajero != null) {
                String asiento = infopasajero.getAsiento();
                int numero = Integer.parseInt(asiento);
                if (numero % 2 != 0) {
                    cola.agregar(infopasajero); 
                }
            }
        }
        System.out.println("Pasajeros en la cola de abordaje:");
        cola.mostrar(); 
    }
}
class nodovuelo {

    private Vuelo vuelo;
    private nodovuelo siguiente;

    public nodovuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
        this.siguiente = null;
    }

    //Getters and Setters
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public nodovuelo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodovuelo siguiente) {
        this.siguiente = siguiente;
    }
}

class listasimplevuelo {

    nodovuelo inicio;
    Scanner scanner = new Scanner(System.in);

    public listasimplevuelo() {
        this.inicio = null;
    }

    public void Agregar(Vuelo vuelo) {
        nodovuelo n = new nodovuelo(vuelo);
        n.setSiguiente(inicio); 
        inicio = n; 
    }

    public void Editar(String nombre) {
        nodovuelo actual = inicio;
        boolean encontrado = false;
        while (actual != null && !encontrado) {
            if (actual.getVuelo().getNombre().equals(nombre)) {
                System.out.println("Ingrese Destino: ");
                String nuevodestino = scanner.nextLine();
                System.out.println("Ingrese Horario: ");
                String nuevohorario = scanner.nextLine();
                System.out.println("Ingrese nombre: ");
                String nuevonombre = scanner.nextLine();
                System.out.println("Ingrese capacidad: ");
                int nuevacapacidad = scanner.nextInt();
                actual.getVuelo().setDestino(nuevodestino);
                actual.getVuelo().setHorario(nuevohorario);
                actual.getVuelo().setNombre(nuevonombre);
                actual.getVuelo().setCapacidad(nuevacapacidad);
                encontrado = true;
            }
            actual = actual.getSiguiente();
        }
        if (encontrado) {
            System.out.println("El vuelo de nombre: " + nombre + ", ha sido editado con exito");
        } else {
            System.out.println("El nombre: " + nombre + " no fue encontrado");
        }
    }

    //Metodo eliminar de acuerdo al nombre
    public void Eliminar(String Nombre) {
        if (inicio != null) {
            nodovuelo actual = inicio;
            nodovuelo anterior = null;

            while (actual != null && !actual.getVuelo().getNombre().equals(Nombre)) {
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if (actual != null) {

                if (actual.getVuelo().getNumpasajeros() > 0) {
                    System.out.println("No se puede eliminar el vuelo " + Nombre + " porque tiene pasajeros asociados.");
                } else {
                    if (anterior == null) {
                        inicio = actual.getSiguiente();
                    } else {
                        anterior.setSiguiente(actual.getSiguiente());
                    }
                    System.out.println("Vuelo " + Nombre + " eliminado correctamente.");
                }
            } else {
                System.out.println("El vuelo con nombre " + Nombre + " no fue encontrado.");
            }
        } else {
            System.out.println("La lista de vuelos está vacía.");
        }

    }

    //Metodo para imprimir la lista de vuelos
    public void imprimirLista() {
        nodovuelo recorre = inicio;
        if (inicio != null) {
            while (recorre != null) {
                System.out.print(recorre.getVuelo().Mostrar()); 
                recorre = recorre.getSiguiente();
            }
            System.out.println();
        } else {
            System.out.println("Lista de Vuelos vacia");
        }
    }

    public nodovuelo Buscar(String nombre) {
        nodovuelo actual = inicio;
        while (actual != null) {
            if (actual.getVuelo().getNombre().equals(nombre)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Vuelo no encontrado");
        return null;

    }

    public void AsociarPasajero(String nombreVuelo, Pasajero pasajero) {
        nodovuelo nodoVuelo = Buscar(nombreVuelo);
        if (nodoVuelo != null) {
            nodoVuelo.getVuelo().AsociarPasajero(pasajero);
        } else {
            System.out.println("No se pudo asociar el pasajero. Vuelo no encontrado.");
        }
    }
}
