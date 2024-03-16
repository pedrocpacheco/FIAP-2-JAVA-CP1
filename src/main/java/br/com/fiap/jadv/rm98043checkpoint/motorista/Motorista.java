package br.com.fiap.jadv.rm98043checkpoint.motorista;

import java.util.List;

import br.com.fiap.jadv.rm98043checkpoint.corrida.Corrida;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_2CP1_JAVA_MOTORISTA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Motorista {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ds_nome_motorista")
  private String nome;

  @Embedded
  private Veiculo veiculo;

  @OneToMany(mappedBy = "motorista")
  private List<Corrida> corridas;

}
