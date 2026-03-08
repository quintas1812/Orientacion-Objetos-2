package tests;
import main.Concurso;
import main.Participante;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
class ConcursoTest {
    @Test
    void testInscripcionEnPrimerDiaOtorgaPuntosExtra() {
        Participante participante = new Participante(12345678, "Juan", "Perez");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(5));
        concurso.agregarA(participante);
        assertEquals(10, concurso.puntosDe(participante));
    }
    @Test
    void testInscripcionFueraDeFechaNoAgregaParticipante() {
        Participante participante = new Participante(87654321, "Ana", "Gomez");
        LocalDate ayer = LocalDate.now().minusDays(1);
        Concurso concurso = new Concurso(ayer.minusDays(5), ayer);
        concurso.agregarA(participante);
        assertEquals(0, concurso.puntosDe(participante));
    }
    @Test
    void testInscripcionEnFechaValidaSinPuntosExtra() {
        Participante participante = new Participante(11223344, "Luis", "Lopez");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy.minusDays(1), hoy.plusDays(1));
        concurso.agregarA(participante);
       assertEquals(0, concurso.puntosDe(participante));
    }

    @Test
    void testAgregaAlArray() {
        Participante participante = new Participante(11223344, "Luis", "Lopez");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy.minusDays(1), hoy.plusDays(1));
        concurso.agregarA(participante);
        assertEquals(1, concurso.cantidadadParticipantes());
    }
}