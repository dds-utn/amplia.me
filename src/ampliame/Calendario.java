package ampliame;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.List;

// alternativa (válida pero no tan correcta semanticamente y menos flexible): podrían crear un repositorio
// de eventos
public class Calendario {
  
  private List<Evento> eventos;
  private double costoConfirmado;

  void programar(Sala sala, LocalDate inicio, LocalDate fin) {
    this.eventos.add(new Evento(sala, inicio, fin));
  }
  
  // deben llamar este método desde el cron
  void procesar() {
    eventos.forEach(it -> it.procesar());
    
    // opcional:  esto podria ser un método calculado segun como lo implementen
    costoConfirmado += eventos.stream().mapToDouble(it -> it.costoConfirmado()).sum();
    
    // opcional: para descargar la memoria y aligerar el proceso
    // también podrían moverlo a otra lista
    eventos = eventos.stream().filter(it -> it.vigente()).collect(toList());
  }
  
  public int cantidadProximosEventos() {
    return (int) this.eventos.stream().filter(it -> it.pendiente()).count();
  }
  
  public double costoConfirmado() {
    return costoConfirmado;
  }

}
