package ejercicio1;

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
// Preparar tu cuenta de Gmail (Paso Obligatorio)
//Google ya no permite usar tu contraseña normal para aplicaciones externas. Debes generar una "Contraseña de Aplicación":
//1.
//Ve a tu Cuenta de Google.
//2.
//Activa la Verificación en dos pasos (si no la tienes ya).
//3.
//Busca en el buscador de la cuenta: "Contraseñas de aplicaciones".
//4.
//Crea una nueva (ponle de nombre "Java Test").
//5.
//Google te dará un código de 16 letras. Guárdalo, esa será tu contraseña en el código.
//2. Modificar el Test en ConcursoTest.java
//Ahora, cambia los datos del servidor para que apunten a Google en lugar de Mailtrap:
//@Test
//void enviarGmailReal() {
//    // 1. Configuración para Gmail
//    String host = "smtp.gmail.com";
//    int port = 587; // Puerto para TLS
//    String username = "tu_correo@gmail.com"; // Tu Gmail real
//    String password = "abcd efgh ijkl mnop"; // ¡Las 16 letras que te dio Google!
//
//    EmailSender emailSender = new EmailSender(host, port, username, password);
//    SaveEmail save = new SaveEmail(emailSender, "correo_del_que_recibe@gmail.com");
//
//    Participante participante = new Participante(12345678, "Prueba", "Real");
//    LocalDate hoy = LocalDate.now();
//    Concurso concurso = new Concurso(hoy, hoy.plusDays(5));
//
//    // Al agregar, se disparará el envío real
//    concurso.agregarA(participante, save);
//}
    //. Ajuste técnico en EmailSender.java
//Para que Gmail no rechace la conexión, asegúrate de que tu clase EmailSender tenga estas propiedades (tu código actual ya debería tenerlas, pero revísalo):
//Java
//prop.put("mail.smtp.auth", "true");
//prop.put("mail.smtp.starttls.enable", "true"); // Vital para Gmail
//¿Qué va a pasar?
//•
//Cuando ejecutes el test, Java se conectará al servidor de Google.
//•
//Google verificará tu "Contraseña de Aplicación".
//•
//El mail saldrá de tu bandeja de salida y llegará a la bandeja de entrada real del destinatario.
//Advertencia de Seguridad: Nunca subas este archivo a GitHub con tu correo y contraseña de aplicación visibles. ¡Úsalo solo para esta prueba local!
//¿Te animas a generar la contraseña en tu cuenta de Google para probarlo?
    @Test
    void Gmail(){//verificar que se manda los gmail
        String host = "sandbox.smtp.mailtrap.io";
        int port = 2525;
        String username = "c9604509b9b552";
        String password = "ceea89428edb2f";
        EmailSender emailSender = new EmailSender(host, port, username, password);
        SaveEmail save = new SaveEmail(emailSender, "augustoq3k@gmail.com");
        Participante participante = new Participante(12345678, "Juan", "Perez");
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(5));
        concurso.agregarA(participante, save);
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
        String expected= LocalDate.now().toString() + ", " + numConcurso + ", Perez DNI: 12345678" + System.lineSeparator();
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
