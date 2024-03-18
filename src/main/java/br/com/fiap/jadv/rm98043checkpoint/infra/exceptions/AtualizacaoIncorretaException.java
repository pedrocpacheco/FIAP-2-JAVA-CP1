package br.com.fiap.jadv.rm98043checkpoint.infra.exceptions;

public class AtualizacaoIncorretaException extends RuntimeException {
  public AtualizacaoIncorretaException(String msg) {
    super(msg);
  }
}