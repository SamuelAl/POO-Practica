
/**
 * Clase principal del programa para almacenar y gestionar
 * los objetos y funcionalidades principales del programa
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
import java.time.*;;

public class ParqueManager

{
    private List<Atraccion> AtraccionesParque;
    private List<Trabajador> TrabajadoresParque;
    private List<EntradaIF> EntradasParque;
    private MaquinaEntradas generadorEntradas;
    private CreadorTrabajadores generadorTrabajadores;
    private CreadorAtracciones generadorAtracciones;
    /**
     * Constructor for objects of class Parque
     */
    public ParqueManager()
    {
        AtraccionesParque = new LinkedList<Atraccion>();
        TrabajadoresParque = new LinkedList<Trabajador>();
        EntradasParque = new LinkedList<EntradaIF>();
        generadorEntradas = new MaquinaEntradas();
        generadorTrabajadores = new CreadorTrabajadores();
        generadorAtracciones = new CreadorAtracciones();
        
    }

    public void addEntrada(LocalDate fecha, int edad,
                           boolean isVIP, boolean isFamilia, 
                           String descuento)
    {
        Entrada entrada = generadorEntradas.nuevaEntrada(fecha, edad, 
                                                    isVIP, isFamilia, descuento);
        EntradasParque.add(entrada);
    }
    
    public void addEntrada(LocalDate fecha, int edad,
                           boolean isVIP, boolean isFamilia, 
                           String descuento, Entrada acompañante)
    {
        Entrada entrada = generadorEntradas.nuevaEntradaNiño(fecha, edad,
                                                    isVIP, isFamilia, descuento,
                                                   acompañante);
        EntradasParque.add(entrada);
    }
    
    public void addTrabajador(TiposTrabajadores tipo)
    {
        Trabajador trabajador = generadorTrabajadores.nuevoTrabajador(tipo);
        TrabajadoresParque.add(trabajador);
    }
    
    public void addAtraccion(String tipo, boolean accesoVIP, float minAlturaCM,
                            int minEdad, boolean accesoNiños, int numRespAtracc,
                            int numAyuAtracc)
    {
        Atraccion atraccion = generadorAtracciones.nuevaAtraccion(tipo, accesoVIP, minAlturaCM,
                            minEdad, accesoNiños, numRespAtracc,
                            numAyuAtracc);
        AtraccionesParque.add(atraccion);
        for (int i = 0; i < atraccion.getNumRespAtracc(); i++)
        {
            TrabajadoresParque.add(generadorTrabajadores.nuevoTrabajador(TiposTrabajadores.RESP_ATRACC));
        }
        
        for (int i = 0; i < atraccion.getNumAyuAtracc(); i++)
        {
            TrabajadoresParque.add(generadorTrabajadores.nuevoTrabajador(TiposTrabajadores.RESP_ATRACC));
        }
    }
    
}
