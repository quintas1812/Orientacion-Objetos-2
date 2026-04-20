package ejercicio2;

public class Plato extends ItemPedido {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        super(nombre, precio);
        this.nombre = nombre;
        this.precio = precio;
    }
    public String Nombre() {
        return nombre;
    }
    public double Precio() {
        return precio;
    }
    public double aplicarDescuento(TarjetaCredito tarjeta) {
        return tarjeta.aplicarDescuentoPlato();
    }
}
