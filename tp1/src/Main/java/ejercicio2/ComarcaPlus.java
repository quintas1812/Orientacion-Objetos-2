package ejercicio2;

public class ComarcaPlus implements TarjetaCredito{
private final double DESCUENTO = 0.98;// descuento del %2
    @Override
    public double aplicarDescuentoBebida(double precio) {
        return precio * DESCUENTO; //para plato y bebida hay descuento
    }
    @Override
    public double aplicarDescuentoPlato(double precio) {
        return precio * DESCUENTO;
    }
}
