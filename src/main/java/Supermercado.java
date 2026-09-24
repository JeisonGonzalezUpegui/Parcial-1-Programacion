public class Supermercado {

}
//Metodos
public boolean agregarCliente(Cliente cliente){
    boolean agregado=false;
    boolean existe=verificarCliente(cliente.getDocumentoIdentidad());
    if(existe==false){
        listaClientes.add(cliente);
        agregado= true;
    }
    return agregado;
}
public boolean agregarProducto(Producto producto){
    boolean agregado=false;
    boolean existe=verficarProducto(producto.getCodigo());
    if(existe==false){
        listaProductos.add(producto);
        agregado=true;
    }
    return agregado;
}
