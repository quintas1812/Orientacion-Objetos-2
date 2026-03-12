package ejercicio2.Tests;
import ejercicio2.Main.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PedidoAPagarTest {
    @Test
    void testCalcularPrecioTotalConVisa() {
        ArrayList<ItemPedido> consumiciones = new ArrayList<ItemPedido>();
        consumiciones.add(new Bebida("Coca Cola", 100));
        consumiciones.add(new Plato("Pasta", 500));
        TarjetaCredito tarjeta = new TarjetaCredito("Visa");
       PedidoAPagar pedido = new PedidoAPagar(consumiciones, tarjeta, 5);
        // Bebida: 100 * 0.97 = 97
        // Plato: 500
        //total: 100 + 500 = 600
        //subtotal : 500 + 97 = 597
        // aplico la propina sobre el total: 600 * (5/100) = 30
        // precio final (subtotal + propina): 597 + 30 = 627
        assertEquals(627f, pedido.calcularPrecioTotal(), 0.01);
    }

    @Test
    void testCalcularPrecioTotalConMastercard() {
        ArrayList<ItemPedido> consumiciones = new ArrayList<ItemPedido>();
        consumiciones.add(new Bebida("Agua", 100));
        consumiciones.add(new Plato("Pizza", 1000));
        TarjetaCredito tarjeta = new TarjetaCredito("Mastercard");
       PedidoAPagar pedido = new PedidoAPagar(consumiciones, tarjeta, 3);
        // Bebida: 100
        // Plato: 1000 * 0.98 = 980
        //total: 100 + 1000 = 1100
        //subtotal : 100 + 980 = 1080
        // aplico la propina sobre el total: 1100 * 0.03 = 33
        // precio final (subtotal + propina): 1080 + 33 = 1113
        assertEquals(1113f, pedido.calcularPrecioTotal(), 0.01);
    }

    @Test
    void testCalcularPrecioTotalConComarcaPlusYPropina() {
        ArrayList<ItemPedido> consumiciones = new ArrayList<ItemPedido>();
        consumiciones.add(new Bebida("Cerveza", 200));
        consumiciones.add(new Plato("Ensalada", 500));
        TarjetaCredito tarjeta = new TarjetaCredito("Comarca Plus");
        PedidoAPagar pedido = new PedidoAPagar(consumiciones, tarjeta, 2);
        // Bebida: 200 * 0.98 = 196
        // Plato: 500 * 0.98 = 490
        //total: 500 + 200 = 700
        //subtotal :196 + 490 = 686
        // aplico la propina sobre el total: 700 * 0.02 = 14
        // precio final (subtotal + propina): 686 + 14 = 700
        assertEquals(700f, pedido.calcularPrecioTotal(), 0.01);
    }
    @Test
     void testCalcularPrecioTotalSinDescuento(){
        ArrayList<ItemPedido> consumiciones = new ArrayList<ItemPedido>();
        consumiciones.add(new Bebida("Cerveza", 200));
        consumiciones.add(new Plato("Ensalada", 500));
        TarjetaCredito tarjeta = new TarjetaCredito("Viedma");
        PedidoAPagar pedido = new PedidoAPagar(consumiciones, tarjeta, 2);
        // Bebida: 200
        // Plato: 500
        //total: 500 + 200 = 700
        // aplico la propina sobre el total: 700 * 0.02 = 14
        // precio final (subtotal + propina): 700 + 14 = 714
         assertEquals(714, pedido.calcularPrecioTotal(), 0.01);
     }

}