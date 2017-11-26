/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Main.Movie;
import Main.Session;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Icaro
 */
public interface MovieInterface {

    public default boolean insertMovieSessions(Movie movie) {
        try {
            for (Session session : movie.getSessions()) {

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into sessaofilme (filmeid, sessaoid) values (?, ?)");
                preparedStatement.setString(1, String.valueOf(movie.getId()));
                preparedStatement.setString(2, String.valueOf(session.getId()));
                preparedStatement.executeUpdate();

            }

            JOptionPane.showMessageDialog(null, "Sessões do Filme " + movie.getName() + " cadastradas com Sucesso!");
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar as Sessões do Filme.");
        }
        return false;
    }

    public default boolean deleteMovieSessions(Integer movieId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from sessaofilme where filmeid = ?");
            preparedStatement.setString(1, String.valueOf(movieId));

            preparedStatement.executeUpdate();
            
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir as Sessões do Filme.");
        }
        return false;
    }
}
