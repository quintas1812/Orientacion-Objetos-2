package ejercicio2;

public class Bebida extends ItemPedido {

    public Bebida(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double aplicarDescuento(TarjetaCredito tarjeta) {
        return tarjeta.aplicarDescuentoBebida();
    }
}