package br.com.fiap.jadv.rm98043checkpoint.corrida.dtos;

import br.com.fiap.jadv.rm98043checkpoint.corrida.Situacao;
import jakarta.validation.constraints.NotNull;

public record CorridaUpdateSituacao(
    @NotNull(message = "Situacao nao pode ser nula") Situacao situacao) {
}