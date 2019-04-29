
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
   private EntradaIF entradaActual;
   private EntradaGen ultimoAdulto;
   private BuscadorDescuentos buscadorDescuentos;
   

    /**
     * Constructor for objects of class MaquinaEntradas
     */
    public MaquinaEntradas()
    {
        buscadorDescuentos = new BuscadorDescuentos();
    }

    
    public EntradaIF nuevaEntrada(LocalDate fecha, int edad, 
                                boolean isVIP, 
                               boolean isFamilia, String descuento)
    {
        EntradaIF entrada = new EntradaGen(fecha, edad);
        entrada.setTemporada();
        entradaActual = entrada;
        
        if (isVIP) {setVIP();}
        if (isFamilia) {setFamilia();}
        if (!descuento.equals("ninguno")) 
        {
            String tmp[] = descuento.split(",");
            for (int i = 0; i < tmp.length; i++)
            {
                setDescuento(tmp[i]);
            }
            
        }
        ultimoAdulto = (EntradaGen)entrada;
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
    
    private void setDescuento(String descuento)
    {
        float fDescuento =  buscadorDescuentos.getDescuento(descuento);
        entradaActual.applyDescuento(descuento, fDescuento);
    }
    
    
    public EntradaIF nuevaEntradaNiño(LocalDate fecha, int edad, 
                                boolean isVIP, 
                               boolean isFamilia, String descuento)
    {
        EntradaIF entrada = new Niño(fecha, edad, ultimoAdulto);
        entrada.setTemporada();
        
        if (isVIP) {setVIP();}
        if (isFamilia) {setFamilia();}
        if (!descuento.equals("ninguno")) {setDescuento(descuento);}
        return entrada;
    }
    
    
    
    
    
}
