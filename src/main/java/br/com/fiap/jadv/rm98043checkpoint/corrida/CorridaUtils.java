package br.com.fiap.jadv.rm98043checkpoint.corrida;

import java.util.Random;

import br.com.fiap.jadv.rm98043checkpoint.corrida.coordenada.Coordenada;

public class CorridaUtils {

  public static Coordenada getAtual(Double latitudeInicio, Double longitudeInicio) {
    Random random = new Random();
    Double latitude;
    Double longitude;
    do {
      latitude = (double) (random.nextInt(201) - 100);
      longitude = (double) (random.nextInt(201) - 10);
    } while (latitude.equals(latitudeInicio) && longitude.equals(longitudeInicio));
    return new Coordenada(latitude, longitude);
  }
}
