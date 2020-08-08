package ampliame;

import java.util.List;

import chatlib.Participante;

public class SalaPartida extends Sala {

  private List<SalaUnitaria> subsalas;
  private CriterioDeAsignacion criterioDeAsignacion;

  @Override
  public void iniciar() {
    this.subsalas = this.criterioDeAsignacion.crearSubsalas(this);
    this.subsalas.forEach(it -> it.iniciar());
  }

  @Override
  protected void incorporar(Participante participante) {
    this.criterioDeAsignacion.asignar(participante, this.subsalas);
  }

  @Override
  public double costoHastaElMomento() {
    return subsalas.stream().mapToDouble(it -> it.costoHastaElMomento()).sum();
  }
}