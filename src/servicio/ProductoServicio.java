package servicio;

import modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductoServicio {

    private ArrayList<Producto>productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarProducto(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());
        Producto producto = new  Producto(nombre,precio,stock);

        agregarProducto(producto);

    }

    public void listarProductos(){
        for(Producto producto : productos){
            System.out.println(producto.toString());
        }
    }

    public Producto buscarProductoPorId(int id){

        Producto retorno = null;

        for(Producto producto : productos){
            if (producto.getIdProducto() == id){
                retorno = producto;
            }
        }

        return retorno;

    }

    public Producto buscarProductoPorNombre(String nombre){

        Producto retorno = null;

        for(Producto producto : productos){
            if (producto.getNombreProducto().equalsIgnoreCase(nombre)){
                retorno = producto;
            }
        }

        return retorno;

    }

    public boolean actualizarProducto(int id, double nuevoPrecio, int nuevoStock) {
        Producto actualizar = buscarProductoPorId(id);
        if (actualizar != null) {
            actualizar.setPrecioProducto(nuevoPrecio);
            actualizar.setStockProducto(nuevoStock);
            return true;
        }
        return false;
    }

    public boolean eliminarProducto(int id){

        return productos.remove(buscarProductoPorId(id));

    }


}
