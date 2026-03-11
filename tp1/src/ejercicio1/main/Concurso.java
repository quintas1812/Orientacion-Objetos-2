package ejercicio1.main;

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
            if (hoy.equals(this.fechaInicio)) {
                int puntos = participante.cantPuntos() + 10;
                participante.cambiarPuntos(puntos);
            }
            return "se puede inscribir";
        }
        return "no se puede inscribir fuera de fechas";
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
