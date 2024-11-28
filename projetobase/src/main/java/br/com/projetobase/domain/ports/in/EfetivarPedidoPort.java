package br.com.projetobase.domain.ports.in;

import br.com.projetobase.domain.model.ResultadoEfetivacao;

import java.util.UUID;

public interface EfetivarPedidoPort {

    ResultadoEfetivacao efetivarPedido(UUID idPedido);

}
