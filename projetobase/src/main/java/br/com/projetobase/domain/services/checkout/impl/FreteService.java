package br.com.projetobase.domain.services.checkout.impl;

import br.com.projetobase.domain.model.ItemCheckout;
import br.com.projetobase.domain.model.checkout.ResultadoItemCheckout;
import br.com.projetobase.domain.model.pedido.Cliente;
import br.com.projetobase.domain.model.pedido.Pedido;
import br.com.projetobase.domain.ports.out.TaxaFreteDataPort;
import br.com.projetobase.domain.services.checkout.CheckoutItemService;

import java.math.BigDecimal;

import static br.com.projetobase.domain.model.ItemCheckout.TipoItemCheckout.FRETE;

public class FreteService implements CheckoutItemService {

    private TaxaFreteDataPort taxaFreteDataPort;

    public FreteService(TaxaFreteDataPort taxaFreteDataPort) {
        this.taxaFreteDataPort = taxaFreteDataPort;
    }

    public FreteService() {
    }


    @Override
    public ResultadoItemCheckout calculaValorItem(final ItemCheckout itemCheckout,
                                                  final Pedido pedido) {
        Cliente cliente = pedido.cliente();
        BigDecimal valorFrete = this.taxaFreteDataPort.buscarTaxaFrete(cliente.endereco());
        return new ResultadoItemCheckout(pedido.valorTotal().multiply(valorFrete), valorFrete, FRETE);
    }
}
