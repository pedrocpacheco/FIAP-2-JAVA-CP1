package br.com.fiap.jadv.rm98043checkpoint.corrida;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {

  public List<Corrida> findByClienteCpf(String cpf);

}
