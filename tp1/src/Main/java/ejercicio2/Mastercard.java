package ejercicio2;

public class Mastercard implements  TarjetaCredito{
    private final double DESCUENTO = 0.98;// descuento del %2

    @Override
    public double aplicarDescuentoBebida(double precio) {
        return precio; //para las bebidas con esta tarjeta no hay descuento
    }

    @Override
    public double aplicarDescuentoPlato(double precio) {
        return precio * DESCUENTO;
    }
}

