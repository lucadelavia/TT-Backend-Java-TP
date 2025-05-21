package modelo;

import java.util.Objects;

public class Pedido {

    private Producto producto;
    private int cantidad;

    public Pedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double subTotal() {
        return producto.getPrecioProducto() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto: " + producto.getNombreProducto() +
                " | Cantidad: " + cantidad +
                " | Subtotal: $" + subTotal();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return cantidad == pedido.cantidad &&
                Objects.equals(producto, pedido.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, cantidad);
    }
}
