package br.com.projetobase.domain.ports.out;

import java.math.BigDecimal;
import java.util.Optional;

public interface DescontoDataPort {

    Optional<BigDecimal> buscarDescontoPorCliente(Long idCliente);
}
