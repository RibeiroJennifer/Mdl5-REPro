package mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Compras;
import mvc.model.Usuarios;
import mvc.repository.ComprasRepository;
import mvc.repository.DestinoRepository;
import mvc.repository.UsuarioRepository;


@Controller
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private ComprasRepository comprasRepository; 
	@Autowired
	private UsuarioRepository usuarioRepository; 
	@Autowired 
	private DestinoRepository destinoRepository;

	@GetMapping
	public ModelAndView compras() {
		ModelAndView modelAndView = new ModelAndView("views/compras/index.html");

		modelAndView.addObject("listaUsuarios", usuarioRepository.findAll());
		modelAndView.addObject("listaDestinos", destinoRepository.findAll());
		modelAndView.addObject("compras", comprasRepository.findAll());
		modelAndView.addObject("compra", new Compras());

		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("compra") Compras compra) {
		// Obtenha o usuário associado à compra
		Usuarios usuario = compra.getUsuario();

		// Verifique se o usuário já está persistido
		if (usuario.getId_usuario() == null) {
			// Se o usuário não estiver persistido, salve-o primeiro
			usuarioRepository.save(usuario);
		}

		// Logica provisoria para salvar o preço do livro em compras.
		double preco = destinoRepository.findById(compra.getDestino().getId_destino()).get().getPreco();
		compra.setTotal_compra(preco);

		comprasRepository.save(compra);

		return "redirect:/compras";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		comprasRepository.deleteById(id);

		return "redirect:/compras";
	}
}
