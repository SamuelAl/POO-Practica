
/**
 * Clase principal del programa para almacenar y gestionar
 * los objetos y funcionalidades principales del programa
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
import java.time.*;
import java.util.concurrent.ThreadLocalRandom;

public class ParqueManager

{
    private List<AtraccionIF> AtraccionesParque;
    private List<Trabajador> TrabajadoresParque;
    private List<EntradaIF> EntradasParque;
    private MaquinaEntradas generadorEntradas;
    private CreadorTrabajadores generadorTrabajadores;
    private CreadorAtracciones generadorAtracciones;
    private AtraccionesFuncionando atraccionesFuncionando;
    /**
     * Constructor for objects of class Parque
     */
    public ParqueManager()
    {
        AtraccionesParque = new LinkedList<AtraccionIF>();
        TrabajadoresParque = new LinkedList<Trabajador>();
        EntradasParque = new LinkedList<EntradaIF>();
        generadorEntradas = new MaquinaEntradas();
        generadorTrabajadores = new CreadorTrabajadores();
        generadorAtracciones = new CreadorAtracciones();
        atraccionesFuncionando = new AtraccionesFuncionando();

    }

    public void addEntrada(LocalDate fecha, int edad,
                           boolean isVIP, boolean isFamilia,
                           String descuento)
    {
        EntradaIF entrada = generadorEntradas.nuevaEntrada(fecha, edad,
                                                    isVIP, isFamilia, descuento);
        EntradasParque.add(entrada);
    }

    public void addEntradaNiño(LocalDate fecha, int edad,
                           boolean isVIP, boolean isFamilia,
                           String descuento)
    {
        EntradaIF entrada = generadorEntradas.nuevaEntradaNiño(fecha, edad,
                                                    isVIP, isFamilia, descuento);
        EntradasParque.add(entrada);
    }

    public void addTrabajador(TiposTrabajadores tipo)
    {
        Trabajador trabajador = generadorTrabajadores.nuevoTrabajador(tipo);
        TrabajadoresParque.add(trabajador);
    }

    public void addAtraccion(String tipo)
    {
        AtraccionIF atraccion = generadorAtracciones.nuevaAtraccion(tipo);
        Trabajador nuevoTrabajador;
        for (int i = 0; i < atraccion.getNumRespAtracc(); i++)
        {
            nuevoTrabajador = generadorTrabajadores.nuevoTrabajador(TiposTrabajadores.RESP_ATRACC);
            TrabajadoresParque.add(nuevoTrabajador);
            atraccion.addTrabajador(nuevoTrabajador);
        }

        for (int i = 0; i < atraccion.getNumAyuAtracc(); i++)
        {
            nuevoTrabajador = generadorTrabajadores.nuevoTrabajador(TiposTrabajadores.AYU_ATRACC);
            TrabajadoresParque.add(nuevoTrabajador);
            atraccion.addTrabajador(nuevoTrabajador);
        }

        AtraccionesParque.add(atraccion);
    }

    public int getNumTrabajadores(TiposTrabajadores tipo)
    {
        int n = 0;

        for (Trabajador trabajador : TrabajadoresParque)
        {
            if (trabajador.getTipo() == tipo)
            {
                n++;
            }
        }

        return n;
    }

    public int getNumTrabajadores()
    {
        return TrabajadoresParque.size();
    }

    public int getNumVisitantes()
    {
        return EntradasParque.size();
    }

    public void usarAtraccion(int index, EntradaIF entrada)
    {
        AtraccionesParque.get(index).usar(entrada);
    }

    //Funcion para generar uso aleatorio de atracciones
    public void randomUsarAtracciones()
    {
        for (AtraccionIF atraccion : AtraccionesParque)
        {
            int n = ThreadLocalRandom.current().nextInt(10) + 1;
            int i = 0;
            for (EntradaIF entrada: EntradasParque)
            {
                if (i%n == 0 || i%n == 2 || i%n == 5)
                {
                    atraccion.usar(entrada);
                }
                i++;
            }

        }
    }

    public void setContenidoAtraccionesFuncionando()
    {
      List<AtraccionIF> atraccFuc1 = new LinkedList<AtraccionIF>();
      for (int i = 0; i < AtraccionesParque.size(); i += 2)
      {
        atraccFuc1.add(AtraccionesParque.get(i));
      }
      atraccionesFuncionando.addAtraccion(new PeriodoTemporada(LocalDate.of(2019, Month.JANUARY, 1), LocalDate.of(2019, Month.MAY, 31)), atraccFuc1);
      List<AtraccionIF> atraccFuc2 = new LinkedList<AtraccionIF>();
      for (int i = 1; i < AtraccionesParque.size(); i += 2)
      {
        atraccFuc2.add(AtraccionesParque.get(i));
      }
      atraccionesFuncionando.addAtraccion(new PeriodoTemporada(LocalDate.of(2019, Month.JUNE, 1), LocalDate.of(2019, Month.DECEMBER, 31)), atraccFuc2);
    }

    public AnalizadorEstadisticas analisisEstadistico()
    {
        AnalizadorEstadisticas analizador = new AnalizadorEstadisticas(EntradasParque, AtraccionesParque, TrabajadoresParque, atraccionesFuncionando);
        return analizador;
    }
}
