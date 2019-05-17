
/**
 * Write a description of class MenuInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.time.*;
import java.time.format.*;
import java.util.HashMap;


public class MenuInterface
{
  Scanner input = new Scanner(System.in);
  ParqueManager manager;
  AnalizadorEstadisticas analizador;
   
   public MenuInterface(ParqueManager manager)
   {
       this.manager = manager;
       analizador = manager.analisisEstadistico();
   }
   
   public void menu1()
    {
        System.out.println();
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
        System.out.println();
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
          GeneradorVisitantes.generarVisitantes(manager);
          this.menuEntradas();
          break;
        case 3:
          resumenVisitantes();
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
        System.out.println();
        System.out.println("-- Nueva Entrada --");
        System.out.println(
        "Seleccione una opcion: \n" +
        "  1) Nueva Entrada Adulto\n" +
        "  2) Nueva Entrada Niño\n" +
        "  3) Salir\n "
        );
        
        int selection = this.input.nextInt();
        input.nextLine();
        
        switch (selection) {
        case 1:
          System.out.println("==========================");
          this.menuNuevaEntradaGeneral(false);
          break;
        case 2:
          this.menuNuevaEntradaGeneral(true);
          break;
        case 3:
          this.menu1();
          break;
        default:
          System.out.println("Invalid selection.");
          break;
        }
    }
    
    private void menuNuevaEntradaGeneral(boolean nino)
    {
        try {
        if(!nino) {System.out.println("-- Nueva Entrada General --");}
        else {System.out.println("-- Nueva Entrada Niño --");}        
        
        System.out.print("Fecha de compra (dd/MM/uuuu):");
        String fechaIn = input.nextLine();
        LocalDate fecha;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern ( "dd/MM/uuuu" );    
        fecha = LocalDate.parse ( fechaIn , formato );
        //System.out.println ( "ld: " + fecha );
               
        System.out.print("Edad: ");
        int edad = input.nextInt();
        if (!nino)
        {
            while (edad < 13)
            {
                System.out.println("Edad invalida");
                System.out.print("Edad (debe ser mayor de 12 años):");
                edad = input.nextInt();
            }
        }
        else
        {
            while (edad < 0 || edad > 12)
            {
                System.out.println("Edad invalida");
                System.out.print("Edad (debe ser menor de 13 años):");
                edad = input.nextInt();
            }
        }
        input.nextLine();
        
        System.out.print("Entrada VIP? (Y/N):");
        String VIPStr = input.nextLine();
        boolean vip;
        while (!VIPStr.equals("Y") && !VIPStr.equals("N"))
        {
            System.out.println("Decision invalida");
            System.out.print("Entrada VIP? (Y/N):");
            VIPStr = input.nextLine();
        }
        if (VIPStr.equals("Y")) {vip = true;}
        else {vip = false;}
        
        System.out.print("Entrada Familiar? (Y/N):");
        String familiarStr = input.nextLine();
        boolean fam;
        while (!familiarStr.equals("Y") && !familiarStr.equals("N"))
        {
            System.out.println("Decision invalida");
            System.out.print("Entrada Familiar? (Y/N)::");
            familiarStr = input.nextLine();
        }
        if (familiarStr.equals("Y")) {fam = true;}
        else {fam = false;}
        System.out.println();
        
        System.out.print("Descuentos Disponibles:\n");
        HashMap<String, Float> descuentos = manager.obtenerDescuentos();
        for (String key : descuentos.keySet())
        {
            System.out.println(key + ": " + descuentos.get(key) + "%");
        }
        System.out.println();
        System.out.print("Desea Añadir algun Descuento? (Y/N):");
        String addDescuento = input.nextLine();
        while (!addDescuento.equals("Y") && !addDescuento.equals("N"))
        {
            System.out.println("Decision invalida");
            System.out.println();
            System.out.print("Desea Añadir algun Descuento? (Y/N):");
            addDescuento = input.nextLine();
        }
        String descuentoStr = "";
        if (addDescuento.equals("N"))
        {
            descuentoStr = "ninguno";
        }
        else
        {
             while (addDescuento.equals("Y"))
             {
                System.out.print("Introducir nombre del descuento: ");
                String descuentoIn = input.nextLine();
                if (descuentos.containsKey(descuentoIn))
                {
                    descuentoIn += ";";
                    descuentoStr += descuentoIn;
                    System.out.println(descuentoStr);
                }
                else
                {
                    System.out.println("Descuento no existe");
                }
                System.out.println();
                System.out.print("Desea Añadir algun Descuento? (Y/N):");
                addDescuento = input.nextLine();
             }
        }
       
        
        //Imprimir Resumen
        System.out.println("Resumen de la Entrada:");
        System.out.println("\tFecha: " + fecha);
        System.out.println("\tEdad: " + edad);
        if (vip)
        {System.out.println("\tVIP: SI");}
        else
        {System.out.println("\tVIP: NO");}
        
        if (fam)
        {System.out.println("\tFamiliar: SI");}
        else
        {System.out.println("\tFamiliar: NO");}
        
        System.out.print("\t");
        String tmp[] = descuentoStr.split(";");
        for (int i = 0; i < tmp.length; i++)
        {
            System.out.print(tmp[i] + " - ");
        }
        System.out.println();
        
        System.out.println("Confirmar Entrada? (Y/N)");
        String confirmar = input.nextLine();
        while (!confirmar.equals("Y") && !confirmar.equals("N"))
        {
            System.out.println("Decision invalida");
            System.out.println();
            System.out.print("Confirmar Entrada? (Y/N):");
            addDescuento = input.nextLine();
        }
        if (confirmar.equals("Y"))
        {
            System.out.println();
            if (!nino) {manager.addEntrada(fecha, edad, vip, fam, descuentoStr);}
            else {manager.addEntradaNiño(fecha, edad, vip, fam, descuentoStr);}
            menuNuevaEntrada();
        }
        else
        {
            System.out.println("Entrada Cancelada");
            menuNuevaEntrada();
        }
        
        System.exit(1);
        } 
        catch ( DateTimeParseException e ) {
            System.out.println ( "Fecha Invalida");
            this.menuNuevaEntrada();
        }
    }
    
    private void resumenVisitantes()
    {
        System.out.println();
        System.out.println("-- Resumen Visitantes --");
        analizador.resumenVisitantesTipo();
        menuEntradas();
    }
}
