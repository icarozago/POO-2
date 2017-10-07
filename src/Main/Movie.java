/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interfaces.MovieInterface;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javafx.util.Pair;
import javax.swing.JOptionPane;

/**
 *
 * @author Icaro
 */
public class Movie implements MovieInterface{
    
    private Integer id;
    
    private String name;
    
    private String ageRating;
    
    private boolean inTheaters;
    
    private Pair<LocalDate, LocalDate> inTheatersPeriod;
    
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

    public Pair<LocalDate, LocalDate> getInTheatersPeriod() {
        return inTheatersPeriod;
    }

    public void setInTheatersPeriod(Pair<LocalDate, LocalDate> inTheatersPeriod) {
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
    
    public static final String MOVIE_FIND_QUERY = " select * from filme ";
    
    private static final String MOVIE_EDIT_QUERY = " update filme set nome = ?, em_cartaz = ?, data_inicio = ?, data_fim = ?, classificacao = ?, idioma = ?, genero = ?, duracao = ?, sinopse = ? where id = ? ";
    
    private static final String MOVIE_INSERT_QUERY = " insert into filme (nome, em_cartaz, data_inicio, data_fim, classificacao, idioma, genero, duracao, sinopse) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    
    private static final String MOVIE_DELETE_QUERY = " delete from filme where id = ? ";

    @Override
    public boolean insertMovie(Movie movie) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(MOVIE_INSERT_QUERY);
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, String.valueOf(movie.isInTheaters()));
            preparedStatement.setString(3, movie.getInTheatersPeriod().getKey().toString());
            preparedStatement.setString(4, movie.getInTheatersPeriod().getValue().toString());
            preparedStatement.setString(5, movie.getAgeRating());
            preparedStatement.setString(6, movie.getLanguage());
            preparedStatement.setString(7, movie.getGenre());
            preparedStatement.setString(8, String.valueOf(movie.getTime()));
            preparedStatement.setString(9, movie.getSynopsis());

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Filme cadastrado com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Filme.");
        }
        return false;
    }

    @Override
    public boolean editMovie(Movie movie) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(MOVIE_EDIT_QUERY);
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, String.valueOf(movie.isInTheaters()));
            preparedStatement.setString(3, movie.getInTheatersPeriod().getKey().toString());
            preparedStatement.setString(4, movie.getInTheatersPeriod().getValue().toString());
            preparedStatement.setString(5, movie.getAgeRating());
            preparedStatement.setString(6, movie.getLanguage());
            preparedStatement.setString(7, movie.getGenre());
            preparedStatement.setString(8, String.valueOf(movie.getTime()));
            preparedStatement.setString(9, movie.getSynopsis());
            preparedStatement.setString(10, String.valueOf(movie.getId()));

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Filme edtado com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o Filme.");
        }
        return false;
    }

    @Override
    public boolean deleteMovie(Integer movieId) {
        try {
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
