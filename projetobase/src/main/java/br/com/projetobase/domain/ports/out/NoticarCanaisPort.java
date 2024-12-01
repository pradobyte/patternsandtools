package br.com.projetobase.domain.ports.out;

import br.com.projetobase.domain.model.Canal;
import br.com.projetobase.domain.model.ResultadoEfetivacao;

import java.util.List;

public interface NoticarCanaisPort {
    void notificarCanais(ResultadoEfetivacao resultadoEfetivacaoe, List<Canal.Tipo> canais);
}
