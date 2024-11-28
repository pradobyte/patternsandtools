package br.com.projetobase.domain.ports.out;

import br.com.projetobase.domain.model.pedido.ItemPedido;

import java.util.List;
import java.util.UUID;

public interface ItemPedidoPort {
    void adicionarItemPedido(ItemPedido pedido);
    void removerItemPedido(UUID idPedido);
    List<ItemPedido> listarItensPedido();
}
