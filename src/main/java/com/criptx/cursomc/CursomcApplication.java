package com.criptx.cursomc;

import com.criptx.cursomc.domain.*;
import com.criptx.cursomc.domain.enums.EstadoPagamento;
import com.criptx.cursomc.domain.enums.TipoCliente;
import com.criptx.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"com.criptx.cursomc"})
public class CursomcApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    public void run(String... args) throws Exception {
        Categoria categoria1 = new Categoria(null, "Informatica");
        Categoria categoria2 = new Categoria(null, "Escritório");
        Categoria categoria3 = new Categoria(null, "Moda e Vestuário");
        Categoria categoria4 = new Categoria(null, "Casa e Decoração");
        Categoria categoria5 = new Categoria(null, "Beleza e Cuidados Pessoais");
        Categoria categoria6 = new Categoria(null, "Esportes e Fitness");
        Categoria categoria7 = new Categoria(null, "Livros e Papelaria");
        Categoria categoria8 = new Categoria(null, "Alimentos e Bebidas");
        Categoria categoria9 = new Categoria(null, "Brinquedos e Jogos");
        Categoria categoria10 = new Categoria(null, "Automotivo");
        Categoria categoria11 = new Categoria(null, "Móveis e Decoração");
        Categoria categoria12 = new Categoria(null, "Jóias e Acessórios");
        Categoria categoria13 = new Categoria(null, "Saúde e Bem-estar");
        Categoria categoria14 = new Categoria(null, "Artes e Artesanato");
        Categoria categoria15 = new Categoria(null, "Pet Shop");
        Categoria categoria16 = new Categoria(null, "Instrumentos Musicais");
        Categoria categoria17 = new Categoria(null, "Ferramentas e Construção");
        Categoria categoria18 = new Categoria(null, "Filmes, Música e Entretenimento");
        Categoria categoria19 = new Categoria(null, "Bebês e Crianças");
        Categoria categoria20 = new Categoria(null, "Viagens e Bagagem");

        Produto produto1 = new Produto(null, "computador", 2000.00);
        Produto produto2 = new Produto(null, "Tablet", 1500.00);
        Produto produto3 = new Produto(null, "teclado", 600.00);

        categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
        categoria2.getProdutos().addAll(Arrays.asList(produto2));

        produto1.getCategorias().addAll(Arrays.asList(categoria1));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria1));

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4, categoria5, categoria6, categoria7));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));


        Estado estado1 = new Estado(null, "Minas Gerais");
        Estado estado2 = new Estado(null, "Campinas");
        Estado estado3 = new Estado(null, "RJ");

        Cidade cidade1 = new Cidade(null, "Uberlandia", estado1);
        Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
        Cidade cidade3 = new Cidade(null, "São Paulo", estado2);
        Cidade cidade4 = new Cidade(null, "Rio de Janeiro", estado3);

        estado1.getCidades().addAll(Arrays.asList(cidade1));
        estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

        estadoRepository.saveAll(Arrays.asList(estado1, estado2));
        cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));


        // ? gerei esses dados usando o https://www.fakenamegenerator.com

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cidade1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cidade2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Pedido pedido1 = new Pedido(null, simpleDateFormat.parse("30/29/2017 10:23"), cli1, e1);
        Pedido pedido2 = new Pedido(null, simpleDateFormat.parse("30/29/2017 10:10"), cli1, e2);

        Pagamento pagamento1 = new PagamentoComCartão(null, EstadoPagamento.QUITADO, pedido1, 6);
        pedido1.setPagamento(pagamento1);

        Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, simpleDateFormat.parse("20/10/2017 00:00") , null);
        pedido2.setPagamento(pagamento2);

        cli1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
        pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));

        ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 0.00, 1, 2000.00);
        ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 0.00, 2, 80.00);
        ItemPedido itemPedido3 = new ItemPedido(pedido2, produto2, 100.00, 1, 800.00);

        pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
        pedido2.getItens().addAll(Arrays.asList(itemPedido3));

        produto1.getItens().addAll(Arrays.asList(itemPedido1));
        produto2.getItens().addAll(Arrays.asList(itemPedido3));
        produto3.getItens().addAll(Arrays.asList(itemPedido2));

        itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
    }
}
