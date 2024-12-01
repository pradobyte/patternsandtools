package br.com.projetobase.domain.ports.out;

import br.com.projetobase.domain.model.cliente.Endereco;

import java.math.BigDecimal;

public interface TaxaFreteDataPort {


    BigDecimal buscarTaxaFrete(Endereco endereco);


}
