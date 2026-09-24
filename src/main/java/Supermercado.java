import java.util.ArrayList;

public class Supermercado {
    //Atributos
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Compra> listaCompras:

    public Supermercado(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaClientes = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
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

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(ArrayList<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }


    //Metodos
    public boolean verificarCliente(String documentoIdentidad) {
        boolean existe = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumentoIdentidad().equals(documentoIdentidad)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean agregado = false;
        boolean existe = verificarCliente(cliente.getDocumentoIdentidad());
        if (existe == false) {
            listaClientes.add(cliente);
            agregado = true;
        }
        return agregado;
    }

    public boolean verificarProducto(String codigo) {
        boolean existe = false;
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    public boolean agregarProducto(Producto producto) {
        boolean agregado = false;
        boolean existe = verificarProducto(producto.getCodigo());
        if (existe == false) {
            listaProductos.add(producto);
            agregado = true;
        }
        return agregado;
    }
    public boolean verificarCompra(String codigo) {
        boolean existe = false;
        for (Compra compra : listaCompras) {
            if (compra.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    public boolean agregarCompra(Compra compra) {
        boolean agregado = false;
        boolean existe = verificarCompra(compra.getCodigo());
        if (existe == false) {
            listaCompras.add(compra);
            agregado = true;
        }
        return agregado;
    }
    public Cliente buscarCliente(String documento) {
        for (Cliente c : listaClientes) {
            if (c.getDocumentoIdentidad().equals(documento)) {
                return c;
            }
        }
        return null;
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
    public Compra buscarCompra(String codigo) {
        for (Compra c : listaCompras) {
            if (c.getCodigo().equals(codigo)) {
                return c;
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