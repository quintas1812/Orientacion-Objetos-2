package ejercicio2;

public class Main {
    public static void main(String[] args) {
        java.util.ArrayList<ItemPedido> consumiciones = new java.util.ArrayList<>();
        consumiciones.add(new Bebida("Coca Cola", 100));
        consumiciones.add(new Bebida("Agua", 100));
        consumiciones.add(new Plato("Pizza", 1000));
        consumiciones.add(new Plato("Pasta", 500));
        SaveFile1 save = new SaveFile1("pruebapedido.txt");

        TarjetaCredito tarjeta = new Visa();
        PedidoAPagar pedido = new PedidoAPagar(consumiciones, tarjeta,2 ,save);

        System.out.println("Calculando total para pedido con Visa...");
        System.out.println("Precio total con propina: " + pedido.calcularPrecioTotal());
    }


}
