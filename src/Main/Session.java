/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interfaces.SessionInterface;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Icaro
 */
public class Session implements SessionInterface {

    private Integer id;

    private Room room;

    private String time;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public Integer getId() {
        return id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private final String SESSION_FIND_QUERY = " select * from session ";

    private static final String SESSION_INSERT_QUERY = " insert into sessao (hora_sessao, sala) values (?, ?)";

    @Override
    public void persistSession(Session session) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alunos_tcc", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SESSION_INSERT_QUERY);
            preparedStatement.setString(1, session.getTime());
            preparedStatement.setString(2, String.valueOf(session.getRoom().getNumber()));

            if (preparedStatement.executeUpdate() > 1) {
                JOptionPane.showMessageDialog(null, "Sessão cadastrada com Sucesso!");
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a Sessão.");
        }
    }

    @Override
    public List<Session> findAllSessions() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alunos_tcc", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(SESSION_FIND_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Session> result = new ArrayList<>();

            while (resultSet.next()) {
                Session session = new Session();
                session.setTime(resultSet.getString("hora_sessao"));
                session.setRoom(session.getRoom().findRoomByNumber(resultSet.getInt("sala")));
                result.add(session);
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
        }
        return null;
    }

    @Override
    public List<Session> findSessionByTime(String time) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alunos_tcc", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(SESSION_FIND_QUERY + " where hora_sessao = (?)");
            preparedStatement.setString(1, time);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Session> result = new ArrayList<>();

            while (resultSet.next()) {
                Session session = new Session();
                session.setTime(resultSet.getString("hora_sessao"));
                session.setRoom(session.getRoom().findRoomByNumber(resultSet.getInt("sala")));
                result.add(session);
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
        }
        return null;
    }

    @Override
    public List<Session> findSessionByRoom(Integer roomId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alunos_tcc", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(SESSION_FIND_QUERY + " where salaId = (?)");
            preparedStatement.setString(1, roomId.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Session> result = new ArrayList<>();

            while (resultSet.next()) {
                Session session = new Session();
                session.setTime(resultSet.getString("hora_sessao"));
                session.setRoom(session.getRoom().findRoomByNumber(resultSet.getInt("sala")));
                result.add(session);
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
        }
        return null;
    }

}
