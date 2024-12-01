package br.com.projetobase.domain.model.pedido;

import br.com.projetobase.domain.model.cliente.Endereco;

public record Cliente(Long id, String nome, Endereco endereco, String telefone) {
}
