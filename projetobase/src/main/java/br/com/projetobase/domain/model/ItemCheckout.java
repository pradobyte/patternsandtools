package br.com.projetobase.domain.model;

import java.math.BigDecimal;

public record ItemCheckout(TipoCheckout tipoCheckout, String descricao, BigDecimal valor) {


}
