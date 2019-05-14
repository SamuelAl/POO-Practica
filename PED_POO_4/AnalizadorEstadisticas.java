
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

    public void resumenAtracciones()
    {
        int[] numeroAtracciones = new int[5];
        for (AtraccionIF atraccion : ListaAtracciones)
        {
            switch (atraccion.getTipo())
            {
              case "A":
                numeroAtracciones[0]++;
                break;
              case "B":
                numeroAtracciones[1]++;
                break;
              case "C":
                numeroAtracciones[2]++;
                break;
              case "D":
                numeroAtracciones[3]++;
                break;
              case "E":
                numeroAtracciones[4]++;
                break;
            }
        }
        System.out.println("Atracciones Tipo A: " + numeroAtracciones[0]);
        System.out.println("Atracciones Tipo B: " + numeroAtracciones[1]);
        System.out.println("Atracciones Tipo C: " + numeroAtracciones[2]);
        System.out.println("Atracciones Tipo D: " + numeroAtracciones[3]);
        System.out.println("Atracciones Tipo E: " + numeroAtracciones[4]);
    }

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
      System.out.println("  Semana: " + semana);

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
                        System.out.println("    Total Semana: $" + sumadorSemana);
                        System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));

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
                            System.out.println("    Total Semana: $" + sumadorSemana);
                            System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));

                            System.out.println("  Total Mes: $" + sumadorMes);
                            System.out.println("\t\t\t\t    Promedio Mensual: " + promedioPrecio(sumadorMes, contadorMes));


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

                            System.out.println("  Total Mes: $" + sumadorMes);
                            System.out.println("\t\t\t\t    Promedio Mensual: $" + promedioPrecio(sumadorMes, contadorMes));


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

                   System.out.println("    Total Semana: $" + sumadorSemana);
                   System.out.println("\t\t\t\t    Promedio Semanal: $" + promedioPrecio(sumadorSemana, contadorSemana));


                   System.out.println("  Total Mes: $" + sumadorMes);
                   System.out.println("\t\t\t\t    Promedio Mensual: $" + promedioPrecio(sumadorMes, contadorMes));

                   System.out.println(" Total Año: $" + sumadorAnno);
                   System.out.println("\t\t\t\t    Promedio Anual: $" + promedioPrecio(sumadorAnno, contadorAnno));


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

                    System.out.println("    Total Semana: $" + sumadorSemana);
                    System.out.println("\t\t\t\t    Promedio Semanal: " + promedioPrecio(sumadorSemana, contadorSemana));

                    System.out.println("  Total Mes: $" + sumadorMes);
                    System.out.println("\t\t\t\t    Promedio Mensual: " + promedioPrecio(sumadorMes, contadorMes));

                    System.out.println(" Total Año: $" + sumadorAnno);
                    System.out.println("\t\t\t\t    Promedio Anual: $" + promedioPrecio(sumadorAnno, contadorAnno));
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

    private void actualizarNivel(List<AtraccionIF> atracciones, int contadorSemana, float sumadorSemana, int contadorMes, float sumadorMes, int contadorAnno, float sumadorAnno)
    {
      contadorSemana = resolvContador(atracciones, contadorSemana);
      sumadorSemana = resolvSumador(atracciones, sumadorSemana);

      contadorMes = resolvContador(atracciones, contadorMes);
      sumadorMes = resolvSumador(atracciones, sumadorMes);

      contadorAnno = resolvContador(atracciones, contadorAnno);
      sumadorAnno = resolvSumador(atracciones, sumadorAnno);
    }


}
