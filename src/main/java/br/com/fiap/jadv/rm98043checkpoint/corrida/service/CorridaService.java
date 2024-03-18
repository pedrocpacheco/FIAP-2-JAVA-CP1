package br.com.fiap.jadv.rm98043checkpoint.corrida.service;

import org.springframework.stereotype.Service;

import br.com.fiap.jadv.rm98043checkpoint.corrida.Corrida;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaAtualizada;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaUpdatePosicaoDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaUpdateSituacao;

@Service
public interface CorridaService {

  Corrida create(CorridaCreateDto dto);

  CorridaAtualizada updateCoordenada(CorridaUpdatePosicaoDto dto, Long id);

  CorridaAtualizada updateSituacao(CorridaUpdateSituacao dto, Long id);

}
