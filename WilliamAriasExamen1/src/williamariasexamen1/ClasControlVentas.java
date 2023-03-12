
package williamariasexamen1;
import java.util.Scanner;


public class ClasControlVentas {
    
    static Scanner sc = new Scanner(System.in);
    static double[] Nfactura = new double[10];
    static boolean Nfacturarepetida = false;
    static boolean Nfacturavalida = false;
    static String[] CedulaCliente = new String[10];
    static boolean cedulaValida = false;
    static boolean cedulaRepetida = false;
    static String[] NombreCliente = new String[10];
    static double precioEntrada1=10500;
    static double precioEntrada2=20500;
    static double precioEntrada3=25500;
    static double Subtotal = 0;
    static double CargoServi = 0;
    static double Total =0;
    static int numclientes = 1;
    static int entradasvendidas = 0;
    static int[] contadorentradasL1 = new int[10]; //todo esto se puede resumir con matrices, pero para no enredarme, luego vuelvo hacer el examen para probar.
    static int[] AcumuladorVentasL1 = new int[10];
    static int[] contadorentradasL2 = new int[10];
    static int[] AcumuladorVentasL2 = new int[10];
    static int[] contadorentradasL3 = new int[10];
    static int[] AcumuladorVentasL3 = new int[10];
    static String[] NombreLocalidad1 = new String[10];
    static String[] NombreLocalidad2 = new String[10];
    static String[] NombreLocalidad3 = new String[10];
    static String[] NombreLocalidades = {"", "Sol Norte/Sur", "Sol Este/Oeste", "Sombra Este/Oeste"};
    static String cedula = "0";
    static String nombre = "0";
    static int factura = 0;
   static void IncluirCliente() {
       
        if (numclientes >= 10) {
            System.out.println("No se pueden incluir mas de 10 clientes.");
            return;
        }
        
        do {
            System.out.print("Ingrese el numero de factura: ");
            factura = sc.nextInt();
            Nfacturarepetida = false;
            Nfacturavalida = false;

        for (int i = 0; i < numclientes; i++) { 
            if (Nfactura[i] != 0 && Nfactura[i] == factura) {
                Nfacturarepetida = true;
                System.out.println("El numero de factura ya existe.");
                break;
        }
    }
    
    if (!Nfacturarepetida) {
        Nfacturavalida = true;
    }
    
} while (!Nfacturavalida);
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        do {
            System.out.print("\nIngrese su cedula: ");
            cedula = sc.next();
            cedulaRepetida = false;
            cedulaValida = false; // reiniciar la variable a false.

            for (int i = 0; i < numclientes; i++) { 
            if (CedulaCliente[i] != null && CedulaCliente[i].equals(cedula)) {
            cedulaRepetida = true;
            System.out.println("La cedula ya existe ");
            break;
             }
            }           
                if  (!cedula.matches("[0-9]+")) { //"!cedula.matches" verifica si la variable cedula contiene solo números.
            System.out.println("La cedula no debe contener espacios ni letras\n");
                } else if (!cedulaRepetida) {
                cedulaValida = true;
                }
        } while (!cedulaValida);
        
        System.out.print("Ingrese su nombre: ");
        nombre = sc.next();
        Nfactura[numclientes] = factura;
        CedulaCliente[numclientes] = cedula;
        NombreCliente[numclientes] = nombre;
        numclientes++;
        System.out.println("\n El Cliente " + nombre +" Se ha agregado correctamente.\n");
        Menucompraentrada();
    }
    static void Localidad1() {
        System.out.println("Has ingresado a Entradas Localidad 1 (Sol Norte/Sur).");
        System.out.println("Tienen un valor de 10500 colones.");
        System.out.print("Cuantas Entradas desea comprar: ");
        entradasvendidas = sc.nextInt();
        int posicion = numclientes - 1; //es necesario para que guarde la informacion asociada a cada cliente.
                                        //lleva el control del número de clientes que han sido registrados en el sistema.
        while (entradasvendidas > 4) { 
            System.out.println("No se pueden comprar mas de 4 entradas por cliente..");
            System.out.print("Cuantas Entradas desea comprar: ");
            entradasvendidas = sc.nextInt();
        }
        if (entradasvendidas + contadorentradasL1[posicion] + contadorentradasL2[posicion] + contadorentradasL3[posicion] > 4) {
            //el if se usa para verificar que no se compren mas de 4 entradas por cliente.
            System.out.println("No se pueden comprar mas de 4 entradas por cliente.");
            return;
        }

        NombreLocalidad1[posicion] = NombreLocalidades[1];
        contadorentradasL1[posicion] += entradasvendidas;
        AcumuladorVentasL1[posicion] += entradasvendidas * precioEntrada1;

        System.out.println("\n Se han vendido "+entradasvendidas+" entradas en Localidad 1 a "+NombreCliente[posicion]+".");
        System.out.println("Total Vendido: "+AcumuladorVentasL1[posicion]+" colones.\n");
}
    static void Localidad2() {
        
        System.out.println("Has ingresado a Entradas Localidad 2 (Sol Norte/Sur).");
        System.out.println("Tienen un valor de 20500 colones.");
        System.out.print("Cuantas Entradas desea comprar: ");
        entradasvendidas = sc.nextInt();
        int posicion = numclientes - 1; // índice del nuevo cliente
        while (entradasvendidas > 4) {
            System.out.println("No se pueden comprar mas de 4 entradas.");
            System.out.print("Cuantas Entradas desea comprar: ");
            entradasvendidas = sc.nextInt();
        }
        if (entradasvendidas + contadorentradasL1[posicion] + contadorentradasL2[posicion] + contadorentradasL3[posicion] > 4) {
            System.out.println("No se pueden comprar mas de 4 entradas por cliente.");
            return;
    }
        NombreLocalidad2[posicion] = NombreLocalidades[2];
       contadorentradasL2[posicion] += entradasvendidas;
       AcumuladorVentasL2[posicion] += entradasvendidas * precioEntrada2;

       System.out.println("\n Se han vendido "+entradasvendidas+" entradas en Localidad 2 a "+NombreCliente[posicion]+".");
       System.out.println("Total Vendido: "+AcumuladorVentasL2[posicion]+" colones.\n");
}
    
    static void Localidad3() {
        System.out.println("Has ingresado a Entradas Localidad 3 (Preferencial).");
        System.out.println("Tienen un valor de 25500 colones.");
        System.out.print("Cuantas Entradas desea comprar: ");
        entradasvendidas = sc.nextInt();
        while (entradasvendidas > 4) {
            System.out.println("No se pueden comprar mas de 4 entradas por cliente.");
            System.out.print("Cuantas Entradas desea comprar: ");
            entradasvendidas = sc.nextInt();
        }
        if (entradasvendidas + contadorentradasL3[numclientes-1] > 4) {
            System.out.println("No se pueden comprar mas de 4 entradas por cliente.");
            return;
        }

       int posicion = numclientes-1; 

        NombreLocalidad3[posicion] = NombreLocalidades[3];
        contadorentradasL3[posicion] += entradasvendidas;
        AcumuladorVentasL3[posicion] += entradasvendidas * precioEntrada3;
        System.out.println("\n Se han vendido "+entradasvendidas+" entradas en Localidad 3 a "+NombreCliente[posicion]+".");
        System.out.println("Total Vendido: "+AcumuladorVentasL3[posicion]+" colones.\n");
}
    
    static void Estadistica() {
        if (numclientes > 0) {
            for (int i = 0; i < numclientes; i++) {
                System.out.println("Numero de Factura: " + Nfactura[i]);
                System.out.println("Cedula del cliente: " + CedulaCliente[i]);
                System.out.println("Nombre del comprador: " + NombreCliente[i]);
                System.out.println("Localidad : " +NombreLocalidad1[i] );
                System.out.println("Cantidad de entradas vendidas: " + contadorentradasL1[i]);
                System.out.println("Localidad : " +NombreLocalidad2[i] );
                System.out.println("Cantidad de entradas vendidas: " + contadorentradasL2[i]);
                System.out.println("Localidad : " +NombreLocalidad3[i] );
                System.out.println("Cantidad de entradas vendidas: " + contadorentradasL3[i]);
                System.out.println("Subtotal): " +(Subtotal=AcumuladorVentasL1[i]+AcumuladorVentasL2[i]+AcumuladorVentasL3[i]));
                System.out.println("Cargos por servicio): " + (CargoServi = contadorentradasL1[i]*1000 +contadorentradasL2[i]*1000+contadorentradasL3[i]*1000));
                System.out.println("Total: " + (Total=Subtotal+CargoServi)) ;
                System.out.println("----------------------------------------\n");
            }
        } else {
            System.out.println("\n\033[1mNo hay clientes registrados.\033[0m");
        }
    }
    
    static void Menucompraentrada() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        while (opcion != 4) {
            System.out.println("\n-------Submenu Venta de Entradas-------\n");
            System.out.println("1. Entradas Localidad 1 (Sol Norte/Sur).");
            System.out.println("2. Entradas Localidad 2 (Sombra Este/Oeste).");
            System.out.println("3. Entradas Localidad 3 (Preferencial).");
            System.out.println("4. Regresar Menu Principal.");
            System.out.print("Seleccione una opcion:");
            String input = sc.nextLine();
            
        while (!input.matches("[1-4]") || !Character.isDigit(input.charAt(0))) { // valida la entrada para que sea un número del 1 al 3.
               System.out.println("\nLa opcion: \"" + input + "\" es invalida.");
               System.out.print("Seleccione una opcion valida del menu (numero): ");
                input = sc.nextLine();
            }

        opcion = Integer.parseInt(input);
        
        switch (opcion) {
                     
            case 1:
                Localidad1();
                break;
            case 2:
               Localidad2();
                break;
            case 3:
               Localidad3();
                break;
            case 4:
                System.out.println("Regresando al menu principal...");
                return;
            }
        }
                sc.close();      
    }

    static void InicializarVec() {
        for (int i = 0; i < 10; i++) {
            CedulaCliente[i] = "";
            NombreCliente[i] = "";
            Nfactura [i] = 0.0;
            Subtotal = 0.0;
            CargoServi= 0.0;
            Total = 0.0;
            }
            numclientes = 0;
            System.out.println("\n Vectores inicializados correctamente.\n"); 
    }
    
static void Reportetodosdatos(){
        for (int i = 0; i < Nfactura.length; i++) { // imprime los datos de los clientes que unicamente compraron.
            if (Nfactura[i] != 0) { 
            System.out.println("Cantidad Entradas Localidad 1 (Sol Norte/Sur): " + contadorentradasL1[i]); 
            System.out.println("Acumulado Dinero Localidad 1 (Sol Norte/Sur): " + AcumuladorVentasL1[i] ); 
            System.out.println("Cantidad Entradas Localidad 2 (Sombra Este/Oeste): " + contadorentradasL2[i]);
            System.out.println("Acumulado Dinero Localidad 2 (Sombra Este/Oeste): " + AcumuladorVentasL2[i] );
            System.out.println("Cantidad Entradas Localidad Preferencial 3: " + contadorentradasL3[i]);
            System.out.println("Acumulado Dinero Localidad Preferencial 3: " + AcumuladorVentasL3[i] );
            }
        }
    }     
 }           