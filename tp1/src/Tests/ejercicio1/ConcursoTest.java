package Tests.ejercicio1;
import Main.ejercicio1.Concurso;
import Main.ejercicio1.Participante;
import Main.ejercicio1.SaveBD;
import Main.ejercicio1.SaveFile;
import Main.ejercicio2.SaveBD1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConcursoTest {
    @Test
    void test1(@TempDir Path tempDir) {
        // este test verifica la logica ademas de si se guardan los datos, en este caso en un archivo temporal.
        // verifica si el participante que se anota el primer dia le otorgan los 10 puntos.
        SaveFile save = new SaveFile(tempDir.resolve("export-participantes.csv").toString());
        Participante participante = new Participante(12345678, "Juan", "Perez");
        Participante participante2 = new Participante(87654321, "Ana", "Gomez");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(5));
        concurso.agregarA(participante, save);
        concurso.agregarA(participante2, save);
        assertEquals(10, concurso.puntosDe(participante));
    }
    @Test
    void test2()  {
        // verifica que se guarde corectamente los datos del archivo utilizando un mockito
        FakeSaveFile save = new FakeSaveFile();
        Participante participante = new Participante(12345678, "Juan", "Perez");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(5));
        concurso.agregarA(participante, save);
        int numConcurso = concurso.idCurso();
        String expected= "2026-03-22, "+numConcurso +", Perez DNI: 12345678\r\n";
        assertEquals(expected, save.Datos());
    }
    @Test
    void testBD(){
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL_DB = "jdbc:mysql://localhost:3306/seminario_tp?useSSL=false&serverTimezone=UTC";
        String USER = "root";
        String PASS = "91188";
        SaveBD save = new SaveBD(DRIVER, URL_DB, USER, PASS);
        Participante participante = new Participante(12345678, "Juan", "Perez");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(5));
        concurso.agregarA(participante, save);
        assertEquals(10, concurso.puntosDe(participante));
    }

    // los siguientes test solo verifican la logica
    @Test
    void testInscripcionFueraDeFechaNoAgregaParticipante() {
        FakeSaveFile save = new FakeSaveFile();
        Participante participante = new Participante(87654321, "Ana", "Gomez");
        LocalDate ayer = LocalDate.now().minusDays(1);
        Concurso concurso = new Concurso(ayer.minusDays(5), ayer);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> concurso.agregarA(participante, save));
        assertEquals("no se puede inscribir fuera de fechas", exception.getMessage());
    }
    @Test
    void testInscripcionEnFechaValidaSinPuntosExtra() {
        FakeSaveFile save = new FakeSaveFile();
        Participante participante = new Participante(11223344, "Luis", "Lopez");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy.minusDays(1), hoy.plusDays(1));
        concurso.agregarA(participante,save);
       assertEquals(0, concurso.puntosDe(participante));
    }

    @Test
    void testAgregaAlArray() {
        FakeSaveFile save = new FakeSaveFile();
        Participante participante = new Participante(11223344, "Luis", "Lopez");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy.minusDays(1), hoy.plusDays(1));
        concurso.agregarA(participante, save);
        assertEquals(1, concurso.cantidadadParticipantes());
    }
}