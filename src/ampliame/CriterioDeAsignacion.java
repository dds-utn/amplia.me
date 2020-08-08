package ampliame;

import java.util.List;

import chatlib.Participante;

public interface CriterioDeAsignacion {

  void asignar(Participante participante, List<SalaUnitaria> subsalas);

  List<SalaUnitaria> crearSubsalas(SalaPartida aulaPartida);

}
