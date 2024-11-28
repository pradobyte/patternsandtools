package br.com.projetobase.domain.model.pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public record Pedido(UUID idPedido, List<ItemPedido> itemPedidos, BigDecimal valorTotal) {


        public static Pedido novoPedido(final UUID idPedido, final List<ItemPedido> itemPedidos) {
            BigDecimal valorTotal = itemPedidos.stream()
                    .map(ItemPedido::getValorTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            return new Pedido(idPedido, itemPedidos, valorTotal);
        }

        public void adicionarItemPedido(final ItemPedido itemPedido) {
            itemPedidos.add(itemPedido);
        }

        public void removerItemPedido(UUID idItemPedido) {
            final Predicate<ItemPedido> itemPedidoPredicate = itemPedido -> itemPedido.id().equals(idItemPedido);
            itemPedidos.removeIf(itemPedidoPredicate);
        }



}
