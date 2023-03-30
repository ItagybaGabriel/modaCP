package com.moda.modaProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.modaProject.models.Cliente;
import com.moda.modaProject.models.Fornecedor;
import com.moda.modaProject.repositories.ClienteRepository;
import com.moda.modaProject.repositories.FornecedorRepository;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("")
	public ModelAndView getTodosClientes() {
		// redirect pra pagina produtoPag que está dentro da pasta produto
		ModelAndView model = new ModelAndView("create/cadastroCliente");

		// pega todos os produtos que tem no banco, já cadastrados
		List<Cliente> listaCliente = clienteRepository.findAll();

		// adicionar lista de produtos preenchida na linha de cima, em uma espécie de
		// variável
		// para chamarmos dentro da página
		model.addObject("clientes", listaCliente);

		// retorna a página produtoPag
		return model;
	}

	@PostMapping("/createCliente")
	public String create(@ModelAttribute("listaCliente") Cliente objCliente) {
		// salva as informações preenchidas no banco
		clienteRepository.save(objCliente);
		// chama o getTodosProdutosEAbrePaginaDeProduto (que corresponde /produto)
		return "redirect:/cliente";
	}
	
	
}
