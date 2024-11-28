package br.com.projetobase.domain.services.pedido;

import br.com.projetobase.domain.model.ItemCheckout;
import br.com.projetobase.domain.model.pedido.SituacaoPedido;

import java.util.List;

public interface PedidoCheckoutService {

    List<ItemCheckout> buscarItensCheckout(SituacaoPedido situacaoPedido);
}
