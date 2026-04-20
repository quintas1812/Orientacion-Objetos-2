package ejercicio2;

public class Visa implements TarjetaCredito{
    private final double DESCUENTO = 0.97;// descuento del %3
    @Override
    public double aplicarDescuentoBebida( ) {
        return DESCUENTO;
    }
    @Override
    public double aplicarDescuentoPlato( ) {
        return 1;         //para los platos con esta tarjeta no hay descuento
    }
}
