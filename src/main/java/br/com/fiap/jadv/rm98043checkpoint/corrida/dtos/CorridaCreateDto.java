package br.com.fiap.jadv.rm98043checkpoint.corrida.dtos;

import br.com.fiap.jadv.rm98043checkpoint.cliente.Cliente;
import br.com.fiap.jadv.rm98043checkpoint.corrida.coordenada.CoordenadaDto;
import br.com.fiap.jadv.rm98043checkpoint.motorista.Motorista;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CorridaCreateDto(
        @NotNull Cliente cliente,
        @NotNull Motorista motorista,
        @Valid CoordenadaDto inicio,
        @Valid CoordenadaDto fim) {
}