
/**
 * Write a description of class MenuInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.time.*;
import java.time.format.*;

public class MenuInterface
{
  Scanner input = new Scanner(System.in);
   ParqueManager manager;
   
   public MenuInterface(ParqueManager manager)
   {
       this.manager = manager;
   }
   
   public void menu1()
    {
        System.out.println("-- Menu Principal --");
        System.out.println(
        "Seleccione una opcion: \n" +
        "  1) Menu Entradas\n" +
        "  2) Menu Atracciones\n" +
        "  3) Menu Trabajadores \n" +
        "  4) Menu Estadisticas\n" +
        "  5) Salir\n "
        );
         
        int selection = this.input.nextInt();
        input.nextLine();
        
        switch (selection) {
        case 1:
          System.out.println("==========================");
          this.menuEntradas();
          break;
        case 2:
          //this.jump();
          break;
        case 3:
          //this.dodge();
          break;
        case 4:
          //this.exit();
          break;
        case 5:
            System.exit(1);
        default:
          System.out.println("Invalid selection.");
          break;
        }
    }
    
    private void menuEntradas()
    {
        System.out.println("-- Menu Entradas --");
        System.out.println(
        "Seleccione una opcion: \n" +
        "  1) Nueva Entrada Individual\n" +
        "  2) Importar Entradas desde Archivo\n" +
        "  3) Resumen Entradas \n" +
        "  4) Salir\n "
        );
        
        int selection = this.input.nextInt();
        input.nextLine();
        
        switch (selection) {
        case 1:
          System.out.println("==========================");
          this.menuNuevaEntrada();
          break;
        case 2:
          //this.jump();
          break;
        case 3:
          //this.dodge();
          break;
        case 4:
            this.menu1();
        default:
          System.out.println("Invalid selection.");
          break;
        }
    }
    
    private void menuNuevaEntrada()
    {
        System.out.println("-- Nueva Entrada --");
        System.out.println(
        "Seleccione una opcion: \n" +
        "  1) Nueva Entrada Adulto\n" +
        "  2) Nueva Entrada Niño\n" +
        "  4) Salir\n "
        );
        
        int selection = this.input.nextInt();
        input.nextLine();
        
        switch (selection) {
        case 1:
          System.out.println("==========================");
          this.menuNuevaEntradaGeneral();
          break;
        case 2:
          //this.jump();
          break;
        case 3:
          //this.dodge();
          break;
        case 4:
            this.menu1();
        default:
          System.out.println("Invalid selection.");
          break;
        }
    }
    
    private void menuNuevaEntradaGeneral()
    {
        System.out.println("-- Nueva Entrada Adulto General --");
        
        System.out.print("Fecha de compra (dd/MM/uuuu):");
        String fechaIn = input.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern ( "dd/MM/uuuu" );
        try {
            LocalDate fecha = LocalDate.parse ( fechaIn , formato );
            //System.out.println ( "ld: " + fecha );
        } catch ( DateTimeParseException e ) {
            System.out.println ( "Fecha Invalida");
        }
        
        System.out.print("Edad (debe ser mayor de 12 años):");
        int edad = input.nextInt();
        while (edad < 13)
        {
            System.out.println("Edad invalida");
            System.out.print("Edad (debe ser mayor de 12 años):");
            edad = input.nextInt();
        }
        input.nextLine();
        
        System.out.print("Entrada VIP? (Y/N):");
        String VIPStr = input.nextLine();
        while (!VIPStr.equals("Y") && !VIPStr.equals("N"))
        {
            System.out.println("Decision invalida");
            System.out.print("Entrada VIP? (Y/N):");
            VIPStr = input.nextLine();
        }
        if (VIPStr.equals("Y")) {boolean vip = true;}
        else {boolean vip = false;}
        
        System.out.print("Entrada Familiar? (Y/N):");
        String familiarStr = input.nextLine();
        while (!familiarStr.equals("Y") && !familiarStr.equals("N"))
        {
            System.out.println("Decision invalida");
            System.out.print("Entrada Familiar? (Y/N)::");
            familiarStr = input.nextLine();
        }
        if (familiarStr.equals("Y")) {boolean vip = true;}
        else {boolean vip = false;}
        System.out.println();
        
        System.out.print("Descuentos Disponibles:\n");
        manager.imprimirDescuentos();
        System.out.print("Desea Añadir algun Descuento? (Y/N):");
        String addDescuento = input.nextLine();
        while (!addDescuento.equals("Y") && !addDescuento.equals("N"))
        {
            System.out.println("Decision invalida");
            System.out.print("Desea Añadir algun Descuento? (Y/N):");
            addDescuento = input.nextLine();
        }
        while (addDescuento.equals("Y"))
        {
            //pedir descuento, buscarlos en buscador descuentos etc....
            addDescuento = input.nextLine();
        }
        
        
        
        System.exit(1);
    }
}
