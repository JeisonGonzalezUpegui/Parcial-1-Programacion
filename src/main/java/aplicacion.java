import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;

public class aplicacion {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);

//menu

Supermercado supermercado= new Supermercado("MarketPlus","carrera 67, manzana 67","676767");

int opcion;
do{
    System.out.println("=====Menú Super Mercado=====");

    System.out.println("---Cliente---");
    System.out.println("1. Agregar cliente");
    System.out.println("2. Buscar cliente");

    System.out.println("---Producto---");
    System.out.println("3. Agregar producto");

    System.out.println("---Compra---");
    System.out.println("4. Registrar Compra");
    System.out.println("5. Consultar compras de un cliente");

    System.out.println("---Consulta---");
    System.out.println("6. Enseñar valor total vendido por dia");

    System.out.println("0. Salir");

    System.out.println("Seleccione la opcion: ");
    opcion=sc.nextInt();
    sc.nextLine();

    switch(opcion) {

        case 1:
            System.out.println("---Agregar Cliente---");

            System.out.println("Nombre del Cliente: ");
            String nombre = sc.nextLine();

            System.out.println("Documento de Identidad: ");
            String documentoIdentidad = sc.nextLine();

            System.out.println("Telefono: ");
            String telefono = sc.nextLine();

            System.out.println("Correo electronico: ");
            String correoElectronico = sc.nextLine();

            Cliente cliente = new Cliente(nombre, documentoIdentidad, telefono, correoElectronico);

            if (supermercado.agregarCliente(cliente)) {
                System.out.println("El cliente fue agregado exitosamente");
            } else {
                System.out.println("El cliente ya existe");
            }
            break;

        case 2:
            System.out.println("---Buscar Cliente---");

            System.out.println("Docuemnto de identidad del cliente: ");
            String documentoBusca=sc.nextLine();

            Cliente clienteBuscado = supermercado.buscarCliente(documentoBusca);

            if (clienteBuscado != null) {
                System.out.println(clienteBuscado);
            } else {
                System.out.println("El cliente no existe");
            }
            break;
        case 3:
            System.out.println("---Agregar Producto---");

            System.out.println("Codigo del producto: ");
            String codigoProducto = sc.nextLine();

            System.out.println("Nombre del producto: ");
            String nombreProducto = sc.nextLine();

            System.out.println("Categoria: 1. Alimentos 2. Bebidas 3. Productos de aseo 4. Cuidado personal");
            int opcionCategoria = sc.nextInt();
            sc.nextLine();

            CategoriaProducto categoriaProducto = null;
            if (opcionCategoria == 1) {
                categoriaProducto = CategoriaProducto.ALIMENTOS;
            } else if (opcionCategoria == 2) {
                categoriaProducto = CategoriaProducto.BEBIDAS;
            } else if (opcionCategoria == 3) {
                categoriaProducto = CategoriaProducto.PRODUCTOS_DE_ASEO;
            } else if (opcionCategoria == 4) {
                categoriaProducto = CategoriaProducto.CUIDADO_PERSONAL;
            }

            if (categoriaProducto == null) {
                System.out.println("Categoria invalida");
                break;
            }

            System.out.println("Precio unitario: ");
            double precioProducto = sc.nextDouble();
            sc.nextLine();

            System.out.println("Cantidad disponible: ");
            int cantidadProducto = sc.nextInt();
            sc.nextLine();

            Producto producto = new Producto(codigoProducto, nombreProducto, precioProducto, cantidadProducto, categoriaProducto);

            if (supermercado.agregarProducto(producto)) {
                System.out.println("El producto fue agregado exitosamente");
            } else {
                System.out.println("El producto ya existe");
            }
            break;

        case 4:
            System.out.println("---Registrar Compra---");

            System.out.println("Documento de identidad del cliente: ");
            String documentoCompra = sc.nextLine();

            Cliente clienteCompra = supermercado.buscarCliente(documentoCompra);
            if (clienteCompra == null) {
                System.out.println("El cliente no existe");
                break;
            }

            System.out.println("Codigo de la compra: ");
            String codigoCompra = sc.nextLine();

            if (supermercado.verificarCompra(codigoCompra)) {
                System.out.println("Ya existe una compra con ese codigo");
                break;
            }

            System.out.println("Año de la compra: ");
            int añoCompra = sc.nextInt();
            sc.nextLine();

            System.out.println("Mes de la compra (1-12): ");
            int mesCompra = sc.nextInt();
            sc.nextLine();

            System.out.println("Dia de la compra (1-31): ");
            int diaCompra = sc.nextInt();
            sc.nextLine();

            if (mesCompra < 1 || mesCompra > 12 || diaCompra < 1 || diaCompra > 31) {
                System.out.println("Fecha invalida");
                break;
            }

            LocalDate fechaCompra = LocalDate.of(añoCompra, mesCompra, diaCompra);

            System.out.println("Metodo de pago: 1. Tarjeta 2. Transferencia bancaria 3. Efectivo");
            int opcionPago = sc.nextInt();
            sc.nextLine();

            MetodoPago metodoPago = null;
            if (opcionPago == 1) {
                metodoPago = MetodoPago.TARJETA;
            } else if (opcionPago == 2) {
                metodoPago = MetodoPago.TRANSFERENCIABANCARIA;
            } else if (opcionPago == 3) {
                metodoPago = MetodoPago.EFECTIVO;
            }

            if (metodoPago == null) {
                System.out.println("Metodo de pago invalido");
                break;
            }

            Compra compra = new Compra(codigoCompra, fechaCompra, metodoPago, clienteCompra);

            String codigoAgregar;
            do {
                System.out.println("Codigo del producto a agregar (0 para terminar): ");
                codigoAgregar = sc.nextLine();

                if (codigoAgregar.equals("0") == false) {
                    Producto productoCompra = supermercado.buscarProducto(codigoAgregar);

                    if (productoCompra == null) {
                        System.out.println("El producto no existe");
                    } else {
                        if (supermercado.agregarProductoCompra(compra, productoCompra)) {
                            System.out.println("Producto agregado. Total actual: " + compra.getValorTotal());
                        } else {
                            System.out.println("No hay disponibilidad de ese producto");
                        }
                    }
                }
            } while (codigoAgregar.equals("0") == false);

            if (supermercado.confirmarCompra(compra)) {
                supermercado.agregarCompra(compra);
                System.out.println("Compra registrada. Valor total: " + compra.getValorTotal());
            } else {
                System.out.println("La compra no tiene productos, no fue registrada");
            }
            break;

        case 5:
            System.out.println("---Compras de un Cliente---");

            System.out.println("Documento de identidad del cliente: ");
            String documentoConsulta = sc.nextLine();

            if (supermercado.verificarCliente(documentoConsulta)) {
                List<Compra> comprasCliente = supermercado.obtenerComprasCliente(documentoConsulta);

        //verifica si la lsiat esta vacia o no
                if (comprasCliente.isEmpty()) {
                    System.out.println("El cliente no ha realizado compras");
                } else {
                    for (Compra compraCliente : comprasCliente) {
                        System.out.println(compraCliente);
                    }
                }
            } else {
                System.out.println("El cliente no existe");
            }
            break;

        case 6:
            System.out.println("---Valor total vendido por dia---");

            System.out.println("Año: ");
            int añoConsulta = sc.nextInt();
            sc.nextLine();

            System.out.println("Mes (1-12): ");
            int mesConsulta = sc.nextInt();
            sc.nextLine();

            System.out.println("Dia (1-31): ");
            int diaConsulta = sc.nextInt();
            sc.nextLine();

            if (mesConsulta < 1 || mesConsulta > 12 || diaConsulta < 1 || diaConsulta > 31) {
                System.out.println("Fecha invalida");
                break;
            }

            LocalDate fechaConsulta = LocalDate.of(añoConsulta, mesConsulta, diaConsulta);
            double totalDia = supermercado.calcularTotalVendidoPorFecha(fechaConsulta);
            System.out.println("Total vendido el " + fechaConsulta + ": " + totalDia);
            break;

        case 0:
            System.out.println("Saliendo...");
            break;

        default:
            System.out.println("Opcion invalida");
    }
    }while(opcion!=0);

sc.close();
}
}
