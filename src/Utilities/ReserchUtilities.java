/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Main.Room;
import Main.Session;
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
public class ReserchUtilities {

    public static List<String> findAllRoomsNumbers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(Room.ROOM_FIND_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(resultSet.getString("numero"));
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sala encontrada!");
        }
        return null;
    }

    public static List<Room> findAllRooms() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(Room.ROOM_FIND_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Room> result = new ArrayList<>();

            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt("id"));
                room.setCapacity(Integer.parseInt(resultSet.getString("lotacao")));
                room.setNumber(Integer.parseInt(resultSet.getString("numero")));
                room.setAir_conditioning(resultSet.getBoolean("ar_condicionado"));
                result.add(room);
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sala encontrada!");
        }
        return null;
    }

    public static Room findRoomByNumber(Integer number) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(Room.ROOM_FIND_QUERY + " where numero = ?");
            preparedStatement.setString(1, number.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            Room room = new Room();
            room.setId(resultSet.getInt("id"));
            room.setCapacity(resultSet.getInt("lotacao"));
            room.setNumber(resultSet.getInt("numero"));
            room.setAir_conditioning(resultSet.getBoolean("ar_condicionado"));

            return room;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sala encontrada!");
        }
        return null;
    }

    public static Room findRoomById(Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(Room.ROOM_FIND_QUERY + " where id = ?");
            preparedStatement.setString(1, id.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            Room room = new Room();
            room.setId(resultSet.getInt("id"));
            room.setCapacity(resultSet.getInt("lotacao"));
            room.setNumber(resultSet.getInt("numero"));
            room.setAir_conditioning(resultSet.getBoolean("ar_condicionado"));

            return room;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sala encontrada!");
        }
        return null;
    }

    public static List<Room> findRoomsByParams(Integer number, Boolean airConditioning) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            String query = Room.ROOM_FIND_QUERY;

            if (number != null && airConditioning != null) {
                query = query + " where numero = ? and ar_condicionado = ?";
            } else if (number != null) {
                query = query + " where numero = ?";
            } else if (airConditioning != null) {
                query = query + " where ar_condicionado = ?";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            if (number != null && airConditioning != null) {
                preparedStatement.setString(1, number.toString());
                preparedStatement.setString(2, airConditioning.toString());
            } else if (number != null) {
                preparedStatement.setString(1, number.toString());
            } else if (airConditioning != null) {
                preparedStatement.setString(1, airConditioning.toString());
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Room> result = new ArrayList<>();

            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt("id"));
                room.setCapacity(resultSet.getInt("lotacao"));
                room.setNumber(resultSet.getInt("numero"));
                room.setAir_conditioning(resultSet.getBoolean("ar_condicionado"));
                result.add(room);
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sala encontrada!");
        }
        return null;
    }

    public static List<Session> findSessionsByParams(String schedule, Integer roomId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            String query = Session.SESSION_FIND_QUERY;

            if (schedule != null && roomId != null) {
                query = query + " where hora_sessao like ? and salaId = ?";
            } else if (schedule != null) {
                query = query + " where hora_sessao like ?";
            } else if (roomId != null) {
                query = query + " where salaId = ?";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            if (schedule != null && roomId != null) {
                preparedStatement.setString(1, "%" + schedule + "%");
                preparedStatement.setString(2, roomId.toString());
            } else if (schedule != null) {
                preparedStatement.setString(1, "%" + schedule + "%");
            } else if (roomId != null) {
                preparedStatement.setString(1, String.valueOf(roomId));
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Session> result = new ArrayList<>();

            while (resultSet.next()) {
                Session session = new Session();
                session.setId(resultSet.getInt("id"));
                session.setTime(resultSet.getString("hora_sessao"));
                session.setRoom(findRoomById(resultSet.getInt("salaId")));
                result.add(session);
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
        }
        return null;
    }

    public static Session findSessionByParams(String schedule, Integer roomId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            String query = Session.SESSION_FIND_QUERY;

            if (schedule != null && roomId != null) {
                query = query + " where hora_sessao = ? and salaId = ?";
            } else if (schedule != null) {
                query = query + " where hora_sessao = ?";
            } else if (roomId != null) {
                query = query + " where salaId = ?";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            if (schedule != null && roomId != null) {
                preparedStatement.setString(1, schedule);
                preparedStatement.setString(2, roomId.toString());
            } else if (schedule != null) {
                preparedStatement.setString(1, schedule);
            } else if (roomId != null) {
                preparedStatement.setString(1, roomId.toString());
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            Session session = new Session();
            session.setId(resultSet.getInt("id"));
            session.setTime(resultSet.getString("hora_sessao"));
            session.setRoom(findRoomById(resultSet.getInt("salaId")));

            return session;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
        }
        return null;
    }
    
    public static List<Session> findAllSessions() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(Session.SESSION_FIND_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Session> result = new ArrayList<>();

            while (resultSet.next()) {
                Session session = new Session();
                session.setId(resultSet.getInt("id"));
                session.setTime(resultSet.getString("hora_sessao"));
                session.setRoom(findRoomById(resultSet.getInt("salaId")));
                result.add(session);
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
        }
        return null;
    }
}
