
/**
 * Write a description of interface Entrada here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
import java.util.Date;

public interface EntradaIF
{
    float getPrecio();
    
    Date getDate();
    
    boolean getVIP();
    
    void setVIP();
    
    String getTipo();
    
    void setTipo(String tipo);
    
    boolean getFamilia();
    
    void setFamilia();
    
    void applyDescuento(float descuento);
}
