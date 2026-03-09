package ejercicio2.Tests;

import ejercicio2.Main.Bebida;
import ejercicio2.Main.PedidoAPagar;
import ejercicio2.Main.Plato;
import ejercicio2.Main.TarjetaCredito;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PedidoAPagarTest {
    @Test
    void testCalcularPrecioTotalConVisaYPropina() {
        java.util.ArrayList<ejercicio2.Main.Bebida> bebidas = new java.util.ArrayList<>();
        bebidas.add(new ejercicio2.Main.Bebida("Coca Cola", 100));
        java.util.ArrayList<ejercicio2.Main.Plato> platos = new java.util.ArrayList<>();
        platos.add(new ejercicio2.Main.Plato("Pasta", 500));
        ejercicio2.Main.TarjetaCredito tarjeta = new ejercicio2.Main.TarjetaCredito("Visa");
        ejercicio2.Main.PedidoAPagar pedido = new ejercicio2.Main.PedidoAPagar(bebidas, platos, tarjeta, 10);
        // Bebida: 100 * 0.97 = 97
        // Plato: 500
        // Subtotal: 597
        // Con 10% propina: 597 * 1.1 = 656.7
        assertEquals(656.7f, pedido.calcularPrecioTotal(), 0.01);
    }

    @Test
    void testCalcularPrecioTotalConMastercardYPropina() {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        bebidas.add(new Bebida("Agua", 100));
      ArrayList<Plato> platos = new ArrayList<>();
        platos.add(new Plato("Pizza", 1000));
        TarjetaCredito tarjeta = new TarjetaCredito("Mastercard");
       PedidoAPagar pedido = new PedidoAPagar(bebidas, platos, tarjeta, 5);
        // Bebida: 100
        // Plato: 1000 * 0.98 = 980
        // Subtotal: 1080
        // Con 5% propina: 1080 * 1.05 = 1134
        assertEquals(1134f, pedido.calcularPrecioTotal(), 0.01);
    }

    @Test
    void testCalcularPrecioTotalConComarcaPlusYPropina() {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        bebidas.add(new Bebida("Cerveza", 200));
        ArrayList<Plato> platos = new ArrayList<>();
        platos.add(new Plato("Ensalada", 500));
        TarjetaCredito tarjeta = new TarjetaCredito("Comarca Plus");
        PedidoAPagar pedido = new PedidoAPagar(bebidas, platos, tarjeta, 5);
        // Bebida: 200
        // Plato: 500
        // Subtotal con descuento (2%): 700 * 0.98 = 686
        // Con 5% propina: 686 * 1.05 = 720.3
        assertEquals(720.3f, pedido.calcularPrecioTotal(), 0.01);
    }
    @Test
     void testCalcularPrecioTotalSinTarjeta(){
        ArrayList<Bebida> bebidas = new ArrayList<>();
        bebidas.add(new Bebida("Cerveza", 200));
        ArrayList<Plato> platos = new ArrayList<>();
        platos.add(new Plato("Ensalada", 500));
        TarjetaCredito tarjeta = new TarjetaCredito("Viedma");

        PedidoAPagar pedido = new PedidoAPagar(bebidas, platos, tarjeta, 5);
        // Bebida: 200
        // Plato: 500
        // Subtotal: 700
        // Con 5% propina: 700 * 1.05 =  735
         assertEquals(735, pedido.calcularPrecioTotal(), 0.01);
     }

}