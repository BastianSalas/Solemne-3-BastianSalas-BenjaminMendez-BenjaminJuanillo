import java.util.LinkedList;
import java.util.Queue;

public class funciones {
    LinkedList<Vuelo> listaVuelos = new LinkedList<>();
    LinkedList<Pasajero> listaPasajeros = new LinkedList<>();

    public void crearVuelo(String destino, String horario, String nombre) {
        Vuelo nuevoVuelo = new Vuelo(destino, horario, nombre);
        listaVuelos.add(nuevoVuelo);
    }

    public void editarVuelo(String nombre, String nuevoDestino, String nuevoHorario) {
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getNombre().equals(nombre)) {
                vuelo.setDestino(nuevoDestino);
                vuelo.setHorario(nuevoHorario);
                break;
            }
        }
    }

    public void eliminarVuelo(String nombre) {
        listaVuelos.removeIf(vuelo -> vuelo.getNombre().equals(nombre) && vuelo.getPasajeros().isEmpty());
    }

    public void mostrarVuelos() {
        for (Vuelo vuelo : listaVuelos) {
            System.out.println("Destino: " + vuelo.getDestino() + ", Horario: " + vuelo.getHorario() + ", Nombre: " + vuelo.getNombre());
        }
    }

    public void crearPasajero(int id, String nombre, String nacionalidad, int asiento) {
        Pasajero nuevoPasajero = new Pasajero(id, nombre, nacionalidad, asiento);
        listaPasajeros.add(nuevoPasajero);
    }

    public void editarPasajero(int id, String nuevoNombre, String nuevaNacionalidad, int nuevoAsiento) {
        for (Pasajero pasajero : listaPasajeros) {
            if (pasajero.getId() == id) {
                pasajero.setNombre(nuevoNombre);
                pasajero.setNacionalidad(nuevaNacionalidad);
                pasajero.setAsiento(nuevoAsiento);
                break;
            }
        }
    }

    public void eliminarPasajero(int id) {
        listaPasajeros.removeIf(pasajero -> pasajero.getId() == id);
    }

    public void asociarPasajeroAVuelo(int idPasajero, String nombreVuelo) {
        Pasajero pasajero = listaPasajeros.stream().filter(p -> p.getId() == idPasajero).findFirst().orElse(null);
        if (pasajero != null) {
            for (Vuelo vuelo : listaVuelos) {
                if (vuelo.getNombre().equals(nombreVuelo) && vuelo.getPasajeros().stream().noneMatch(p -> p.getId() == idPasajero)) {
                    vuelo.getPasajeros().add(pasajero);
                    break;
                }
            }
        }
    }

    public void mostrarPasajerosDeVuelo(String nombreVuelo) {
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getNombre().equals(nombreVuelo)) {
                for (Pasajero pasajero : vuelo.getPasajeros()) {
                    System.out.println("ID: " + pasajero.getId() + ", Nombre: " + pasajero.getNombre() + ", Nacionalidad: " + pasajero.getNacionalidad() + ", Asiento: " + pasajero.getAsiento());
                }
                break;
            }
        }
    }

    public void procesoAbordaje(String nombreVuelo) {
        Queue<Pasajero> colaAbordaje = new LinkedList<>();
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getNombre().equals(nombreVuelo)) {
                for (Pasajero pasajero : vuelo.getPasajeros()) {
                    if (pasajero.getAsiento() % 2 == 0) {
                        colaAbordaje.add(pasajero);
                    }
                }
                for (Pasajero pasajero : vuelo.getPasajeros()) {
                    if (pasajero.getAsiento() % 2 != 0) {
                        colaAbordaje.add(pasajero);
                    }
                }
                break;
            }
        }

        if (colaAbordaje.isEmpty()) {
            System.out.println("La lista de pasajeros del vuelo no está llena.");
        } else {
            System.out.println("Proceso de abordaje:");
            while (!colaAbordaje.isEmpty()) {
                Pasajero pasajero = colaAbordaje.poll();
                System.out.println("Pasajero ID: " + pasajero.getId() + ", Nombre: " + pasajero.getNombre());
            }
        }
    }
}
