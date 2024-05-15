package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

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
 return manager.createQuery("select S1 from Movie S1 where id=?1").setParameter(1, id).getResultList();
	
}

public List<Movie> fetchbyName(String Name){
	return manager.createQuery("select s1 from Movie s1 where name=?1").setParameter(1, Name).getResultList();
}

public List<Movie> fetchbyRating(double rating){
	return manager.createQuery("select s1 from Movie s1 where rating >=?1").setParameter(1, rating).getResultList();
}

public List<Movie> fetchbylanguage(String language) {
	return manager.createQuery("select s1 from Movie s1 where language =?1").setParameter(1, language).getResultList();
}

public void deleteMovie(int id) {
	transaction.begin();
	manager.remove(manager.find(Movie.class, id));
	transaction.commit();
}

public Movie fetchObject(int id) {
	return manager.find(Movie.class, id);	
}

public void updateMovie(Movie movie) {
	transaction.begin();
	manager.merge(movie);
	transaction.commit();	
}


}
