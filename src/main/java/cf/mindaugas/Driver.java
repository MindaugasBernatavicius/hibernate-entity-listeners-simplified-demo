package cf.mindaugas;

import cf.mindaugas.model.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Driver {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("cf.mindaugas.movie_catalog");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {

        Driver d = new Driver();
        long id = d.saveMovieGiveId();
        Movie movie = d.getMovie(id);
        System.out.println(movie.getAge());

    }

    public Movie getMovie(Long movieId) {
        EntityManager em = getEntityManager();
        Movie movie = em.find(Movie.class, new Long(movieId));
        return movie;
    }

    public long saveMovieGiveId() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Movie movie = new Movie();
        movie.setId(3L);
        movie.setMovieName("The Godfather");
        movie.setReleaseYear(1972);
        movie.setLanguage("English");
        em.persist(movie);
        em.getTransaction().commit();
        return movie.getId();
    }
}
