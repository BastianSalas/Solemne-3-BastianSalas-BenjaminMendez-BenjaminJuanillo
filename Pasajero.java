import java.util.Scanner;
public class Pasajero {

    private String id, nombre, nacionalidad, asiento;


    public Pasajero(String id, String nombre, String nacionalidad, String asiento) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.asiento = asiento;
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }


    public String Mostrar() {
        return "Id: " + id + ", Nombre: " + nombre + ", Nacionalidad: " + nacionalidad + ", Asiento: " + asiento;
    }
}
class nodo {

    Pasajero pasajero; //Objeto pasajero almacenado en el nodo
    nodo siguiente; 
    nodo anterior; 

    public nodo(Pasajero pasajero) {
        this.pasajero = pasajero;
        this.siguiente = null;
        this.anterior = null;
    }

    //Getters and Setters
    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }

    public nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(nodo anterior) {
        this.anterior = anterior;
    }
}


class listadoble {

    Scanner scanner = new Scanner(System.in);
    nodo inicio;//crea el puntero que apunta al inicio de la lista
    nodo fin;//crea el puntero que apunta al fin lista

    public listadoble() {
        this.inicio = null;
        this.fin = null;
    }

    //Metodo para agregar pasajero al inicio de la lista
    public void AgregarPasajero(Pasajero pasajero) {
        nodo n = new nodo(pasajero);
        if (inicio == null) {
            //si el puntero inicio apunta a null, lista vacia
            inicio = n;
            fin = n;
        } else {
            n.setSiguiente(inicio);//apunta el enlace siguiente del nodo apuntado por n al puntero inicio
            inicio.setAnterior(n);//apunta el enlase anterior del nodo apuntado por inicio a n
            inicio = n; 
        }
    }

    //Metodo para editar por el id entrado
    public void Editar(String id) {
        nodo actual = inicio; //nodo que contiene el objeto
        boolean encontrado = false;
        while (actual != null && !encontrado) {
            if (actual.getPasajero().getId().equals(id)) { //Compara si el get id del pasajero ya guardado anteriormente es igual al id entregado por el usuario
                System.out.print("Ingrese ID del pasajero: ");
                String nuevoid = scanner.nextLine();
                System.out.print("Ingrese nombre del pasajero: ");
                String nuevonombre = scanner.nextLine();
                System.out.print("Ingrese nacionalidad del pasajero: ");
                String nuevanacionalidad = scanner.nextLine();
                System.out.print("Ingrese número de asiento del pasajero: ");
                String nuevoasiento = scanner.nextLine();
                actual.getPasajero().setId(nuevoid);
                actual.getPasajero().setNacionalidad(nuevanacionalidad);
                actual.getPasajero().setNombre(nuevonombre);
                actual.getPasajero().setAsiento(nuevoasiento);
                encontrado = true;
            }
            actual = actual.siguiente;
        }
        if (encontrado) {
            System.out.println("El pasajero de id: " + id + " ha sido modificado");
        } else {
            System.out.println("El id: " + id + " no se encontro");
        }
    }

    //Metodo para eliminar un pasajero de acuerdo al id
    public void EliminarPasajero(String id) {
        nodo actual = inicio;
        boolean encontrado = false;
        while (actual != null && !encontrado) {
            if (actual.getPasajero().getId().equals(id)) {//Compara si el get id del pasajero ya guardado anteriormente es igual al id entregado por el usuario
                encontrado = true;
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                } else {
                    inicio = actual.getSiguiente();
                }
                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                } else {
                    fin = actual.getAnterior();
                }
            } else {
                actual = actual.getSiguiente();
            }
        }
        if (encontrado) {
            System.out.println("El pasajero de id: " + id + " ha sido eliminado");
        } else {
            System.out.println("El id: " + id + " no se encontro");
        }
    }

    //Metodo para buscar un pasajero por su id y devolver el nodo en el que se encuentra
    public nodo Buscar(String id) {
        nodo actual = inicio;
        boolean encontrado = false;
        while (actual != null && !encontrado) {
            if (actual.getPasajero().getId().equals(id)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
}
