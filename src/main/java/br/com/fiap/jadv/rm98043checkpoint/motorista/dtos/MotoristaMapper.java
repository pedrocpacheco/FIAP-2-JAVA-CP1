package br.com.fiap.jadv.rm98043checkpoint.motorista.dtos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.jadv.rm98043checkpoint.motorista.Motorista;
import br.com.fiap.jadv.rm98043checkpoint.motorista.Veiculo;
import br.com.fiap.jadv.rm98043checkpoint.motorista.veiculo.VeiculoDto;

public abstract class MotoristaMapper {

  public static Motorista createEntityFromDto(MotoristaCreateDto dto) {
    var entity = new Motorista(
        null,
        dto.nome(),
        new Veiculo(
            dto.veiculo().placa(),
            dto.veiculo().descricao(),
            dto.veiculo().cor()),
        null);
    return entity;
  }

  public static List<MotoristaEncontradoDto> createDtosFromEntities(List<Motorista> entities) {
    return entities.stream()
        .map(motorista -> new MotoristaEncontradoDto(motorista.getId(), motorista.getNome(),
            new VeiculoDto(motorista.getVeiculo())))
        .collect(Collectors.toList());
  }

}
