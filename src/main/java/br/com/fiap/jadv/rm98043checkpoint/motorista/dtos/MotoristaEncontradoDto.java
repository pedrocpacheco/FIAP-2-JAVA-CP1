package br.com.fiap.jadv.rm98043checkpoint.motorista.dtos;

import br.com.fiap.jadv.rm98043checkpoint.motorista.Motorista;
import br.com.fiap.jadv.rm98043checkpoint.motorista.veiculo.VeiculoDto;
import jakarta.validation.Valid;

public record MotoristaEncontradoDto(
    Long id,
    String nome,
    @Valid VeiculoDto veiculo) {

  public MotoristaEncontradoDto(Motorista entity) {
    this(entity.getId(), entity.getNome(), new VeiculoDto(entity.getVeiculo()));
  }
}
