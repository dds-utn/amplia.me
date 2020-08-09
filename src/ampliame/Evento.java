package ampliame;

import java.time.Duration;
import java.time.LocalDate;

public class Evento {

  Sala sala;
  LocalDate inicio;
  LocalDate fin;
  EstadoEvento estado;

  public Evento(Sala sala, LocalDate inicio, LocalDate fin) {
    if (inicio.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("Debe iniciar más tarde");
    }
    if (fin.isAfter(inicio)) {
      throw new IllegalArgumentException("Debe terminar después del inicio");
    }

    this.sala = sala;
    this.inicio = inicio;
    this.fin = fin;
    this.estado = EstadoEvento.PENDIENTE;

    if (this.getDuracionEnMinutos() < 15) {
      throw new IllegalArgumentException("Debe durar al menos 15 minutos");
    }
  }

  private long getDuracionEnMinutos() {
    return Duration.between(inicio, fin).toMinutes();
  }

  public void procesar() {
    LocalDate now = LocalDate.now();
    this.estado.procesar(this, now);
  }

  public boolean vigente() {
    return estado != EstadoEvento.FINALIZADO;
  }

  public boolean pendiente() {
    return estado == EstadoEvento.PENDIENTE;
  }

  public void activar() {
    sala.iniciar();
    estado = EstadoEvento.ACTIVO;
  }

  public void finalizar() {
    sala.finalizar();
    estado = EstadoEvento.FINALIZADO;
  }

  public double costoConfirmado() {
    return sala.costoConfirmado();
  }
}
