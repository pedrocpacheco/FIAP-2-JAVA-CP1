package br.com.fiap.jadv.rm98043checkpoint.corrida.service;

import org.springframework.stereotype.Service;

import br.com.fiap.jadv.rm98043checkpoint.corrida.Corrida;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaPosicaoAtualizadaDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaUpdatePosicaoDto;

@Service
public interface CorridaService {

  Corrida create(CorridaCreateDto dto);

  CorridaPosicaoAtualizadaDto updateCoordenada(CorridaUpdatePosicaoDto dto, Long id);

}
