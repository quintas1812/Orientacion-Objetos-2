
package ejercicio2;

public abstract class ItemPedido {
    protected String nombre;
    protected double precio;

    public ItemPedido(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double Precio() {
        return this.precio;
    }

    public String Nombre() {
        return this.nombre;
    }

    public abstract double aplicarDescuento(TarjetaCredito tarjeta);
}
