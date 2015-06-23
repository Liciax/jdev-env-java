package fr.treeptik.pizzaiolo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import fr.treeptik.pizzaiolo2.dao.PizzaDAO;
import fr.treeptik.pizzaiolo2.exception.ServiceException;
import fr.treeptik.pizzaiolo2.model.Pizza;

@Service
public class PizzaService {

	@Autowired
	private PizzaDAO pizzaDAO;

	public Pizza save(Pizza pizza) throws ServiceException {
		try {
			return pizzaDAO.save(pizza);
		} catch (DataAccessException e) {
			throw new ServiceException("error save pizza", e);
		}
	}

	public void delete(Pizza pizza) throws ServiceException {
		try {
			pizzaDAO.delete(pizza);
		} catch (DataAccessException e) {
			throw new ServiceException("error save pizza", e);
		}
	}

	public List<Pizza> list() throws ServiceException {
		try {
			return pizzaDAO.findAll();
		} catch (DataAccessException e) {
			throw new ServiceException("error find pizza", e);
		}
	}
}
