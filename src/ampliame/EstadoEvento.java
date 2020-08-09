package ampliame;

import java.time.LocalDate;

// Alternativa (un poco menos cohesiva pero válida): podrían haberlo hecho con ifs
public enum EstadoEvento {
  PENDIENTE {
    // asumiento que el cron ejecutará alguna vez antes de la finalización
    public void procesar(Evento evento, LocalDate now) {
      if (evento.inicio.isAfter(now)) {
        evento.activar();
      }
    }
  },
  ACTIVO {
    public void procesar(Evento evento, LocalDate now) {
      if (evento.fin.isAfter(now)) {
        evento.finalizar();
      }
    }
  },
  FINALIZADO {
    public void procesar(Evento evento, LocalDate now) {
    }
  };

  public abstract void procesar(Evento evento, LocalDate now);

}