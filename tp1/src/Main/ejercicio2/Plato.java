package Main.ejercicio2;

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
    public double descuentoPara(TarjetaCredito tarjeta) {
        if ("Mastercard".equals(tarjeta.Nombre()) || "Comarca Plus".equals(tarjeta.Nombre()))  {
            return this.precio * 0.98;
        }
        return  this.precio;
    }
}
