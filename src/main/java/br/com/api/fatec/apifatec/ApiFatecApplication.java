package br.com.api.fatec.apifatec;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.api.fatec.apifatec.domain.pedidovenda.PedidoVendaService;
import br.com.api.fatec.apifatec.entities.PedidoVenda;
import br.com.api.fatec.apifatec.entities.PedidoVendaItem;
import br.com.api.fatec.apifatec.shared.enums.PedidoVendaStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.domain.pedidovenda.PedidoVendaRepository;
import br.com.api.fatec.apifatec.domain.produto.ProdutoRepository;
import br.com.api.fatec.apifatec.entities.Cliente;
import br.com.api.fatec.apifatec.entities.Produto;

@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository,
								 @Autowired ProdutoRepository produtoRepository,
								 @Autowired PedidoVendaRepository pedidoVendaRepository
								 ) {
		return args -> {
			// Criação de Clientes
			Cliente cliente1 = new Cliente();
			cliente1.setNome("Danilo");
			cliente1.setEmail("h2danilofatec@hotmail.com");
			cliente1.setEndereco("Rua xxx, 126");
			cliente1.setRazaoSocial("Danilo");
			clienteRepository.save(cliente1);

			Cliente cliente2 = new Cliente();
			cliente2.setNome("Arthur");
			cliente2.setEmail("arthurfatec@hotmail.com");
			cliente2.setEndereco("Rua xxx, 127");
			cliente2.setRazaoSocial("Arthur");
			clienteRepository.save(cliente2);

			Cliente cliente3 = new Cliente();
			cliente3.setNome("Lucas");
			cliente3.setEmail("lucasfatec@hotmail.com");
			cliente3.setEndereco("Rua xxx, 128");
			cliente3.setRazaoSocial("Lucas");
			clienteRepository.save(cliente3);

			Cliente cliente4 = new Cliente();
			cliente4.setNome("Mariana");
			cliente4.setEmail("marianafatec@hotmail.com");
			cliente4.setEndereco("Rua xxx, 129");
			cliente4.setRazaoSocial("Mariana");
			clienteRepository.save(cliente4);

			Cliente cliente5 = new Cliente();
			cliente5.setNome("Fernanda");
			cliente5.setEmail("fernandafatec@hotmail.com");
			cliente5.setEndereco("Rua xxx, 130");
			cliente5.setRazaoSocial("Fernanda");
			clienteRepository.save(cliente5);

			// Criação de Produtos
			Produto produto1 = new Produto();
			produto1.setDescricao("Produto 1");
			produto1.setPreco(new BigDecimal(100));
			produto1.setAtivo("SIM");
			produto1.setQuantidadeEstoque(50);
			produtoRepository.save(produto1);

			Produto produto2 = new Produto();
			produto2.setDescricao("Produto 2");
			produto2.setPreco(new BigDecimal(150));
			produto2.setAtivo("SIM");
			produto2.setQuantidadeEstoque(30);
			produtoRepository.save(produto2);

			Produto produto3 = new Produto();
			produto3.setDescricao("Produto 3");
			produto3.setPreco(new BigDecimal(200));
			produto3.setAtivo("SIM");
			produto3.setQuantidadeEstoque(20);
			produtoRepository.save(produto3);

			Produto produto4 = new Produto();
			produto4.setDescricao("Produto 4");
			produto4.setPreco(new BigDecimal(250));
			produto4.setAtivo("SIM");
			produto4.setQuantidadeEstoque(10);
			produtoRepository.save(produto4);

			Produto produto5 = new Produto();
			produto5.setDescricao("Produto 5");
			produto5.setPreco(new BigDecimal(300));
			produto5.setAtivo("SIM");
			produto5.setQuantidadeEstoque(5);
			produtoRepository.save(produto5);

			// Criação de Pedidos de Venda
			LocalDate data = LocalDate.now();

			PedidoVenda pedido1 = new PedidoVenda();
			pedido1.setCliente(cliente1);
			pedido1.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			pedido1.setEmissao(data);

			PedidoVendaItem item1 = new PedidoVendaItem();
			item1.setProduto(produto1);
			item1.setQuantidade(5);
			item1.setValorUnitario(produto1.getPreco());
			item1.setValorTotal(item1.getValorUnitario().multiply(BigDecimal.valueOf(item1.getQuantidade())));
			pedido1.addItem(item1);

			PedidoVendaItem item2 = new PedidoVendaItem();
			item2.setProduto(produto2);
			item2.setQuantidade(3);
			item2.setValorUnitario(produto2.getPreco());
			item2.setValorTotal(item2.getValorUnitario().multiply(BigDecimal.valueOf(item2.getQuantidade())));
			pedido1.addItem(item2);

			pedido1.setTotal();
			pedidoVendaRepository.save(pedido1);

			PedidoVenda pedido2 = new PedidoVenda();
			pedido2.setCliente(cliente2);
			pedido2.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			pedido2.setEmissao(data);

			PedidoVendaItem item3 = new PedidoVendaItem();
			item3.setProduto(produto3);
			item3.setQuantidade(2);
			item3.setValorUnitario(produto3.getPreco());
			item3.setValorTotal(item3.getValorUnitario().multiply(BigDecimal.valueOf(item3.getQuantidade())));
			pedido2.addItem(item3);

			PedidoVendaItem item4 = new PedidoVendaItem();
			item4.setProduto(produto4);
			item4.setQuantidade(1);
			item4.setValorUnitario(produto4.getPreco());
			item4.setValorTotal(item4.getValorUnitario().multiply(BigDecimal.valueOf(item4.getQuantidade())));
			pedido2.addItem(item4);

			pedido2.setTotal();
			pedidoVendaRepository.save(pedido2);

			PedidoVenda pedido3 = new PedidoVenda();
			pedido3.setCliente(cliente3);
			pedido3.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			pedido3.setEmissao(data);

			PedidoVendaItem item5 = new PedidoVendaItem();
			item5.setProduto(produto1);
			item5.setQuantidade(1);
			item5.setValorUnitario(produto1.getPreco());
			item5.setValorTotal(item5.getValorUnitario().multiply(BigDecimal.valueOf(item5.getQuantidade())));
			pedido3.addItem(item5);

			PedidoVendaItem item6 = new PedidoVendaItem();
			item6.setProduto(produto5);
			item6.setQuantidade(2);
			item6.setValorUnitario(produto5.getPreco());
			item6.setValorTotal(item6.getValorUnitario().multiply(BigDecimal.valueOf(item6.getQuantidade())));
			pedido3.addItem(item6);

			pedido3.setTotal();
			pedidoVendaRepository.save(pedido3);

			PedidoVenda pedido4 = new PedidoVenda();
			pedido4.setCliente(cliente4);
			pedido4.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			pedido4.setEmissao(data);

			PedidoVendaItem item7 = new PedidoVendaItem();
			item7.setProduto(produto2);
			item7.setQuantidade(4);
			item7.setValorUnitario(produto2.getPreco());
			item7.setValorTotal(item7.getValorUnitario().multiply(BigDecimal.valueOf(item7.getQuantidade())));
			pedido4.addItem(item7);

			PedidoVendaItem item8 = new PedidoVendaItem();
			item8.setProduto(produto3);
			item8.setQuantidade(2);
			item8.setValorUnitario(produto3.getPreco());
			item8.setValorTotal(item8.getValorUnitario().multiply(BigDecimal.valueOf(item8.getQuantidade())));
			pedido4.addItem(item8);

			pedido4.setTotal();
			pedidoVendaRepository.save(pedido4);

			PedidoVenda pedido5 = new PedidoVenda();
			pedido5.setCliente(cliente5);
			pedido5.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			pedido5.setEmissao(data);

			PedidoVendaItem item9 = new PedidoVendaItem();
			item9.setProduto(produto4);
			item9.setQuantidade(2);
			item9.setValorUnitario(produto4.getPreco());
			item9.setValorTotal(item9.getValorUnitario().multiply(BigDecimal.valueOf(item9.getQuantidade())));
			pedido5.addItem(item9);

			PedidoVendaItem item10 = new PedidoVendaItem();
			item10.setProduto(produto5);
			item10.setQuantidade(1);
			item10.setValorUnitario(produto5.getPreco());
			item10.setValorTotal(item10.getValorUnitario().multiply(BigDecimal.valueOf(item10.getQuantidade())));
			pedido5.addItem(item10);

			pedido5.setTotal();
			pedidoVendaRepository.save(pedido5);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}
}
