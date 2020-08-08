package ampliame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AsignacionDinamica implements CriterioDeAsignacion {

  int cantidadDeSalas;

  @Override
  public List<SalaUnitaria> crearSubsalas(SalaPartida aulaPartida) {
    return IntStream.of(this.cantidadDeSalas).mapToObj((it) -> new Aula()).collect(Collectors.toList());
  }

}
