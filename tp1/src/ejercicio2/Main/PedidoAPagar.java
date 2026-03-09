package ejercicio2.Main;

import java.util.ArrayList;

public class PedidoAPagar {
    private ArrayList<Bebida> bebidas;
    private ArrayList<Plato> platos;
    private float precioTotal;
    private TarjetaCredito tarjeta;
    private float porcentajeDePropina;

    public PedidoAPagar(ArrayList<Bebida> bebidas, ArrayList<Plato> platos, TarjetaCredito tarjeta, float porcentajeDePropina) {
        this.bebidas = bebidas;
        this.platos = platos;
        this.tarjeta = tarjeta;
        this.precioTotal = calcularPrecioTotal();
        this.porcentajeDePropina = porcentajeDePropina;
    }
    public float calcularPrecioTotal() {
                double totalBebida = 0;
                double totalPlato = 0;
                double precioAPagar = 0;
        for (Bebida bebida : bebidas) {
          totalBebida += bebida.Precio();
        }
        if ("Visa".equals(tarjeta.Nombre())) {
            totalBebida = (float) (totalBebida * 0.97);
        }
        for (Plato plato : platos) {
            totalPlato += plato.Precio();
        }
        if ("Mastercard".equals(tarjeta.Nombre())) {
            totalPlato = (float) (totalPlato * 0.98);
        }
        precioAPagar = totalBebida + totalPlato;
        if ("Comarca Plus".equals(tarjeta.Nombre())) {
            precioAPagar = (float) (precioAPagar * 0.98);
        }
        precioAPagar = (float) (precioAPagar * (1 + (porcentajeDePropina / 100)));
        return (float) precioAPagar;
    }
    }


