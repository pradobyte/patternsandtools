package br.com.projetobase.domain.model;

import br.com.projetobase.domain.model.checkout.ResultadoItemCheckout;
import br.com.projetobase.domain.model.pedido.Pedido;

import java.math.BigDecimal;
import java.util.List;

public record ResultadoEfetivacao(Pedido pedido, List<ResultadoItemCheckout> itemCheckouts) {


    public BigDecimal getValorTotalPedidoCheckouts() {
        return itemCheckouts.stream()
                .map(ResultadoItemCheckout::valorResultado)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
