
import java.util.ArrayList;

public class Supermercado {
    //Atributos
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;

    public Supermercado(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    //Métodos de búsqueda
    public Cliente buscarCliente(String documento) {
        for (Cliente c : clientes) {
            if (c.getDocumentoIdentidad().equals(documento)) {
                return c;
            }
        }
        return null;
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}