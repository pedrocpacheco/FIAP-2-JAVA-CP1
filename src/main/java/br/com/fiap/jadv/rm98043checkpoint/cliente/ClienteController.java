package br.com.fiap.jadv.rm98043checkpoint.cliente;

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

import br.com.fiap.jadv.rm98043checkpoint.cliente.dtos.ClienteCreateDto;
import br.com.fiap.jadv.rm98043checkpoint.cliente.dtos.ClienteEncontradoDto;
import br.com.fiap.jadv.rm98043checkpoint.cliente.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("rm98043/clientes")
public class ClienteController {

  @Autowired
  public ClienteService service;

  @PostMapping()
  public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteCreateDto dto) {
    return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<List<ClienteEncontradoDto>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
  }

  @GetMapping("{id}")
  public ResponseEntity<ClienteEncontradoDto> findById(@PathVariable Long id) {
    System.out.println(id);
    return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
  }
}
