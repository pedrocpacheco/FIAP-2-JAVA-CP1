package br.com.fiap.jadv.rm98043checkpoint.motorista.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record MotoristaCreateDto(
    @NotBlank(message = "O nome não pode ser nulo") String nome,
    @Valid VeiculoDto veiculo) {

}