package br.com.projetobase.domain.model.pedido;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemPedido(UUID id, String nome, Integer quantidade, BigDecimal valor) {

    public BigDecimal getValorTotal() {
        return valor.multiply(BigDecimal.valueOf(quantidade));
    }
}
