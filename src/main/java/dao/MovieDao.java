package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Movie;

public class MovieDao {
EntityManagerFactory factory = Persistence.createEntityManagerFactory("shashank");
EntityManager manager = factory.createEntityManager();
EntityTransaction transaction = manager.getTransaction();

public void saveMovie(Movie movie) {
	transaction.begin();
	manager.persist(movie);
	transaction.commit();
}

public List<Movie> fetchAll()
{
	return manager.createQuery("select S1 from Movie S1").getResultList();
	
}

public List<Movie> fetchById(int id) {
 return manager.
	
}
}
