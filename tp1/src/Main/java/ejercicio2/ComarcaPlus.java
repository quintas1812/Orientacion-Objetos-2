package ejercicio2;

public class ComarcaPlus implements TarjetaCredito{
private final double DESCUENTO = 0.98;// descuento del %2
    @Override
    public double aplicarDescuentoBebida() {
        return DESCUENTO; //para plato y bebida hay descuento
    }
    @Override
    public double aplicarDescuentoPlato() {
        return DESCUENTO;
    }
}
