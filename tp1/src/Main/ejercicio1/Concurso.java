package Main.ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    private static int num = 0;
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.id = num++;
    }
    public void agregarA(Participante participante, Save save) {
        LocalDate hoy = LocalDate.now();
        if (!hoy.isBefore(this.fechaInicio) && !hoy.isAfter(this.fechaFin)) {
            participantes.add(participante);
            participante.setFechaInscripcion(hoy);
            if (hoy.equals(this.fechaInicio)) {
                int puntos = participante.cantPuntos() + 10;
                participante.cambiarPuntos(puntos);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(participante.fechaInscripcion()).append(", ").append(this.id).append(", ")
                    .append(participante.Apellido()).append(" DNI: ")
                    .append(participante.Dni()).append(System.lineSeparator());
            String datos = sb.toString();
            save.guardar(datos);
        }else {
            throw new RuntimeException("no se puede inscribir fuera de fechas");
        }
    }



    public int idCurso(){
        return this.id;
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
