
/**
 * Clase para analizar y generar
 * estadisticas del parque.
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

    public AnalizadorEstadisticas(List<EntradaIF> listaEntradas, List<AtraccionIF> listaAtracc, List<Trabajador> listaTrab)
    {
        ListaEntradas = listaEntradas;
        ListaAtracciones = listaAtracc;
        ListaTrabajadores = listaTrab;;
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
     * Metodo resumenVisitantes
     *
     * Genera estadisticas sobre el numero de visitantes
     * por dia, semana, mes y año, y lo imprime en pantalla.
     * Usa funcion analisisPorFecha(ListaEntradas) como soporte.
     *
     */
    public void resumenVisitantes()
    {
        analisisPorFechas(ListaEntradas);
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
        return round(promedio, 2);
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
        return round(promedio, 2);
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
        return round(promedio, 2);
    }

    //RESUMEN PRECIOS

    /**
     * Method resumenPrecios
     *
     * Genera estadisticas sobre los precios de las entradas y sus promedios
     * agrupando los contenidos por dias, semanas, meses y dias del año.
     * El contenido se imprime en pantalla.
     *
     */
    public void resumenPrecios()
    {
        int dia = ListaEntradas.get(0).getDate().getDayOfMonth();
        int month = ListaEntradas.get(0).getDate().getMonthValue();
        int daysInMonth = ListaEntradas.get(0).getDate().lengthOfMonth();
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int semana = ListaEntradas.get(0).getDate().get(woy);
        int anno = ListaEntradas.get(0).getDate().getYear();

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

                    System.out.println("    Total Semana: $" + round(sumadorSemana, 2));
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
                        System.out.println("    Total Semana: $" + round(sumadorSemana, 2));
                        System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));
                        contadorSemana = 1;
                        sumadorSemana = entrada.getPrecio();
                        semana = fecha.get(woy);

                        System.out.println("  Total Mes: $" + round(sumadorMes, 2));
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

                        System.out.println("  Total Mes: " + round(sumadorMes, 2));
                        System.out.println("\t\t\t\t    Promedio Mensual:$" + promedioPrecio(sumadorMes, contadorMes));
                        contadorMes = 1;
                        sumadorMes = entrada.getPrecio();
                        System.out.println("Mes: " + month);

                        contadorAnno++;
                        sumadorAnno += entrada.getPrecio();
                    }
                    daysInMonth = fecha.lengthOfMonth();

                }
            }
            else
            {
               System.out.println("   " + dia + "/" +
                                           month + "/" +
                                           anno +
                                           " - Precio Medio: $" + promedioPrecio(sumadorDia, contadorDia));
               contadorDia = 1;
               sumadorDia = entrada.getPrecio();

               System.out.println("    Total Semana: " + round(sumadorSemana, 2));
               System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));
               contadorSemana = 1;
               sumadorSemana = entrada.getPrecio();
               semana = fecha.get(woy);

               System.out.println("  Total Mes: " + round(sumadorMes, 2));
               System.out.println("\t\t\t\t    Promedio Mensual: $" + promedioPrecio(sumadorMes, contadorMes));
               contadorMes = 1;
               sumadorMes = entrada.getPrecio();

               System.out.println(" Total Año: " + round(sumadorAnno, 2));
               System.out.println("\t\t\t\t    Promedio Anual: $" + promedioPrecio(sumadorAnno, contadorAnno));
               contadorAnno = 1;
               sumadorAnno = entrada.getPrecio();

               dia = fecha.getDayOfMonth();
               month = fecha.getMonthValue();
               anno = fecha.getYear();

               System.out.println("Año: " + anno);
               System.out.println("Mes: " + month);
               System.out.println("  Semana: " + semana);

            }

            if (fecha == ultimaFecha)
            {
                dia = fecha.getDayOfMonth();
                month = fecha.getMonthValue();
                daysInMonth = fecha.lengthOfMonth();

                System.out.println("   " + dia + "/" +
                                       month + "/" +
                                       fecha.getYear() +
                                       " - Precio Medio: $" + promedioPrecio(sumadorDia, contadorDia));

                System.out.println("    Total Semana: " + round(sumadorSemana, 2));
                System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));

                System.out.println("  Total Mes: " + round(sumadorMes, 2));
                System.out.println("\t\t\t\t    Promedio Mensual: $" + promedioPrecio(sumadorMes, contadorMes));

                System.out.println(" Total Año: " + round(sumadorAnno, 2));
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
     * Calcula estadisticas sobre el uso de las atracciones
     * del parque, agrupando por dia, semana, mes y año.
     * Imprimer resultados en pantalla
     *
     */
    public void resumenVisitasAtracciones()
    {
      int counter = 1;
      String tipo = ListaAtracciones.get(0).getTipo();
      for (AtraccionIF atraccion : ListaAtracciones)
      {
        if (!tipo.equals(atraccion.getTipo()))
        {
          tipo = atraccion.getTipo();
          counter = 1;
        }
        System.out.println("Atraccion " + counter + " - Tipo " + atraccion.getTipo());
        List<EntradaIF> usuarios = atraccion.getUsuarios();

        analisisPorFechas(usuarios);
        counter++;
      }
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
     */
    private void analisisPorFechas(List<EntradaIF> listaEntradas)
    {
      if (listaEntradas.size() > 0)
      {
          int dia = listaEntradas.get(0).getDate().getDayOfMonth();
          int month = listaEntradas.get(0).getDate().getMonthValue();
          int daysInMonth = listaEntradas.get(0).getDate().lengthOfMonth();
          TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
          int semana = listaEntradas.get(0).getDate().get(woy);
          int anno = listaEntradas.get(0).getDate().getYear();
    
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
              else
              {
                 System.out.println("   " + dia + "/" +
                                             month + "/" +
                                             anno +
                                             " - Total Visitantes: " + contadorDia);
                 contadorDia = 1;
    
                 System.out.println("    Total Semana: " + contadorSemana);
                 promedioSemanal = promedioSemanal(contadorSemana);
                 System.out.println("\t\t\t\t    Promedio Semanal: " + contadorSemana);
                 contadorSemana = 1;
                 semana = fecha.get(woy);
    
                 System.out.println("  Total Mes: " + contadorMes);
                 promedioMes = promedioMensual(contadorMes, daysInMonth);
                 System.out.println("\t\t\t\t    Promedio Mensual: " + promedioMes);
                 contadorMes = 1;
    
                 System.out.println(" Total Año: " + contadorAnno);
                 promedioAnno = promedioAnual(contadorAnno);
                 System.out.println("\t\t\t\t    Promedio Anual: " + promedioAnno);
                 contadorAnno = 1;
    
                 dia = fecha.getDayOfMonth();
                 month = fecha.getMonthValue();
                 anno = fecha.getYear();
    
                 System.out.println("Año: " + anno);
                 System.out.println("Mes: " + month);
                 System.out.println("  Semana: " + semana);
    
              }
    
              if (fecha == ultimaFecha)
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
                  System.out.println("\t\t\t\t    Promedio Anual: " + (promedioAnno++));
              }
          }
          
      }
      else
      {
          System.out.println("No hay datos");
      }
      
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
