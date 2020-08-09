package ampliame;

import java.time.LocalDate;
import java.util.List;

import chatlib.Chatlib;
import chatlib.Participante;

public abstract class Sala {

  protected Chatlib chatlib;
  protected Participante anfitrion;
  protected List<Participante> participantes;
  private boolean finalizada;
  private int cupo;

  public void admitir(Participante participante) {
    this.validarCupoDisponible();
    this.incorporar(participante);
  }

  protected abstract void incorporar(Participante participante);

  private void validarCupoDisponible() {
    if (!hayCupoDisponible()) {
      throw new IllegalStateException("no se puede agregar más gente");
    }
  }

  private boolean hayCupoDisponible() {
    return this.participantes.size() < this.cupo;
  }

  void finalizar() {
    this.finalizada = true;
  }

  public double costoConfirmado() {
    if (!this.finalizada) {
      return 0;
    }
    return costoHastaElMomento();
  }

  protected abstract double costoHastaElMomento();

  public abstract void iniciar();
  

}