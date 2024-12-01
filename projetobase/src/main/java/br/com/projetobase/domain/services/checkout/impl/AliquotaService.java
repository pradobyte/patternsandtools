package br.com.projetobase.domain.services.checkout.impl;

import br.com.projetobase.domain.model.ItemCheckout;
import br.com.projetobase.domain.model.checkout.ResultadoItemCheckout;
import br.com.projetobase.domain.model.pedido.Pedido;
import br.com.projetobase.domain.services.checkout.CheckoutItemService;

public class AliquotaService implements CheckoutItemService {

    @Override
    public ResultadoItemCheckout calculaValorItem(ItemCheckout itemCheckout, Pedido pedido) {
        return null;
    }
}


