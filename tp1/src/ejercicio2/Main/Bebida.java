package ejercicio2.Main;

public class Bebida extends ItemPedido {

    public Bebida(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double descuentoPara(TarjetaCredito tarjeta) {
        if ("Visa".equals(tarjeta.Nombre()))  {
            return this.precio * 0.97;
        }
        if ("Comarca Plus".equals(tarjeta.Nombre())) {
            return this.precio * 0.98;
        }
        return  this.precio;
    }
}