package fr.treeptik.pizzaiolo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.treeptik.pizzaiolo2.model.Pizza;

public interface PizzaDAO extends JpaRepository<Pizza, Integer> {

}
