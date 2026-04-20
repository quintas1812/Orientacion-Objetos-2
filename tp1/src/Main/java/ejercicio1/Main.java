package ejercicio1;

public class Main {
    public static void main(String[] args) {
        java.time.LocalDate hoy = java.time.LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(10));
        Participante p1 = new Participante(12345678, "Juan", "Perez", "Jueanperez212@gmail.com");
        System.out.println("Inscribiendo participante...");
        Save save = new SaveFile("pruebaconcurso.txt");
        EmailSender emailSender = new EmailSender("sandbox.smtp.mailtrap.io", 2525, "c9604509b9b552", "ceea89428edb2f");
        Notificador notificador = new Email(emailSender);
        concurso.agregarA(p1, save, notificador);
        System.out.println("Puntos del participante: " + concurso.puntosDe(p1));
        System.out.println("Cantidad de inscriptos: " + concurso.cantidadadParticipantes());
    }
}
