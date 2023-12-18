package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Destinos;
import mvc.repository.DestinoRepository;

@Controller
@RequestMapping("/destinos")
public class DestinoController {

	@Autowired
	private DestinoRepository destinoRepository;
	
	@GetMapping
	public ModelAndView  destino() {
		ModelAndView modelAndView = new ModelAndView("views/destinos/index.html");
		modelAndView.addObject("destinos", destinoRepository.findAll());
		modelAndView.addObject("destino", new Destinos()); 
		
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Destinos destino) {
		destinoRepository.save(destino);

		return "redirect:/destinos";
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		destinoRepository.deleteById(id);

		return "redirect:/destinos";
	}
}

