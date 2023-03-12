
package williamariasexamen1;

import java.util.Scanner;

public class ClassMenuPrin {
    
    static Scanner sc = new Scanner(System.in);
    static int opcion = 0;
    
    public void Menuprin() {
        
        while (opcion != 4) {
            System.out.println("------- Federacion Costarricense de Futbol-------\n");
            System.out.println("1. Ingresar datos.");
            System.out.println("2. Inicializar arreglo");
            System.out.println("3. Estadisticas.");
            System.out.println("4. Salir.");
            System.out.print("Seleccione una opcion: ");
            String input = sc.nextLine();
            
            while (!input.matches("[1-4]") || !Character.isDigit(input.charAt(0))) { // valida la entrada para que sea un número del 1 al 3.
               System.out.println("\nLa opcion: \"" + input + "\" es invalida.");
               System.out.print("Seleccione una opcion valida del menu (numero): ");
                input = sc.nextLine();                                                      
            } 

            opcion = Integer.parseInt(input); 

            switch (opcion) {
                case 1:
                    ClasControlVentas. IncluirCliente();
                    break;
                case 2:
                    ClasControlVentas.InicializarVec();
                    break;
                case 3:
                    ClasControlVentas.Estadistica();
                    break;
                case 4:
                    ClasControlVentas.Reportetodosdatos();
                    break;
                }
        }
            sc.close();
    }
}  


