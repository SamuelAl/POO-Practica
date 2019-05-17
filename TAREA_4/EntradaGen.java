
/**
 * Implementacion general de la interfaz EntradaIF.
 * Ofrece la funcionalidad general de las entradas
 * del parque de atracciones
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.HashMap;
import java.time.*;
import java.math.BigDecimal;

public class EntradaGen implements EntradaIF
{
    // instance variables - replace the example below with your own
    protected HashMap<String, Float> descuentosApl;
    protected float precio;
    protected float descuentoTotal;
    
    private LocalDate fecha;
    private int edad;
    
    private boolean isVIP;
    private boolean VIPAplicado = false;
    private boolean isFamilia;
    private String temporada;
    
    private Temporadas temporadas;
    
    /**
     * Constructor for objects of class EntradaGen
     */
    public EntradaGen(LocalDate fecha, int edad, Temporadas temporadas)
    {
        this.fecha = fecha;
        this.edad = edad;
        precio = PARAMETROS.PRECIO_BASE;
        descuentosApl = new HashMap<String, Float>();
        this.temporadas = temporadas;
    }
    
    /**
     * Metodo getter que devuelve edad del visitante
     *
     * @return    edad del visitante
     */
    public int getEdad()
    {
        // return edad
        return this.edad;
    }
    
    /**
     * Method getPrecio
     * 
     * Metodo que devuelve el precio 
     * de la entrada
     *
     * @return Precio de la entrada
     */
    public float getPrecio()
    {
        return round(precio, 2);
    }
    
    /**
     * Method applyDescuento
     * 
     * Metodo para aplicar descuentos a la 
     * entrada, modificando el precio.
     *
     * @param tipo Identificador del descuento en formato string
     * @param descuento Valor del descuento (porcentaje)
     */
    public void applyDescuento(String tipo ,float descuento)
    {
        if (descuentoTotal < 90)
        {
            precio = precio * ((100 - descuento)/100);
            descuentosApl.put(tipo, descuento);
            descuentoTotal += descuento;
        }
        else
        {
            System.out.println("No se pueden aplicar mas descuentos");
        }
    }

    /**
     * Method getTipo
     * 
     * Devuelve un objeto string con el 
     * tipo de entrada. Esto se construye a partir
     * de los descuentos aplicados, que identifican
     * la entrada
     *
     * @return El tipo de entrada
     */
    public String getTipo()
    {
        String tipos = "";
        if (descuentosApl.isEmpty())
        {
            tipos = "adulto";
        }
        
        else
        {
            for (String key : descuentosApl.keySet())
            {
                tipos += key + " - ";
            }
            tipos = tipos.substring(0, tipos.length()-3);
        }
        
        return tipos;
    }
    
    
     /**
      * Method getDate
      * 
      * Devuelve la fecha de compra
      * de la entrada
      *
      * @return Fecha de la compra (LocalDate)
      */
     public LocalDate getDate()
    {
        return this.fecha;
    }
    
    /**
     * Method getVIP
     * 
     * Indica si la entrada es una
     * entrada VIP o no
     *
     * @return True si la entrada es VIP
     */
    public boolean getVIP()
    {
        return this.isVIP;
    }
    
    /**
     * Method setVIP
     * 
     * Convierte entrada en entrada VIP
     * Utiliza porcentajes especificados en el 
     * enunciado para calcular el precio de
     * la entrada VIP para niños y seniors
     *
     */
    public void setVIP()
    {
        isVIP = true;
        if (!VIPAplicado) 
            {
                if (descuentosApl.containsKey("senior"))
                {
                    precio += (precio * (0.83333));
                } else if (descuentosApl.containsKey("niño"))
                {
                    System.out.println("descuento niño");
                    precio += (precio * (0.83333));
                } else 
                {
                    precio += PARAMETROS.PRECIO_VIP_BASE;
                }
                
                VIPAplicado = true;
            }
    }
    
    /**
     * Method getTemporada
     * 
     * Devuelve la temporada en la que se ha
     * comprado la entrada
     *
     * @return Temporada en la que se ha comprado la entrada (String)
     */
    public String getTemporada()
    {
        return this.temporada;
    }
    
    /**
     * Method setTemporada
     * 
     * Metodo para que la entrada calcule 
     * la temporada en la que se compra
     * a partir de la lista de temporadas suministrada
     * por la MaquinaEntradas
     *
     */
    public void setTemporada()
    {
        this.temporada = temporadas.checkTemporada(fecha);
        precio = precio * (temporadas.get(temporada) / 100);
    }
    
    /**
     * Method getFamilia
     * 
     * Indica si la entrada es una entrada
     * familiar o no
     *
     * @return True: Si la entrada es familiar
     */
    public boolean getFamilia()
    {
        return this.isFamilia;
    }
    
    /**
     * Method setFamilia
     * 
     * Convierte la entrada en una entrada familiar, 
     * aplicando el descuento apropiado
     *
     */
    public void setFamilia()
    {
        isFamilia = true;
        if (isFamilia) 
            {
                applyDescuento("Familia" ,PARAMETROS.DESCUENTO_FAMILIA);
            }
    }
    
    /**
     * Method round
     *
     * Metodo para redondear valores float a dos decimales
     *
     * @param d Valor a redondear (float)
     * @param decimalPlace Numero de decimales (entero)
     * @return Valor redondeado (float)
     */
    private float round(float d, int decimalPlace)
    {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
