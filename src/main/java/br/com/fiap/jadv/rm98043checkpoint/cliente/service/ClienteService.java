package br.com.fiap.jadv.rm98043checkpoint.cliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.jadv.rm98043checkpoint.cliente.Cliente;
import br.com.fiap.jadv.rm98043checkpoint.cliente.dtos.ClienteCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.cliente.dtos.ClienteEncontradoDto;

@Service
public interface ClienteService {

  public Cliente create(ClienteCreateDto dto);

  List<ClienteEncontradoDto> findAll();

  public ClienteEncontradoDto findById(Long id);

}
