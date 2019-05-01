
/**
 * Write a description of class AtraccionesFuncionando here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;

public class AtraccionesFuncionando
{

    private List<AtraccionIF> atracciones;

    public AtraccionesFuncionando()
    {
        atracciones = new LinkedList<AtraccionIF>();
    }


  public void addAtraccion(AtraccionIF atraccion)
  {
    atracciones.add(atraccion);
  }

  public List getAtracciones()
  {
    return atracciones;
  }
}
