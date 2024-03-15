package br.com.fiap.jadv.rm98043checkpoint.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public Cliente create(@Valid @RequestBody ClienteCreateDto dto) {
    return service.create(dto);
  }

  @GetMapping()
  public List<ClienteEncontradoDto> findAll() {
    return service.findAll();
  }

  @GetMapping("{id}")
  public ClienteEncontradoDto findById(@RequestParam Long id) {
    return service.findById(id);
  }
}
