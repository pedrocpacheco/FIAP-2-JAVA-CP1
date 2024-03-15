package br.com.fiap.jadv.rm98043checkpoint.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  public Cliente findByCpf(String cpf);

}
