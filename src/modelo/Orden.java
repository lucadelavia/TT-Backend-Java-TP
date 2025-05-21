package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Orden {

    private static int contadorOrden = 0;
    private int idOrden;
    private ArrayList<Pedido> productosPedidos;

    public Orden() {
        this.idOrden = ++contadorOrden;
        this.productosPedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        productosPedidos.add(pedido);
    }

    public double calcularTotal() {
        double total = 0;
        for (Pedido pedido : productosPedidos) {
            total += pedido.subTotal();
        }
        return total;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public ArrayList<Pedido> getProductosPedidos() {
        return productosPedidos;
    }

    public void setProductosPedidos(ArrayList<Pedido> productosPedidos) {
        this.productosPedidos = productosPedidos;
    }

    @Override
    public String toString() {
        return "Orden ID: " + idOrden + "\n" +
                "Pedidos: " + productosPedidos + "\n" +
                "Total: $" + calcularTotal();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Orden orden = (Orden) o;
        return idOrden == orden.idOrden &&
                Objects.equals(productosPedidos, orden.productosPedidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrden, productosPedidos);
    }
}
