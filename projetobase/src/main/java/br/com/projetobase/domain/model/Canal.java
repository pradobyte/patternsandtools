package br.com.projetobase.domain.model;

public record Canal(Canal.Tipo tipo, String destinatario) {

    public enum Tipo {
        EMAIL,
        SMS,
        WHATSAPP
    }
}
