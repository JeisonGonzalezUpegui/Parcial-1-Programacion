import java.time.LocalDate;

public class Compra {

    private String codigo;
    private LocalDate fecha;
    private double valorTotal;

    public Compra(String codigo, LocalDate fecha, double valorTotal) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
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

    @Override
    public String toString() {
        return "Compra{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
