import java.util.LinkedList;

class Pasajero {
    private int id;
    private String nombre;
    private String nacionalidad;
    private int asiento;

    public Pasajero(int id, String nombre, String nacionalidad, int asiento) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.asiento = asiento;
    }
/////////////////////////////////////////////////////////////////////
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
/////////////////////////////////////////////////////////////////////
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/////////////////////////////////////////////////////////////////////
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
/////////////////////////////////////////////////////////////////////
    public int getAsiento() {
        return asiento;
    }
    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
/////////////////////////////////////////////////////////////////////
}

class Vuelo {
    private String destino;
    private String horario;
    private String nombre;
    private LinkedList<Pasajero> pasajeros;

    public Vuelo(String destino, String horario, String nombre) {
        this.destino = destino;
        this.horario = horario;
        this.nombre = nombre;
        this.pasajeros = new LinkedList<>();
    }

/////////////////////////////////////////////////////////////////////
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
/////////////////////////////////////////////////////////////////////
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
/////////////////////////////////////////////////////////////////////
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/////////////////////////////////////////////////////////////////////
    public LinkedList<Pasajero> getPasajeros() {
        return pasajeros;
    }
    public void setPasajeros(LinkedList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }
/////////////////////////////////////////////////////////////////////    
}
