package br.com.fiap.jadv.rm98043checkpoint.corrida;

import java.sql.Date;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_2CP1_JAVA_CORRIDA")
public class Corrida {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "latitude", column = @Column(name = "nr_latitude_origem")),
      @AttributeOverride(name = "longitude", column = @Column(name = "nr_longitude_origem"))
  })
  private Coordenada inicio;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "latitude", column = @Column(name = "nr_latitude_atual")),
      @AttributeOverride(name = "longitude", column = @Column(name = "nr_longitude_atual"))
  })
  private Coordenada atual;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "latitude", column = @Column(name = "nr_latitude_destino")),
      @AttributeOverride(name = "longitude", column = @Column(name = "nr_longitude_destino")),
  })
  private Coordenada destino;

  @Column(name = "dt_solicitacao")
  private Date dataInicio;

  @Column(name = "dt_finalizacao")
  private Date dataFim;

}
