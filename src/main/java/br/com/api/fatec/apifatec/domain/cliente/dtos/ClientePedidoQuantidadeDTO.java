package br.com.api.fatec.apifatec.domain.cliente.dtos;

public class ClientePedidoQuantidadeDTO {
	private Long clienteId;
    private Long quantidadePedidos;

    public ClientePedidoQuantidadeDTO(Long clienteId, Long quantidadePedidos) {
        this.clienteId = clienteId;
        this.quantidadePedidos = quantidadePedidos;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getQuantidadePedidos() {
        return quantidadePedidos;
    }

    public void setQuantidadePedidos(Long quantidadePedidos) {
        this.quantidadePedidos = quantidadePedidos;
    }

}
