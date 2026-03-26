package ejercicio1;

public class SaveEmail implements Save {
    private EmailSender emailSender;
    private String destinatario;

    public SaveEmail(EmailSender emailSender, String destinatario) {
        this.emailSender = emailSender;
        this.destinatario = destinatario;
    }

    @Override
    public void guardar(String datos) {
        emailSender.enviarEmail(destinatario, "Nueva Inscripción", datos);
    }
}