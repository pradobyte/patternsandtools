package br.com.projetobase.infrastructure.adapters;

import br.com.projetobase.domain.model.MensagemCanal;
import br.com.projetobase.infrastructure.integration.datatransfers.EmailMessageDTO;
import br.com.projetobase.infrastructure.integration.datatransfers.SMSDTO;
import br.com.projetobase.infrastructure.integration.datatransfers.WhatsappMessageDTO;

public class IntegrationMapper {

    public static WhatsappMessageDTO mapToWhatsapp(MensagemCanal mensagemCanal) {
        return new WhatsappMessageDTO(mensagemCanal.idPedido(), mensagemCanal.mensagem(), "[numero]");
    }

    public static EmailMessageDTO maToEmail(MensagemCanal mensagemCanal) {
        return new EmailMessageDTO();
    }


    public static SMSDTO mapToSMS(MensagemCanal mensagemCanal) {
        return new SMSDTO();
    }
}
