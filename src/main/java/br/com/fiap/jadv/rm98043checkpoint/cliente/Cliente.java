package br.com.fiap.jadv.rm98043checkpoint.cliente;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fiap.jadv.rm98043checkpoint.corrida.Corrida;
import jakarta.persistence.Column;
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

  @OneToMany(mappedBy = "cliente")
  @JsonIgnore
  private List<Corrida> corridas;

  public Cliente(Long id, String cpf, String nome) {
    this.id = id;
    this.cpf = cpf;
    this.nome = nome;
  }

}
