package br.com.fiap.jadv.rm98043checkpoint.motorista;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Veiculo {

  @Column(name = "nr_placa_descricao")
  private String placa;

  @Column(name = "ds_veiculo")
  private String descricao;

  @Column(name = "ds_cor_veiculo")
  private String cor;

}
