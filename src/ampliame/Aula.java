package ampliame;

import chatlib.Participante;

public class Aula extends SalaUnitaria {

  @Override
  protected void incorporar(Participante participante) {
    participantes.add(participante);
    chatlib.habilitarVideo(participante);
    chatlib.habilitarPantallaCompartida(participante);
    chat.incorporarSinModeracion(participante);
    
  }

}


