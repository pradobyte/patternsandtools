package br.com.projetobase.domain.services.checkout.impl;

import br.com.projetobase.domain.model.ItemCheckout;
import br.com.projetobase.domain.model.checkout.ResultadoItemCheckout;
import br.com.projetobase.domain.model.pedido.Pedido;
import br.com.projetobase.domain.ports.out.DescontoDataPort;
import br.com.projetobase.domain.services.checkout.CheckoutItemService;

import java.math.BigDecimal;

public class DescontoService implements CheckoutItemService {



    public DescontoService() {
    }

    public DescontoService(DescontoDataPort descontoDataPort) {
        this.descontoDataPort = descontoDataPort;
    }

    private DescontoDataPort descontoDataPort;


    @Override
    public ResultadoItemCheckout calculaValorItem(ItemCheckout itemCheckout, Pedido pedido) {
        return this.descontoDataPort.buscarDescontoPorCliente(pedido.cliente().id())
                .map(desconto -> new ResultadoItemCheckout(pedido.valorTotal().multiply(desconto), desconto, itemCheckout.tipoCheckout()))
                .orElse(new ResultadoItemCheckout(BigDecimal.ZERO, BigDecimal.ZERO, itemCheckout.tipoCheckout()));


    }
}
