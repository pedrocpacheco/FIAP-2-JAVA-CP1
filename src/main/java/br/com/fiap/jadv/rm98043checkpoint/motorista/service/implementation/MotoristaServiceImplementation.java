package br.com.fiap.jadv.rm98043checkpoint.motorista.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.jadv.rm98043checkpoint.motorista.Motorista;
import br.com.fiap.jadv.rm98043checkpoint.motorista.MotoristaRepository;
import br.com.fiap.jadv.rm98043checkpoint.motorista.dtos.MotoristaCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.motorista.dtos.MotoristaEncontradoDto;
import br.com.fiap.jadv.rm98043checkpoint.motorista.dtos.MotoristaMapper;
import br.com.fiap.jadv.rm98043checkpoint.motorista.service.MotoristaService;

@Service
public class MotoristaServiceImplementation implements MotoristaService {

  @Autowired
  private MotoristaRepository repository;

  @Override
  public Motorista create(MotoristaCreateDto dto) {
    var motorista = MotoristaMapper.createEntityFromDto(dto);
    return repository.save(motorista);
  }

  public List<MotoristaEncontradoDto> findAll() {
    var dtos = MotoristaMapper.createDtosFromEntities(repository.findAll());
    return dtos;
  }

  public MotoristaEncontradoDto findById(Long id) {
    var entity = repository.findById(id).get();
    var dto = new MotoristaEncontradoDto(entity);

    return dto;
  }

}
