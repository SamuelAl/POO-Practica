
/**
 * Write a description of class Niño here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.time.*;

public class Niño implements EntradaIF
{
    private float precio;
    private HashMap<String, Float> descuentosApl;
    private EntradaGen acompañante;
    
    private LocalDate fecha;
    private int edad;
    
    private boolean isVIP;
    private boolean isFamilia;
    private String temporada;
    
    private Temporadas temporadas = new Temporadas();

    /**
     * Constructor for objects of class Niño
     */
    public Niño(LocalDate fecha ,int edad, EntradaGen acompañante)
    {
        this.fecha = fecha;
        this.edad = edad;
        this.acompañante = acompañante;
        precio = PARAMETROS.PRECIO_BASE * ((100 - PARAMETROS.DESCUENTO_NIÑO)/100);
        descuentosApl.put("niño", PARAMETROS.DESCUENTO_NIÑO);
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
    
    public float getPrecio()
    {
        return precio;
    }
    
    public void applyDescuento(String tipo ,float descuento)
    {
        precio = precio * ((100 - descuento)/100);
        descuentosApl.put(tipo, descuento);
    }
    
    public EntradaGen getAcompañante()
    {
        return acompañante;
    }
    
    public String getTipo()
    {
        return "Niño";
    }
    
    protected HashMap<String, Float> getDescuentos()
    {
        return descuentosApl;
    }
    
     public LocalDate getDate()
    {
        return this.fecha;
    }
    
    public boolean getVIP()
    {
        return this.isVIP;
    }
    
    public void setVIP()
    {
        isVIP = true;
        if (isVIP) 
        {
            if (getDescuentos().get("senior") != null)
            {
                precio += (precio * (0.83333));
            } else if (getDescuentos().get("niño") != null)
            {
                precio += (precio * (0.83333));
            } else 
            {
                precio += PARAMETROS.PRECIO_VIP_BASE;
            }
        }
    }
    
    public String getTemporada()
    {
        return this.temporada;
    }
    
    public void setTemporada()
    {
        this.temporada = temporadas.checkTemporada(fecha);
        precio = precio * (temporadas.get(temporada) / 100);
    }
    
    public boolean getFamilia()
    {
        return this.isFamilia;
    }
    
    public void setFamilia()
    {
        isFamilia = true;
        if (isFamilia) 
        {
            precio = precio * ((100 - PARAMETROS.DESCUENTO_FAMILIA) / 100);
        }
    }
}
