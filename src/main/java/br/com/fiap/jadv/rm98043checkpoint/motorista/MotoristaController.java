package br.com.fiap.jadv.rm98043checkpoint.motorista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.jadv.rm98043checkpoint.motorista.dtos.MotoristaCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.motorista.dtos.MotoristaEncontradoDto;
import br.com.fiap.jadv.rm98043checkpoint.motorista.service.MotoristaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("rm98043/motoristas")
public class MotoristaController {

  @Autowired
  private MotoristaService service;

  @PostMapping()
  public ResponseEntity<Motorista> create(@Valid @RequestBody MotoristaCreateDto dto) {
    return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<MotoristaEncontradoDto>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MotoristaEncontradoDto> findById(@PathVariable Long id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
  }

}
