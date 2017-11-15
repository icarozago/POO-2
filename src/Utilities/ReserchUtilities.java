/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Main.HalfTicket;
import Main.Movie;
import Main.Room;
import Main.Sale;
import Main.Session;
import Main.Ticket;
import Main.WholeTicket;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.util.Pair;
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

    public static List<String> getInTheaterMoviesNames() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("select distinct nome from filme where em_cartaz = 'true'");
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

    public static Movie findMovieById(Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from filme where id = ?");
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            Movie result = new Movie();
            resultSet.next();
            result.setAgeRating(resultSet.getString("classificacao"));
            result.setGenre(resultSet.getString("genero"));
            result.setInTheaters(resultSet.getBoolean("em_cartaz"));
            result.setInTheatersPeriod(new Pair<>(
                    resultSet.getString("data_inicio"),
                    resultSet.getString("data_fim")));
            result.setLanguage(resultSet.getString("idioma"));
            result.setName(resultSet.getString("nome"));
            result.setSessions(null);
            result.setSynopsis(resultSet.getString("sinopse"));
            result.setTime(Integer.valueOf(resultSet.getString("duracao")));
            result.setId(Integer.valueOf(resultSet.getString("id")));
            return result;
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return null;
    }

    public static List<Session> findMovieSessions(Integer movieId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select sessao.id, sessao.hora_sessao, sessao.salaid from "
                    + "sessaofilme inner join sessao on sessaofilme.sessaoid = sessao.id where filmeid = ?");
            preparedStatement.setString(1, String.valueOf(movieId));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Session> result = new ArrayList<>();
            while (resultSet.next()) {
                Session session = new Session();
                session.setId(resultSet.getInt("sessao.id"));
                session.setTime(resultSet.getString("sessao.hora_sessao"));
                session.setRoom(findRoomById(resultSet.getInt("sessao.salaId")));
                result.add(session);
            }

            return result;
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return null;
    }

    public static Movie findMovieByName(String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from filme where nome = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            Movie result = new Movie();
            resultSet.next();
            result.setAgeRating(resultSet.getString("classificacao"));
            result.setGenre(resultSet.getString("genero"));
            result.setInTheaters(resultSet.getBoolean("em_cartaz"));
            result.setInTheatersPeriod(new Pair<>(
                    resultSet.getString("data_inicio"),
                    resultSet.getString("data_fim")));
            result.setLanguage(resultSet.getString("idioma"));
            result.setName(resultSet.getString("nome"));
            result.setSessions(findMovieSessions(Integer.valueOf(resultSet.getString("id"))));
            result.setSynopsis(resultSet.getString("sinopse"));
            result.setTime(Integer.valueOf(resultSet.getString("duracao")));
            result.setId(Integer.valueOf(resultSet.getString("id")));
            return result;
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return null;
    }

    public static List<Movie> findAllMovies() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from filme");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Movie> result = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie();

                movie.setAgeRating(resultSet.getString("classificacao"));
                movie.setGenre(resultSet.getString("genero"));
                movie.setInTheaters(resultSet.getBoolean("em_cartaz"));
                movie.setInTheatersPeriod(new Pair<>(
                        resultSet.getString("data_inicio"),
                        resultSet.getString("data_fim")));
                movie.setLanguage(resultSet.getString("idioma"));
                movie.setName(resultSet.getString("nome"));
                movie.setSessions(findMovieSessions(Integer.valueOf(resultSet.getString("id"))));
                movie.setSynopsis(resultSet.getString("sinopse"));
                movie.setTime(Integer.valueOf(resultSet.getString("duracao")));
                movie.setId(Integer.valueOf(resultSet.getString("id")));

                result.add(movie);
            }
            return result;
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return null;
    }

    public static List<Movie> findMoviesByParams(String name, String ageRating,
            String sessionInit, String sessionFinish, String firstDate,
            String lastDate, Boolean inTheater) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            String query = "select filme.nome, filme.id, filme.classificacao,"
                    + " filme.duracao, filme.em_cartaz, filme.data_inicio, filme.data_fim,"
                    + " filme.idioma, filme.genero, filme.sinopse from filme "
                    + " left join sessaofilme on filme.id = sessaofilme.filmeid "
                    + " left join sessao on sessao.id = sessaofilme.sessaoid "
                    + " where filme.nome like ? and filme.classificacao like ? "
                    + " and filme.data_inicio >= ? and filme.data_fim <= ? "
                    + " and filme.em_cartaz like ?";

            if (!sessionInit.equals("Selecione") && !sessionFinish.equals("Selecione")) {
                query += " and sessao.hora_sessao >= ? and sessao.hora_sessao <= ? ";
            } else if (!sessionInit.equals("Selecione")) {
                query += " and sessao.hora_sessao >= ? ";
            } else if (!sessionFinish.equals("Selecione")) {
                query += " and sessao.hora_sessao <= ? ";
            }

            String initialDate;
            String finalDate;

            if (firstDate != null && !firstDate.equals("    /  /  ")) {
                initialDate = firstDate;
            } else {
                initialDate = "";
            }

            if (lastDate != null && !lastDate.equals("    /  /  ")) {
                finalDate = lastDate;
            } else {
                finalDate = "9999/12/31";
            }

            query += " group by filme.id";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, !name.isEmpty() ? "%" + name + "%" : "%");
            preparedStatement.setString(2, !ageRating.equals("Selecione") ? "%" + ageRating + "%" : "%");
            preparedStatement.setString(3, initialDate);
            preparedStatement.setString(4, finalDate);
            preparedStatement.setString(5, inTheater != null ? inTheater.toString() : "%");

            if (!sessionInit.equals("Selecione") && !sessionFinish.equals("Selecione")) {
                preparedStatement.setString(6, sessionInit);
                preparedStatement.setString(7, sessionFinish);
            } else if (!sessionInit.equals("Selecione")) {
                preparedStatement.setString(6, sessionInit);
            } else if (!sessionFinish.equals("Selecione")) {
                preparedStatement.setString(7, sessionFinish);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Movie> result = new ArrayList<>();

            while (resultSet.next()) {
                Movie movie = new Movie();

                movie.setAgeRating(resultSet.getString("filme.classificacao"));
                movie.setGenre(resultSet.getString("filme.genero"));
                movie.setInTheaters(resultSet.getBoolean("filme.em_cartaz"));
                movie.setInTheatersPeriod(new Pair<>(
                        resultSet.getString("filme.data_inicio"),
                        resultSet.getString("filme.data_fim")));
                movie.setLanguage(resultSet.getString("filme.idioma"));
                movie.setName(resultSet.getString("filme.nome"));
                movie.setSessions(findMovieSessions(Integer.valueOf(resultSet.getString("filme.id"))));
                movie.setSynopsis(resultSet.getString("filme.sinopse"));
                movie.setTime(Integer.valueOf(resultSet.getString("filme.duracao")));
                movie.setId(Integer.valueOf(resultSet.getString("filme.id")));

                result.add(movie);
            }
            return result;
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return null;
    }

    public static List<Session> findSessionsByMovie(Integer movieId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from sessaofilme where filmeid = ?");
            preparedStatement.setString(1, movieId.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Session> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(findSessionById(resultSet.getInt("sessaoid")));
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
        }
        return null;
    }

    public static Session findSessionById(Integer sessionId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(Session.SESSION_FIND_QUERY + " where id = ?");
            preparedStatement.setString(1, sessionId.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            Session result = new Session();

            resultSet.next();
            result.setId(resultSet.getInt("id"));
            result.setTime(resultSet.getString("hora_sessao"));
            result.setRoom(findRoomById(resultSet.getInt("salaId")));

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sessão encontrada!");
        }
        return null;
    }

    public static Sale findSaleByTime(Date date) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(Sale.SALE_FIND_QUERY + " where data like ?");
            preparedStatement.setString(1, "%" + formatter.format(date) + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Sale result = new Sale();

            resultSet.next();
            result.setId(resultSet.getInt("id"));
            result.setAmount(resultSet.getInt("valor"));
            result.setDate(date);
            result.setTickets(ReserchUtilities.findTicketsBySaleId(result.getId()));

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Venda encontrada!");
        }
        return null;
    }

    public static Sale findSaleById(Integer saleId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(Sale.SALE_FIND_QUERY + " where id = ?");
            preparedStatement.setString(1, saleId.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            Sale result = new Sale();

            resultSet.next();
            result.setId(resultSet.getInt("id"));
            result.setAmount(resultSet.getInt("valor"));
            result.setDate(resultSet.getDate("data"));
            result.setTickets(ReserchUtilities.findTicketsBySaleId(result.getId()));

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Venda encontrada!");
        }
        return null;
    }

    public static List<Ticket> findTicketsBySaleId(Integer saleId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select ingresso.filmeid, ingresso.sessaoid, ingresso.valor, "
                    + "venda.id, venda.data, venda.valor from ingresso "
                    + "inner join venda on venda.id = ingresso.vendaid "
                    + " where ingresso.vendaid = ?");
            preparedStatement.setString(1, String.valueOf(saleId));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Ticket> result = new ArrayList<>();
            while (resultSet.next()) {
                Ticket ticket;
                if (resultSet.getInt("ingresso.valor") == 8) {
                    ticket = new HalfTicket(findMovieById(
                            resultSet.getInt("ingresso.filmeId")),
                            findSessionById(resultSet.getInt("ingresso.sessaoId")),
                            null);
                } else {
                    ticket = new WholeTicket(findMovieById(
                            resultSet.getInt("ingresso.filmeId")),
                            findSessionById(resultSet.getInt("ingresso.sessaoId")),
                            null);
                }

                Sale sale = new Sale();
                sale.setId(resultSet.getInt("venda.id"));
                sale.setAmount(resultSet.getDouble("venda.valor"));
                sale.setDate(resultSet.getDate("venda.data"));
                sale.setTickets(result);

                result.forEach(e -> e.setSale(sale));

                result.add(ticket);
            }

            return result;
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return null;
    }

    public static List<Sale> findSalesByParams(List<Movie> movies, Date initialDate, Date finalDate, Double initialValue, Double finalValue) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");
            String query = "select venda.id, venda.data, venda.valor "
                    + " from venda inner join ingresso on ingresso.vendaid = venda.id "
                    + " where venda.valor >= ? "
                    + " and venda.data <= ? "
                    + " and venda.data >= ? ";

            if (finalValue != null) {
                query += " and venda.valor <= ?";
            }

            if (!movies.isEmpty()) {
                query += " and ingresso.filmeid in (?)";
            }
            query += " group by venda.id";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, initialValue != null ? initialValue.toString() : "0");
            preparedStatement.setString(2, finalDate != null ? formatter.format(finalDate) : "9999-12-31 00:00:00");
            preparedStatement.setString(3, initialDate != null ? formatter.format(initialDate) : "%");
            if (finalValue != null) {
                preparedStatement.setString(4, finalValue.toString());
            }
            if (!movies.isEmpty()) {
                String movieIds = "";
                for (int i = 0; i < movies.size(); i++) {
                    if (i != movies.size() - 1) {
                        movieIds += movies.get(i).getId() + ", ";
                    } else {
                        movieIds += movies.get(i).getId();
                    }

                }
                preparedStatement.setString(5, movieIds);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Sale> result = new ArrayList<>();
            while (resultSet.next()) {
                Sale sale = new Sale();
                List<Ticket> tickets = findTicketsBySaleId(resultSet.getInt("venda.id"));

                sale.setId(resultSet.getInt("venda.id"));
                sale.setTickets(tickets);
                String data = resultSet.getString("venda.data");
                sale.setDate(formatter.parse(data));
                sale.setAmount(resultSet.getDouble("venda.valor"));

                result.add(sale);
            }

            return result;
        } catch (ClassNotFoundException | SQLException | ParseException ex) {

        }
        return null;
    }
}
