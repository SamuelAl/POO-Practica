
/**
 * Clase que contiene toda la funcionalidad de
 * los menus que controlan el programa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.time.*;
import java.time.format.*;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;


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

   /**
    * Method menu1
    *
    * Menu Principal del programa
    *
    */
   public void menu1()
    {
        imprLineaBl();
        System.out.println("-- Menu Principal --");
        System.out.println(
        "Seleccione una opcion: \n" +
        "  1) Menu Entradas\n" +
        "  2) Menu Atracciones\n" +
        "  3) Menu Trabajadores \n" +
        "  4) Menu Estadisticas\n" +
        "  5) Salir\n "
        );

        int seleccion = this.input.nextInt();
        input.nextLine();

        switch (seleccion) {
        case 1:
          System.out.println("==========================");
          this.menuEntradas();
          break;
        case 2:
          System.out.println("==========================");
          this.menuAtracciones();
          break;
        case 3:
          System.out.println("==========================");
          menuTrabajadores();
          break;
        case 4:
          System.out.println("==========================");
          menuEstadisticas();
          break;
        case 5:
            System.exit(1);
        default:
          System.out.println("Entrada Invalida.");
          break;
        }
    }

    /////////////////MENUS ENTRADA

    /**
     * Method menuEntradas
     *
     * Menu principal para toda la funcionalidad
     * de las entradas
     *
     */
    private void menuEntradas()
    {
        imprLineaBl();
        System.out.println("-- Menu Entradas --");
        System.out.println(
        "Seleccione una opcion: \n" +
        "  1) Nueva Entrada Individual\n" +
        "  2) Importar Entradas desde Archivo\n" +
        "  3) Resumen Entradas \n" +
        "  4) Salir\n "
        );

        int seleccion = this.input.nextInt();
        input.nextLine();

        switch (seleccion) {
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
          System.out.println("Entrada Invalida.");
          break;
        }
    }


    /**
     * Method menuNuevaEntrada
     *
     * Menu para crear nueva entrada
     *
     */
    private void menuNuevaEntrada()
    {
        imprLineaBl();
        System.out.println("-- Nueva Entrada --");
        System.out.println(
        "Seleccione una opcion: \n" +
        "  1) Nueva Entrada Adulto\n" +
        "  2) Nueva Entrada Niño\n" +
        "  3) Salir\n "
        );

        int seleccion = this.input.nextInt();
        input.nextLine();

        switch (seleccion) {
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
          System.out.println("Entrada Invalida.");
          break;
        }
    }

    /**
     * Method menuNuevaEntradaGeneral
     *
     * Menu para configurar y crear una nueva entrada
     * General o de niño
     *
     * @param nino True si entrada es de niño
     */
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
        imprLineaBl();

        System.out.print("Descuentos Disponibles:\n");
        HashMap<String, Float> descuentos = manager.obtenerDescuentos();
        for (String key : descuentos.keySet())
        {
            System.out.println(key + ": " + descuentos.get(key) + "%");
        }
        imprLineaBl();
        System.out.print("Desea Añadir algun Descuento? (Y/N):");
        String addDescuento = input.nextLine();
        while (!addDescuento.equals("Y") && !addDescuento.equals("N"))
        {
            System.out.println("Decision invalida");
            imprLineaBl();
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
                imprLineaBl();
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
        imprLineaBl();

        System.out.println("Confirmar Entrada? (Y/N)");
        String confirmar = input.nextLine();
        while (!confirmar.equals("Y") && !confirmar.equals("N"))
        {
            System.out.println("Decision invalida");
            imprLineaBl();
            System.out.print("Confirmar Entrada? (Y/N):");
            addDescuento = input.nextLine();
        }
        if (confirmar.equals("Y"))
        {
            imprLineaBl();
            if (!nino) {manager.addEntrada(fecha, edad, vip, fam, descuentoStr);}
            else {manager.addEntradaNiño(fecha, edad, vip, fam, descuentoStr);}
            menuNuevaEntrada();
        }
        else
        {
            System.out.println("Entrada Cancelada");
            menuNuevaEntrada();
        }

        }
        catch ( DateTimeParseException e ) {
            System.out.println ( "Fecha Invalida");
            this.menuNuevaEntrada();
        }
    }

    /**
     * Method resumenVisitantes
     *
     * Opcion para mostrar resumen de visitantes
     * del parque
     *
     */
    private void resumenVisitantes()
    {
        imprLineaBl();
        System.out.println("-- Resumen Visitantes --");
        analizador.resumenVisitantesTipo();
        menuEntradas();
    }

    //////////// MENUS ATRACCIONES

    /**
     * Method menuAtracciones
     *
     * Menu principal para la funcionalidad de
     * de Atracciones
     *
     */
    private void menuAtracciones()
    {
      imprLineaBl();
      System.out.println("-- Menu Atracciones --");
      System.out.println(
      "Seleccione una opcion: \n" +
      "  1) Nueva Atraccion\n" +
      "  2) Generar Atracciones\n" +
      "  3) Activar/Desactivar Atracciones \n" +
      "  4) Generar Uso Aleatorio de Atracciones\n" +
      "  5) Resumen Atracciones\n" +
      "  6) Salir\n "
      );

      int seleccion = this.input.nextInt();
      input.nextLine();

      switch (seleccion) {
      case 1:
        imprLineaBl();
        this.menuNuevaAtraccion();
        break;
      case 2:
        generarAtracciones();
        break;
      case 3:
        menuAtraccionesActivas();
        break;
      case 4:
        usoAleatorioAtracciones();
        break;
      case 5:
        resumenAtracciones();
        break;
      case 6:
          menu1();
      default:
        System.out.println("Entrada Invalida.");
        break;
      }

    }

    /**
     * Method menuNuevaAtraccion
     *
     * Menu para crear una nueva atraccion
     *
     */
    private void menuNuevaAtraccion()
    {
      imprLineaBl();
      System.out.print("Introducir Tipo de Atraccion (A, B, C, D, E): ");
      String tipo = input.nextLine();
      while (!tipo.equals("A") &&
             !tipo.equals("B") &&
             !tipo.equals("C") &&
             !tipo.equals("D") &&
             !tipo.equals("E")
             )
      {
        System.out.println("Tipo Invalido");
        System.out.print("Introducir Tipo de Atraccion (A, B, C, D, E): ");
        tipo = input.nextLine();
      }
      manager.addAtraccion(tipo);
      System.out.println("Atraccion Añadida con exito");
      menuAtracciones();

    }

    /**
     * Method menuAtraccionesActivas
     *
     * Menu para administrar atracciones activas
     *
     */
    private void menuAtraccionesActivas()
    {
      imprLineaBl();
      System.out.println("-- Menu Atracciones --");
      System.out.println(
      "Seleccione una opcion: \n" +
      "  1) Nuevo Periodo de Atracciones Activas\n" +
      "  2) Generar Atracciones Activas\n" +
      "  3) Resumen Atracciones Activas\n" +
      "  4) Salir"
      );

      int seleccion = this.input.nextInt();
      input.nextLine();

      switch (seleccion) {
      case 1:
        imprLineaBl();
        this.menuNuevaAtraccionActiva();
        break;
      case 2:
        generarAtraccionesActivas();
        break;
      case 3:
        resumenAtraccionesActivas();
        menuAtracciones();
        break;
      case 4:
        menuAtracciones();
        break;

      default:
        System.out.println("Entrada Invalida.");
        break;
      }

    }


    /**
     * Method generarAtracciones
     *
     * Menu para generar atracciones del parque
     * segun el enunciado
     *
     */
    private void generarAtracciones()
    {
      GeneradorContenido.generadorContenido(manager);
      imprLineaBl();
      System.out.println("-- Lista de Atracciones --");
      analizador.resumenAtracciones();
      menuAtracciones();
    }

    /**
     * Method resumenAtracciones
     *
     * Opcion para mostrar resumen de las
     * atracciones presentes en el parque
     *
     */
    private void resumenAtracciones()
    {
      imprLineaBl();
      System.out.println("-- Lista de Atracciones --");
      analizador.resumenAtracciones();
      menuAtracciones();
    }

    /**
     * Method menuNuevaAtraccionActiva
     *
     * Menu para crear nuevos periodos de atracciones
     * activas
     *
     */
    private void menuNuevaAtraccionActiva()
    {
      imprLineaBl();
      System.out.println("-- Nuevo Periodo de Atracciones Activas --");
      imprLineaBl();
      System.out.println("Periodos Actuales:");
      resumenAtraccionesActivas();
      imprLineaBl();
      System.out.println("Creacion de Nuevo Periodo:");
      System.out.println("* Crea un nuevo periodo. Primero especifique las fechas del periodo\n" +
                         "* y despues escoja las atracciones que deben estar activas durante ese periodo\n" +
                         "* Para modificar un periodo existente, entre las mismas fechas\n" +
                         "* y cree una lista nueva. La lista nueva reemplazara la vieja");

      System.out.print("Fecha Inicial: ");
      String fechaInic = input.nextLine();
      LocalDate fechaInicial;
      DateTimeFormatter formato = DateTimeFormatter.ofPattern ( "dd/MM/uuuu" );
      fechaInicial = LocalDate.parse ( fechaInic , formato );

      System.out.print("Fecha Final: ");
      String fechaFin = input.nextLine();
      LocalDate fechaFinal;
      fechaFinal = LocalDate.parse ( fechaFin , formato );

      PeriodoTemporada periodo = new PeriodoTemporada(fechaInicial, fechaFinal);

      imprLineaBl();

      List<AtraccionIF> atraccionesDisponibles = manager.getAtracciones();
      List<AtraccionIF> atraccionesSeleccionadas = new LinkedList<AtraccionIF>();

      System.out.println("Atracciones Disponibles: ");
      int counter = 0;
      for (AtraccionIF atraccion : atraccionesDisponibles)
      {
        System.out.println("Atraccion #" + counter + " tipo " + atraccion.getTipo());
        counter++;
      }

      imprLineaBl();

      String confirmar;
      int atraccionIndex = 0;
      do
      {
        System.out.print("Desea Añadir una Atraccion? (Y/N): ");
        confirmar = input.nextLine();
      }
      while (!confirmar.equals("Y") && !confirmar.equals("N"));

      while(confirmar.equals("Y"))
      {
        System.out.print("Seleccione una Atraccion para añadir\n" +
                         "a la lista de atracciones activas en el periodo de tiempo especificado (numero): ");
        if (atraccionIndex > counter)
        {
          System.out.println("Entrada No Valida");
        }
        else
        {
          atraccionIndex = input.nextInt();
          atraccionesSeleccionadas.add(atraccionesDisponibles.get(atraccionIndex));
          System.out.println("Atracciones Seleccionadas:");
          for (AtraccionIF atraccion : atraccionesSeleccionadas)
          {
            System.out.print("Atraccion " + atraccionesSeleccionadas.indexOf(atraccion) + " tipo: " + atraccion.getTipo() + " - ");
          }

          do
          {
            System.out.println("Desea Añadir una Atraccion? (Y/N): ");
            confirmar = input.nextLine();
          }
          while (!confirmar.equals("Y") && !confirmar.equals("N"));
        }

      }
      manager.addAtraccionesFuncionando(periodo, atraccionesSeleccionadas);

      resumenAtraccionesActivas();
      menuAtracciones();

    }

    /**
     * Method resumenAtraccionesActivas
     *
     * Opcion para mostrar resumen de los
     * periodos de atracciones activas
     *
     */
    private void resumenAtraccionesActivas()
    {
      analizador.resumenAtraccionesActivas();
    }

    /**
     * Method generarAtraccionesActivas
     *
     * Menu para generar periodos de atracciones
     * activas automaticamente
     *
     */
    private void generarAtraccionesActivas()
    {
      manager.setContenidoAtraccionesFuncionando();
      menuAtraccionesActivas();
    }

    /**
     * Method usoAleatorioAtracciones
     *
     * Menu para generar uso aleatorio de
     * las atracciones
     *
     */
    private void usoAleatorioAtracciones()
    {
      manager.randomUsarAtracciones();
      imprLineaBl();
      System.out.println("Uso aleatorio de las atracciones generado");
      menuAtracciones();
    }

    ///////// MENUS TRABAJADORES

    /**
     * Method menuTrabajadores
     *
     * Menu principal para la funcionalidad
     * de los trabajadores
     *
     */
    private void menuTrabajadores()
    {
      imprLineaBl();
      System.out.println("-- Menu Atracciones --");
      System.out.println(
      "Seleccione una opcion: \n" +
      "  1) Resumen de los Trabajadores\n" +
      "  2) Salir\n "
      );

      int seleccion = this.input.nextInt();
      input.nextLine();

      switch (seleccion) {
      case 1:
        imprLineaBl();
        resumenTrabajadores();;
        break;
      case 2:
        menu1();
        break;
      default:
        System.out.println("Entrada Invalida.");
        break;
      }
    }


    /**
     * Method resumenTrabajadores
     *
     * Opcion para mostrar resumen de los
     * trabajadores del parque de atracciones
     *
     */
    private void resumenTrabajadores()
    {
      System.out.println("-- Resumen Trabajadores --");
      System.out.println("Los trabajadores se generan automaticamente\n" +
                         "segun las proporciones indicadas cuando se crean\n" +
                         "nuevas atracciones:");
      analizador.trabajadoresPorAtraccion();
      menuTrabajadores();
    }

    ////////// MENU Estadisticas

    /**
     * Method menuEstadisticas
     *
     * Menu principal de la funcionalidad
     * de estadisticas del sistema
     *
     */
    private void menuEstadisticas()
    {
      imprLineaBl();
      System.out.println("-- Menu Estadisticas --");
      System.out.println(
      "Seleccione una opcion: \n" +
      "  1) Informacion Visitantes del Parque\n" +
      "  2) Informacion Precio Entradas\n" +
      "  3) Informacion Uso de Atracciones\n" +
      "  4) Informacion Gastos del Personal Diario\n" +
      "  5) Salir"
      );

      int seleccion = this.input.nextInt();
      input.nextLine();

      switch (seleccion) {
      case 1:
        imprLineaBl();
        estadisticasVisitantes();
        break;
      case 2:
        imprLineaBl();
        estadisticasPrecios();
        break;
      case 3:
        imprLineaBl();
        estadisticasUsoAtracciones();
        break;
      case 4:
        imprLineaBl();
        estadisticasGastos();
        break;
      case 5:
        imprLineaBl();
        menu1();
      default:
        System.out.println("Entrada Invalida.");
        break;
      }
    }

    /**
     * Method estadisticasVisitantes
     *
     * Opcion para generar estadisticas sobre los
     * visitantes que visitan el parque
     *
     */
    private void estadisticasVisitantes()
    {
      System.out.println("Especificar Año: ");
      int anno = input.nextInt();
      imprLineaBl();
      analizador.resumenVisitantes(anno);
      menuEstadisticas();
    }

    /**
     * Method estadisticasPrecios
     *
     * Opcion para generar estadisticas
     * sobre los precios de las entradas
     *
     */
    private void estadisticasPrecios()
    {
      System.out.print("Especificar Año: ");
      int anno = input.nextInt();
      imprLineaBl();
      analizador.resumenPrecios(anno);
      menuEstadisticas();
    }


    /**
     * Method estadisticasUsoAtracciones
     *
     * Opcion para generar estadisticas sobre
     * el uso de las atracciones
     *
     */
    private void estadisticasUsoAtracciones()
    {
      System.out.print("Especificar Año: ");
      int anno = input.nextInt();
      List<AtraccionIF> atraccionesDisponibles = manager.getAtracciones();
      System.out.println("Atracciones Disponibles: ");
      int counter = 0;
      for (AtraccionIF atraccion : atraccionesDisponibles)
      {
        System.out.println("Atraccion #" + counter + " tipo " + atraccion.getTipo());
        counter++;
      }

      int atraccionIndex = 0;
      System.out.print("Seleccione una Atraccion (numero): ");
      atraccionIndex = input.nextInt();

      while (atraccionIndex > counter)
      {
        System.out.println("Entrada No Valida");
        System.out.print("Seleccione una Atraccion (numero): ");
        atraccionIndex = input.nextInt();
      }

      imprLineaBl();
      analizador.resumenVisitasAtracciones(anno, atraccionesDisponibles.get(atraccionIndex));
      menuEstadisticas();
    }

    /**
     * Method estadisticasGastos
     *
     * Opcion para generar estadisticas sobre los gastos
     * diarios del personal del parque
     *
     */
    private void estadisticasGastos()
    {
      System.out.print("Especificar Año: ");
      int anno = input.nextInt();
      imprLineaBl();
      analizador.resumenGastoPersonal(anno);
      menuEstadisticas();
    }

    ////////// OTROS

    private void imprLineaBl()
    {
      System.out.println();
    }

}
