
/**
 * Clase con el metodo main del sistema.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */



public class parque
{


    
    
    public static void main (String[] args)
    {
        ParqueManager manager = new ParqueManager();
        MenuInterface menu = new MenuInterface(manager);
        menu.menu1();

    }
    
    
}
