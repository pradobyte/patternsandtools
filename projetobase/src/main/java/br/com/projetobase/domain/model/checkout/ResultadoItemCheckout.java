package br.com.projetobase.domain.model.checkout;

import br.com.projetobase.domain.model.ItemCheckout;

import java.math.BigDecimal;

public record ResultadoItemCheckout(BigDecimal valorResultado,
                                    BigDecimal percentualAplicaco,
                                    ItemCheckout.TipoItemCheckout tipoItemCheckout) {


}
