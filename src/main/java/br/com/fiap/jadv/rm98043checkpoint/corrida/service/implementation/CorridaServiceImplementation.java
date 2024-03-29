package br.com.fiap.jadv.rm98043checkpoint.corrida.service.implementation;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.jadv.rm98043checkpoint.cliente.ClienteRepository;
import br.com.fiap.jadv.rm98043checkpoint.corrida.Corrida;
import br.com.fiap.jadv.rm98043checkpoint.corrida.CorridaRepository;
import br.com.fiap.jadv.rm98043checkpoint.corrida.CorridaUtils;
import br.com.fiap.jadv.rm98043checkpoint.corrida.Situacao;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaAtualizada;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaMapper;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaUpdatePosicaoDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaUpdateSituacao;
import br.com.fiap.jadv.rm98043checkpoint.corrida.service.CorridaService;
import br.com.fiap.jadv.rm98043checkpoint.infra.exceptions.AtualizacaoIncorretaException;
import br.com.fiap.jadv.rm98043checkpoint.infra.exceptions.InformacaoExistenteException;
import br.com.fiap.jadv.rm98043checkpoint.motorista.MotoristaRepository;

@Service
public class CorridaServiceImplementation implements CorridaService {

  @Autowired
  private CorridaRepository repository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private MotoristaRepository motoristaRepository;

  public Corrida create(CorridaCreateDto dto) {
    var cliente = clienteRepository.findById(dto.clienteId()).get();
    var motorista = motoristaRepository.findById(dto.motoristaId()).get();

    var corridas = repository.findByClienteCpf(cliente.getCpf());
    if (corridas.stream().anyMatch(
        corrida -> corrida.getSituação() != Situacao.CONCLUIDA && corrida.getSituação() != Situacao.CANCELADA))
      throw new InformacaoExistenteException("Já há uma corrida ativa para este cliente");

    var corrida = CorridaMapper.createEntityFromDto(dto);

    corrida.setAtual(CorridaUtils.getAtual(dto.inicio().latitude(), dto.inicio().longitude()));
    corrida.setCliente(cliente);
    corrida.setMotorista(motorista);

    return repository.save(corrida);
  }

  public CorridaAtualizada updateSituacao(CorridaUpdateSituacao dto, Long id) {
    var corrida = repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Não há corrida com esse ID"));

    var situacaoAtual = corrida.getSituação();
    var novaSituacao = dto.situacao();

    if (!CorridaUtils.isTransicaoValida(situacaoAtual, novaSituacao)) {
      throw new AtualizacaoIncorretaException(
          "As atualizações possíveis são: Aguardando -> Cancelada || Aguardando -> Em Andamento -> Concluída");
    }

    corrida.setSituação(novaSituacao);
    repository.save(corrida);

    return new CorridaAtualizada(corrida);
  }

  public CorridaAtualizada updateCoordenada(CorridaUpdatePosicaoDto dto, Long id) {
    var corrida = repository.findById(id).get();

    if (repository.findById(corrida.getId()) == null) {
      throw new IllegalArgumentException("Não há corrida com esse ID");
    }

    corrida.setAtual(dto.atual());

    if (corrida.getSituação() == Situacao.EM_ANDAMENTO) {
      if (corrida.getAtual().equals(corrida.getFim()))
        corrida.setSituação(Situacao.CONCLUIDA);
      corrida.setDataFim(new Date(System.currentTimeMillis()));
      repository.save(corrida);
    }

    if (corrida.getSituação() == Situacao.AGUARDANDO) {
      if (corrida.getAtual().equals(corrida.getInicio()))
        corrida.setSituação(Situacao.EM_ANDAMENTO);
      repository.save(corrida);
    }

    return new CorridaAtualizada(corrida);
  }

}
