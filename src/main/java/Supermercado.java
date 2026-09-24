import java.util.ArrayList;

public class Supermercado {
    //Atributos
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;

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

