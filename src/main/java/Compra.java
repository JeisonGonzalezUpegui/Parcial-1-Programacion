import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {

    private String codigo;
    private LocalDate fecha;
    private double valorTotal;
    private MetodoPago metodoPago;
    private Cliente cliente;
    private ArrayList<Producto> listaProductos;
    private boolean confirmada;

    public Compra(String codigo, LocalDate fecha, MetodoPago metodoPago, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
        this.valorTotal = 0;
        this.confirmada = false;
        //Inicializar la lista
        this.listaProductos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public MetodoPago getMetadoPago() {
        return metodoPago;
    }

    public void setMetadoPago(MetodoPago metadoPago) {
        this.metodoPago = metadoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", valorTotal=" + valorTotal +
                ", metadoPago=" + metodoPago +
                ", cliente=" + cliente +
                ", listaProductos=" + listaProductos +
                ", confirmada=" + confirmada +
                '}';
    }
}


