package br.com.projetobase.domain.usecases;

import br.com.projetobase.domain.model.ResultadoEfetivacao;
import br.com.projetobase.domain.model.pedido.Pedido;
import br.com.projetobase.domain.model.pedido.SituacaoPedido;
import br.com.projetobase.domain.ports.in.EfetivarPedidoPort;
import br.com.projetobase.domain.ports.out.PedidoDataPort;
import br.com.projetobase.domain.services.pedido.PedidoCheckoutService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EfefivacaoPedidoUseCase implements EfetivarPedidoPort {


    public EfefivacaoPedidoUseCase(PedidoDataPort pedidoDataPort, PedidoCheckoutService pedidoCheckOutService) {
        this.pedidoDataPort = pedidoDataPort;
        this.pedidoCheckOutService = pedidoCheckOutService;
    }

    private PedidoDataPort pedidoDataPort;
    private PedidoCheckoutService pedidoCheckOutService;

    @Override
    public ResultadoEfetivacao efetivarPedido(UUID idPedido) {
        final Pedido pedido = this.pedidoDataPort.buscarPedido(idPedido);
        var itensCheckout = this.pedidoCheckOutService.buscarItensCheckout(SituacaoPedido.EM_ANALISE);
        return null;
    }


}
