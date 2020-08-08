package ampliame;

import java.util.List;

import chatlib.Chat;
import chatlib.ConexionDePantalla;
import chatlib.ConexionDeVideo;

public abstract class SalaUnitaria extends Sala {
  List<ConexionDePantalla> conexionesDePantalla;
  List<ConexionDeVideo> conexionesDeVideo;
  Chat chat;

  @Override
  public void iniciar() {
    this.chatlib.habilitarVideo(this.anfitrion);
  }

  @Override
  protected double costoHastaElMomento() {
   throw new UnsupportedOperationException("uninmplemented"); 
  }
}

 