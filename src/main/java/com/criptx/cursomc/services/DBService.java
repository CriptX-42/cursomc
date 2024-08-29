package com.criptx.cursomc.services;

import com.criptx.cursomc.domain.*;
import com.criptx.cursomc.domain.enums.EstadoPagamento;
import com.criptx.cursomc.domain.enums.Perfil;
import com.criptx.cursomc.domain.enums.TipoCliente;
import com.criptx.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

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
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void instantiateTestDatabase() throws ParseException {
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
        Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
        Produto p5 = new Produto(null, "Toalha", 50.00);
        Produto p6 = new Produto(null, "Colcha", 200.00);
        Produto p7 = new Produto(null, "TV true color", 1200.00);
        Produto p8 = new Produto(null, "Roçadeira", 800.00);
        Produto p9 = new Produto(null, "Abajour", 100.00);
        Produto p10 = new Produto(null, "Pendente", 180.00);
        Produto p11 = new Produto(null, "Shampoo", 90.00);

        categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
        categoria2.getProdutos().addAll(Arrays.asList(produto2));
        categoria2.getProdutos().addAll(Arrays.asList(produto2, p4));
        categoria3.getProdutos().addAll(Arrays.asList(p5, p6));
        categoria4.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3, p7));
        categoria5.getProdutos().addAll(Arrays.asList(p8));
        categoria6.getProdutos().addAll(Arrays.asList(p9, p10));
        categoria7.getProdutos().addAll(Arrays.asList(p11));

        produto1.getCategorias().addAll(Arrays.asList(categoria1, categoria4));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2, categoria4));
        produto3.getCategorias().addAll(Arrays.asList(categoria1, categoria4));
        p4.getCategorias().addAll(Arrays.asList(categoria2));
        p5.getCategorias().addAll(Arrays.asList(categoria3));
        p6.getCategorias().addAll(Arrays.asList(categoria3));
        p7.getCategorias().addAll(Arrays.asList(categoria4));
        p8.getCategorias().addAll(Arrays.asList(categoria5));
        p9.getCategorias().addAll(Arrays.asList(categoria6));
        p10.getCategorias().addAll(Arrays.asList(categoria6));
        p11.getCategorias().addAll(Arrays.asList(categoria7));

        produto1.getCategorias().addAll(Arrays.asList(categoria1));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria1));

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4, categoria5, categoria6, categoria7));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, p4, p5, p6, p7, p8, p9, p10, p11));


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

        Cliente cli1 = new Cliente(null, "Maria Silva", "rs6073@gmail.com", "36378912377", TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("1234"));

        cli1.addPerfil(Perfil.CLIENTE);
        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        Cliente cli2 = new Cliente(null, "Ana Costa", "nelio.iftm@gmail.com", "31628382740", TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123"));
        cli2.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
        cli2.addPerfil(Perfil.ADMIN);

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cidade1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cidade2);
        Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2, cidade2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
        cli2.getEnderecos().addAll(Arrays.asList(e3));

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Pedido pedido1 = new Pedido(null, simpleDateFormat.parse("30/29/2017 10:23"), cli1, e1);
        Pedido pedido2 = new Pedido(null, simpleDateFormat.parse("30/29/2017 10:10"), cli1, e2);

        Pagamento pagamento1 = new PagamentoComCartão(null, EstadoPagamento.QUITADO, pedido1, 6);
        pedido1.setPagamento(pagamento1);

        Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, simpleDateFormat.parse("20/10/2017 00:00"), null);
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
