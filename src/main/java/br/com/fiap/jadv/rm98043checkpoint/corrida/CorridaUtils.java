package br.com.fiap.jadv.rm98043checkpoint.corrida;

import java.util.Random;

import br.com.fiap.jadv.rm98043checkpoint.corrida.coordenada.Coordenada;

public class CorridaUtils {

  public static Coordenada getAtual(Double latitudeInicio, Double longitudeInicio) {
    Random random = new Random();
    Double latitude;
    Double longitude;
    do {
      latitude = -100 + (200 * random.nextDouble());
      longitude = -100 + (200 * random.nextDouble());
      latitude = (double) Math.round(latitude);
      longitude = (double) Math.round(longitude);
    } while (latitude.equals(latitudeInicio) && longitude.equals(longitudeInicio));
    return new Coordenada(latitude, longitude);
  }

  public static boolean isTransicaoValida(Situacao situacaoAtual, Situacao novaSituacao) {
    switch (situacaoAtual) {
      case AGUARDANDO:
        return novaSituacao == Situacao.CANCELADA || novaSituacao == Situacao.EM_ANDAMENTO;
      case EM_ANDAMENTO:
        return novaSituacao == Situacao.CONCLUIDA;
      default:
        return false;
    }
  }

}
