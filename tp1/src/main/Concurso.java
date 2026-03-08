package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String agregarA(Participante participante) {
        LocalDate hoy = LocalDate.now();
        if (!hoy.isBefore(this.fechaInicio) && !hoy.isAfter(this.fechaFin)) {
            participantes.add(participante);
            return "se puedo inscribir";
        }
        if (hoy.equals(this.fechaInicio)) {
           int puntos= participante.cantPuntos() + 10;
           participante.cambiarPuntos(puntos);
            return "se puedo inscribir";
        }
        if (hoy.isAfter(this.fechaFin)){
            return "no se puede inscribir fuera de fechas";
        }
        return null;
    }
    public int puntosDe(Participante participante){
        return participante.cantPuntos();
    }
    public void eliminarA(Participante participante) {

        participantes.remove(participante);
    }
    public int cantidadadParticipantes(){
        return this.participantes.size();
    }
}
