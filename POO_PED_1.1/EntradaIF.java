
/**
 * Write a description of interface Entrada here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
import java.time.*;

public interface EntradaIF
{
    float getPrecio();
    
    LocalDate getDate();
    
    boolean getVIP();
    
    void setVIP();
    
    String getTemporada();
    
    void setTemporada();
    
    boolean getFamilia();
    
    void setFamilia();
    
    void applyDescuento(float descuento);
    
    TiposEntradas getTipo();
    
    // Fusionar con Visitante
    
    int getEdad();
    
}
