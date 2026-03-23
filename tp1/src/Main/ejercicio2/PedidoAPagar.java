package Main.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoAPagar {
    private ArrayList<ItemPedido> consumiciones;
    private float precioTotal;
    private TarjetaCredito tarjeta;
    private int porcentajeDePropina;

    public PedidoAPagar(ArrayList<ItemPedido> consumiciones, TarjetaCredito tarjeta, int porcentajeDePropina, Save1 save) {
        this.consumiciones = consumiciones;
        this.tarjeta = tarjeta;
        this.porcentajeDePropina = porcentajeDePropina;
        this.precioTotal = calcularPrecioTotal();
        LocalDate date = LocalDate.now();
        save.guardar(date + " $" + precioTotal);
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
