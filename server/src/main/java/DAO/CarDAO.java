package DAO;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import models.Car;

@Stateless
public class CarDAO extends GenericDAO<Car, Integer> {

    @Override
    public Car get(Integer param) {
        Car entity = em.find(Car.class, param);
		return entity;
    }

    @Override
    public List<Car> getAll() {
        String jpql = "SELECT c FROM Car c";
		Query query = em.createQuery(jpql);
		return query.getResultList();
    }

}
