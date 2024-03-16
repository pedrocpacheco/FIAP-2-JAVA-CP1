package br.com.fiap.jadv.rm98043checkpoint.corrida.service;

import org.springframework.stereotype.Service;

import br.com.fiap.jadv.rm98043checkpoint.corrida.Corrida;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaCreateDto;

@Service
public interface CorridaService {

  Corrida create(CorridaCreateDto dto);

}
