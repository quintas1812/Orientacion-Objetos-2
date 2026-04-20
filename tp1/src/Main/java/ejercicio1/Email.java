package ejercicio1;

public class Email implements Notificador {
    private final EmailSender emailSender;

    public Email(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void notificar(String datos, String usuario) {
        emailSender.enviarEmail(usuario, "Nueva Inscripción", datos);
    }
}
