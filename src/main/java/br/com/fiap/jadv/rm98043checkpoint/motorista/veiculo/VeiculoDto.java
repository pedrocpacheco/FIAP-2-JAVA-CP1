package br.com.fiap.jadv.rm98043checkpoint.motorista.veiculo;

import br.com.fiap.jadv.rm98043checkpoint.motorista.Veiculo;
import jakarta.validation.constraints.NotBlank;

public record VeiculoDto(
        @NotBlank(message = "Informe a placa corretamente") String placa,
        @NotBlank(message = "Descricao não pode ser nula") String descricao,
        @NotBlank(message = "Cor não pode ser nula") String cor) {

    public VeiculoDto(Veiculo entity) {
        this(entity.getPlaca(), entity.getDescricao(), entity.getCor());
    }
}
