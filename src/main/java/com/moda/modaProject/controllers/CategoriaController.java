package com.moda.modaProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.modaProject.models.Categoria;
import com.moda.modaProject.models.Fornecedor;
import com.moda.modaProject.repositories.CategoriaRepository;
import com.moda.modaProject.repositories.FornecedorRepository;



@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping("")
	public ModelAndView getTodosCategorias() {
		// redirect pra pagina produtoPag que está dentro da pasta produto
		ModelAndView model = new ModelAndView("create/cadastroCategoria");

		// pega todos os produtos que tem no banco, já cadastrados
		List<Categoria> listaCategoria = categoriaRepository.findAll();

		// adicionar lista de produtos preenchida na linha de cima, em uma espécie de
		// variável
		// para chamarmos dentro da página
		model.addObject("categorias", listaCategoria);

		// retorna a página produtoPag
		return model;
	}

	@PostMapping("/createCategoria")
	public String create(@ModelAttribute("listaCategoria") Categoria objCategoria) {
		// salva as informações preenchidas no banco
		categoriaRepository.save(objCategoria);
		// chama o getTodosProdutosEAbrePaginaDeProduto (que corresponde /produto)
		return "redirect:/categoria";
	}
	
}
