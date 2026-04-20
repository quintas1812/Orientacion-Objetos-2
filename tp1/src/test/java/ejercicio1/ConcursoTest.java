package ejercicio1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ConcursoTest {

    @DisplayName("Verifica si se le otorgan los 10 puntos si se inscribe el primer día")
    @Test
    void testInscripcionPrimerDiaSumaPuntos(@TempDir Path tempDir) {
        SaveFile save = new SaveFile(tempDir.resolve("export-participantes.csv").toString());
        Notificador notificador = new FakeNotificador();
        Participante participante = new Participante(12345678, "Juan", "Perez", "juan@gmail.com");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(5));
        concurso.agregarA(participante, save, notificador);
        assertEquals(10, concurso.puntosDe(participante));
    }

    @Test
    void testInscripcionConEmailMockeado() {
        // Usamos un mock para verificar que se intenta enviar el mail sin mandarlo realmente
        EmailSender emailSenderMock = mock(EmailSender.class);
        Notificador notificadorEmail = new Email(emailSenderMock);
        Save save = new FakeSaveFile();
        Participante participante = new Participante(12345678, "Juan", "Perez", "juan@gmail.com");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(5));
        concurso.agregarA(participante, save, notificadorEmail);
        verify(emailSenderMock, times(1)).enviarEmail(anyString(), anyString(), anyString());
        assertEquals(10, concurso.puntosDe(participante));
    }

    @Test
    void testGmailReal() {
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "augustoq3k@gmail.com";
        String password = "gniijodsrhcp";
        EmailSender emailSender = new EmailSender(host, port, username, password);
        Notificador notificadorEmail = new Email(emailSender);
        Save save = new FakeSaveFile();
        Participante participante = new Participante(47780898, "Morena", "Quintas", "morequintas@gmail.com");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(5));
        concurso.agregarA(participante, save, notificadorEmail);
        assertEquals(10, concurso.puntosDe(participante));
    }

    @Test
    void testInscripcionFueraDeFechaLanzaExcepcion() {
        FakeSaveFile save = new FakeSaveFile();
        Notificador notificador = new FakeNotificador();
        Participante participante = new Participante(87654321, "Ana", "Gomez", "ana@gmail.com");
        LocalDate ayer = LocalDate.now().minusDays(1);
        Concurso concurso = new Concurso(ayer.minusDays(5), ayer);
        RuntimeException exception = assertThrows(RuntimeException.class,
            () -> concurso.agregarA(participante, save, notificador));
        assertEquals("no se puede inscribir fuera de fechas", exception.getMessage());
    }

    @Test
    void testInscripcionEnFechaValidaSinPuntosExtra() {
        FakeSaveFile save = new FakeSaveFile();
        Notificador notificador = new FakeNotificador();
        Participante participante = new Participante(11223344, "Luis", "Lopez", "luis@gmail.com");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy.minusDays(1), hoy.plusDays(1));
        concurso.agregarA(participante, save, notificador);
        assertEquals(0, concurso.puntosDe(participante));
    }

    @Test
    void testAgregaAlArrayCorrectamente() {
        FakeSaveFile save = new FakeSaveFile();
        Notificador notificador = new FakeNotificador();
        Participante participante = new Participante(11223344, "Luis", "Lopez", "luis@gmail.com");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(1));
        concurso.agregarA(participante, save, notificador);
        assertEquals(1, concurso.cantidadadParticipantes());
    }
}
