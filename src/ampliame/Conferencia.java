package ampliame;

import chatlib.Participante;

public class Conferencia extends SalaUnitaria {

  @Override
  protected void incorporar(Participante participante) {
    participantes.add(participante);
    chat.incorporarConModeracion(participante);
  }

}
