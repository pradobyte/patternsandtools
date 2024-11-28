package br.com.projetobase.domain.ports.in;

import br.com.projetobase.domain.model.pedido.ResultadoPedido;

import java.util.UUID;

public interface CancelarPedidoPort {

    ResultadoPedido cancelarPedido(UUID idPedido);

}
