package br.com.fiap.jadv.rm98043checkpoint.corrida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaPosicaoAtualizadaDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.dtos.CorridaUpdatePosicaoDto;
import br.com.fiap.jadv.rm98043checkpoint.corrida.service.CorridaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("rm98043/corridas")
public class CorridaController {

  @Autowired
  private CorridaService service;

  @PostMapping
  public ResponseEntity<Corrida> create(@Valid @RequestBody CorridaCreateDto dto) {
    return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
  }

  @PutMapping("{id}/posicao-atual")
  public ResponseEntity<CorridaPosicaoAtualizadaDto> updatePosicao(
      @Valid @RequestBody CorridaUpdatePosicaoDto dto,
      @PathVariable Long id) {
    return new ResponseEntity<>(service.updateCoordenada(dto, id), HttpStatus.OK);
  }

}
