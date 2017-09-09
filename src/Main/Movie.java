/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author Icaro
 */
public class Movie {
    
    private Integer id;
    
    private Room room;
    
    private String name;
    
    private String ageRating;
    
    private boolean inTheaters;
    
    private Pair<LocalDate, LocalDate> inTheatersPeriod;
    
    private String genre;
    
    private List<Session> sessions;
    
    private int time;
    
    private String synopsis;
    
    private String language;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

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
    
    public static List<String> getInTheaterMovieNames () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alunos_tcc", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("select nome from filme where em_cartaz = 'true'");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> resultado = new ArrayList<>();
            while (resultSet.next()) {
                resultado.add(resultSet.getString("nome"));
            }
            return resultado;
        } catch (ClassNotFoundException | SQLException ex) {
            
        }
        return null;
    }
    
}
