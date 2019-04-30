
/**
 * Write a description of class main here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
public class parque
{
    
    public static void main (String[] args)
    {
        ParqueManager manager = new ParqueManager();
        
        GeneradorContenido.generadorContenido(manager);
        
        AnalizadorEstadisticas analizador = manager.analisisEstadistico();
        analizador.analizarFechas();
    }
}
