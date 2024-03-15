package br.com.fiap.jadv.rm98043checkpoint.cliente.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteCreateDto(
    @NotBlank(message = "O CPF não pode ser nulo.") @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato XXX.XXX.XXX-XX") String cpf,
    @NotBlank(message = "O nome não pode ser nulo") String nome) {
}