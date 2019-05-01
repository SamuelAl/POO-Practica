

/**
 * Write a description of class AnalizadorEstadisticas here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
import java.time.*;
import java.time.temporal.*;
import java.util.Locale;

public class AnalizadorEstadisticas
{
    private List<AtraccionIF> ListaAtracciones;
    private List<EntradaIF> ListaEntradas;
    private List<Trabajador> ListaTrabajadores;

    public AnalizadorEstadisticas(List<AtraccionIF> listaAtracc, List<EntradaIF> listaEntradas,
                                  List<Trabajador> listaTrab)
    {
        ListaAtracciones = listaAtracc;
        ListaEntradas = listaEntradas;
        ListaTrabajadores = listaTrab;
    }

    public void resumenVisitantes()
    {
        analisisPorFechas(ListaEntradas);
    }

    private float promedioSemanal(int n)
    {
        float promedio = (float) (n*1.0f/7);
        return promedio;
    }

    private float promedioMensual(int n, int m)
    {
        float promedio = (float) ((n*1.0f)/m);
        return promedio;
    }

    private float promedioAnual(int n)
    {
        float promedio = (float) ((n*1.0f)/365);
        return promedio;
    }

    //RESUMEN PRECIOS

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
                        System.out.println("\t\t\t\t    Promedio Mensual: " + promedioPrecio(sumadorMes, contadorMes));
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

                        System.out.println("  Total Mes: " + sumadorMes);
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

               System.out.println("    Total Semana: " + sumadorSemana);
               System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));
               contadorSemana = 1;
               sumadorSemana = entrada.getPrecio();
               semana = fecha.get(woy);

               System.out.println("  Total Mes: " + sumadorMes);
               System.out.println("\t\t\t\t    Promedio Mensual: $" + promedioPrecio(sumadorMes, contadorMes));
               contadorMes = 1;
               sumadorMes = entrada.getPrecio();

               System.out.println(" Total Año: " + sumadorAnno);
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
                                       " - Precio Medio: " + promedioPrecio(sumadorDia, contadorDia));

                System.out.println("    Total Semana: " + sumadorSemana);
                System.out.println("\t\t\t\t    Promedio Semanal: " + promedioPrecio(sumadorSemana, contadorSemana));

                System.out.println("  Total Mes: " + sumadorMes);
                System.out.println("\t\t\t\t    Promedio Mensual: " + promedioPrecio(sumadorMes, contadorMes));

                System.out.println(" Total Año: " + sumadorAnno);
                System.out.println("\t\t\t\t    Promedio Anual: $" + promedioPrecio(sumadorAnno, contadorAnno));
            }

        }
    }

    private float promedioPrecio (float imp, int n)
    {
      float promedio = (float) (imp*1.0f)/n;
      return promedio;
    }

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

    private void analisisPorFechas(List<EntradaIF> listaEntradas)
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
                  System.out.println("\t\t\t\t    Promedio Anual: " + promedioAnno);
              }

      }
    }

}
