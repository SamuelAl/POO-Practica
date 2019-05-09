
/**
 * Write a description of class AtraccionesFuncionando here.
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

  public List<AtraccionIF> getAtracciones(LocalDate fecha)
  {
    for (PeriodoTemporada periodo : atraccionesActivas.keySet())
    {
      if (periodo.enPeriodo(fecha)) {return atraccionesActivas.get(periodo);}
    }
    return new LinkedList<AtraccionIF>();
  }

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
