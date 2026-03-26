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
        // Formateamos los datos para el cuerpo del mail
        String asunto = "Nueva inscripción al concurso";
        String cuerpo = "Se ha registrado un nuevo participante:" + datos;

        // Enviamos el correo usando el emailSender que ya configuramos
        emailSender.enviarEmail(this.destinatario, asunto, cuerpo);
    }
}
