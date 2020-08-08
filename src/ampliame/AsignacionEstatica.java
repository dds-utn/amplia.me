package ampliame;

import java.util.List;

import chatlib.Participante;

public class AsignacionEstatica implements CriterioDeAsignacion {
  //// mapa email/nombre/id usuarie (o incluso el objeto participante) => nombre
  //// de sala
  // attr distribucion: Map[String, string]

  @Override
  public void asignar(Participante participante, List<SalaUnitaria> subsalas) {
    // this.distribucion.values.map( nombreDeSala => new Sala(sala, nombreDeSala))
    //subsalas.find(it => it.nombre == this.distribucion[participante.email])
    // salaParaParticipante(participante,
    //// subsalas).agregarParticipante(participante)
  }

  @Override
  public List<SalaUnitaria> crearSubsalas(SalaPartida aulaPartida) {
    // TODO Auto-generated method stub
    return null;
  }

}
