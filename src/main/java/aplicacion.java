import java.util.Scanner;
import java.time.LocalDate;

public class aplicacion {
static void main() {
Scanner sc=new Scanner(System.in);

//menu

Supermercado supermercado= new Supermercado("D67","carrera 67, manzana 67","676767");

int opcion;
do{
    System.out.println("=====Menú Super Mercado=====");

    System.out.println("---Cliente---");
    System.out.println("1. Agregar cliente");
    System.out.println("2. Buscar cliente");

    System.out.println("---Compra---");
    System.out.println("3. Registrar Compra");

    System.out.println("---Consulta---");
    System.out.println("4. Enseñar valor total vendido por dia");

    System.out.println("0. Salir");

    System.out.println("Sellacion la opcion");
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
            String docuemntobusca=sc.nextLine();


    }
    }while(opcion!=0);

sc.close();
}
}
