package fr.treeptik.pizzaiolo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.pizzaiolo2.exception.ServiceException;
import fr.treeptik.pizzaiolo2.model.Pizza;
import fr.treeptik.pizzaiolo2.service.PizzaService;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init() throws ServiceException {
		ModelAndView view = new ModelAndView("list", "pizzas",
				pizzaService.list());
		view.addObject("initialPizza", new Pizza());
		return view;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("initialPizza") Pizza pizza)
			throws ServiceException {
		pizzaService.save(pizza);
		return init();
	}

}
