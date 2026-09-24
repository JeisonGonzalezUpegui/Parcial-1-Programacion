public class Supermercado {

    //Metodos
    public boolean verificarCliente(String documentoIdentidad) {
        boolean existe= false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumentoIdentidad().equals(documentoIdentidad)){
                existe=true;
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
    public boolean verificarProducto(String codigo){
        boolean existe=false;
        for(Producto producto: listaProductos){
            if(producto.getProducto().equals(codigo)){
                existe=true;
                break;
            }
        }
        return existe;
    }

    public boolean agregarProducto(Producto producto) {
        boolean agregado = false;
        boolean existe = verficarProducto(producto.getCodigo());
        if (existe == false) {
            listaProductos.add(producto);
            agregado = true;
        }
        return agregado;
    }
}
