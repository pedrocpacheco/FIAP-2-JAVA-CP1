package br.com.fiap.jadv.rm98043checkpoint.corrida.dtos;

import java.util.Date;

import br.com.fiap.jadv.rm98043checkpoint.corrida.Corrida;
import br.com.fiap.jadv.rm98043checkpoint.corrida.Situacao;
import br.com.fiap.jadv.rm98043checkpoint.corrida.coordenada.Coordenada;

public record CorridaPosicaoAtualizadaDto(
        Long id,
        Situacao situacao,
        Date dataInicio,
        Date dataFim,
        Coordenada inicio,
        Coordenada atual,
        Coordenada fim) {

    public CorridaPosicaoAtualizadaDto(Corrida entity) {
        this(entity.getId(), entity.getSituação(), entity.getDataInicio(), entity.getDataFim(), entity.getInicio(),
                entity.getAtual(), entity.getFim());
    }
}
