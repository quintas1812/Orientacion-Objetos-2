package ejercicio1.main;
public class Participante {
    private int dni;
    private String nombre;
    private String apellido;
    private int puntos;
    public Participante(int dni, String nombre, String apellido ) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntos =0;
    }
    public int Dni() {
        return dni;
    }
    public String Nombre() {
        return nombre;
    }
    public String Apellido() {
        return apellido;
    }
    public int cantPuntos() {
        return puntos;
    }
    public void cambiarPuntos(int puntos) {
        this.puntos = puntos;
    }
}
