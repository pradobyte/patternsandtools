package br.com.projetobase.domain.services.checkout;

import br.com.projetobase.domain.model.ItemCheckout;
import br.com.projetobase.domain.model.checkout.ResultadoItemCheckout;
import br.com.projetobase.domain.model.pedido.Pedido;

import java.math.BigDecimal;

public interface CheckoutItemService {

    ResultadoItemCheckout calculaValorItem(ItemCheckout itemCheckout, Pedido pedido);
}
