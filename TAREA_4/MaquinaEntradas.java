
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
import java.util.HashMap;

public class MaquinaEntradas
{
   private EntradaIF entradaActual;
   private EntradaGen ultimoAdulto;
   private BuscadorDescuentos buscadorDescuentos;
   private Temporadas temporadas;


    /**
     * Constructor for objects of class MaquinaEntradas
     */
    public MaquinaEntradas()
    {
        buscadorDescuentos = new BuscadorDescuentos();
        temporadas = new Temporadas();
    }


    /**
     * Method nuevaEntrada
     * 
     * Crea y devuelve una nueva entrada general
     * EntradaGen
     *
     * @param fecha Fecha de compra
     * @param edad Edad de la persona
     * @param isVIP Si es entrada VIP
     * @param isFamilia Si es entrada Familiar
     * @param descuento Lista de descuentos aplicables
     * @return Nueva entrada (EntradaIF)
     */
    public EntradaIF nuevaEntrada(LocalDate fecha, int edad,
                                boolean isVIP,
                               boolean isFamilia, String descuento)
    {
        EntradaIF entrada = new EntradaGen(fecha, edad, temporadas);
        entrada.setTemporada();
        entradaActual = entrada;
        if (isFamilia) {setFamilia();}
        String tmp[];
        if (!descuento.equals("ninguno"))
        {
            tmp = descuento.split(";");
            for (int i = 0; i < tmp.length; i++)
            {
                setDescuento(tmp[i]);
            }

        }

        if (isVIP) {setVIP();}

        ultimoAdulto = (EntradaGen)entrada;
        //Imprimir informacion entrada
        System.out.println("************************");
        System.out.println("*   ENTRADA PARQUNED");
        System.out.println("* Fecha: " + fecha);
        System.out.println("* Edad: " + edad);
        if (isVIP) {System.out.println("* VIP");}
        if (isFamilia) {System.out.println("* Familiar");}
        System.out.println("* " + entrada.getTipo());
        System.out.println("* Precio: $" + entrada.getPrecio());
        System.out.println("************************");
        System.out.println();
        
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


    /**
     * Method nuevaEntradaNiño
     *
     * Metodo para crear una nueva entrada
     * de niño. Usa el campo ultimo adulto
     * para añadir a la entrada un acompañante
     *
     * @param fecha Fecha de compra
     * @param edad Edad de la persona
     * @param isVIP Si es entrada VIP
     * @param isFamilia Si es entrada Familiar
     * @param descuento Lista de descuentos aplicables
     * @return Nueva entrada (EntradaIF)
     */
    public EntradaIF nuevaEntradaNiño(LocalDate fecha, int edad,
                                boolean isVIP,
                               boolean isFamilia, String descuento)
    {
        if(ultimoAdulto != null)
        {
          EntradaIF entrada = new Niño(fecha, edad, temporadas, ultimoAdulto);
          entrada.setTemporada();
          if (isFamilia) {setFamilia();}

          if (!descuento.equals("ninguno")) {setDescuento(descuento);}
          if (isVIP) {setVIP();}
          
        System.out.println("************************");
        System.out.println("*   ENTRADA PARQUNED");
        System.out.println("* Fecha: " + fecha);
        System.out.print("* Edad: " + edad);
        System.out.println(" - NIÑO ACOMPAÑADO");
        if (isVIP) {System.out.println("* VIP");}
        if (isFamilia) {System.out.println("* Familiar");}
        System.out.println("* " + entrada.getTipo());
        System.out.println("* Precio: $" + entrada.getPrecio());
        System.out.println("************************");
        System.out.println();
          
        return entrada;
        }
        else
        {
          System.out.println("Se necesita un adulto");
          return null;
        }

    }
    
    public HashMap<String, Float> obtenerDescuentosDisponibles()
    {
        return buscadorDescuentos.obtenerDescuentos();
    }





}
