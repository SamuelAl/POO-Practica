
/**
 * Clase principal del programa para almacenar y gestionar
 * los objetos y funcionalidades principales del programa
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
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

    /**
     * Method addEntrada
     * 
     * Crea una nueva entrada (EntradaGen)
     * y la añade a la lista de entradas
     *
     * @param fecha Fecha de compra de la entrada
     * @param edad Edad del visitante
     * @param isVIP Si la entrada es VIP
     * @param isFamilia Si es una entrada familias
     * @param descuento Descuentos aplicados
     */
    public void addEntrada(LocalDate fecha, int edad,
                           boolean isVIP, boolean isFamilia,
                           String descuento)
    {
        EntradaIF entrada = generadorEntradas.nuevaEntrada(fecha, edad,
                                                    isVIP, isFamilia, descuento);
        EntradasParque.add(entrada);
    }
    
    /**
     * Method addEntradaNiño
     * 
     * Crea una nueva entrada tipo niño (Niño)
     * y la añade a la lista de entradas
     *
     * @param fecha Fecha de compra de la entrada
     * @param edad Edad del visitante
     * @param isVIP Si la entrada es VIP
     * @param isFamilia Si es una entrada familias
     * @param descuento Descuentos aplicados
     */
    public void addEntradaNiño(LocalDate fecha, int edad,
                           boolean isVIP, boolean isFamilia,
                           String descuento)
    {
        EntradaIF entrada = generadorEntradas.nuevaEntradaNiño(fecha, edad,
                                                    isVIP, isFamilia, descuento);
        EntradasParque.add(entrada);
    }

    /**
     * Method addTrabajador
     * 
     * Crea y añade un nuevo trabajador del tipo
     * especificado en el parametro
     * 
     * @param tipo Tipo de trabajador (TiposTrabajadores)
     */
    public void addTrabajador(TiposTrabajadores tipo)
    {
        Trabajador trabajador = generadorTrabajadores.nuevoTrabajador(tipo);
        TrabajadoresParque.add(trabajador);
    }

    /**
     * Method addAtraccion
     * 
     * Crea una nueva atraccion y la añade a la lista
     * de atracciones. Tambien se ocupa de crear los trabajdores necesarios 
     * para el uso de la atraccion y los añade a a la lista de trabajadores.
     *
     * @param tipo Tipo de atraccion
     */
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

    /**
     * Method getNumTrabajadores
     * 
     * Devuelve el numero de trabajadores
     * del parque de un cierto tipo
     *
     * @param tipo Tipo de trabajadors
     * @return Numero de trabajadores
     */
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

    /**
     * Method getNumTrabajadores
     * 
     * Devuelve el numero total de trabajadores del parque.
     *
     * @return Total de trabajadores del parque
     */
    public int getNumTrabajadores()
    {
        return TrabajadoresParque.size();
    }

    /**
     * Method getNumVisitantes
     * 
     * Devuelve el total de visitantes
     * del parque
     *
     * @return Total de visitantes del parque
     */
    public int getNumVisitantes()
    {
        return EntradasParque.size();
    }

    /**
     * Method usarAtraccion
     * 
     * Metodo de apoyo para usar una atraccion
     * especifica
     *
     * @param index Referencia a la atraccion en la lista de atracciones (indice)
     * @param entrada Entrada del visitante que usa la atraccion
     */
    public void usarAtraccion(int index, EntradaIF entrada)
    {
        AtraccionesParque.get(index).usar(entrada);
    }

    
    /**
     * Method randomUsarAtracciones
     * 
     * Metodo de apoyo que genera un uso
     * aleatorio de las atracciones del parque
     *
     */
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

    /**
     * Method setContenidoAtraccionesFuncionando
     * 
     * Genera contenido para el objeto clase AtraccionesFuncionando
     * Que despues se usara en las estadisticas
     * Las atracciones funcionando se turnan en dos periodos (mitades del año 2019)
     *
     */
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

    /**
     * Method analisisEstadistico
     * 
     * Crea y devuelve un nuevo objeto AnalizadorEstadisticas
     *
     * @return Objeto AnalizadorEstadisticas
     */
    public AnalizadorEstadisticas analisisEstadistico()
    {
        AnalizadorEstadisticas analizador = new AnalizadorEstadisticas(EntradasParque, AtraccionesParque, TrabajadoresParque, atraccionesFuncionando);
        return analizador;
    }
    
    public HashMap<String, Float> obtenerDescuentos()
    {
        return generadorEntradas.obtenerDescuentosDisponibles();
    }
}
