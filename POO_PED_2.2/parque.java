
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class parque
{
    
    public static void main (String[] args)
    {
        ParqueManager manager = new ParqueManager();
        
        int nTrabajadores;
        //Crear atracciones
        for (int i = 0; i < 4; i++)
        {
            manager.addAtraccion("A");
        }
        
        for (int i = 0; i < 6; i++)
        {
            manager.addAtraccion("B");
        }
        
        for (int i = 0; i < 4; i++)
        {
            manager.addAtraccion("C");
        }
        
        for (int i = 0; i < 3; i++)
        {
            manager.addAtraccion("D");
        }
        
        for (int i = 0; i < 7; i++)
        {
            manager.addAtraccion("E");
        }
        
        System.out.println("Numero trabajadores: " + manager.getNumTrabajadores());
        
        nTrabajadores = manager.getNumTrabajadores();
        
        int nAteCl = (int)(nTrabajadores* 0.3);
        
        for (int i = 0; i < nAteCl; i++)
        {
            manager.addTrabajador(TiposTrabajadores.ATENCION_CL);
        }
        
        int nRelPubl = (int)(nTrabajadores * 0.1);
        
        for (int i = 0; i < nRelPubl; i++)
        {
            manager.addTrabajador(TiposTrabajadores.REL_PUBLICAS);
        }
        
        System.out.println("Numero trabajadores Atencion : " + manager.getNumTrabajadores(TiposTrabajadores.ATENCION_CL));
        System.out.println("Numero trabajadores Relaciones : " + manager.getNumTrabajadores(TiposTrabajadores.REL_PUBLICAS));
        
    }
}
