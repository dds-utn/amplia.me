package ampliame;

import java.util.List;
import java.util.stream.Stream;

import chatlib.Chat;
import chatlib.Conexion;
import chatlib.ConexionDePantalla;
import chatlib.ConexionDeVideo;

public abstract class SalaUnitaria extends Sala {
  List<ConexionDePantalla> conexionesDePantalla;
  List<ConexionDeVideo> conexionesDeVideo;
  Chat chat;
  
  @Override
  public void iniciar() {
    // registrar el momento de inicio de la sala
    this.chatlib.habilitarVideo(this.anfitrion);
  }
  
  @Override
  void finalizar() {
    // registrar el momento de finalizacion de la sala
    super.finalizar();
    this.conexiones().forEach(it -> it.destruir());
    this.chat.cerrar();
  }

  private Stream<Conexion> conexiones() {
    return Stream.concat(conexionesDePantalla.stream(), conexionesDeVideo.stream());
  }

  @Override
  protected double costoHastaElMomento() {
   throw new UnsupportedOperationException("calcular el costo en funcion tiempo que estuvo prendido"); 
  }
  
  
}

 