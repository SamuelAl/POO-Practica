
/**
 * Interfaz principal de las entradas, con
 * toda la funcionalidad necesaria.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
import java.time.*;

public interface EntradaIF
{
    /**
     * Method getPrecio
     * 
     * Metodo que devuelve el precio 
     * de la entrada
     *
     * @return Precio de la entrada
     */
    float getPrecio();
    
    /**
      * Method getDate
      * 
      * Devuelve la fecha de compra
      * de la entrada
      *
      * @return Fecha de la compra (LocalDate)
      */
    LocalDate getDate();
    
    /**
     * Method getVIP
     * 
     * Indica si la entrada es una
     * entrada VIP o no
     *
     * @return True si la entrada es VIP
     */
    boolean getVIP();
    
    /**
     * Method setVIP
     * 
     * Convierte entrada en entrada VIP
     * Utiliza porcentajes especificados en el 
     * enunciado para calcular el precio de
     * la entrada VIP para niños y seniors
     *
     */
    void setVIP();
    
    /**
     * Method getTemporada
     * 
     * Devuelve la temporada en la que se ha
     * comprado la entrada
     *
     * @return Temporada en la que se ha comprado la entrada (String)
     */
    String getTemporada();
    
    /**
     * Method setTemporada
     * 
     * Metodo para que la entrada calcule 
     * la temporada en la que se compra
     * a partir de la lista de temporadas suministrada
     * por la MaquinaEntradas
     *
     */
    void setTemporada();
    
     /**
     * Method getFamilia
     * 
     * Indica si la entrada es una entrada
     * familiar o no
     *
     * @return True: Si la entrada es familiar
     */
    boolean getFamilia();
    
    /**
     * Method setFamilia
     * 
     * Convierte la entrada en una entrada familiar, 
     * aplicando el descuento apropiado
     *
     */
    void setFamilia();
    
    /**
     * Method applyDescuento
     * 
     * Metodo para aplicar descuentos a la 
     * entrada, modificando el precio.
     *
     * @param tipo Identificador del descuento en formato string
     * @param descuento Valor del descuento (porcentaje)
     */
    void applyDescuento(String tipo, float descuento);
    
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
    String getTipo();
    
    /**
     * Metodo getter que devuelve edad del visitante
     *
     * @return    edad del visitante
     */
    int getEdad();
    
}
