
/**
 * Clase MaquinaEntradas: se encarga de gestionar la asignacion
 * de entradas a cada visitante, gestionando la aplicacion de
 * descuentos y la seleccion de la entrada apropiada para cada
 * visitante
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.time.LocalDate;

public class MaquinaEntradas
{
   private Entrada entradaActual;
   

    /**
     * Constructor for objects of class MaquinaEntradas
     */
    public MaquinaEntradas()
    {
    }

    
    public Entrada nuevaEntrada(LocalDate fecha, int edad, 
                               TiposEntradas tipo, boolean isVIP, 
                               boolean isFamilia, float descuento)
    {
        Entrada entrada = entradaFactory(tipo, fecha, edad);
        entrada.setTemporada();
        entradaActual = entrada;
        
        if (isVIP) {setVIP();}
        if (isFamilia) {setFamilia();}
        if (descuento > 0) {setDescuento(descuento);}
        return entrada;
    }
    
    private void setFamilia()
    {
        if (entradaActual != null)
        {
            entradaActual.setFamilia();
        }
    }
    
    private void setVIP()
    {
        if (entradaActual != null)
        {
            entradaActual.setVIP();
        }
    }
    
    private void setDescuento(float descuento)
    {
        entradaActual.applyDescuento(descuento);
    }
    
    
    public Entrada nuevaEntradaNiño(LocalDate fecha, int edad, 
                               TiposEntradas tipo, boolean isVIP, 
                               boolean isFamilia, float descuento, 
                               Entrada acompañante)
    {
        Entrada entrada = new Niño(fecha, edad, acompañante);
        entrada.setTemporada();
        
        if (isVIP) {setVIP();}
        if (isFamilia) {setFamilia();}
        if (descuento > 0) {setDescuento(descuento);}
        return entrada;
    }
    
    private Entrada entradaFactory(TiposEntradas tipo, LocalDate fecha, int edad)
    {
        Entrada entrada;
        switch (tipo)
        {
            case ESTUDIANTE:
                entrada = new NormalAdulto(fecha, edad);
                break;
            case DISCAPACITADO:
                entrada = new Discapacitado(fecha, edad);
                break;
            case DESEMPLEADO:
                entrada = new Desempleado(fecha, edad);
                break;
            case SENIOR:
                entrada = new Senior(fecha, edad);
                break;
            default:
                entrada = new NormalAdulto(fecha, edad);
        }
        return entrada;
    }
    
    
    
}
