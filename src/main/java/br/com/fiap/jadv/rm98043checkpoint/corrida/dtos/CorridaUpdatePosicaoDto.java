package br.com.fiap.jadv.rm98043checkpoint.corrida.dtos;

import br.com.fiap.jadv.rm98043checkpoint.corrida.coordenada.Coordenada;
import jakarta.validation.Valid;

public record CorridaUpdatePosicaoDto(@Valid Coordenada atual) {

}