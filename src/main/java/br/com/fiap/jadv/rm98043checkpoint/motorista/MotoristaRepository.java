package br.com.fiap.jadv.rm98043checkpoint.motorista;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

  Motorista findByVeiculoPlaca(String placa);

}