package chatlib;

public interface Chat {

  void incorporarConModeracion(Participante participante);
  void incorporarSinModeracion(Participante participante);
  void cerrar();

}
