package br.com.projetobase.application.adapters.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/pedidos")
@RestController
public class EfetivacaoPedidoController {


    @PostMapping
    public void efetivarPedido() {
        // TODO
    }
}
