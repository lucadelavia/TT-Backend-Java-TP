import modelo.*;
import servicio.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductoServicio productoServicio = new ProductoServicio();
        OrdenServicio ordenServicio = new OrdenServicio();

        int opcion;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear orden");
            System.out.println("6) Listar órdenes");
            System.out.println("7) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());

                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(scanner.nextLine());

                    Producto producto = new Producto(nombre, precio, stock);
                    productoServicio.agregarProducto(producto);
                    System.out.println("Producto agregado.");
                    break;

                case 2:
                    productoServicio.listarProductos();
                    break;

                case 3:
                    System.out.print("Ingrese ID del producto a actualizar: ");
                    int idActualizar = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = Double.parseDouble(scanner.nextLine());

                    System.out.print("Nuevo stock: ");
                    int nuevoStock = Integer.parseInt(scanner.nextLine());

                    boolean actualizado = productoServicio.actualizarProducto(idActualizar, nuevoPrecio, nuevoStock);
                    if (actualizado) {
                        System.out.println("Producto actualizado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese ID del producto a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());

                    boolean eliminado = productoServicio.eliminarProducto(idEliminar);
                    if (eliminado) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    Orden nuevaOrden = new Orden();

                    System.out.print("¿Cuántos productos desea agregar a la orden?: ");
                    int cantidadProductos = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < cantidadProductos; i++) {
                        System.out.print("ID del producto: ");
                        int idProd = Integer.parseInt(scanner.nextLine());

                        Producto prodSeleccionado = productoServicio.buscarProductoPorId(idProd);
                        if (prodSeleccionado == null) {
                            System.out.println("Producto no encontrado.");
                            continue;
                        }

                        System.out.print("Cantidad deseada: ");
                        int cantidad = Integer.parseInt(scanner.nextLine());

                        boolean agregado = ordenServicio.agregarPedidoAOrden(nuevaOrden, prodSeleccionado, cantidad);

                        if (agregado) {
                            System.out.println("Producto agregado a la orden.");
                        }
                    }

                    ordenServicio.agregarOrden(nuevaOrden);
                    System.out.println("Orden creada. ID: " + nuevaOrden.getIdOrden());

                    break;

                case 6:
                    for (Orden orden : ordenServicio.listarOrdenes()) {
                        System.out.println(orden);
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 7);
    }
}
