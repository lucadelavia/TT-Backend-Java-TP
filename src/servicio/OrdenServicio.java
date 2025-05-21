package servicio;

import modelo.Orden;
import modelo.Producto;
import modelo.Pedido;

import java.util.ArrayList;
import java.util.List;

public class OrdenServicio {

    private ArrayList<Orden> ordenes = new ArrayList<>();

    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
    }

    public Orden buscarOrdenPorId(int id) {
        for (Orden orden : ordenes) {
            if (orden.getIdOrden() == id) {
                return orden;
            }
        }
        return null;
    }

    public List<Orden> listarOrdenes() {
        return ordenes;
    }

    public boolean agregarPedidoAOrden(Orden orden, Producto producto, int cantidad) {
        if (producto.getStockProducto() < cantidad) {
            System.out.println("Stock insuficiente para: " + producto.getNombreProducto());
            return false;
        }

        producto.setStockProducto(producto.getStockProducto() - cantidad);
        Pedido pedido = new Pedido(producto, cantidad);
        orden.agregarPedido(pedido);
        return true;
    }
}
