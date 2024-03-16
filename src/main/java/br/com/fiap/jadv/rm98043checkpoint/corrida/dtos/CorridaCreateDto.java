package br.com.fiap.jadv.rm98043checkpoint.corrida.dtos;

import br.com.fiap.jadv.rm98043checkpoint.corrida.coordenada.CoordenadaDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CorridaCreateDto(
        @NotNull Long clienteId,
        @NotNull Long motoristaId,
        @Valid CoordenadaDto inicio,
        @Valid CoordenadaDto fim) {
}