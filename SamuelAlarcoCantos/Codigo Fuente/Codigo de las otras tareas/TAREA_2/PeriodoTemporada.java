
/**
 * Write a description of class PeriodoTemporada here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.time.*;

public class PeriodoTemporada
{
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;


    /**
     * Constructor for objects of class PeriodoTemporada
     */
    public PeriodoTemporada(LocalDate fInicio, LocalDate fFinal)
    {
        fechaInicio = fInicio;
        fechaFinal = fFinal;
    }


    public boolean enPeriodo(LocalDate fecha)
    {
        return !(fecha.isBefore(fechaInicio) || fecha.isAfter(fechaFinal));
    }

    public LocalDate getFechaInic()
    {
      return fechaInicio;
    }

    public LocalDate getFechaFinal()
    {
      return fechaFinal;
    }

    public boolean equals(PeriodoTemporada periodo)
    {
      if (this.fechaInicio == periodo.getFechaInic() && this.fechaFinal == periodo.getFechaFinal())
      {
        return true;
      }
      else
      {
          return false;
      }
    }
}
