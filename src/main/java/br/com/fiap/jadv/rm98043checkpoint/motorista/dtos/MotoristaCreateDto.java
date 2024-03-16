package br.com.fiap.jadv.rm98043checkpoint.motorista.dtos;

import br.com.fiap.jadv.rm98043checkpoint.motorista.veiculo.VeiculoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record MotoristaCreateDto(
        @NotBlank(message = "O nome não pode ser nulo") String nome,
        @Valid VeiculoDto veiculo) {

}