package br.com.api.fatec.apifatec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.fatec.apifatec.domain.cliente.dtos.ClientePedidoQuantidadeDTO;
import br.com.api.fatec.apifatec.domain.pedidovenda.PedidoVendaRepository;
import br.com.api.fatec.apifatec.domain.pedidovenda.PedidoVendaService;

@RestController()
@RequestMapping("/pedidos/total-quantidade-por-cliente")
public class PedidoPorClienteController {
	@Autowired
	PedidoVendaService pedidoDeVendaService; 
	
    @Autowired
    private PedidoVendaService pedidoVendaService;
	
	@GetMapping
    public List<ClientePedidoQuantidadeDTO> getTotalQuantidadePedidosPorCliente() {
        return pedidoVendaService.getTotalQuantidadePedidosPorCliente();
    }
	
}
