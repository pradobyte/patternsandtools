package br.com.projetobase.domain.model.pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public record Pedido(UUID idPedido,
                     Cliente cliente,
                     Pedido.Categoria categoria,
                     List<ItemPedido> itemPedidos,
                     BigDecimal valorTotal) {

        public enum Categoria {
            ALIMENTACAO,
            VESTUARIO,
            ELETRONICOS,
            MOVEIS,
            LIVROS,
            BRINQUEDOS,
            OUTROS
        }
        public BigDecimal valorTotal() {
            return this.itemPedidos.stream()
                    .map(ItemPedido::getValorTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }


        public void atualizarItemPedido(final ItemPedido itemPedido) {
            final Predicate<ItemPedido> itemPedidoPredicate = itemPedido1 -> itemPedido1.id().equals(itemPedido.id());
            itemPedidos.removeIf(itemPedidoPredicate);
            itemPedidos.add(itemPedido);
        }

        public void adicionarItemPedido(final ItemPedido itemPedido) {
            itemPedidos.add(itemPedido);
        }

        public void removerItemPedido(UUID idItemPedido) {
            final Predicate<ItemPedido> itemPedidoPredicate = itemPedido -> itemPedido.id().equals(idItemPedido);
            itemPedidos.removeIf(itemPedidoPredicate);
        }





}
