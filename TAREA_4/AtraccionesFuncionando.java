/**
 * Clase AtraccionesFuncionando, que almacena y suministra
 * las atracciones activas en determinadas fechas del año.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.time.*;

public class AtraccionesFuncionando
{

    private HashMap<PeriodoTemporada, List<AtraccionIF> > atraccionesActivas;

    public AtraccionesFuncionando()
    {
        atraccionesActivas = new HashMap<PeriodoTemporada, List<AtraccionIF> >();
    }

    
  /**
   * Metodo addAtraccion
   * 
   * Metodo para añadir listas de atracciones
   * activas para un determinado periodo del año
   *
   * @param periodo Periodo en que las atracciones de la lista estaran activas
   * @param atracciones Lista de atracciones activas durante dicho periodo
   */
  public void addAtraccion(PeriodoTemporada periodo, List<AtraccionIF> atracciones)
  {
    PeriodoTemporada key = buscarPeriodo(periodo);
    if (key != null)
    {
      for (AtraccionIF atraccion : atracciones)
      {
        List<AtraccionIF> nuevaLista = new LinkedList<AtraccionIF>(atraccionesActivas.get(periodo));
        nuevaLista.add(atraccion);
        atraccionesActivas.put(periodo, nuevaLista);
      }
    }
    else
    {
      if (!buscarCoincidencias(periodo))
      {
        atraccionesActivas.put(periodo, atracciones);
      }
      else
      {
          System.out.println("Error: Coincidencia de fechas");
      }

    }
  }

  /**
   * Metodo getAtracciones
   * 
   * Metodo que devuelve una lista de atracciones activas
   * en la fecha dada.
   *
   * @param fecha Fecha en la que se buscan atracciones activas
   * @return Lista de atracciones activas para dicha fecha
   */
  public List<AtraccionIF> getAtracciones(LocalDate fecha)
  {
    for (PeriodoTemporada periodo : atraccionesActivas.keySet())
    {
      if (periodo.enPeriodo(fecha)) {return atraccionesActivas.get(periodo);}
    }
    return new LinkedList<AtraccionIF>();
  }

  /**
   * Metodo buscarPeriodo
   * 
   * Metodo privado para verificar si un periodo dado existe
   *
   * @param periodo Periodo que se debe buscar en el HashMap
   * @return True: si periodo encontrada; False: si periodo no existen en el HashMap
   */
  private PeriodoTemporada buscarPeriodo(PeriodoTemporada periodo)
  {
    if (!atraccionesActivas.isEmpty())
    {
      for (PeriodoTemporada key : atraccionesActivas.keySet())
      {
        if (key.equals(periodo))
        {
          return key;
        }
      }
      return null;
    }
    else
    {
      return null;
    }
  }

  /**
   * Metodo buscarCoincidencias
   * 
   * Metodo para verificar si periodo dado coincide con
   * otros periodos en existentes en el HashMap
   *
   * @param periodo Periodo para la busqueda
   * @return True: Si existe coincidendia; False: Si no se encuentra coincidencia
   */
  private boolean buscarCoincidencias(PeriodoTemporada periodo)
  {
    for (PeriodoTemporada key : atraccionesActivas.keySet())
    {
      if (key.enPeriodo(periodo.getFechaInic())
          || key.enPeriodo(periodo.getFechaFinal())
          || ((key.getFechaInic().compareTo(periodo.getFechaInic()) < 0) && (key.getFechaFinal().compareTo(periodo.getFechaFinal()) > 0)))
          {
            return true;
          }
    }
    return false;
  }


}
