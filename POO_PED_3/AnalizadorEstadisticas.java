
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
    
    public void analizarVisitantes(int anno)
    {
        
    }
    
    public void analizarFechas()
    {
        int dia = ListaEntradas.get(0).getDate().getDayOfMonth();
        int month = ListaEntradas.get(0).getDate().getMonthValue();
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int semana = ListaEntradas.get(0).getDate().get(woy);
        int contadorDia = 0;
        int contadorSemana = 0;
        int contadorMes = 0;
        int contadorAnno = 0;
        System.out.println("Mes: " + month);
        System.out.println("  Semana: " + semana);
        for (EntradaIF entrada : ListaEntradas)
        {
            LocalDate fecha = entrada.getDate();
            
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
                                           fecha.getYear() +
                                           " - Total Visitantes: " + contadorDia);
                        contadorDia = 1;
                        contadorSemana++;
                        dia = fecha.getDayOfMonth();
                    }
                }
                else
                {
                    System.out.println("   " + dia + "/" + 
                                       month + "/" +
                                       fecha.getYear() +
                                       " - Total Visitantes: " + contadorDia);
                contadorDia = 1;
                dia = fecha.getDayOfMonth();
                System.out.println("    Total Semana: " + contadorSemana);
                contadorSemana = 1;
                semana = fecha.get(woy);
                System.out.println("  Semana: " + semana);
                }
            }
            else
            {
                System.out.println("   " + dia + "/" + 
                                       month + "/" +
                                       fecha.getYear() +
                                       " - Total Visitantes: " + contadorDia);
                contadorDia = 1;
                dia = fecha.getDayOfMonth();
                month = fecha.getMonthValue();
                System.out.println("  Total Mes: " + contadorMes);
                contadorMes = 1;
                System.out.println("Mes: " + month);
            }
           
        }
    }
    
}
