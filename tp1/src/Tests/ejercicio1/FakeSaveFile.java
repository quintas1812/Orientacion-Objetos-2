package Tests.ejercicio1;

import Main.ejercicio1.Save;

public class FakeSaveFile implements Save {
    private String datos;
    public String Datos() {
        return datos;
    }
    @Override
    public void guardar(String datos) {
        this.datos = datos;
    }
}
