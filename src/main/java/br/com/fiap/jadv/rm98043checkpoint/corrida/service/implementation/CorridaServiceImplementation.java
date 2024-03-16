package br.com.fiap.jadv.rm98043checkpoint.corrida.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.jadv.rm98043checkpoint.corrida.Corrida;
import br.com.fiap.jadv.rm98043checkpoint.corrida.CorridaRepository;
import br.com.fiap.jadv.rm98043checkpoint.corrida.CorridaUtils;
import br.com.fiap.jadv.rm98043checkpoint.corrida.Situacao;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaMapper;
import br.com.fiap.jadv.rm98043checkpoint.corrida.service.CorridaService;
import br.com.fiap.jadv.rm98043checkpoint.infra.exceptions.InformacaoExistenteException;

@Service
public class CorridaServiceImplementation implements CorridaService {

  @Autowired
  private CorridaRepository repository;

  public Corrida create(CorridaCreateDto dto) {
    var corridas = repository.findByClienteCpf(dto.cliente().getCpf());
    if (corridas.stream().anyMatch(
        corrida -> corrida.getSituação() != Situacao.CONCLUIDA && corrida.getSituação() != Situacao.CANCELADA))
      throw new InformacaoExistenteException("Já há uma corrida ativa para este cliente");

    var corrida = CorridaMapper.createEntityFromDto(dto);
    corrida.setAtual(CorridaUtils.getAtual(dto.inicio().latitude(), dto.inicio().longitude()));
    return repository.save(corrida);
  }
}
