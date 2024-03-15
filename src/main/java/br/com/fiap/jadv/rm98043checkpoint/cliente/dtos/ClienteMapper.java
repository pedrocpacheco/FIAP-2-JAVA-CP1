package br.com.fiap.jadv.rm98043checkpoint.cliente.dtos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.jadv.rm98043checkpoint.cliente.Cliente;

public abstract class ClienteMapper {

  public static Cliente createEntityFromDto(ClienteCreateDto dto) {
    var entity = new Cliente(
        null,
        dto.cpf(),
        dto.nome());
    return entity;
  }

  public static List<ClienteEncontradoDto> createDtosFromEntities(List<Cliente> entities) {
    return entities.stream()
        .map(cliente -> new ClienteEncontradoDto(cliente.getId(), cliente.getCpf(), cliente.getNome()))
        .collect(Collectors.toList());
  }

}
