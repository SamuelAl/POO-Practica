
/**
 * Clase MaquinaEntradas: se encarga de gestionar la asignacion
 * de entradas a cada visitante, gestionando la aplicacion de
 * descuentos y la seleccion de la entrada apropiada para cada
 * visitante
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.Date;

public class MaquinaEntradas
{
   private Visitante visitanteActual;
   private Visitante acompañanteActual;

    /**
     * Constructor for objects of class MaquinaEntradas
     */
    public MaquinaEntradas()
    {
    }

    public void nuevoAdulto(int edad, String dni)
    {
        visitanteActual = new Adulto(edad, dni);
    }
    
    public void setEstudiante()
    {
        if (visitanteActual instanceof Adulto)
        {
            ((Adulto) visitanteActual).setEstudiante();
        }
    }
    
    public void setDiscapacitado()
    {
        if (visitanteActual instanceof Adulto)
        {
            ((Adulto) visitanteActual).setDescapacitado();
        }
    }
    
    public void setDesempleado()
    {
        if (visitanteActual instanceof Adulto)
        {
            ((Adulto) visitanteActual).setDesempleado();
        }
    }
    
    public void nuevoSenior(int edad, String dni)
    {
        visitanteActual = new Senior(edad, dni);
    }
    
    public void setAcompañanteActual()
    {
        if (visitanteActual instanceof Adulto || visitanteActual instanceof Senior)
        {
            acompañanteActual = visitanteActual;
        }
    }
    
    public void nuevoNiño(int edad)
    {
        visitanteActual = new Niño(edad);
    }
    
    public void setAcompañante()
    {
        if (visitanteActual instanceof Niño)
        {
            ((Niño) visitanteActual).setAcompañante(acompañanteActual);
        }
    }
    
    public void nuevaEntrada(Date fecha, float descuento, String tipo, boolean isVIP, boolean isFamilia)
    {
        EntradaIF entrada = new Entrada(fecha);
        entrada.setTipo(tipo);
        if (isVIP)
        {
            entrada.setVIP();
        }
        if (isFamilia)
        {
            entrada.setFamilia();
        }
        
        if (descuento > 0)
        {
            entrada.applyDescuento(descuento);
        }
        
        // Se le asigna nueva entrada al visitante
        visitanteActual.comprarEntrada(entrada);
    }
    
    
    
}
