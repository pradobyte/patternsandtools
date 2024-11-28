package br.com.projetobase.domain.ports.out;

import br.com.projetobase.domain.model.pedido.Pedido;

import java.util.UUID;

public interface PedidoDataPort {

  Pedido buscarPedido(UUID idPedido);

}
