
/**
 * Clase para generar contenido automatico 
 * para el parque
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
public class GeneradorContenido
{
    public static void generadorContenido(ParqueManager manager)
    {
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


        nTrabajadores = manager.getNumTrabajadores();

        int nAteCl = (int)(nTrabajadores * 0.3);

        for (int i = 0; i < nAteCl; i++)
        {
            manager.addTrabajador(TiposTrabajadores.ATENCION_CL);
        }

        int nRelPubl = (int)(nTrabajadores * 0.1);

        for (int i = 0; i < nRelPubl; i++)
        {
            manager.addTrabajador(TiposTrabajadores.REL_PUBLICAS);
        }

        

    }
}
