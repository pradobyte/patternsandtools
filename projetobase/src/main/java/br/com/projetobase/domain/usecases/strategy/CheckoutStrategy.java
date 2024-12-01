package br.com.projetobase.domain.usecases.strategy;

import br.com.projetobase.domain.model.ItemCheckout;
import br.com.projetobase.domain.services.checkout.CheckoutItemService;
import br.com.projetobase.domain.services.checkout.impl.AliquotaService;
import br.com.projetobase.domain.services.checkout.impl.DescontoService;
import br.com.projetobase.domain.services.checkout.impl.FreteService;

public class CheckoutStrategy {


    public static CheckoutItemService getStrategy(ItemCheckout.TipoItemCheckout tipoItemCheckout) {
        return switch (tipoItemCheckout) {
            case ALIQUOTA -> new AliquotaService();
            case DESCONTO -> new DescontoService();
            case FRETE -> new FreteService();
        };
    }
}
