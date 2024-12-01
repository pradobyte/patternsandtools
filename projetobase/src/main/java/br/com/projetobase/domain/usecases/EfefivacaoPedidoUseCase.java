package br.com.projetobase.domain.usecases;

import br.com.projetobase.domain.model.Canal;
import br.com.projetobase.domain.model.ItemCheckout;
import br.com.projetobase.domain.model.ResultadoEfetivacao;
import br.com.projetobase.domain.model.checkout.ResultadoItemCheckout;
import br.com.projetobase.domain.model.pedido.Pedido;
import br.com.projetobase.domain.ports.in.EfetivarPedidoPort;
import br.com.projetobase.domain.ports.out.CheckoutDataPort;
import br.com.projetobase.domain.ports.out.NoticarCanaisPort;
import br.com.projetobase.domain.ports.out.PedidoDataPort;
import br.com.projetobase.domain.services.checkout.CheckoutItemService;
import br.com.projetobase.domain.usecases.strategy.CheckoutStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static br.com.projetobase.domain.model.Canal.Tipo.EMAIL;
import static br.com.projetobase.domain.model.Canal.Tipo.SMS;
import static br.com.projetobase.domain.model.Canal.Tipo.WHATSAPP;
import static java.util.List.of;

@Service
public class EfefivacaoPedidoUseCase implements EfetivarPedidoPort {

    private PedidoDataPort pedidoDataPort;
    private CheckoutDataPort checkoutDataPort;
    private NoticarCanaisPort noticarCanaisPort;


    public EfefivacaoPedidoUseCase(PedidoDataPort pedidoDataPort,
                                   CheckoutDataPort checkoutDataPort,
                                   NoticarCanaisPort noticarCanaisPort) {
        this.pedidoDataPort = pedidoDataPort;
        this.checkoutDataPort = checkoutDataPort;
        this.noticarCanaisPort = noticarCanaisPort;
    }

    @Override
    public ResultadoEfetivacao efetivarPedido(final UUID idPedido) {
        final Pedido pedido = this.pedidoDataPort.buscarPedido(idPedido);
        final List<ItemCheckout> resultadoValorCheckout = this.checkoutDataPort.buscarItensCheckout();

        final List<ResultadoItemCheckout> resultadoItemCheckouts = resultadoValorCheckout
                .stream().map(itemCheckout -> {
                    CheckoutItemService checkoutItemService = CheckoutStrategy.getStrategy(itemCheckout.tipoCheckout());
                    return checkoutItemService.calculaValorItem(itemCheckout, pedido);
                }).toList();

        final ResultadoEfetivacao resultadoEfetivacao =  new ResultadoEfetivacao(pedido, resultadoItemCheckouts);

        this.noticarCanaisPort.notificarCanais(resultadoEfetivacao, of(SMS, EMAIL, WHATSAPP));

        return resultadoEfetivacao;
    }


}
