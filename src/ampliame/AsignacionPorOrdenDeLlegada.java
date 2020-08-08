package ampliame;

import java.util.List;

import chatlib.Participante;

public class AsignacionPorOrdenDeLlegada extends AsignacionDinamica {

  @Override
  public void asignar(Participante participante, List<SalaUnitaria> subsalas) {
    // asignar participante haciendo round robin entre salas
  }

}
