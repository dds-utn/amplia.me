package ampliame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chatlib.Participante;

public class AsignacionAlAzar extends AsignacionDinamica {

  @Override
  public void asignar(Participante participante, List<SalaUnitaria> subsalas) {
    List<SalaUnitaria> candidatas = new ArrayList<>(subsalas);
    Collections.shuffle(candidatas );
    candidatas.get(0).admitir(participante);
  }
}  

