package br.com.projetobase.infrastructure.integration.datatransfers;

import java.util.UUID;

public record WhatsappMessageDTO (UUID id, String message, String phoneNumber) {

}
