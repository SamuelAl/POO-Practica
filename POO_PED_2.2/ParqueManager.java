
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
    private List<AtraccionIF> AtraccionesParque;
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
        AtraccionesParque = new LinkedList<AtraccionIF>();
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
        EntradaIF entrada = generadorEntradas.nuevaEntrada(fecha, edad, 
                                                    isVIP, isFamilia, descuento);
        EntradasParque.add(entrada);
    }
    
    public void addEntrada(LocalDate fecha, int edad,
                           boolean isVIP, boolean isFamilia, 
                           String descuento, EntradaGen acompañante)
    {
        EntradaIF entrada = generadorEntradas.nuevaEntradaNiño(fecha, edad,
                                                    isVIP, isFamilia, descuento,
                                                   acompañante);
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
        AtraccionesParque.add(atraccion);
        for (int i = 0; i < atraccion.getNumRespAtracc(); i++)
        {
            TrabajadoresParque.add(generadorTrabajadores.nuevoTrabajador(TiposTrabajadores.RESP_ATRACC));
        }
        
        for (int i = 0; i < atraccion.getNumAyuAtracc(); i++)
        {
            TrabajadoresParque.add(generadorTrabajadores.nuevoTrabajador(TiposTrabajadores.AYU_ATRACC));
        }
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
    
}
