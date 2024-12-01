package br.com.projetobase.domain.model;

import java.math.BigDecimal;

public record ItemCheckout(TipoItemCheckout tipoCheckout, String descricao, BigDecimal valor) {

    public enum  TipoItemCheckout {
        ALIQUOTA,
        FRETE,
        DESCONTO
    }

}
