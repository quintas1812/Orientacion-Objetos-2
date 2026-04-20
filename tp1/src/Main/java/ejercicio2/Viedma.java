package ejercicio2;

public class Viedma implements TarjetaCredito{
    private final double DESCUENTO = 1; // esta tarjeta no tenia ningun descuento
    @Override
    public double aplicarDescuentoBebida() {
        return DESCUENTO;
    }
    @Override
    public double aplicarDescuentoPlato() {
        return DESCUENTO;
    }
}
