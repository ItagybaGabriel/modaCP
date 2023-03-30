package com.moda.modaProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.modaProject.models.Fornecedor;
import com.moda.modaProject.models.Produto;
import com.moda.modaProject.repositories.FornecedorRepository;
import com.moda.modaProject.repositories.ProdutoRepository;


@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@GetMapping("")
	public ModelAndView getTodosFornecedores() {
		// redirect pra pagina produtoPag que está dentro da pasta produto
		ModelAndView model = new ModelAndView("create/cadastroFornecedor");

		// pega todos os produtos que tem no banco, já cadastrados
		List<Fornecedor> listaFornecedor = fornecedorRepository.findAll();

		// adicionar lista de produtos preenchida na linha de cima, em uma espécie de
		// variável
		// para chamarmos dentro da página
		model.addObject("fornecedores", listaFornecedor);

		// retorna a página produtoPag
		return model;
	}

	@PostMapping("/createFornecedor")
	public String create(@ModelAttribute("listaFornecedor") Fornecedor objFornecedor) {
		// salva as informações preenchidas no banco
		fornecedorRepository.save(objFornecedor);
		// chama o getTodosProdutosEAbrePaginaDeProduto (que corresponde /produto)
		return "redirect:/fornecedor";
	}
}
