package ejercicio2;

public class Visa implements TarjetaCredito{
    private final double DESCUENTO = 0.97;// descuento del %3
    @Override
    public double aplicarDescuentoBebida(double precio) {
        return precio * DESCUENTO;
    }
    @Override
    public double aplicarDescuentoPlato(double precio) {
        return precio;         //para los platos con esta tarjeta no hay descuento
    }
}
