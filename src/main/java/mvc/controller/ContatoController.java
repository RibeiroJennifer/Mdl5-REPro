package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Contato;
import mvc.repository.ContatoRepository;

@Controller
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@GetMapping
	public ModelAndView  contato() {
		ModelAndView modelAndView = new ModelAndView("views/contato/index.html");
		modelAndView.addObject("contatos", contatoRepository.findAll());
		modelAndView.addObject("contato", new Contato()); 
		
		return modelAndView;
	}
	
	@PostMapping("/criar")
	public String criar(Contato contato) {
		contatoRepository.save(contato);

		return "redirect:/contato";
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		contatoRepository.deleteById(id);

		return "redirect:/contato";
	}
}
