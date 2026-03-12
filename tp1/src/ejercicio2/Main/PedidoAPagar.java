package ejercicio2.Main;

import java.util.ArrayList;

public class PedidoAPagar {
    private ArrayList<ItemPedido> consumiciones;
    private float precioTotal;
    private TarjetaCredito tarjeta;
    private int porcentajeDePropina;

    public PedidoAPagar(ArrayList<ItemPedido> consumiciones, TarjetaCredito tarjeta, int porcentajeDePropina) {
        this.consumiciones = consumiciones;
        this.tarjeta = tarjeta;
        this.precioTotal = calcularPrecioTotal();
        this.porcentajeDePropina = porcentajeDePropina;
    }
    public float calcularPrecioTotal() {
        float costoTotal = 0;
        float descuentoTotal = 0;
        for (ItemPedido consumiciones : this.consumiciones) {
            costoTotal += consumiciones.Precio();
            descuentoTotal += consumiciones.descuentoPara(this.tarjeta);
        }
        float montoPropina = (float) (costoTotal * (this.porcentajeDePropina / 100.0));
        return  descuentoTotal + montoPropina;
    }
}
