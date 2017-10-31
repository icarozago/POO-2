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

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public static final String SESSION_FIND_QUERY = " select * from sessao ";

    private static final String SESSION_INSERT_QUERY = " insert into sessao (hora_sessao, salaId) values (?, ?)";
    
    private static final String SESSION_EDIT_QUERY = " update sessao set hora_sessao = ?, salaId = ? where id = ?";
    
    private static final String SESSION_DELETE_QUERY = " delete from sessao where id = ?";

    @Override
    public boolean insertSession(Session session) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SESSION_INSERT_QUERY);
            preparedStatement.setString(1, session.getTime());
            preparedStatement.setString(2, String.valueOf(session.getRoom().getId()));

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sessão cadastrada com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a Sessão.");
        }
        return false;
    }

//    @Override
//    public List<Session> findAllSessions() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection;
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
//            PreparedStatement preparedStatement = connection.prepareStatement(SESSION_FIND_QUERY);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<Session> result = new ArrayList<>();
//
//            while (resultSet.next()) {
//                Session session = new Session();
//                session.setTime(resultSet.getString("hora_sessao"));
//                session.setRoom(session.getRoom().findRoomByNumber(resultSet.getInt("salaId")));
//                result.add(session);
//            }
//
//            return result;
//        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
//            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
//        }
//        return null;
//    }
//
//    @Override
//    public List<Session> findSessionByTime(String time) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection;
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alunos_tcc", "root", "123456");
//            PreparedStatement preparedStatement = connection.prepareStatement(SESSION_FIND_QUERY + " where hora_sessao = (?)");
//            preparedStatement.setString(1, time);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<Session> result = new ArrayList<>();
//
//            while (resultSet.next()) {
//                Session session = new Session();
//                session.setTime(resultSet.getString("hora_sessao"));
//                session.setRoom(session.getRoom().findRoomByNumber(resultSet.getInt("sala")));
//                result.add(session);
//            }
//
//            return result;
//        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
//            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
//        }
//        return null;
//    }
//
//    @Override
//    public List<Session> findSessionByRoom(Integer roomId) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection;
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alunos_tcc", "root", "123456");
//            PreparedStatement preparedStatement = connection.prepareStatement(SESSION_FIND_QUERY + " where salaId = (?)");
//            preparedStatement.setString(1, roomId.toString());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<Session> result = new ArrayList<>();
//
//            while (resultSet.next()) {
//                Session session = new Session();
//                session.setTime(resultSet.getString("hora_sessao"));
//                session.setRoom(session.getRoom().findRoomByNumber(resultSet.getInt("sala")));
//                result.add(session);
//            }
//
//            return result;
//        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
//            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
//        }
//        return null;
//    }

    @Override
    public boolean editSession(Session session) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SESSION_EDIT_QUERY);
            preparedStatement.setString(1, session.getTime());
            preparedStatement.setString(2, String.valueOf(session.getRoom().getId()));
            preparedStatement.setString(3, session.getId().toString());

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sessão editada com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar a Sessão.");
        }
        return false;
    }

    @Override
    public boolean deleteSession(Integer sessionId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SESSION_DELETE_QUERY);
            preparedStatement.setString(1, sessionId.toString());

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sessão excluída com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a Sessão.");
        }
        return false;
    }

}
