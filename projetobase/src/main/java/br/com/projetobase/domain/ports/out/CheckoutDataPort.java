package br.com.projetobase.domain.ports.out;

import br.com.projetobase.domain.model.ItemCheckout;

import java.util.List;

public interface CheckoutDataPort {

    List<ItemCheckout> buscarItensCheckout();

}
