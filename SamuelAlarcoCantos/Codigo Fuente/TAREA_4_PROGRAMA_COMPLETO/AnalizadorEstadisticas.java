
/**
 * Write a description of class AnalizadorEstadisticas here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.time.*;
import java.time.temporal.*;
import java.util.Locale;
import java.math.BigDecimal;

public class AnalizadorEstadisticas
{
    private List<EntradaIF> ListaEntradas;
    private List<AtraccionIF> ListaAtracciones;
    private List<Trabajador> ListaTrabajadores;
    private AtraccionesFuncionando atraccionesActivas;

    public AnalizadorEstadisticas(List<EntradaIF> listaEntradas, List<AtraccionIF> listaAtracc, List<Trabajador> listaTrab, AtraccionesFuncionando atraccionesAct)
    {
        ListaEntradas = listaEntradas;
        ListaAtracciones = listaAtracc;
        ListaTrabajadores = listaTrab;
        this.atraccionesActivas = atraccionesAct;
    }

    /**
     * Metodo resumenAtracciones
     *
     * Imprime en pantalla un recuento de las
     * atracciones creadas en el parque
     *
     */
    public void resumenAtracciones()
    {
        HashMap<String, Integer> tiposAtracciones = new HashMap();
        for (AtraccionIF atraccion : ListaAtracciones)
        {
          String tipo = atraccion.getTipo();
          if (tiposAtracciones.containsKey(tipo))
          {
            tiposAtracciones.put(tipo, tiposAtracciones.get(tipo) + 1);
          }
          else
          {
            tiposAtracciones.put(tipo, 1);
          }
        }
        for (String tipo : tiposAtracciones.keySet())
        {
          System.out.println("Atracciones " + tipo + ": " + tiposAtracciones.get(tipo));
        }
      }

      /**
       * Method resumenAtraccionesActivas
       * 
       * Metodo para mostrar informacion
       * sobre las atracciones activas
       *
       */
      public void resumenAtraccionesActivas()
      {
        atraccionesActivas.imprPeriodos();
      }


    /**
     * Metodo resumenTrabajadoresTipo
     *
     * Cuenta el numero de trabajadores del tipo
     * especificado y lo devuelve como entero
     *
     * @param tipo Tipo de trabajador (TiposTrabajadores)
     * @return Numero de trabajadores del tipo especificado (entero)
     */
    public int resumenTrabajadoresTipo(TiposTrabajadores tipo)
    {
        int n = 0;

        for (Trabajador trabajador : ListaTrabajadores)
        {
            if (trabajador.getTipo() == tipo)
            {
                n++;
            }
        }

        return n;
    }

    /**
     * Method trabajadoresPorAtraccion
     * 
     * Metodo para mostrar informacion
     * sobre los trabajadores por atraccion
     * del parque
     *
     */
    public void trabajadoresPorAtraccion()
    {
      int counter = 0;
      for (AtraccionIF atraccion : ListaAtracciones)
      {
        List<Trabajador> trabajadores = new LinkedList<Trabajador>(atraccion.getTrabajadores());
        HashMap<TiposTrabajadores, Integer> contadorTrabajadores = new HashMap();
        System.out.println("Atraccion #" + counter + " tipo " + atraccion.getTipo() + ": ");
        counter++;

        for (Trabajador trabajador : trabajadores)
        {
          if (!contadorTrabajadores.containsKey(trabajador.getTipo()))
          {
              contadorTrabajadores.put(trabajador.getTipo(), 1);
          }
          else
          {
            contadorTrabajadores.put(trabajador.getTipo(), (contadorTrabajadores.get(trabajador.getTipo()) + 1));
          }
        }
        for (TiposTrabajadores tipo : contadorTrabajadores.keySet())
        {
          switch (tipo)
          {
            case AYU_ATRACC:
              System.out.println("Ayudantes de Atraccion: " + contadorTrabajadores.get(tipo));
              break;
            case RESP_ATRACC:
              System.out.println("Responsables de Atraccion: " + contadorTrabajadores.get(tipo));
              break;
          }
        }
          System.out.println();
      }
      System.out.println("Relaciones Publicas: " + resumenTrabajadoresTipo(TiposTrabajadores.REL_PUBLICAS));
      System.out.println("Atencion al Cliente: " + resumenTrabajadoresTipo(TiposTrabajadores.ATENCION_CL));

      System.out.println();
    }

    /**
     * Metodo resumenVisitantesTipo
     *
     * Imprime en pantalla un recuento de los visitantes
     * del parque agrupados por tipo/descuento de la entrada
     *
     */
    public void resumenVisitantesTipo()
    {
      HashMap<String, Integer> tiposVisitantes = new HashMap();
      for (EntradaIF entrada : ListaEntradas)
      {
        String tipo = entrada.getTipo();
        if (tiposVisitantes.containsKey(tipo))
        {
          tiposVisitantes.put(tipo, tiposVisitantes.get(tipo) + 1);
        }
        else
        {
          tiposVisitantes.put(tipo, 1);
        }
      }
      for (String tipo : tiposVisitantes.keySet())
      {
        System.out.println(tipo + ": " + tiposVisitantes.get(tipo));
      }
    }

   
    /**
     * Method resumenVisitantes
     * 
     * Metodo para generar estadisticas sobre 
     * los visitantes del parque en un año
     *
     * @param year Año
     */
    public void resumenVisitantes(int year)
    {
        analisisPorFechas(ListaEntradas, year);
    }

    /**
     * Method promedioSemanal
     *
     * Calcula un promedio semanal de un entero
     * (lo divide por siete)
     *
     * @param n Entero del que se quiere calcular el promedio semanal
     * @return Promedio semanal (float)
     */
    private float promedioSemanal(int n)
    {
        float promedio = (float) (n*1.0f/7);
        return promedio;
    }

    /**
     * Method promedioMensual
     *
     * Calcula el promedio mensual de un entero
     * dividiendolo por el numero de dias del mes
     *
     * @param n Entero del que se quiere calcular el promedio mensual
     * @param m Numero de dias del mes
     * @return Promedio mensual (float)
     */
    private float promedioMensual(int n, int m)
    {
        float promedio = (float) ((n*1.0f)/m);
        return promedio;
    }

    /**
     * Method promedioAnual
     *
     * Calcula el promedio anual de un entero,
     * dividiendolo por el numero de dias de un año natural
     *
     * @param n Entero del que se quiere calcular el promedio anual
     * @return Promedio anual
     */
    private float promedioAnual(int n)
    {
        float promedio = (float) ((n*1.0f)/365);
        return promedio;
    }

    //RESUMEN PRECIOS

    
    /**
     * Method resumenPrecios
     * 
     * Metodo para generar estadisticas sobre los 
     * precios de las entradas en el periodo de un
     * añp
     *
     * @param year Año
     */
    public void resumenPrecios(int year)
    {
        int dia = ListaEntradas.get(0).getDate().getDayOfMonth();
        int month = ListaEntradas.get(0).getDate().getMonthValue();
        int daysInMonth = ListaEntradas.get(0).getDate().lengthOfMonth();
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int semana = ListaEntradas.get(0).getDate().get(woy);
        int anno = year;

        int contadorDia = 0;
        int contadorSemana = 0;
        int contadorMes = 0;
        int contadorAnno = 0;

        float sumadorDia = 0;
        float sumadorSemana = 0;
        float sumadorMes = 0;
        float sumadorAnno = 0;

        float promedioImpSemanal = 0;
        float promedioImpMes = 0;
        float promedioImpAnno = 0;

        LocalDate ultimaFecha = ListaEntradas.get(ListaEntradas.size()-1).getDate();

        System.out.println("Año: " + anno);
        System.out.println("Mes: " + month);
        System.out.println("  Semana: " + semana);

        for (EntradaIF entrada : ListaEntradas)
        {
            LocalDate fecha = entrada.getDate();
            if (fecha.getYear() == anno)
            {
                if (fecha.getMonthValue() == month) //Loop para el mes
                {
                    if (fecha.get(woy) == semana)
                    {
                         if (fecha.getDayOfMonth() == dia)
                        {
                            contadorDia++;
                            contadorSemana++;
                            contadorMes++;
                            contadorAnno++;

                            sumadorDia += entrada.getPrecio();
                            sumadorSemana += entrada.getPrecio();
                            sumadorMes += entrada.getPrecio();
                            sumadorAnno += entrada.getPrecio();
                        }
                        else
                        {
                            System.out.println("   " + dia + "/" +
                                               month + "/" +
                                               anno +
                                               " - Precio Medio: $" + promedioPrecio(sumadorDia, contadorDia));
                            contadorDia = 1;
                            sumadorDia = entrada.getPrecio();
                            dia = fecha.getDayOfMonth();

                            contadorSemana++;
                            sumadorSemana += entrada.getPrecio();
                            contadorMes++;
                            sumadorMes += entrada.getPrecio();
                            contadorAnno++;
                            sumadorAnno += entrada.getPrecio();

                        }
                    }
                    else
                    {
                        System.out.println("   " + dia + "/" +
                                           month + "/" +
                                           anno +
                                           " - Precio Medio: $" + promedioPrecio(sumadorDia, contadorDia));
                    contadorDia = 1;
                    dia = fecha.getDayOfMonth();

                    System.out.println("    Total Semana: $" + sumadorSemana);
                    System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));
                    contadorSemana = 1;
                    sumadorSemana = entrada.getPrecio();
                    semana = fecha.get(woy);
                    System.out.println("  Semana: " + semana);

                    contadorMes++;
                    sumadorMes += entrada.getPrecio();
                    contadorAnno++;
                    sumadorAnno += entrada.getPrecio();
                    }
                }
                else
                {
                    System.out.println("   " + dia + "/" +
                                           month + "/" +
                                           anno +
                                           " - Precio Medio: $" + promedioPrecio(sumadorDia, contadorDia));
                    contadorDia = 1;
                    dia = fecha.getDayOfMonth();
                    month = fecha.getMonthValue();
                    if (fecha.get(woy) != semana)//Casos en los que fin de semana y fin de mes coinciden
                    {
                        System.out.println("    Total Semana: $" + sumadorSemana);
                        System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));
                        contadorSemana = 1;
                        sumadorSemana = entrada.getPrecio();
                        semana = fecha.get(woy);

                        System.out.println("  Total Mes: $" + sumadorMes);
                        System.out.println("\t\t\t\t    Promedio Mensual: $" + promedioPrecio(sumadorMes, contadorMes));
                        contadorMes = 1;
                        sumadorMes = entrada.getPrecio();
                        contadorAnno++;
                        sumadorAnno += entrada.getPrecio();

                        System.out.println("Mes: " + month);
                        System.out.println("  Semana: " + semana);
                    }
                    else
                    {
                        contadorSemana++;
                        sumadorSemana += entrada.getPrecio();

                        System.out.println("  Total Mes: $" + sumadorMes);
                        System.out.println("\t\t\t\t    Promedio Mensual:$" + promedioPrecio(sumadorMes, contadorMes));
                        contadorMes = 1;
                        sumadorMes = entrada.getPrecio();
                        System.out.println("Mes: $" + month);

                        contadorAnno++;
                        sumadorAnno += entrada.getPrecio();
                    }
                    daysInMonth = fecha.lengthOfMonth();

                }
            }

            

            if (fecha == ultimaFecha || fecha.getYear() > year)
            {
                dia = fecha.getDayOfMonth();
                month = fecha.getMonthValue();
                daysInMonth = fecha.lengthOfMonth();

                System.out.println("   " + dia + "/" +
                                       month + "/" +
                                       fecha.getYear() +
                                       " - Precio Medio: $" + promedioPrecio(sumadorDia, contadorDia));

                System.out.println("    Total Semana: " + sumadorSemana);
                System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));

                System.out.println("  Total Mes: " + sumadorMes);
                System.out.println("\t\t\t\t    Promedio Mensual: $" + promedioPrecio(sumadorMes, contadorMes));

                System.out.println(" Total Año: " + sumadorAnno);
                System.out.println("\t\t\t\t    Promedio Anual: $" + promedioPrecio(sumadorAnno, contadorAnno));
            }

        }
    }

    /**
     * Method promedioPrecio
     *
     * Funcion para calcular un promedio, dividiendo por n
     *
     * @param imp Float del que se quiere calcular el promedio
     * @param n Entero por el que se desea dividir
     * @return Promedio de n / m
     */
    private float promedioPrecio (float imp, int n)
    {
      float promedio = (float) (imp*1.0f)/n;
      return round(promedio, 2);
    }

    
    /**
     * Method resumenVisitasAtracciones
     * 
     * Metodo para genera estadisticas sobre
     * el uso de una atraccion en el periodo
     * de un año
     *
     * @param year año
     * @param atraccion Atraccion
     */
    public void resumenVisitasAtracciones(int year, AtraccionIF atraccion)
    {

        System.out.println("Atraccion - Tipo " + atraccion.getTipo());
        List<EntradaIF> usuarios = atraccion.getUsuarios();

        analisisPorFechas(usuarios, year);

      }

    /**
     * Method analisisPorFechas
     *
     * Funcion base para generar las estadisticas sobre entradas
     * agrupadas por dias, semana, mes y año. Codigo se puede
     * reutilizar, con ligeras modificaciones, para otros
     * tipos de lista
     *
     * @param listaEntradas A parameter
     * @param year Año
     */
    private void analisisPorFechas(List<EntradaIF> listaEntradas, int year)
    {
      int dia = listaEntradas.get(0).getDate().getDayOfMonth();
      int month = listaEntradas.get(0).getDate().getMonthValue();
      int daysInMonth = listaEntradas.get(0).getDate().lengthOfMonth();
      TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
      int semana = listaEntradas.get(0).getDate().get(woy);
      int anno = year;

      int contadorDia = 0;
      int contadorSemana = 0;
      int contadorMes = 0;
      int contadorAnno = 0;

      float promedioSemanal = 0;
      float promedioMes = 0;
      float promedioAnno = 0;

      LocalDate ultimaFecha = listaEntradas.get(listaEntradas.size()-1).getDate();

      System.out.println("Año: " + anno);
      System.out.println("Mes: " + month);
      System.out.println("  Semana: " + semana);

      for (EntradaIF entrada : listaEntradas)
      {
          LocalDate fecha = entrada.getDate();
          if (fecha.getYear() == anno)
          {
              if (fecha.getMonthValue() == month) //Loop para el mes
              {
                  if (fecha.get(woy) == semana)
                  {
                       if (fecha.getDayOfMonth() == dia)
                      {
                          contadorDia++;
                          contadorSemana++;
                          contadorMes++;
                          contadorAnno++;
                      }
                      else
                      {
                          System.out.println("   " + dia + "/" +
                                             month + "/" +
                                             anno +
                                             " - Total Visitantes: " + contadorDia);
                          contadorDia = 1;
                          dia = fecha.getDayOfMonth();

                          contadorSemana++;
                          contadorMes++;
                          contadorAnno++;
                      }
                  }
                  else
                  {
                      System.out.println("   " + dia + "/" +
                                         month + "/" +
                                         anno +
                                         " - Total Visitantes: " + contadorDia);
                  contadorDia = 1;
                  dia = fecha.getDayOfMonth();

                  System.out.println("    Total Semana: " + contadorSemana);
                  promedioSemanal = promedioSemanal(contadorSemana);
                  System.out.println("\t\t\t\t    Promedio Semanal: " + contadorSemana);
                  contadorSemana = 1;
                  semana = fecha.get(woy);
                  System.out.println("  Semana: " + semana);

                  contadorMes++;
                  contadorAnno++;
                  }
              }
              else
              {
                  System.out.println("   " + dia + "/" +
                                         month + "/" +
                                         anno +
                                         " - Total Visitantes: " + contadorDia);
                  contadorDia = 1;
                  dia = fecha.getDayOfMonth();
                  month = fecha.getMonthValue();
                  if (fecha.get(woy) != semana)//Casos en los que fin de semana y fin de mes coinciden
                  {
                      System.out.println("    Total Semana: " + contadorSemana);
                      promedioSemanal = promedioSemanal(contadorSemana);
                      System.out.println("\t\t\t\t    Promedio Semanal: " + contadorSemana);
                      contadorSemana = 1;
                      semana = fecha.get(woy);

                      System.out.println("  Total Mes: " + contadorMes);
                      promedioMes = promedioMensual(contadorMes, daysInMonth);
                      System.out.println("\t\t\t\t    Promedio Mensual: " + promedioMes);
                      contadorMes = 1;
                      contadorAnno++;

                      System.out.println("Mes: " + month);
                      System.out.println("  Semana: " + semana);
                  }
                  else
                  {
                      contadorSemana++;

                      System.out.println("  Total Mes: " + contadorMes);
                      promedioMes = promedioMensual(contadorMes, daysInMonth);
                      System.out.println("\t\t\t\t    Promedio Mensual: " + promedioMes);
                      contadorMes = 1;
                      System.out.println("Mes: " + month);

                      contadorAnno++;
                  }
                  daysInMonth = fecha.lengthOfMonth();

              }
          }
          

          if (fecha == ultimaFecha || fecha.getYear() > year)
          {
              dia = fecha.getDayOfMonth();
              month = fecha.getMonthValue();
              daysInMonth = fecha.lengthOfMonth();

              System.out.println("   " + dia + "/" +
                                     month + "/" +
                                     fecha.getYear() +
                                     " - Total Visitantes: " + contadorDia);

              System.out.println("    Total Semana: " + contadorSemana);
              promedioSemanal = promedioSemanal(contadorSemana);
              System.out.println("\t\t\t\t    Promedio Semanal: " + contadorSemana);

              System.out.println("  Total Mes: " + contadorMes);
              promedioMes = promedioMensual(contadorMes, daysInMonth);
              System.out.println("\t\t\t\t    Promedio Mensual: " + promedioMes);

              System.out.println(" Total Año: " + contadorAnno);
              promedioAnno = promedioAnual(contadorAnno);
              System.out.println("\t\t\t\t    Promedio Anual: " + promedioAnno);
          }
      }
    }

    /**
     * Metodo resumenGastoPersonal
     *
     * Calcula estadisticas sobre los gastos de personal
     * en el parque de atracciones en un año natural,
     * tomando en cuenta las fluctuaciones durante el año
     * dado que ciertas atracciones pueden estar activas o no
     *
     * @param year Año del que se quiere hacer el analisis.
     */
    public void resumenGastoPersonal(int year)
    {

      LocalDate fechaBase = LocalDate.of(year, Month.JANUARY, 1);

      List<Trabajador> trabajadores;
      List<AtraccionIF> atracciones;

      TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
      int semana = fechaBase.get(woy);
      int month = fechaBase.getMonthValue();
      int daysInMonth = fechaBase.lengthOfMonth();
      int anno = year;

      int contadorSemana = 0;
      int contadorMes = 0;
      int contadorAnno = 0;

      float sumadorDia = 0;
      float sumadorSemana = 0;
      float sumadorMes = 0;
      float sumadorAnno = 0;

      float promedioImpSemanal = 0;
      float promedioImpMes = 0;
      float promedioImpAnno = 0;

      System.out.println("Año: " + anno);
      System.out.println("Mes: " + month);

      for (int i = 0; i < fechaBase.lengthOfYear(); i++)
      {
          atracciones = atraccionesActivas.getAtracciones(fechaBase);
          if (atracciones.size() > 0)
          {
                LocalDate fecha = fechaBase;
                if (fecha.getYear() == anno)
                {
                    if (fecha.getMonthValue() == month) //Loop para el mes
                    {
                        if (fecha.get(woy) == semana)
                        {
                             contadorSemana = resolvContador(atracciones, contadorSemana);
                             sumadorSemana = resolvSumador(atracciones, sumadorSemana);

                             contadorMes = resolvContador(atracciones, contadorMes);
                             sumadorMes = resolvSumador(atracciones, sumadorMes);

                             contadorAnno = resolvContador(atracciones, contadorAnno);
                             sumadorAnno = resolvSumador(atracciones, sumadorAnno);
                        }
                        else
                        {
                        System.out.println("  Semana: " + semana);
                        System.out.println("    Total Semana: $" + round(sumadorSemana, 2));
                        System.out.println("\t\t\t\t    Promedio Semanal: $" + round(promedioPrecio(sumadorSemana, contadorSemana), 2));

                        contadorSemana = resolvContador(atracciones, 0);
                        sumadorSemana = resolvSumador(atracciones, 0);

                        contadorMes = resolvContador(atracciones, contadorMes);
                        sumadorMes = resolvSumador(atracciones, sumadorMes);

                        contadorAnno = resolvContador(atracciones, contadorAnno);
                        sumadorAnno = resolvSumador(atracciones, sumadorAnno);

                        semana = fecha.get(woy);
                        }
                    }
                    else
                    {
                        month = fecha.getMonthValue();
                        if (fecha.get(woy) != semana)//Casos en los que fin de semana y fin de mes coinciden
                        {
                            System.out.println("  Semana: " + semana);
                            System.out.println("    Total Semana: $" + round(sumadorSemana, 2));
                            System.out.println("\t\t\t\t    Promedio Semanal: $" + round(promedioPrecio(sumadorSemana, contadorSemana), 2));

                            System.out.println("  Total Mes: $" + sumadorMes);
                            System.out.println("\t\t\t\t    Promedio Mensual: " + round(promedioPrecio(sumadorMes, contadorMes), 2));


                            contadorSemana = resolvContador(atracciones, 0);
                            sumadorSemana = resolvSumador(atracciones, 0);

                            contadorMes = resolvContador(atracciones, 0);
                            sumadorMes = resolvSumador(atracciones, 0);

                            contadorAnno = resolvContador(atracciones, contadorAnno);
                            sumadorAnno = resolvSumador(atracciones, sumadorAnno);

                            semana = fecha.get(woy);

                            System.out.println("Mes: " + month);
                        }
                        else
                        {

                            System.out.println("  Total Mes: $" + round(sumadorMes, 2));
                            System.out.println("\t\t\t\t    Promedio Mensual: $" + round(promedioPrecio(sumadorMes, contadorMes), 2));


                            contadorSemana = resolvContador(atracciones, contadorSemana);
                            sumadorSemana = resolvSumador(atracciones, sumadorSemana);

                            contadorMes = resolvContador(atracciones, 0);
                            sumadorMes = resolvSumador(atracciones, 0);

                            contadorAnno = resolvContador(atracciones, contadorAnno);
                            sumadorAnno = resolvSumador(atracciones, sumadorAnno);

                            System.out.println("Mes: " + month);
                        }
                        daysInMonth = fecha.lengthOfMonth();
                    }
                }
                else
                {

                   System.out.println("    Total Semana: $" + round(sumadorSemana, 2));
                   System.out.println("\t\t\t\t    Promedio Semanal: $" + round(promedioPrecio(sumadorSemana, contadorSemana), 2));


                   System.out.println("  Total Mes: $" + sumadorMes);
                   System.out.println("\t\t\t\t    Promedio Mensual: $" + round(promedioPrecio(sumadorMes, contadorMes), 2));

                   System.out.println(" Total Año: $" + sumadorAnno);
                   System.out.println("\t\t\t\t    Promedio Anual: $" + round(promedioPrecio(sumadorAnno, contadorAnno), 2));


                   contadorSemana = resolvContador(atracciones, 0);
                   sumadorSemana = resolvSumador(atracciones, 0);

                   contadorMes = resolvContador(atracciones, 0);
                   sumadorMes = resolvSumador(atracciones, 0);

                   contadorAnno = resolvContador(atracciones, 0);
                   sumadorAnno = resolvSumador(atracciones, 0);

                   semana = fecha.get(woy);
                   month = fecha.getMonthValue();
                   anno = fecha.getYear();

                   System.out.println("Año: " + anno);
                   System.out.println("Mes: " + month);
                   System.out.println("  Semana: " + semana);

                }

                if (i == fechaBase.lengthOfYear() - 1)
                {
                    month = fecha.getMonthValue();
                    daysInMonth = fecha.lengthOfMonth();

                    System.out.println("    Total Semana: $" + round(sumadorSemana, 2));
                    System.out.println("\t\t\t\t    Promedio Semanal: " + round(promedioPrecio(sumadorSemana, contadorSemana), 2));

                    System.out.println("  Total Mes: $" + sumadorMes);
                    System.out.println("\t\t\t\t    Promedio Mensual: " + round(promedioPrecio(sumadorMes, contadorMes), 2));

                    System.out.println(" Total Año: $" + sumadorAnno);
                    System.out.println("\t\t\t\t    Promedio Anual: $" + round(promedioPrecio(sumadorAnno, contadorAnno), 2));
                }
                else
                {
                    fechaBase = fechaBase.plusDays(1);
                }
          }
          else
          {
            fechaBase = fechaBase.plusDays(1);
          }


      }
    }

    /**
     * Method resolvContador
     *
     * Funcion de ayuda para las estadisticas de gasto personal,
     * que se encarga de actualizar un contador de trabajadores
     * a partir de la lista de atracciones suministrada
     *
     * @param atracciones Lista de atracciones a analizar
     * @param n Valor actual del contador (entero)
     * @return Valor actualizado del contador (entero)
     */
    private int resolvContador(List<AtraccionIF> atracciones, int n)
    {
      List<Trabajador> trabajadores;
      int contador = n;
      for (AtraccionIF atraccion : atracciones)
      {
        trabajadores = atraccion.getTrabajadores();
        for (Trabajador trabajador : trabajadores)
        {
          contador++;
        }
      }
      for (Trabajador trabajador : ListaTrabajadores)
      {
        if (trabajador.getTipo() == TiposTrabajadores.REL_PUBLICAS || trabajador.getTipo() == TiposTrabajadores.ATENCION_CL)
        {
          contador++;
        }
      }

      return contador;
    }

    /**
     * Method resolvSumador
     *
     * Funcion de ayuda para las estadisticas de gasto personal,
     * que se encarga de actualizar un sumador de salario de los trabajadores
     * a partir de la lista de atracciones suministrada
     *
     * @param atracciones Lista de atracciones a analizar
     * @param n Valor actual del sumador (float)
     * @return Valor actualizado del sumador (float)
     */
    private float resolvSumador(List<AtraccionIF> atracciones, float n)
    {
      List<Trabajador> trabajadores;
      float sumador = n;
      for (AtraccionIF atraccion : atracciones)
      {
        trabajadores = atraccion.getTrabajadores();
        for (Trabajador trabajador : trabajadores)
        {
          sumador += trabajador.getSueldo();
        }
      }
      for (Trabajador trabajador : ListaTrabajadores)
      {
        if (trabajador.getTipo() == TiposTrabajadores.REL_PUBLICAS || trabajador.getTipo() == TiposTrabajadores.ATENCION_CL)
        {
          sumador++;
        }
      }
      return sumador;
    }

    /**
     * Method round
     *
     * Metodo para redondear valores float a dos decimales
     *
     * @param d Valor a redondear (float)
     * @param decimalPlace Numero de decimales (entero)
     * @return Valor redondeado (float)
     */
    private float round(float d, int decimalPlace)
    {
        BigDecimal n = new BigDecimal(Float.toString(d));
        n = n.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return n.floatValue();
    }


}
