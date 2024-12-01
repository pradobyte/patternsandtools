package br.com.projetobase.infrastructure.adapters;

import br.com.projetobase.domain.model.Canal;
import br.com.projetobase.domain.model.MensagemCanal;
import br.com.projetobase.domain.model.ResultadoEfetivacao;
import br.com.projetobase.domain.ports.out.NoticarCanaisPort;
import br.com.projetobase.infrastructure.integration.EmailClient;
import br.com.projetobase.infrastructure.integration.SmsClient;
import br.com.projetobase.infrastructure.integration.WhatsappClient;

import java.util.List;

public class NotificacaoAdapter implements NoticarCanaisPort {

    private WhatsappClient whatsappClient;
    private EmailClient emailClient;
    private SmsClient smsClient;
    private IntegrationMapper integrationMapper;

    @Override
    public void notificarCanais(final ResultadoEfetivacao resultadoEfetivacaoe,
                                final List<Canal.Tipo> canais) {

        final MensagemCanal mensagemCanal = new MensagemCanal(resultadoEfetivacaoe.pedido().idPedido(),
                                                        canais,
                                                        "Pedido efetivado com sucesso!");

        canais.parallelStream().forEach(canal -> {
            switch (canal) {
                case EMAIL -> emailClient.sendEmail(IntegrationMapper.maToEmail(mensagemCanal));
                case SMS -> smsClient.sendSms(IntegrationMapper.mapToSMS(mensagemCanal));
                case WHATSAPP -> whatsappClient.sendWhats(IntegrationMapper.mapToWhatsapp(mensagemCanal));
            }
        });
        }

}
