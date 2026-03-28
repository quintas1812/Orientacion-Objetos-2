package ejercicio2;

public class Viedma implements TarjetaCredito{
    private final double DESCUENTO = 1; // esta tarjeta no tenia ningun descuento
    @Override
    public double aplicarDescuentoBebida(double precio) {
        return precio * DESCUENTO;
    }
    @Override
    public double aplicarDescuentoPlato(double precio) {
        return precio * DESCUENTO;
    }
}
