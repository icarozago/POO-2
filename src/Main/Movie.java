
package Main;

import Interfaces.MovieInterface;
import Interfaces.SerializableInterface;
import Utilities.ReserchUtilities;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javafx.util.Pair;
import javax.swing.JOptionPane;

public class Movie implements SerializableInterface, MovieInterface{
    
    private Integer id;
    
    private String name;
    
    private String ageRating;
    
    private boolean inTheaters;
    
    private Pair<String, String> inTheatersPeriod;
    
    private String genre;
    
    private List<Session> sessions;
    
    private int time;
    
    private String synopsis;
    
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public boolean isInTheaters() {
        return inTheaters;
    }

    public void setInTheaters(boolean inTheaters) {
        this.inTheaters = inTheaters;
    }

    public Pair<String, String> getInTheatersPeriod() {
        return inTheatersPeriod;
    }

    public void setInTheatersPeriod(Pair<String, String> inTheatersPeriod) {
        this.inTheatersPeriod = inTheatersPeriod;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Query para selecionar todas os filmes
     */
    public static final String MOVIE_FIND_QUERY = " select * from filme ";
    
    /**
     * Query para alterar filmes
     */
    private static final String MOVIE_EDIT_QUERY = " update filme set nome = ?, em_cartaz = ?, data_inicio = ?, data_fim = ?, classificacao = ?, idioma = ?, genero = ?, duracao = ?, sinopse = ? where id = ? ";
    
    /**
     * Query para inserir filmes
     */
    private static final String MOVIE_INSERT_QUERY = " insert into filme (nome, em_cartaz, data_inicio, data_fim, classificacao, idioma, genero, duracao, sinopse) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    
     /**
     * Query para deletar filmes
     */
    private static final String MOVIE_DELETE_QUERY = " delete from filme where id = ? ";

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean insert(Object object) {
        try {
            Movie movie = (Movie) object;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(MOVIE_INSERT_QUERY);
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, String.valueOf(movie.isInTheaters()));
            preparedStatement.setString(3, movie.getInTheatersPeriod().getKey());
            preparedStatement.setString(4, movie.getInTheatersPeriod().getValue());
            preparedStatement.setString(5, movie.getAgeRating());
            preparedStatement.setString(6, movie.getLanguage());
            preparedStatement.setString(7, movie.getGenre());
            preparedStatement.setString(8, String.valueOf(movie.getTime()));
            preparedStatement.setString(9, movie.getSynopsis());
            
            boolean insertSessions = true;
            int insertNumbers = preparedStatement.executeUpdate();
            
            if (movie.getSessions() != null) {
                movie.setId(ReserchUtilities.findMovieByName(movie.getName())
                        .getId());
                insertSessions = movie.insertMovieSessions(movie);
            }

            if (insertSessions &&  insertNumbers > 0) {
                JOptionPane.showMessageDialog(null, "Filme cadastrado com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Filme.");
        }
        return false;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean edit(Object object) {
        try {
            Movie movie = (Movie) object;
            movie.deleteMovieSessions(movie.getId());
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(MOVIE_EDIT_QUERY);
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, String.valueOf(movie.isInTheaters()));
            preparedStatement.setString(3, movie.getInTheatersPeriod().getKey());
            preparedStatement.setString(4, movie.getInTheatersPeriod().getValue());
            preparedStatement.setString(5, movie.getAgeRating());
            preparedStatement.setString(6, movie.getLanguage());
            preparedStatement.setString(7, movie.getGenre());
            preparedStatement.setString(8, String.valueOf(movie.getTime()));
            preparedStatement.setString(9, movie.getSynopsis());
            preparedStatement.setString(10, String.valueOf(movie.getId()));
            
            boolean insertSessions = true;
            
            if (movie.getSessions() != null) {
                insertSessions = movie.insertMovieSessions(movie);
            }

            if (insertSessions && preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Filme edtado com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o Filme.");
        }
        return false;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean delete(Object object) {
        try {
            Integer movieId = (Integer) object;
            new Movie().deleteMovieSessions(movieId);
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(MOVIE_DELETE_QUERY);
            preparedStatement.setString(1, String.valueOf(movieId));

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Filme excluido com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Filme.");
        }
        return false;
    }

    
}
