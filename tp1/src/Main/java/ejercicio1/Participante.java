package ejercicio1;

import java.time.LocalDate;



public class Participante {
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaInscripcion;
    private int puntos;
    private String email;
    public Participante(int dni, String nombre, String apellido, String email ) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntos =0;
        this.email = email;

    }
    public LocalDate fechaInscripcion() {
        return fechaInscripcion;
    }
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
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
    private void verificarEmail() {

    }

    public String email() {
        return this.email;
    }
}
