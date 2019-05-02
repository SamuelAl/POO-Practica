
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
    atraccionesActivas.put(periodo, atracciones);
  }

  public List<AtraccionIF> getAtracciones(LocalDate fecha)
  {
    for (PeriodoTemporada periodo : atraccionesActivas.keySet())
    {
      if (periodo.enPeriodo(fecha)) {return atraccionesActivas.get(periodo);}
    }
    
    return new LinkedList<AtraccionIF>();
  }


}
