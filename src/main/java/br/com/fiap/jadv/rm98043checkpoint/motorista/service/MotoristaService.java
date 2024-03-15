package br.com.fiap.jadv.rm98043checkpoint.motorista.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.jadv.rm98043checkpoint.motorista.Motorista;
import br.com.fiap.jadv.rm98043checkpoint.motorista.dtos.MotoristaCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.motorista.dtos.MotoristaEncontradoDto;

@Service
public interface MotoristaService {

  Motorista create(MotoristaCreateDto dto);

  List<MotoristaEncontradoDto> findAll();

  MotoristaEncontradoDto findById(Long id);

}