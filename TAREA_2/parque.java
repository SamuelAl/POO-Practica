
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

        System.out.println("Bienvenido a Parque de Atracciones PARQUNED");
        System.out.println();
        System.out.println();
        
        GeneradorVisitantes.generarVisitantes(manager);

        AnalizadorEstadisticas analizador = manager.analisisEstadistico();

        GeneradorContenido.generadorContenido(manager);

        System.out.println("Generando Atracciones....");
        
        
        System.out.println("Estructuras Generadas: ");
        System.out.println();
        analizador.resumenAtracciones();
        System.out.println();
        System.out.println("Resumen Trabajadores: ");
        System.out.println();
        System.out.println("Ayudantes de Atraccion: " + analizador.resumenTrabajadoresTipo(TiposTrabajadores.AYU_ATRACC));
        System.out.println("Responsables de Atraccion: " + analizador.resumenTrabajadoresTipo(TiposTrabajadores.RESP_ATRACC));
        System.out.println("Atencion al Cliente: " + analizador.resumenTrabajadoresTipo(TiposTrabajadores.ATENCION_CL));
        System.out.println("Relaciones Publicas: " + analizador.resumenTrabajadoresTipo(TiposTrabajadores.REL_PUBLICAS));
        System.out.println();
        System.out.println("Importando Visitantes del archivo Visitantes.txt ...");
        System.out.println();
        analizador.resumenVisitantesTipo();
        System.out.println("======================================");

        

    }
}
