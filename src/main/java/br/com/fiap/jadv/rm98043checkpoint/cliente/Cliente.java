package br.com.fiap.jadv.rm98043checkpoint.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_2CP1_JAVA_CLIENTE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "nr_id_cliente")
  private Long id;

  @Column(name = "nr_cpf_cliente")
  private String cpf;

  @Column(name = "nr_nome_cliente")
  private String nome;

}
