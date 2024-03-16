package br.com.fiap.jadv.rm98043checkpoint.corrida;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import br.com.fiap.jadv.rm98043checkpoint.cliente.Cliente;
import br.com.fiap.jadv.rm98043checkpoint.corrida.coordenada.Coordenada;
import br.com.fiap.jadv.rm98043checkpoint.motorista.Motorista;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_2CP1_JAVA_CORRIDA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Corrida {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        @Column(name = "dt_solicitacao")
        @CreationTimestamp
        private Date dataInicio;

        @Column(name = "dt_finalizacao")
        private Date dataFim;

        @Column(name = "cd_situacao_corrida")
        private Situacao situação;

        @ManyToOne
        @JoinColumn(name = "cliente_id")
        private Cliente cliente;

        @ManyToOne
        @JoinColumn(name = "motorista_id")
        private Motorista motorista;

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
}
