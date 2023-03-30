package com.moda.modaProject.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.modaProject.models.Produto;
import com.moda.modaProject.repositories.ProdutoRepository;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("")
	public ModelAndView getTodosProdutos() {
		// redirect pra pagina produtoPag que está dentro da pasta produto
		ModelAndView model = new ModelAndView("create/cadastroProduto");

		// pega todos os produtos que tem no banco, já cadastrados
		List<Produto> listaProduto = produtoRepository.findAll();

		// adicionar lista de produtos preenchida na linha de cima, em uma espécie de
		// variável
		// para chamarmos dentro da página
		model.addObject("produtos", listaProduto);

		// retorna a página produtoPag
		return model;
	}
	
	@GetMapping("/masculino")
	public ModelAndView getTodosProdutosMasculinos() {
		ModelAndView model = new ModelAndView("index");
		List<Produto> listaProduto = produtoRepository.findAll();
		Stream<Produto> listaMasculino = listaProduto.stream().filter(p -> p.getCategoria() == 1);
		
		model.addObject("produtoss", listaMasculino);
		return model;
	}
	
	@GetMapping("/feminino")
	public ModelAndView getTodosProdutosFemininos() {
		ModelAndView model = new ModelAndView("index");
		List<Produto> listaProduto = produtoRepository.findAll();
		Stream<Produto> listaFemininos = listaProduto.stream().filter(p -> p.getCategoria() == 2);
		
		model.addObject("produtoss", listaFemininos);
		return model;
	}
	
	@GetMapping("/unissex")
	public ModelAndView getTodosProdutosUnissex() {
		ModelAndView model = new ModelAndView("index");
		List<Produto> listaProduto = produtoRepository.findAll();
		Stream<Produto> listaUnissex = listaProduto.stream().filter(p -> p.getCategoria() == 3);
		
		model.addObject("produtoss", listaUnissex);
		return model;
	}

	@PostMapping("/createProduto")
	public String create(@ModelAttribute("listaProdutos") Produto objProduto) {
		// salva as informações preenchidas no banco
		produtoRepository.save(objProduto);
		// chama o getTodosProdutosEAbrePaginaDeProduto (que corresponde /produto)
		return "redirect:/produto";
	}
	
}
