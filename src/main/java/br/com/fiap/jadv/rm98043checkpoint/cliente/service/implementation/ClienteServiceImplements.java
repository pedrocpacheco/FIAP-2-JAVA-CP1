package br.com.fiap.jadv.rm98043checkpoint.cliente.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.jadv.rm98043checkpoint.cliente.Cliente;
import br.com.fiap.jadv.rm98043checkpoint.cliente.ClienteRepository;
import br.com.fiap.jadv.rm98043checkpoint.cliente.dtos.ClienteCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.cliente.dtos.ClienteEncontradoDto;
import br.com.fiap.jadv.rm98043checkpoint.cliente.dtos.ClienteMapper;
import br.com.fiap.jadv.rm98043checkpoint.cliente.service.ClienteService;
import br.com.fiap.jadv.rm98043checkpoint.infra.exceptions.InformacaoExistenteException;

@Service
public class ClienteServiceImplements implements ClienteService {

  @Autowired
  private ClienteRepository repository;

  public Cliente create(ClienteCreateDto dto) {
    if (repository.findByCpf(dto.cpf()) != null)
      throw new InformacaoExistenteException("Cliente com CPF ja existente");

    var cliente = ClienteMapper.createEntityFromDto(dto);
    return repository.save(cliente);
  }

  public List<ClienteEncontradoDto> findAll() {
    var dtos = ClienteMapper.createDtosFromEntities(repository.findAll());
    return dtos;
  }

  public ClienteEncontradoDto findById(Long id) {
    var entity = repository.findById(id).get();
    var dto = new ClienteEncontradoDto(entity.getId(), entity.getCpf(), entity.getNome());
    return dto;
  }

}
