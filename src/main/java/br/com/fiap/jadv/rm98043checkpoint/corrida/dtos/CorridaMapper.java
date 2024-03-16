package br.com.fiap.jadv.rm98043checkpoint.corrida.dtos;

import br.com.fiap.jadv.rm98043checkpoint.corrida.Corrida;
import br.com.fiap.jadv.rm98043checkpoint.corrida.Situacao;
import br.com.fiap.jadv.rm98043checkpoint.corrida.coordenada.Coordenada;

public abstract class CorridaMapper {

  public static Corrida createEntityFromDto(CorridaCreateDto dto) {
    System.out.println(dto.cliente().getCpf());
    var entity = new Corrida(
        null,
        null,
        null,
        Situacao.AGUARDANDO,
        dto.cliente(),
        dto.motorista(),
        new Coordenada(dto.inicio().latitude(), dto.inicio().latitude()),
        null,
        new Coordenada(dto.fim().latitude(), dto.fim().longitude()));
    return entity;
  }

}
