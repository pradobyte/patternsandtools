package br.com.projetobase.domain.services.pedido.impl;

import br.com.projetobase.domain.model.ItemCheckout;
import br.com.projetobase.domain.model.pedido.SituacaoPedido;
import br.com.projetobase.domain.services.pedido.PedidoCheckoutService;

import java.util.List;

public class PedidoCheckoutServiceImpl implements PedidoCheckoutService {

    @Override
    public List<ItemCheckout> buscarItensCheckout(SituacaoPedido situacaoPedido) {
        return List.of();
    }
}
