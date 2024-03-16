package br.com.fiap.jadv.rm98043checkpoint.corrida.coordenada;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CoordenadaDto(
    @Min(value = -100, message = "Valor não pode ser menor que 100") @Max(value = 100, message = "Valor não pode ser maior que 100") @NotNull(message = "Valor não pode ser nulo") Double latitude,
    @Min(value = -100, message = "Valor não pode ser menor que 100") @Max(value = 100, message = "Valor não pode ser maior que 100") @NotNull(message = "Valor não pode ser nulo") Double longitude) {
  public CoordenadaDto(Coordenada entity) {
    this(entity.getLatitude(), entity.getLongitude());
  }
}