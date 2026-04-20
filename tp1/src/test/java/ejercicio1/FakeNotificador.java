package ejercicio1;

public class FakeNotificador implements Notificador {
    private String datos;
    private String usuario;
    @Override
    public void notificar(String datos, String usuario) {

    }
    public String Usuario() {
        return usuario;
    }
    public String Datos() {
        return datos;
    }
}
