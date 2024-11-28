package br.com.projetobase.domain.model.pedido;

public record ResultadoPedido(Pedido pedido, String mensagem) {

    public static ResultadoPedido sucesso(Pedido pedido) {
        return new ResultadoPedido(pedido, "Pedido efetivado com sucesso");
    }

    public static ResultadoPedido canceladoComSucesso(Pedido pedido) {
        return new ResultadoPedido(pedido, "Pedido cancelado");
    }

    public static ResultadoPedido erro(Pedido pedido, String mensagem) {
        return new ResultadoPedido(pedido, mensagem);
    }

    public boolean isSucesso() {
        return mensagem.equals("Pedido efetivado com sucesso");
    }

    public boolean isErro() {
        return !isSucesso();
    }
}
