import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Supermercado {
    //Atributos
    private String nombre;
    private String direccion;
    private String telefono;

    //creacion listas
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Compra> listaCompras;

    public Supermercado(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

        //inicializar las listas
        listaClientes = new ArrayList<>();
        listaProductos = new ArrayList<>();
        listaCompras = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
    //============Clientes============

    //verificar clientes
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

    // agregar cliente
    public boolean agregarCliente(Cliente cliente) {
        boolean agregado = false;
        boolean existe = verificarCliente(cliente.getDocumentoIdentidad());
        if (existe == false) {
            listaClientes.add(cliente);
            agregado = true;
        }
        return agregado;
    }

    //buscar cliente
    public Cliente buscarCliente(String documento) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumentoIdentidad().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }

    //============Productos============

    // verificar productos
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

    // agregar producto
    public boolean agregarProducto(Producto producto) {
        boolean agregado = false;
        boolean existe = verificarProducto(producto.getCodigo());
        if (existe == false) {
            listaProductos.add(producto);
            agregado = true;
        }
        return agregado;
    }

    //buscar producto
    public Producto buscarProducto(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    //============Compras============

    //verificar compras
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

    //agregar compra (guardarla en el supermercado)
    public boolean agregarCompra(Compra compra) {
        boolean agregado = false;
        boolean existe = verificarCompra(compra.getCodigo());
        if (existe == false) {
            listaCompras.add(compra);
            agregado = true;
        }
        return agregado;
    }

    // buscar compra
    public Compra buscarCompra(String codigo) {
        for (Compra compra : listaCompras) {
            if (compra.getCodigo().equals(codigo)) {
                return compra;
            }
        }
        return null;
    }

    //contar cuantas unidades de un producto ya estan en una compra
    public int contarProducto(Compra compra, String codigoProducto) {
        int cantidad = 0;
        for (Producto producto : compra.getListaProductos()) {
            if (producto.getCodigo().equals(codigoProducto)) {
                cantidad = cantidad + 1;
            }
        }
        return cantidad;
    }

    //verificar que haya disponibilidad del producto
    public boolean verificarDisponibilidad(Compra compra, Producto producto) {
        boolean disponible = false;
        int seleccionadas = contarProducto(compra, producto.getCodigo());
        if (producto.getCantidadDisponible() > seleccionadas) {
            disponible = true;
        }
        return disponible;
    }

    //calcular el valor total de una compra
    public double calcularValorTotal(Compra compra) {
        double total = 0;
        for (Producto producto : compra.getListaProductos()) {
            total = total + producto.getPrecio();
        }
        compra.setValorTotal(total);
        return total;
    }
    //agregar un producto a una compra
    public boolean agregarProductoCompra(Compra compra, Producto producto) {
        boolean agregado = false;
        boolean disponible = verificarDisponibilidad(compra, producto);
        if (compra.isConfirmada() == false && disponible) {
            compra.getListaProductos().add(producto);
            calcularValorTotal(compra);
            agregado = true;
        }
        return agregado;
    }
    //confirmar compra (actualiza el inventario)
    public boolean confirmarCompra(Compra compra) {
        boolean confirmada = false;
        if (compra.isConfirmada() == false && compra.getListaProductos().isEmpty() == false) {
            for (Producto producto : compra.getListaProductos()) {
                producto.setCantidadDisponible(producto.getCantidadDisponible() - 1);
            }
            compra.setConfirmada(true);
            confirmada = true;
        }
        return confirmada;
    }
    //obtener las compras de un cliente
    public List<Compra> obtenerComprasCliente(String documento) {
        List<Compra> comprasCliente = new ArrayList<>();
        for (Compra compra : listaCompras) {
            if (compra.getCliente().getDocumentoIdentidad().equals(documento)) {
                comprasCliente.add(compra);
            }
        }
        return comprasCliente;
    }
    //calcular el total vendido en una fecha
    public double calcularTotalVendidoPorFecha(LocalDate fecha) {
        double total = 0;
        for (Compra compra : listaCompras) {
            if (compra.getFecha().equals(fecha)) {
                total = total + compra.getValorTotal();
            }
        }
        return total;
    }
}


